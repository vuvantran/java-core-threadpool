package com.memorynotfound;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationStartUpListener implements ServletContextListener {

    private ExecutorService applicationThreadPool;
    public static final String THREAD_POOL_ATTRIBUTE_NAME = "applicationThreadPool";

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("---- initialize servlet context -----");

        System.out.println("initialize new thread-pool and use it in application scope");
        applicationThreadPool = Executors.newFixedThreadPool(3);

        event.getServletContext().setAttribute(THREAD_POOL_ATTRIBUTE_NAME, applicationThreadPool);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("---- destroying servlet context -----");

        System.out.println("Shutdown threadpool before shutting down Tomcat server!");
        applicationThreadPool.shutdownNow();

        event.getServletContext().removeAttribute(THREAD_POOL_ATTRIBUTE_NAME);
    }
}
