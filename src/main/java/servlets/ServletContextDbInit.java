package servlets;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class ServletContextDbInit implements ServletContextListener {
	ServletContext context;

	public void contextInitialized(ServletContextEvent sce) {

		
		try {
			InitialContext ctxRep = new InitialContext();
			DataSource CinemaBuddyDB = (DataSource) ctxRep.lookup("java:comp/env/jdbc/CinemaBuddyDB");
			sce.getServletContext().setAttribute("CinemaBuddyDB", CinemaBuddyDB);
		} catch (Exception e) {
			throw new RuntimeException(e);
			
			
		}
	}

	public void contextDestroyed(ServletContextEvent contextEvent) {

	}

}
