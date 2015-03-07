package com.app.functional.dynoforms.persistence.dto;

import java.util.Date;
import java.util.List;


public class FormDataDTO {
    private String formId;
    private Date dateCreated;
    private Date dateUpdated;
    private String createdby;
    private String data;
    
    
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

    
    
}
