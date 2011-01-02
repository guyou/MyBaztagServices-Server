package org.aggelos.baztag.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.aggelos.baztag.api.Nabaztag;
import org.aggelos.baztag.api.xml.ApiAnswer;
import org.aggelos.baztag.dao.NabaztagDao;
import org.aggelos.baztag.model.PNabaztag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;

/**
 * A controller for all rabbit related operations (CRUD etc)
 * @author Sinmaniphel
 *
 */
@Controller
@RequestMapping("/nabaztag/*")
public class NabaztagController {
	
	private static final Logger LOGGER = Logger.getLogger(NabaztagController.class.getName());
	
	@Autowired
	NabaztagDao dao;
	
	
	@RequestMapping(value="add",method=RequestMethod.GET) 
	public String addNabaztagForm(HttpSession session, Model model) {
		
		model.addAttribute("api",new PNabaztag());

		model.addAttribute("content", "inc/forms/form_rabbit_add.jsp");
		return "index";
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST) 
	public String submitNabaztagForm(HttpSession session, @ModelAttribute PNabaztag ptag, Model model) {
		User currentUser = UserServiceFactory.getUserService().getCurrentUser();
		ptag.setOwner(currentUser);

		LOGGER.info("persisting a nabaztag");
		
		//The Api will test the Nabaztag
		
		Nabaztag tag = ptag.generateBindedNabaztag();
		if(!tag.updateStatus()) {
			String errors = "";
			for(ApiAnswer answer : tag.getLastErrors()) {
				errors += "<br/>"+answer.getMessage();
			}
			model.addAttribute("errorMsg", "oooooh... Ce nabaztag n'a pas pu �tre reconnu par les serveurs de Violet par ce que : "+errors);
			return "redirect:/nabaztag/add";
		}
		
		ptag.merge(tag);
		dao.save(ptag);
		session.setAttribute("currentTag", ptag);
		return "forward:/nabaztag/info/current";
	}
	
	@RequestMapping("info/{value}")
	public String displayNabaztag(HttpSession session, Model model, @PathVariable String value) {
		if("current".equals(value)) {
			model.addAttribute("tag", ((PNabaztag)session.getAttribute("currentTag")).getBindedNabaztag());
			model.addAttribute("content", "inc/nab_display.jsp");
		}
		else {
			PNabaztag tag = dao.getNabaztagById(UserServiceFactory.getUserService().getCurrentUser(), value);
			model.addAttribute("tag", tag);
			model.addAttribute("content", "inc/nab_display.jsp");
		}
		return "index";
	}
	
	@RequestMapping("purge")
	public String purge() {
		dao.purge();
		return "index";
	}

}