package dh.master.info.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dh.master.info.data.Nuristani;
import dh.master.info.service.IndexService;

@Controller
@ControllerAdvice
public class XmlController {

	@Autowired
	IndexService indexer;
	

	 Map<Integer, Nuristani> NuristaniMap= new HashMap<Integer, Nuristani>();
	
	    @RequestMapping(value = "/test", method = RequestMethod.GET)
	    public String submit(
	      @ModelAttribute("nuristani") Nuristani doc,
	      BindingResult result, ModelMap model) {
	        if (result.hasErrors()) {
	            return "error";
	        }
	        model.addAttribute("head", doc.getHeading());
	        model.addAttribute("content", doc.getText());
	  
	        NuristaniMap.put(1, doc);
	
	 
	        return "test";
	    }
	    

	    
}
