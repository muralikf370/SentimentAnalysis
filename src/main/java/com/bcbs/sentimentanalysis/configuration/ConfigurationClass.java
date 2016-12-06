package com.bcbs.sentimentanalysis.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;


@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(basePackages ="com.bcbs.sentimentanalysis")
@PropertySource(value = { "classpath:enviornment.properties" })
@EnableTransactionManagement
public class ConfigurationClass extends WebMvcConfigurerAdapter  {
	@Autowired
    private Environment environment;
	
	private static final Logger logger = LoggerFactory.getLogger(ConfigurationClass.class);
	@Bean
    public UrlBasedViewResolver  viewResolver(){
	UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
	//	ChainableInternalResourceViewResolver viewResolver = new ChainableInternalResourceViewResolver();
	logger.info("In UrlBasedViewResolver::");
	//277
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("");
       viewResolver.setSuffix("");
        return viewResolver;
   } 

@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    //registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		logger.info("Before In addResourceHandlers::");
		//160
	    registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/static/");
		logger.info("After In addResourceHandlers::");
	    
	}
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		logger.info("Before In configureDefaultServletHandling::");
		//194
		configurer.enable();
		logger.info("After In configureDefaultServletHandling::");
    }
	
	@Bean
	public DataSource getDataSource() {
	/*	DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://actstagedb.cqzf2yborbv2.us-east-1.rds.amazonaws.com:3306/ActNewProduction");
		dataSource.setUsername("dbuser");
		dataSource.setPassword("tempe1q2w3e4r");*/
		  DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
	        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
	        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
	        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
			
		return dataSource;
	}
	
	 @Bean 
	  public JdbcTemplate getJdbcTemplete(){
		  JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		  return jdbcTemplate;
	  }

	 
	  private Properties hibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
	        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
	        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
	        return properties;        
	    }
	  
	  @Bean
	    @Autowired
	    public HibernateTransactionManager transactionManager(SessionFactory s) {
	       HibernateTransactionManager txManager = new HibernateTransactionManager();
	       txManager.setSessionFactory(s);
	       return txManager;
	    } 
	  
	  @Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(getDataSource());
	        sessionFactory.setPackagesToScan(new String[] { "com.bcbs.sentimentanalysis.model" });
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        return sessionFactory;
	     }
	     
	 @Bean
	 public CommonsMultipartResolver multipartResolver() {
	     CommonsMultipartResolver resolver=new CommonsMultipartResolver();
	     resolver.setDefaultEncoding("utf-8");
	     return resolver;
	 }

}
