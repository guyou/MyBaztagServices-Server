package org.aggelos.baztag.controller;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/_ah/xmpp/presence")
public class XmppPresenceController {

	private static final Logger LOGGER = Logger.getLogger(XmppPresenceController.class.getName());
	
	@RequestMapping("available")
	public void handleAvailable(HttpServletRequest req, HttpServletResponse rep) {
		try {
			Scanner scanner = new Scanner(req.getInputStream());
			StringBuffer content = new StringBuffer();
			while(scanner.hasNext()) {
				content.append(scanner.next());
			}
			scanner.close();
			LOGGER.warning("Content of request in available : "+content.toString());
			
			

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("unavailable")
	public void handleUnavailable(HttpServletRequest req, HttpServletResponse rep) {
		try {
			Scanner scanner = new Scanner(req.getInputStream());
			StringBuffer content = new StringBuffer();
			while(scanner.hasNext()) {
				content.append(scanner.next());
			}
			scanner.close();
			LOGGER.warning("Content of request in unavailable : "+content.toString());
			
			

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("probe")
	public void handleProbe(HttpServletRequest req, HttpServletResponse rep) {
		try {
			Scanner scanner = new Scanner(req.getInputStream());
			StringBuffer content = new StringBuffer();
			while(scanner.hasNext()) {
				content.append(scanner.next());
			}
			scanner.close();
			LOGGER.warning("Content of request in probe : "+content.toString());
			
			

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
