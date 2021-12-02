package de.kraueterhaus.adtool.application.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import de.kraueterhaus.adtool.controller.interceptor.MainSessionInterceptor;

/**
 * Legt die Grundlagen für den Spring-MVC Kontext fest. Das abzusuchende
 * Verzeichnis bezüglich der Modell-Klassen wird auf das Base-Package
 * <code>de.kraueterhaus.adtool</code> festgelegt.
 * 
 * @author www.kraueterhaus.de
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages =
{ "de.kraueterhaus.adtool" })
public class WebMvcConfig implements WebMvcConfigurer
{

	@Bean
	/**
	 * Initialisierung des Resolver und Festlegung der Views.
	 * 
	 * @return
	 */
	public InternalResourceViewResolver resolver()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	/**
	 * Legt den Ressourcen-Handler fest. Hier werden z. B. Datenbank-Properties für
	 * Hibernate definiert.
	 */
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	/**
	 * Fügt Interceptoren zum Abfangen bestimmter Verhaltensmuster hinzu. Ein
	 * Eingriff in den Prozessablauf von Spring wird dadurch gewährleistet (z. B.
	 * Prüfung einer validen Session).
	 */
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(new MainSessionInterceptor());
	}
}
