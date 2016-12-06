package com.bcbs.sentimentanalysis.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class InitilizerClass  extends AbstractAnnotationConfigDispatcherServletInitializer  {

	 
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
	//	return null;
		  return new Class[] { ConfigurationClass.class };
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		//return null;
		return new String[] { "/" };
	}
	


}
