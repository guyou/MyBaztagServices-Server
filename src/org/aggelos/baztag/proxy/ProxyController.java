package org.aggelos.baztag.proxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aggelos.baztag.app.ApplicationBinder;
import org.aggelos.baztag.app.ZTampApplicationConfig;
import org.aggelos.baztag.dao.NabaztagDao;
import org.aggelos.baztag.dao.NotificationsDao;
import org.aggelos.baztag.dao.ZtampDao;
import org.aggelos.baztag.model.PNabaztag;
import org.aggelos.baztag.model.Ztamp;
import org.aggelos.baztag.model.notif.NewStampNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.appengine.api.users.User;

/**
 * The purpose of this class is to emulate the violet server
 * the Nabaztag communicates with in order to get a connection
 * @author aggelos
 *
 */
@Controller
public class ProxyController {

	private static final Logger LOGGER = Logger.getLogger(ProxyController.class.getName());
	
	@Autowired
	private NabaztagDao tagDao;
	
	
	/*@Autowired
	private NotificationsDao notificationsDao;
	
	@Autowired
	private ApplicationBinder binder;*/
	
	// TODO : find why this (bootcode providing) does not work locally
	/**
	 * Upon connection, the Nabaztag will try to get a bytecode provided by the server.
	 * This bytecode is static and contains most of the features needed by the nabaztag
	 */
	@RequestMapping("/bc.jsp")
	public void provideBootCode(HttpServletRequest request, HttpServletResponse response) {
		LOGGER.warning("Bootcode required");
		try {
			File bc = new File("bootcode.bin");
			response.setDateHeader("Date", new java.util.Date().getTime());
		    LOGGER.warning(request.getQueryString());
			InputStream is = new FileInputStream(bc);
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			LOGGER.warning("found file");
			byte[] buffer = new byte[1024];
			while(is.read(buffer)!=-1) {
				os.write(buffer);
			}
			os.close();
			LOGGER.warning("finished writing");
			byte[] buf = os.toByteArray();
		    //response.setContentLength((int)bc.length());
			response.setHeader("Keep-Alive", "timeout=5, max=100 ");
			response.setHeader("Connection", "Keep-Alive");
			response.setHeader("Transfer-Encoding", "chunked");
			
			response.setContentType("text/plain");
			response.getOutputStream().write(buf);
		    response.getOutputStream().flush();
		    response.getOutputStream().close();
		} catch (MalformedURLException e) {
			LOGGER.severe(e.getClass().getName() +" : "+ e.getMessage());
		} catch (IOException e) {
			LOGGER.severe(e.getClass().getName() +" : "+ e.getMessage());
		}
		LOGGER.warning("Bootcode sent");
		
	}
	
	@RequestMapping("/locate.jsp")
	public void doOtherThingJSP(HttpServletRequest request, HttpServletResponse resp) {
		LOGGER.warning("Accessed locate");
		 resp.setContentType("text/plain");
		    try {
				resp.getWriter().println("ping mybaztagservices.appspot.com");            
				resp.getWriter().println("broad mybaztagservices.appspot.com");            
				resp.getWriter().println("xmpp_domain mybaztagservices.appspotchat.com");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}       
		
	}	
	
	/**
	 * the rfid context is called when a given nabaztag sniffs a rfid chip
	 * @param t the rfid chip
	 * @param sn the serial number of the nabaztag which sniffed the chip
	 * @return
	 */
	@RequestMapping(value="/rfid.jsp",method=RequestMethod.GET)
	public @ResponseBody String catchValue(@RequestParam String t, @RequestParam String sn) {
		/*
		 * behaviour : if we find a user associated to the stamp, then we execute the app 
		 * on the nabaztag which sniffed the stamp. Else, we notify the owner of the nabaztag
		 * that a new stamp has been found and not parametered
		 * 
		 */
		/*Ztamp chip = tampDao.findByRfId(t);
		PNabaztag associatedTag = tagDao.getBySerialNumber(sn);
		
		if(chip==null) {
			chip = new Ztamp();
			User owner = associatedTag.getOwner();
			chip.setHashCode(t);
			chip.setOwner(owner);
			tampDao.save(chip);
			notificationsDao.save(new NewStampNotification(owner,associatedTag,chip));
		}
		else {
			for(ZTampApplicationConfig conf:tampDao.getAppConfigs(chip)) {
				binder.forName(conf.getApplicationIdentifier()).doYourStuff(conf, associatedTag);
				
			}
		}
		
		return "";*/
		return "";
	}
}
