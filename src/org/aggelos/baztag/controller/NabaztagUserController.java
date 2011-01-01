package org.aggelos.baztag.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * A global controller to controle all User related operations
 * @author sinmaniphel
 *
 */
@Controller
public class NabaztagUserController {

	private static final Logger LOGGER = Logger.getLogger(NabaztagUserController.class.getName());
	
	@RequestMapping("/")
	public String homeHandler(Model model) {
		return "index";
	}
	
	@RequestMapping("/simple")
	public @ResponseBody String simple() {
		return "Hello world!";
	}

	
}
