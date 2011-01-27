package org.aggelos.baztag.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aggelos.baztag.dao.NabaztagDao;
import org.aggelos.baztag.dao.ZtampDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;

/**
 * this interceptor will do the necessary to add informations to the session once the User connects
 * @author sinmaniphel
 *
 */
public class UserConnectedInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	private NabaztagDao tagDao;
	
	@Autowired
	private ZtampDao ztampDao;
	
	public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

		User currentUser = UserServiceFactory.getUserService().getCurrentUser();
		if(currentUser!=null) {
			/*
			 * We are going to populate the list of the tags for this user
			 */
			HttpSession curSession = request.getSession();
			if(curSession.getAttribute("nabaztagList")==null) {
				curSession.setAttribute("nabaztagList", tagDao.list(currentUser));
				curSession.setAttribute("ztampList", ztampDao.list(currentUser));
			}
		}
		/*
		 * In any case, we are not going to interrupt the user with this
		 */
		return true;
    }

	
}
