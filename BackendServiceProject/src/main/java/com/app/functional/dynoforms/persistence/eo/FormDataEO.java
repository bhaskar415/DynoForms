package com.app.functional.dynoforms.persistence.eo;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FORMS_DATA")
public class FormDataEO {
	
	@Id
	private String id;
    private String formId;
    private Date dateCreated;
    private Date dateUpdated;
    private String createdby;
    private List<FormDataType> data;

    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public List<FormDataType> getData() {
		return data;
	}
	public void setData(List<FormDataType> data) {
		this.data = data;
	}

}
