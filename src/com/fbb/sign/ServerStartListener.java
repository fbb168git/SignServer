package com.fbb.sign;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerStartListener implements ServletContextListener {
    private static Logger logger = LoggerFactory.getLogger(ServerStartListener.class); 
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	    PortAliveService.stop();
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
	    logger.info("启动端口保活服务...");
	    PortAliveService.start();
	 }
}
