package dh.master.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dh.master.info.data.Nuristani;

@Controller
public class XmlController {


	   
	    @RequestMapping(value = "/test", method = RequestMethod.GET)
	    public String submit(
	      @ModelAttribute("prasun") Nuristani prasun,
	      BindingResult result, ModelMap model) {
	        if (result.hasErrors()) {
	            return "error";
	        }
	        model.addAttribute("head", prasun.heading);
	        model.addAttribute("content", prasun.text);
	 
	
	 
	        return "test";
	    }
	    
//	    @ModelAttribute("messages")
//	    public List<Message> messages() {
//	        return messageRepository.findAll();
//	    }
	    
	    
}
