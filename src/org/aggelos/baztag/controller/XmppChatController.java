package org.aggelos.baztag.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.appengine.api.xmpp.Message;
import com.google.appengine.api.xmpp.MessageBuilder;
import com.google.appengine.api.xmpp.SendResponse;
import com.google.appengine.api.xmpp.XMPPService;
import com.google.appengine.api.xmpp.XMPPServiceFactory;

@Controller
@RequestMapping("/_ah/xmpp/message")
public class XmppChatController {

	XMPPService xmpp = XMPPServiceFactory.getXMPPService();
	private static final Logger LOGGER = Logger.getLogger(XmppChatController.class.getName());
	
	@RequestMapping("chat")
	public void handleChat(HttpServletRequest req, HttpServletResponse rep) {
		
		
		try {
			Scanner scanner = new Scanner(req.getInputStream());
			StringBuffer content = new StringBuffer();
			while(scanner.hasNext()) {
				content.append(scanner.next());
			}
			scanner.close();
			LOGGER.warning("Content of request : "+content.toString());
			
			/*Message msg = xmpp.parseMessage(req);
			LOGGER.info(msg.getBody());
			
			Message response = new MessageBuilder().withMessageType(
					msg.getMessageType()).withBody(msg.getBody())
					.withRecipientJids(msg.getFromJid()).build();
			boolean messageSent = false;
			SendResponse status = xmpp.sendMessage(response);
			
			//xmpp.
			
			messageSent = (status.getStatusMap().get(msg.getFromJid()) == SendResponse.Status.SUCCESS);

			if (!messageSent) {
			// An Error Occurred
			}*/

			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
