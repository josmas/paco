package com.google.sampling.experiential.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.google.cloud.sql.jdbc.Statement;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.sampling.experiential.cloudsql.columns.InputColumns;
import com.google.sampling.experiential.dao.CSDataTypeDao;
import com.google.sampling.experiential.dao.CSExternStringTextDao;
import com.google.sampling.experiential.dao.CSInputDao;
import com.google.sampling.experiential.dao.dataaccess.DataType;
import com.google.sampling.experiential.dao.dataaccess.Input;
import com.google.sampling.experiential.server.CloudSQLConnectionManager;
import com.google.sampling.experiential.server.PacoId;
import com.pacoapp.paco.shared.util.ErrorMessages;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.JdbcParameter;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.insert.Insert;

public class CSInputDaoImpl implements CSInputDao {
  public static final Logger log = Logger.getLogger(CSInputDaoImpl.class.getName());
  private CSDataTypeDao dataTypeDao = new CSDataTypeDaoImpl();
  private CSExternStringTextDao externStringDao = new CSExternStringTextDaoImpl();
  private static List<Column> inputColList = Lists.newArrayList();

  static {
    inputColList.add(new Column(InputColumns.NAME_ID));
    inputColList.add(new Column(InputColumns.REQUIRED));
    inputColList.add(new Column(InputColumns.CONDITIONAL));
    inputColList.add(new Column(InputColumns.RESPONSE_TYPE_ID));
    inputColList.add(new Column(InputColumns.TEXT_ID));
    inputColList.add(new Column(InputColumns.LIKERT_STEPS));
    inputColList.add(new Column(InputColumns.LEFT_LABEL));
    inputColList.add(new Column(InputColumns.RIGHT_LABEL));
    inputColList.add(new Column(InputColumns.CHANNEL));
  }
  
  @Override
  public void insertInput(Input input) throws SQLException {
    Connection conn = null;
    PreparedStatement statementCreateInput = null;
    ResultSet rs = null;
    ExpressionList insertInputExprList = new ExpressionList();
    List<Expression> exp = Lists.newArrayList();
    Insert inputInsert = new Insert();
    try {
      log.info("Inserting input into input table");
      conn = CloudSQLConnectionManager.getInstance().getConnection();
      conn.setAutoCommit(false);
      inputInsert.setTable(new Table(InputColumns.TABLE_NAME));
      inputInsert.setUseValues(true);
      insertInputExprList.setExpressions(exp);
      inputInsert.setItemsList(insertInputExprList);
      inputInsert.setColumns(inputColList);
      // Adding ? for prepared stmt
      for (Column c : inputColList) {
        ((ExpressionList) inputInsert.getItemsList()).getExpressions().add(new JdbcParameter());
      }

      statementCreateInput = conn.prepareStatement(inputInsert.toString(), Statement.RETURN_GENERATED_KEYS);
      List<DataType> allDataTypes = dataTypeDao.getAllDataTypes();
      // TODO add background inputs, etc
      if (input.getInputId() == null || input.getInputId().getId() == null) {
        PacoId variableNameId = externStringDao.getTextAndCreate(input.getName().getLabel(), true);
        PacoId textId = externStringDao.getTextAndCreate(input.getText().getLabel(), true);
        statementCreateInput.setLong(1, variableNameId.getId());
        statementCreateInput.setBoolean(2, input.isRequired());
        statementCreateInput.setString(3, input.getConditional());
        DataType responseDataType = dataTypeDao.getMatchingDataType(allDataTypes, input.getResponseDataType().getName(), input.getResponseDataType().isNumeric(), input.getResponseDataType().isMultiSelect());
        input.setResponseDataType(responseDataType);
        Integer dataTypeId = responseDataType.getDataTypeId().getId().intValue();
        statementCreateInput.setObject(4, dataTypeId, Types.INTEGER);
        statementCreateInput.setLong(5, textId.getId());
        statementCreateInput.setInt(6, input.getLikertSteps());
        statementCreateInput.setString(7, input.getLeftLabel());
        statementCreateInput.setString(8, input.getRightLabel());
        statementCreateInput.setString(9, "Group");
        log.info(statementCreateInput.toString());
        statementCreateInput.execute();
        rs = statementCreateInput.getGeneratedKeys();
        if (rs.next()) {
          input.setInputId(new PacoId(rs.getLong(1), true)); 
        }
      } //if
      conn.commit();
    } catch(SQLException sqle) {
      log.warning("Exception while inserting to input_history table:" +  sqle);
    } finally {
      try {
        if( rs != null) { 
          rs.close();
        }
        if (statementCreateInput != null) {
          statementCreateInput.close();
        }
        if (conn != null) {
          conn.close();
        }
      } catch (SQLException ex1) {
        log.info(ErrorMessages.CLOSING_RESOURCE_EXCEPTION.getDescription() + ex1);
      }
    }
  }
}
