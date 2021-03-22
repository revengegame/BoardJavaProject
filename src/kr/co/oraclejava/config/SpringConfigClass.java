package kr.co.oraclejava.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class SpringConfigClass 
extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override //프로젝트에서 사용할 빈을 정의하기 위해 지정
	protected Class<?>[] getRootConfigClasses() {		
		return new Class[] {RootAppContext.class};
	}

	@Override //Spring MVC 프로젝트 설정을 위한 클래스를 지정
	protected Class<?>[] getServletConfigClasses() {		
		return new Class[] {ServletAppContext.class};
	}

	@Override //DispatcherServlet에 매핑할 요청 주소를 설정하는 부분
	protected String[] getServletMappings() {		
		return new String[] {"/"};
	}
	
	protected Filter[] getServletFilters() { //한글매핑 처리		
		CharacterEncodingFilter encodingFilter=new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		return new Filter[] {encodingFilter};
	}
	
	@Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        //registration.setInitParameter("dispatchOptionsRequest", "true");
        super.customizeRegistration(registration);
        MultipartConfigElement config1 = new MultipartConfigElement(null, 52428800, 524288000,0);
        registration.setMultipartConfig(config1);
    }

}
