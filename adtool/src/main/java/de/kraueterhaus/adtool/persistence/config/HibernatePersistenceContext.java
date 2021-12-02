package de.kraueterhaus.adtool.persistence.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Beschreibung des Datenbankzugriffs zur Persistierung von Objekten im Sinne
 * des ORM-Handlings auf einer Datenbank.
 * 
 * Die Beschreibung der Datenbank, der Zugriffsrechte und der entsprechenden
 * Dialekte und Treiber werden in der Datei <code>database.properties</code> im
 * Ressourcen-Verzeichnis definiert.
 * 
 * @author www.kraueterhaus.de
 *
 */
@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
public class HibernatePersistenceContext
{

	@Autowired
	private Environment environment;

	@Bean
	/**
	 * Liefert die SessionFactory für das Spring-Management zum Bereitstellen
	 * einzelner Datenbanksitzungen.
	 * 
	 * @return
	 */
	public LocalSessionFactoryBean sessionFactory()
	{
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[]
		{ "de.kraueterhaus.adtool.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	/**
	 * Liefert die Zugangsdaten einer beliebigen Datenbank, welche in Datei
	 * <code>datenbank.properties</code> definiert werden.
	 * 
	 * @return
	 */
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}

	/**
	 * Liefert die Kofiguration einer beliebigen Datenbank, welche in Datei
	 * <code>datenbank.properties</code> definiert werden.
	 * 
	 * @return
	 */
	private Properties hibernateProperties()
	{
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		return properties;
	}

	/**
	 * Wird von Spring für die Transaktionen innerhalb der Session benötigt, da
	 * ADTool eine 'Single Hibernate Session Factory' für den transaktionalen
	 * Datenzugriff auf das DBMS verwendet.
	 * 
	 * @return
	 */
	@Bean
	public HibernateTransactionManager getTransactionManager()
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
}
