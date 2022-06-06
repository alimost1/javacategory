package com.soft.ProductManager.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



public class HibernateUtil {
    
	private static SessionFactory sessionFactory = buildSessionFactory();
	private static ServiceRegistry serviceRegistry;
	private static Session session =null;

    public static SessionFactory buildSessionFactory() {
        try {
            // loads configuration and mappings
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            serviceRegistry= new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

            // builds a session factory from the service registry
            return configuration.buildSessionFactory(serviceRegistry);           
        }catch (Throwable ex) {
        	
        	System.err.println("failed" +ex);
        	throw new ExceptionInInitializerError(ex);
        	
        	 
        }
    
        
    }


	

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static Session openSession() {
		return sessionFactory.openSession();
	}
	
	public static Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public static void close() {
		if(sessionFactory!=null) 
		{
			sessionFactory.close();
		}	
			sessionFactory=null;
		}




	public static ServiceRegistry getServiceRegistry() {
		return serviceRegistry;
	}




	public static void setServiceRegistry(ServiceRegistry serviceRegistry) {
		HibernateUtil.serviceRegistry = serviceRegistry;
	}




	public static Session getSession() {
		return session;
	}




	public static void setSession(Session session) {
		HibernateUtil.session = session;
	}




	public static void setSessionFactory(SessionFactory sessionFactory) {
		HibernateUtil.sessionFactory = sessionFactory;
	}



		
	}


	


