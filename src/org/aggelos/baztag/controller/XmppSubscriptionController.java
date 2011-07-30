package org.aggelos.baztag.controller;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/_ah/xmpp/subscription")
public class XmppSubscriptionController {

	private static final Logger LOGGER = Logger.getLogger(XmppSubscriptionController.class.getName());
	
	@RequestMapping("subscribe")
	public void handleSubscribe(HttpServletRequest req, HttpServletResponse rep) {
		try {
			Scanner scanner = new Scanner(req.getInputStream());
			StringBuffer content = new StringBuffer();
			while(scanner.hasNext()) {
				content.append(scanner.next());
			}
			scanner.close();
			LOGGER.warning("Content of request in subscribe : "+content.toString());
			
			

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("subscribed")
	public void handleSubscribed(HttpServletRequest req, HttpServletResponse rep) {
		try {
			Scanner scanner = new Scanner(req.getInputStream());
			StringBuffer content = new StringBuffer();
			while(scanner.hasNext()) {
				content.append(scanner.next());
			}
			scanner.close();
			LOGGER.warning("Content of request in subscribed : "+content.toString());
			
			

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("unsubscribe")
	public void handleUnsubscribe(HttpServletRequest req, HttpServletResponse rep) {
		try {
			Scanner scanner = new Scanner(req.getInputStream());
			StringBuffer content = new StringBuffer();
			while(scanner.hasNext()) {
				content.append(scanner.next());
			}
			scanner.close();
			LOGGER.warning("Content of request in unsubscribe : "+content.toString());
			
			

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("unsubscribed")
	public void handleUnsubscribed(HttpServletRequest req, HttpServletResponse rep) {
		try {
			Scanner scanner = new Scanner(req.getInputStream());
			StringBuffer content = new StringBuffer();
			while(scanner.hasNext()) {
				content.append(scanner.next());
			}
			scanner.close();
			LOGGER.warning("Content of request in unsubscribed : "+content.toString());
			
			

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
