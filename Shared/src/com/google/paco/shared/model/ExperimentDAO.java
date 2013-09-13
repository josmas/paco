/*
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance  with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
// Copyright 2010 Google Inc. All Rights Reserved.

package com.google.paco.shared.model;

import java.io.Serializable;



/**
 *
 * Dumb data object for passing the experiment definition to the GWT client.
 *
 * We use this because GWt serialization won't serialize a JDO nucleus object.
 *
 * @author Bob Evans
 *
 */
public class ExperimentDAO extends ExperimentDAOCore implements Serializable {

  // Please see ExperimentCreationPanel for documentation about valid email
  // addresses.
  public static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                           + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

  private String modifyDate;
  private Boolean published;
  private String[] admins;
  private String[] publishedUsers;
  private Boolean deleted = false;
  private Boolean webRecommended = false;
  private Integer version;
  protected SignalGroupDAO[] signalGroups;

  /**
   * @param id
   * @param title
   * @param description
   * @param informedConsentForm
   * @param email
   * @param fixedDuration
   * @param questionsChange
   * @param hash
   * @param published
   *          TODO
   * @param admins
   *          TODO
   */
  public ExperimentDAO(Long id, String title, String description, String informedConsentForm, String email,
                       SignalGroupDAO[] signalGroups, String joinDate, String modifyDate,
                       Boolean published, String[] admins, String[] publishedUsers, Boolean deleted,
                       Boolean webRecommended, Integer version) {
    super(id, title, description, informedConsentForm, email, joinDate);
    this.id = id;
    this.title = title;
    this.description = description;
    this.informedConsentForm = informedConsentForm;
    this.creator = email;
    this.signalGroups = signalGroups;
    this.modifyDate = modifyDate;
    this.published = published;
    this.admins = admins;
    this.publishedUsers = publishedUsers;
    this.deleted = deleted;
    this.webRecommended = webRecommended;
    this.version = version;
  }

  /**
   *
   */
  public ExperimentDAO() {
    super();
    this.admins = new String[0];
    this.publishedUsers = new String[0];
    this.signalGroups = new SignalGroupDAO[0];
  }

  public String getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(String modifyDate) {
    this.modifyDate = modifyDate;
  }

  /**
   * @return
   */
  public Boolean getPublished() {
    return published;
  }

  public void setPublished(Boolean published) {
    this.published = published;
  }

  /**
   * @return
   */
  public String[] getAdmins() {
    return admins;
  }

  public void setAdmins(String[] admins) {
    setAdminsWithValidation(admins);
  }

  private void setAdminsWithValidation(String[] admins) {
    if (!emailListIsValid(admins)) {
      throw new IllegalArgumentException("Admins email address list is invalid.");
    }
    this.admins = admins;
  }

  public String[] getPublishedUsers() {
    return publishedUsers;
  }

  public void setPublishedUsers(String[] publishedUsers) {
    setPublishedUsersWithValidation(publishedUsers);
  }

  private void setPublishedUsersWithValidation(String[] publishedUsers) {
    if (!emailListIsValid(publishedUsers)) {
      throw new IllegalArgumentException("Published email address list is invalid.");
    }
    this.publishedUsers = publishedUsers;
  }

  // Visible for testing
  public boolean emailListIsValid(String[] emailList) {
    if (emailList == null) { // Allows for removal of sensitive fields.
      return true;
    }
    for (String email : emailList) {
      if (!email.matches(EMAIL_REGEX)) {
        return false;
      }
    }
    return true;
  }

  public Boolean getDeleted() {
    return deleted;
  }

  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }

  public Boolean getWebRecommended() {
    return webRecommended;
  }

  public void setWebRecommended(Boolean webRecommended) {
    this.webRecommended = webRecommended;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public boolean isWhoAllowedToPostToExperiment(String who) {
    who = who.toLowerCase();
    for (int i = 0; i < admins.length; i++) {
      if (admins[i].equals(who)) {
        return true;
      }
    }
    if (getPublished()) {
      String[] publishedUsers2 = getPublishedUsers();
      if (publishedUsers2.length == 0) {
        return true;
      }
      for (int i = 0; i < publishedUsers2.length; i++) {
        if (publishedUsers2[i].equals(who)) {
          return true;
        }
      }
    }
    return false;
  }

  public SignalGroupDAO[] getSignalGroups() {
    return signalGroups;
  }

  public boolean isFixedDuration() {
    boolean fixed = true;
    for (SignalGroupDAO signalGroup : getSignalGroups()) {
      if (!signalGroup.getFixedDuration()) {
        fixed = false;
      }
    }
    return fixed;
  }

  public String getCompositeSchedule() {
    StringBuffer buf = new StringBuffer();
    for (SignalGroupDAO signalGroup : signalGroups) {
      buf.append(signalGroup.toString());
    }
    return buf.toString();
  }

  public void setSignalGroups(SignalGroupDAO[] signalGroups) {
    this.signalGroups = signalGroups;
  }

  public InputDAO getInputWithId(Long valueOf) {
    for (SignalGroupDAO signalGroup : signalGroups) {
      InputDAO[] inputs = signalGroup.getInputs();
      for (InputDAO inputDAO : inputs) {
        if (inputDAO.getId() != null && inputDAO.getId() == valueOf) {
          return inputDAO;
        }
      }
    }
    return null;
  }

  public InputDAO getInputWithName(String name) {
    for (SignalGroupDAO signalGroup : signalGroups) {
      InputDAO[] inputs = signalGroup.getInputs();
      for (InputDAO inputDAO : inputs) {
        if (inputDAO.getName() != null && inputDAO.getName().equals(name)) {
          return inputDAO;
        }
      }
    }
    return null;

  }

}
