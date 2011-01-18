package org.aggelos.baztag.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.aggelos.baztag.dao.NabaztagDao;
import org.aggelos.baztag.model.PNabaztag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.appengine.api.users.UserServiceFactory;

/**
 * A global controller to controle all User related operations
 * @author sinmaniphel
 *
 */
@Controller
public class NabaztagUserController {

	private static final Logger LOGGER = Logger.getLogger(NabaztagUserController.class.getName());
	
	@Autowired
	NabaztagDao nabDao;
	
	@RequestMapping("/")
	public String homeHandler(Model model) {
		List<PNabaztag> tags = nabDao.list(UserServiceFactory.getUserService().getCurrentUser());
		model.addAttribute("tags", tags);
		return "index";
	}
	
	@RequestMapping("/about")
	public String aboutHandler(Model model) {
		model.addAttribute("content", "inc/about.jsp");
		return "about";
	}

	
}
