package org.aggelos.baztag.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.aggelos.baztag.dao.NabaztagDao;
import org.aggelos.baztag.exception.DaoException;
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
import com.google.appengine.api.xmpp.JID;
import com.google.appengine.api.xmpp.Message;
import com.google.appengine.api.xmpp.MessageBuilder;
import com.google.appengine.api.xmpp.SendResponse;
import com.google.appengine.api.xmpp.XMPPService;
import com.google.appengine.api.xmpp.XMPPServiceFactory;

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
		
		dao.save(ptag);
		session.setAttribute("currentTag", ptag);
		// force rebuild list
		return "forward:/nabaztag/info/current";
	}
	
	@RequestMapping("info/{value}")
	public String displayNabaztag(HttpSession session, Model model, @PathVariable String value) {
		if("current".equals(value)) {
			model.addAttribute("ptag", session.getAttribute("currentTag"));
			model.addAttribute("content", "inc/nab_display.jsp");
		}
		else {
			// TODO : may return nothing
			PNabaztag tag = dao.getNabaztagById(value);
			model.addAttribute("ptag", tag);
			session.setAttribute("currentTag", tag);
<<<<<<< HEAD
	            
        boolean messageSent = false;
        /*if (xmpp.getPresence(doudou).isAvailable()) {
            SendResponse status = xmpp.sendMessage(msg);
            messageSent = (status.getStatusMap().get(doudou) == SendResponse.Status.SUCCESS);
        }*/

        	model.addAttribute("ptag", session.getAttribute("currentTag"));
=======
			Nabaztag binded = tag.generateBindedNabaztag();
			binded.updateStatus();
			
			model.addAttribute("tag",binded);
>>>>>>> 538dbd92a8eba9d9389fe537ff49c5fb8971d036
			model.addAttribute("content", "inc/nab_display.jsp");
			
			
		}
		return "index";
	}
	
	@RequestMapping(value = "delete/{value}",method = RequestMethod.GET)
	public String deleteNabaztag(Model model, @PathVariable String value) {
		// First of all we will check the given nabaztag is the user's nabaztag
		PNabaztag tag = dao.getNabaztagById(value);
		if(tag==null) {
			// if not, error message, and redirect to home
			// TODO : redirect to Nabaztag list
			model.addAttribute("errorMsg", "Ah ? Vous n'avez aucun nabaztag de ce genre ! ");
			return "redirect:/";
		}
		User currentUser = UserServiceFactory.getUserService().getCurrentUser();
		if(!tag.getOwner().equals(currentUser)) {
			// if not, error message, and redirect to home
			// TODO : redirect to Nabaztag list
			model.addAttribute("errorMsg", "Ah ? Vous n'avez aucun nabaztag de ce genre ! ");
			return "redirect:/";
		}
		model.addAttribute("content", "inc/nab_delete.jsp");
		model.addAttribute("tagToDelete", tag);
		return "index";
	}
	
	@RequestMapping(value = "delete/{value}",method = RequestMethod.POST)
	public String deleteNabaztagConfirmed(Model model, @PathVariable String value, HttpSession session) {
		// First of all we will check the given nabaztag is the user's nabaztag
		try{
			dao.deleteNabaztag(UserServiceFactory.getUserService().getCurrentUser(), value);
			// return to homepage with info message
			model.addAttribute("infoMsg", "Le lapin a �t� retir� de votre compte");
			// force rebuild list
			session.removeAttribute("nabaztagList");
			
		}
		catch(DaoException e) {
			// this may happen in case the user tried to delete another user's nabaztag
			model.addAttribute("errorMsg", e.getLocalizedMessage());
		}
		return "index";
	}
	
	
	@RequestMapping("purge")
	public String purge() {
		dao.purge();
		return "index";
	}
	
	@RequestMapping("changeState")
	public String wakeUp(HttpSession session, Model model) {
		/*PNabaztag tag = (PNabaztag) session.getAttribute("currentTag");
		if(tag==null) {
			model.addAttribute("errorMsg", "aaah ! je ne sais pas de quel Nabaztag on parle !");
			return "redirect:/";
		}
		Nabaztag binded = tag.getBindedNabaztag();
		if(!binded.setAwake(!binded.isAwake())) {
			model.addAttribute("errorMsg", binded.getLastErrors().get(0).getMessage());
			return "redirect:/";
		}*/
		
		return "forward:/nabaztag/info/current";
	}

}
