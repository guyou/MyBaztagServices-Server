package org.aggelos.baztag.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.aggelos.baztag.api.Nabaztag;
import org.aggelos.baztag.api.xml.ApiAnswer;
import org.aggelos.baztag.controller.form.FormZtamp;
import org.aggelos.baztag.dao.NabaztagDao;
import org.aggelos.baztag.dao.ZtampDao;
import org.aggelos.baztag.exception.DaoException;
import org.aggelos.baztag.model.PNabaztag;
import org.aggelos.baztag.model.Ztamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.appengine.api.xmpp.JID;
import com.google.appengine.api.xmpp.Message;
import com.google.appengine.api.xmpp.MessageBuilder;
import com.google.appengine.api.xmpp.SendResponse;
import com.google.appengine.api.xmpp.XMPPService;
import com.google.appengine.api.xmpp.XMPPServiceFactory;

/**
 * A controller for all ztamp related operations (CRUD etc)
 * @author Sinmaniphel
 *
 */
@Controller
@RequestMapping("/ztamp/*")
public class ZtampController {
	
	private static final Logger LOGGER = Logger.getLogger(ZtampController.class.getName());
	
	@Autowired
	ZtampDao dao;
	
		
	@RequestMapping(value="update",method=RequestMethod.POST) 
	public String submitZtampForm(HttpSession session, @ModelAttribute FormZtamp ztamp, Model model) {
		
		LOGGER.info("persisting a Ztamp");
		
		Ztamp upStam = dao.getZtampById(ztamp.getKey());
		upStam.setName(ztamp.getName());
		
		dao.save(upStam);
		// force rebuild list
		session.removeAttribute("ztampList");
		return "forward:/ztamp/info/"+upStam.getKeyAsString();
	}
	
	@RequestMapping("info/{value}")
	public String displayZtamp(HttpSession session, Model model, @PathVariable String value) {
			// TODO : may return nothing
			Ztamp tag = dao.getZtampById(value);
			model.addAttribute("ztamp", tag);
			model.addAttribute("formZtamp",new FormZtamp());
			model.addAttribute("content", "inc/stamp_display.jsp");
			return "index";
	}
	
	/*@RequestMapping(value = "delete/{value}",method = RequestMethod.GET)
	public String deleteZtamp(Model model, @PathVariable String value) {
		// First of all we will check the given Ztamp is the user's Ztamp
		PZtamp tag = dao.getZtampById(value);
		if(tag==null) {
			// if not, error message, and redirect to home
			// TODO : redirect to Ztamp list
			model.addAttribute("errorMsg", "Ah ? Vous n'avez aucun Ztamp de ce genre ! ");
			return "redirect:/";
		}
		User currentUser = UserServiceFactory.getUserService().getCurrentUser();
		if(!tag.getOwner().equals(currentUser)) {
			// if not, error message, and redirect to home
			// TODO : redirect to Ztamp list
			model.addAttribute("errorMsg", "Ah ? Vous n'avez aucun Ztamp de ce genre ! ");
			return "redirect:/";
		}
		model.addAttribute("content", "inc/nab_delete.jsp");
		model.addAttribute("tagToDelete", tag);
		return "index";
	}
	
	@RequestMapping(value = "delete/{value}",method = RequestMethod.POST)
	public String deleteZtampConfirmed(Model model, @PathVariable String value, HttpSession session) {
		// First of all we will check the given Ztamp is the user's Ztamp
		try{
			dao.deleteZtamp(UserServiceFactory.getUserService().getCurrentUser(), value);
			// return to homepage with info message
			model.addAttribute("infoMsg", "Le ztamp a �t� retir� de votre compte");
			// force rebuild list
			session.removeAttribute("ZtampList");
			
		}
		catch(DaoException e) {
			// this may happen in case the user tried to delete another user's Ztamp
			model.addAttribute("errorMsg", e.getLocalizedMessage());
		}
		return "index";
	}*/
	
	
	

}
