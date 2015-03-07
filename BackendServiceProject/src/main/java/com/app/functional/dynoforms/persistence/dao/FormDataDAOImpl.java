package com.app.functional.dynoforms.persistence.dao;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.functional.dynoforms.persistence.dto.FormDataDTO;
import com.app.functional.dynoforms.persistence.eo.FormDataEO;
import com.app.functional.dynoforms.persistence.eo.FormDataType;
import com.app.functional.dynoforms.persistence.eo.FormsEO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class FormDataDAOImpl {
	
	@Autowired
	private FormDataDAO formDataDAO;	
	
	@Autowired
	private FormsDAO formsDAO;
	
	
	@RequestMapping(value="/formsDataImpl/add/cascadeSave",method = RequestMethod.POST,headers="Accept=application/json")
	public @ResponseBody FormDataEO add(@RequestBody FormDataEO data) {
		
		//System.out.println("******************Cascade save********************"+data.getFormName());
		System.out.println("*****************Cascade save*********************"+data.getData());

		FormsEO selectedFormsEO  = null;

		List<FormsEO> formEOList = formsDAO.findById(data.getFormId());
		
				for (FormsEO formsEO : formEOList) {
					selectedFormsEO = formsEO;
					break;
					}
	
		FormDataEO newformDataEO  = null;
		newformDataEO = formDataDAO.save(data);
	
		 List<FormDataEO> newformDataEOList = new ArrayList<FormDataEO>();
		 
		 newformDataEOList.addAll(selectedFormsEO.getFormData());// added old data Ref list first so that oyu wont lose the old data ref list Note: just adding one list obj will clear the older ref and replaces with just that ref
		 newformDataEOList.add(newformDataEO);// added new data Ref to the above list so that it has all the ref to older and new so that DAO save operation will save every thing otherwise it will only save the last one and will lose all the previous data

		
			System.out.println("******************post the task********************"+newformDataEO.getId());

			selectedFormsEO.setFormData(newformDataEOList);
			
			formsDAO.save(selectedFormsEO);

		return newformDataEO;
	
	}
	
	
	
	@RequestMapping(value="/formsDataImpl/cascadeSave",method = RequestMethod.POST,headers="Accept=application/json")
	public @ResponseBody FormDataEO add2(@RequestBody String data ) {
		
		System.out.println("*****************Cascade save*********************"+data);

		Map<String,String> map = new HashMap<String,String>();
		ObjectMapper mapper = new ObjectMapper();
	
		//convert JSON string to Map
				try {
					map = mapper.readValue(data, 
					    new TypeReference<HashMap<String,String>>(){});
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				List<FormDataType> newformDataTypeList = new ArrayList<FormDataType>();
				
				FormDataDTO formDataDTO = new FormDataDTO();
								
		   Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator() ;
	        while(iterator.hasNext()){
	            Map.Entry<String, String> mapData = iterator.next();
				
	            if(mapData.getKey().equalsIgnoreCase("formId")){	            	
	            	formDataDTO.setFormId(mapData.getValue());
	            }  else{	            
	            FormDataType formDataType = new FormDataType();
	            formDataType.setFormFieldName(mapData.getKey());
	            formDataType.setFormFieldData(mapData.getValue());
	            newformDataTypeList.add(formDataType);
	            }
	        }
	        
					
					FormDataEO newformDataEO  = new FormDataEO();				
					newformDataEO.setFormId(formDataDTO.getFormId());
					newformDataEO.setData(newformDataTypeList);
					newformDataEO.setCreatedby(null);
					newformDataEO.setDateCreated(new Date());
					newformDataEO.setDateUpdated(new Date());
					
					FormDataEO newSavedformDataEO  = null;
					newSavedformDataEO = formDataDAO.save(newformDataEO);
			   
					
				FormsEO selectedFormsEO  = null;

				List<FormsEO> formEOList = formsDAO.findById(formDataDTO.getFormId());				
				for (FormsEO formsEO : formEOList) {
					selectedFormsEO = formsEO;
					break;
					}	
			
			  List<FormDataEO> newformDataEOList = new ArrayList<FormDataEO>();
	if (selectedFormsEO.getFormData() != null){
			 newformDataEOList.addAll(selectedFormsEO.getFormData());// added old data Ref list first so that oyu wont lose the old data ref list Note: just adding one list obj will clear the older ref and replaces with just that ref
	}
			 newformDataEOList.add(newSavedformDataEO);// added new data Ref to the above list so that it has all the ref to older and new so that DAO save operation will save every thing otherwise it will only save the last one and will lose all the previous data
			
			 selectedFormsEO.setFormData(newformDataEOList);
			 formsDAO.save(selectedFormsEO);
		
		return null;
	}
	
	
    @RequestMapping("/formsDataImpl/get")
    public @ResponseBody String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
    	System.out.println("==== in greeting ====");
        return "WORLD";
    }
	
	
	

}
