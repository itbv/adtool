package de.kraueterhaus.adtool.application.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import de.kraueterhaus.adtool.persistence.config.HibernatePersistenceContext;

/**
 * Klasse zur allgemeinen Initialisierung der ADTool-Anwendung.
 * 
 * @author www.kraueterhaus.de
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

	/**
	 * Legt den Persistenzkontext zur Datenbank fest, welcher �ber Hibernate
	 * definiert wird.
	 */
	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		return new Class[]
		{ HibernatePersistenceContext.class };
		// return null;
	}

	/**
	 * Bereitstellung der Servletkonfiguration und Initialisierung �ber Klasse
	 * <code>WebMvcConfig</code>.
	 */
	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		return new Class[]
		{ WebMvcConfig.class };
	}

	/**
	 * Legt das Servlet Mapping f�r die ADTool-Anwendung fest.
	 */
	@Override
	protected String[] getServletMappings()
	{
		return new String[]
		{ "/" };
	}

}