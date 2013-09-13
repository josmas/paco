package com.google.paco.shared.model;

import java.io.Serializable;


public class ExperimentDAOCore implements Serializable {

  protected static final String DEFAULT_STRING = "";

  protected String title;
  protected String description;
  protected String informedConsentForm;
  protected String creator;
  protected String joinDate;
  protected Long id;

  public ExperimentDAOCore(Long id, String title, String description, String informedConsentForm,
                           String email, String joinDate) {
    super();
    this.id = id;
    this.title = title;
    this.description = description;
    this.informedConsentForm = informedConsentForm;
    this.creator = email;
    this.joinDate = joinDate;
  }

  /**
   *
   */
  public ExperimentDAOCore() {
    super();
    this.title = DEFAULT_STRING;
    this.description = DEFAULT_STRING;
    this.informedConsentForm = DEFAULT_STRING;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    setTitleWithValidation(title);
  }

  private void setTitleWithValidation(String title) {
    if (!isTitleValid(title)) {
      throw new IllegalArgumentException("Title cannot be empty.");
    }
    this.title = title;
  }

  public boolean isTitleValid() {
    return isTitleValid(title);
  }

  private boolean isTitleValid(String title) {
    return !title.equals("");
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getInformedConsentForm() {
    return informedConsentForm;
  }

  public void setInformedConsentForm(String informedConsentForm) {
    this.informedConsentForm = informedConsentForm;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public String getJoinDate() {
    return joinDate;
  }

  public void setJoinDate(String joinDate) {
    this.joinDate = joinDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}