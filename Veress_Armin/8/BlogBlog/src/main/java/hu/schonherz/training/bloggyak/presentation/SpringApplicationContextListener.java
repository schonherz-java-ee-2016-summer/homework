package hu.schonherz.training.bloggyak.presentation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Lenovo on 2016.08.03..
 */
public class SpringApplicationContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String springContextLocation = (String) servletContextEvent.getServletContext().getAttribute("contextConfigLocation");

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-context.xml");

        servletContextEvent.getServletContext().setAttribute("applicationContext", ac);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
