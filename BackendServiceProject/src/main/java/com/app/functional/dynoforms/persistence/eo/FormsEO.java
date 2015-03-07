package com.app.functional.dynoforms.persistence.eo;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FORMS")
public class FormsEO {
	
  
		@Id
	    private String id;
        private String formName;
	    private Date dateCreated;
	    private Date dateUpdated;
	    private String createdby;
	    private List<String> fields;
	   
	    @DBRef
	    private List<FormDataEO> formData;
	    

		public List<FormDataEO> getFormData() {
			return formData;
		}
		public void setFormData(List<FormDataEO> formData) {
			this.formData = formData;
		}
		public String getCreatedby() {
			return createdby;
		}
		public void setCreatedby(String createdby) {
			this.createdby = createdby;
		}
		public List<String> getFields() {
			return fields;
		}
		public void setFields(List<String> fields) {
			this.fields = fields;
		}
		public String getId() {
	  		return id;
	  	}
	  	public void setId(String id) {
	  		this.id = id;
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
	      public String getFormName() {
	  		return formName;
	  	}
	  	public void setFormName(String formName) {
	  		this.formName = formName;
	  	}


}
