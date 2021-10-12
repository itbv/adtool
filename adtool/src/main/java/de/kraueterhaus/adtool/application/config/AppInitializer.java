package de.kraueterhaus.adtool.application.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import de.kraueterhaus.adtool.persistence.config.HibernatePersistenceContext;

/**
 * @author 
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		return new Class[]
		{ HibernatePersistenceContext.class };
		// return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		return new Class[]
		{ WebMvcConfig.class };
	}

	@Override
	protected String[] getServletMappings()
	{
		return new String[]
		{ "/" };
	}

}