package com.google.sampling.experiential.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ExperimentCreationMenuBar extends Composite {

  public static final int DESCRIPTION_PANEL = 0;
  public static final int DURATION_PANEL = 1;
  public static final int SCHEDULE_PANEL = 2;
  public static final int INPUTS_PANEL = 3;
  public static final int FEEDBACK_PANEL = 4;
  public static final int PUBLISHING_PANEL = 5;


  private MyConstants myConstants;

  private VerticalPanel mainPanel;
  private Tree menuTree;
  private TreeItem showDescriptionItem;
  private TreeItem signalGroupsRootTree;
  private TreeItem showPublishingItem;

  private int numSignalGroups;

  private ExperimentCreationListener listener;
  private boolean isForNewExperiment;

  public ExperimentCreationMenuBar(ExperimentCreationListener listener, boolean isForNewExperiment) {
    super();
    myConstants = GWT.create(MyConstants.class);
    this.isForNewExperiment = isForNewExperiment;
    this.listener = listener;
    mainPanel = new VerticalPanel();
    initWidget(mainPanel);
    initMenu();
  }

  private void initMenu() {
    createMenuHeader();
    menuTree = new Tree();

    // Main menu roots.
    showDescriptionItem = new TreeItem(myConstants.experimentDescriptionButtonText());
    signalGroupsRootTree = new TreeItem(myConstants.signalGroups());
    showPublishingItem = new TreeItem(myConstants.experimentPublishingButtonText());

    numSignalGroups = 0;
    createAddSignalGroupButton();
    createSignalGroup();
    signalGroupsRootTree.setState(true); // Unfold the tree by default.

    // Add main menu headers to menu tree.
    menuTree.addItem(showDescriptionItem);
    menuTree.addItem(signalGroupsRootTree);
    menuTree.addItem(showPublishingItem);

    createMainMenuTreeSelectionHandler();
    mainPanel.add(menuTree);
  }

  private void createMainMenuTreeSelectionHandler() {
    // Navigation callbacks.
    menuTree.addSelectionHandler(new SelectionHandler<TreeItem>() {
      @Override
      public void onSelection(SelectionEvent<TreeItem> event) {
        TreeItem selectedButton = event.getSelectedItem();
        if (selectedButton.equals(signalGroupsRootTree)) {
          return;
        } else if (selectedButton.equals(showDescriptionItem)) {
          fireExperimentCreationCode(ExperimentCreationListener.SHOW_DESCRIPTION_CODE, 0);
        } else if (selectedButton.equals(showPublishingItem)) {
          fireExperimentCreationCode(ExperimentCreationListener.SHOW_PUBLISHING_CODE, 0);
        } else if (selectedItemIsSpecificSignalGroupHeader(selectedButton)){
          int signalGroupNum = signalGroupsRootTree.getChildIndex(selectedButton);
          if (selectedItemIsAddNewSignalGroup(signalGroupNum)) {
            fireExperimentCreationCode(ExperimentCreationListener.NEW_SIGNAL_GROUP, null);
          } else {
            fireExperimentCreationCode(ExperimentCreationListener.SHOW_SCHEDULE_CODE, signalGroupNum);
          }
        } else {
          int signalGroupNum = signalGroupsRootTree.getChildIndex(selectedButton.getParentItem());
          int viewWithinSignalGroupNum = selectedButton.getParentItem().getChildIndex(selectedButton);
          if (selectedItemIsShowDuration(viewWithinSignalGroupNum)) {
            fireExperimentCreationCode(ExperimentCreationListener.SHOW_DURATION_CODE, signalGroupNum);
          } else if (selectedItemIsShowSchedule(viewWithinSignalGroupNum)) {
            fireExperimentCreationCode(ExperimentCreationListener.SHOW_SCHEDULE_CODE, signalGroupNum);
          } else if (selectedItemIsShowInputs(viewWithinSignalGroupNum)) {
            fireExperimentCreationCode(ExperimentCreationListener.SHOW_INPUTS_CODE, signalGroupNum);
          } else {
            fireExperimentCreationCode(ExperimentCreationListener.SHOW_FEEDBACK_CODE, signalGroupNum);
          }
        }
      }
    });
  }

  public void addSignalGroup() {
    createSignalGroup();
  }

  public void deleteSignalGroup(int groupNum) {
    TreeItem toRemove = signalGroupsRootTree.getChild(groupNum - 1);
    signalGroupsRootTree.removeItem(toRemove);
  }

  public void setSelectedItem(int itemType, Integer groupNum) {
    switch (itemType) {
    case DESCRIPTION_PANEL:
      menuTree.setSelectedItem(showDescriptionItem, false);
      break;
    case DURATION_PANEL:
      menuTree.setSelectedItem(getShowDurationItem(groupNum), false);
      break;
    case SCHEDULE_PANEL:
      menuTree.setSelectedItem(getShowScheduleItem(groupNum), false);
      break;
    case INPUTS_PANEL:
      menuTree.setSelectedItem(getShowInputsItem(groupNum), false);
      break;
    case FEEDBACK_PANEL:
      menuTree.setSelectedItem(getShowFeedbackItem(groupNum), false);
      break;
    case PUBLISHING_PANEL:
      menuTree.setSelectedItem(showPublishingItem, false);
      break;
    default:
      System.err.println("Unhandled code sent to experiment creation menu.");
    }
  }

  private void createMenuHeader() {
    Label labelMessage = new Label();
    labelMessage.setSize("200", "30");
    labelMessage.setText(isForNewExperiment ? myConstants.experimentCreation()
                                            : myConstants.experimentUpdate());
    mainPanel.add(labelMessage);
  }

  private void createAddSignalGroupButton() {
    TreeItem addSignalGroup = new TreeItem(myConstants.newSignalGroupButtonText());
    signalGroupsRootTree.addItem(addSignalGroup);
  }

  private void createSignalGroup() {
    int newGroupDisplayNum = signalGroupsRootTree.getChildCount();
    TreeItem signalGroup = new TreeItem(myConstants.signalGroup() + " " + newGroupDisplayNum);
    TreeItem showDuration = new TreeItem(myConstants.signalGroupDuration());
    TreeItem showSchedule = new TreeItem(myConstants.schedule());
    TreeItem showInputs = new TreeItem(myConstants.experimentInputsButtonText());
    TreeItem showFeedback = new TreeItem(myConstants.experimentFeedbackButtonText());
    signalGroup.addItem(showDuration);
    signalGroup.addItem(showSchedule);
    signalGroup.addItem(showInputs);
    signalGroup.addItem(showFeedback);
    signalGroup.setState(true); // Input group is open by default.
    // Insert in front of "Add Signal Group" item.
    signalGroupsRootTree.insertItem(newGroupDisplayNum - 1, signalGroup);
    ++numSignalGroups;
  }

  private TreeItem getSignalGroupHeaderItem(int groupNum) {
    return signalGroupsRootTree.getChild(groupNum);
  }

  private TreeItem getShowDurationItem(int groupNum) {
    return getSignalGroupHeaderItem(groupNum).getChild(0);
  }

  private TreeItem getShowScheduleItem(int groupNum) {
    return getSignalGroupHeaderItem(groupNum).getChild(1);
  }

  private TreeItem getShowInputsItem(int groupNum) {
    return getSignalGroupHeaderItem(groupNum).getChild(2);
  }

  private TreeItem getShowFeedbackItem(int groupNum) {
    return getSignalGroupHeaderItem(groupNum).getChild(3);
  }

  private boolean selectedItemIsShowDuration(int viewWithinSignalGroupNum) {
    return viewWithinSignalGroupNum == 0;
  }

  private boolean selectedItemIsShowSchedule(int viewWithinSignalGroupNum) {
    return viewWithinSignalGroupNum == 1;
  }

  private boolean selectedItemIsShowInputs(int viewWithinSignalGroupNum) {
    return viewWithinSignalGroupNum == 2;
  }

  private boolean selectedItemIsShowFeedback(int viewWithinSignalGroupNum) {
    return viewWithinSignalGroupNum == 3;
  }

  private boolean selectedItemIsAddNewSignalGroup(int signalGroupNum) {
    return signalGroupNum == numSignalGroups;
  }

  private boolean selectedItemIsSpecificSignalGroupHeader(TreeItem selectedButton) {
    return selectedButton.getParentItem() != null &&
        selectedButton.getParentItem().equals(signalGroupsRootTree);
  }

  private void fireExperimentCreationCode(int code, Integer groupNum) {
    listener.eventFired(code, groupNum, null);
  }
}
