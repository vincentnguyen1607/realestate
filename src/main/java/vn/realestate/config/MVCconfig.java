package vn.realestate.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("vn.realestate")
@PropertySource({ "classpath:persistence-mysql.properties" })
public class MVCconfig implements WebMvcConfigurer {
	
	@Autowired
	private Environment e;
	
	@Bean
	public ViewResolver internalResourceViewResolver() {
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	    viewResolver.setViewClass(JstlView.class);
	    viewResolver.setPrefix("/WEB-INF/view/");
	    viewResolver.setSuffix(".jsp");
	    return viewResolver;
	}

	// Define Database DataSource / connection pool
	@Bean
	public DataSource myDataSource() {

		ComboPooledDataSource myDataSource = new ComboPooledDataSource();

		try {
			myDataSource.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}

		myDataSource.setJdbcUrl(e.getProperty("jdbc.url"));
		myDataSource.setUser(e.getProperty("jdbc.user"));
		myDataSource.setPassword(e.getProperty("jdbc.password"));

		// these are connection pool properties for C3P0
		myDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		myDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		myDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		myDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		return myDataSource;
	}

	private int getIntProperty(String propName) {
		String propVal = e.getProperty(propName);
		int intPropVal = Integer.parseInt(propVal);
		return intPropVal;
	}

	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", e.getProperty("hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.show_sql", e.getProperty("hibernate.show_sql"));
		return hibernateProperties;
	}

	@Bean
	public LocalSessionFactoryBean mySessionFactory(){
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan(e.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(hibernateProperties());	
		return sessionFactory;
	}

	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager manager = new HibernateTransactionManager();
		manager.setSessionFactory(sessionFactory);
		return manager;
	}
}
