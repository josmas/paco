package com.google.sampling.experiential.dao.dataaccess;

import java.lang.reflect.Field;

import org.joda.time.DateTime;

import com.google.sampling.experiential.server.PacoId;

public class Group {
  private PacoId groupId;
  private String name;
  private String customRendering;
  private Boolean fixedDuration;
  private DateTime startDate;
  private DateTime endDate;
  private Boolean rawDataAccess;
  private String endOfDayGroup;
  public PacoId getGroupId() {
    return groupId;
  }
  public void setGroupId(PacoId groupId) {
    this.groupId = groupId;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getCustomRendering() {
    return customRendering;
  }
  public void setCustomRendering(String customRendering) {
    this.customRendering = customRendering;
  }
  public Boolean getFixedDuration() {
    return fixedDuration;
  }
  public void setFixedDuration(Boolean fixedDuration) {
    this.fixedDuration = fixedDuration;
  }
  public DateTime getStartDate() {
    return startDate;
  }
  public void setStartDate(DateTime startDate) {
    this.startDate = startDate;
  }
  public DateTime getEndDate() {
    return endDate;
  }
  public void setEndDate(DateTime endDate) {
    this.endDate = endDate;
  }
  public Boolean getRawDataAccess() {
    return rawDataAccess;
  }
  public void setRawDataAccess(Boolean rawDataAccess) {
    this.rawDataAccess = rawDataAccess;
  }
  public String getEndOfDayGroup() {
    return endOfDayGroup;
  }
  public void setEndOfDayGroup(String endOfDayGroup) {
    this.endOfDayGroup = endOfDayGroup;
  }
  @Override
  public String toString() {
    return "Group [groupId=" + groupId + ", name=" + name + ", customRendering=" + customRendering
           + ", fixedDuration=" + fixedDuration + ", startDate=" + startDate + ", endDate=" + endDate
           + ", rawDataAccess=" + rawDataAccess + ", endOfDayGroup=" + endOfDayGroup + "]";
  }
  public Boolean compareWithoutId(Group other) throws IllegalArgumentException, IllegalAccessException { 
    Field[] fields = this.getClass().getDeclaredFields();
    for (Field field : fields) {
      if (!field.getName().equals("groupId")) {
        if (((field.get(this) != null && !field.get(this).equals(field.get(other)))) || (field.get(this) == null && field.get(other) != null)){
          return false;
        }
      }
    }
    return true;
  }
}
