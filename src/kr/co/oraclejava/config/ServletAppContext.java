package kr.co.oraclejava.config;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.oraclejava.beans.UserBean;
import kr.co.oraclejava.interceptor.CheckLoginInterceptor;
import kr.co.oraclejava.interceptor.CheckWriterInterceptor;
import kr.co.oraclejava.interceptor.TopMenuInterceptor;
import kr.co.oraclejava.mapper.BoardMapper;
import kr.co.oraclejava.mapper.TopMenuMapper;
import kr.co.oraclejava.mapper.UserMapper;
import kr.co.oraclejava.service.BoardService;
import kr.co.oraclejava.service.TopMenuService;

@Configuration
//Controller Annotation이 설정되어 있는 클래스를 컨트롤러로 등록하는 역할.
@EnableWebMvc
@ComponentScan("kr.co.oraclejava.controller")
@ComponentScan("kr.co.oraclejava.dao")
@ComponentScan("kr.co.oraclejava.service")

@PropertySource("/WEB-INF/properties/db.properties")
public class ServletAppContext implements WebMvcConfigurer {
	
	@Value("${db.classname}")
	private String db_classname;
	
	@Value("${db.url}")
	private String db_url;
	
	@Value("${db.username}")
	private String db_username;
	
	@Value("${db.password}")
	private String db_password;
	
	@Autowired
	private TopMenuService topMenuService;
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
	@Autowired
	private BoardService boardService;

	public void configureViewResolvers(ViewResolverRegistry registry) {
		//controller의 메소드가 반환되는 jsp의 이름 앞 뒤에 경로의 확장자를 붙여주도록 설정합니다.
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	//정적 파일의 경로 설정(mapping)
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	
	//데이터베이스 접속에 대한 정보를 관리하는 Bean
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName(db_classname); 
		source.setUrl(db_url); 
		source.setUsername(db_username); 
		source.setPassword(db_password); 
		
		return source;		
	}
	
	//쿼리문과 접속 정보를 관리하는 객체 생성
	@Bean
	public SqlSessionFactory factory(BasicDataSource source) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(source); 
		SqlSessionFactory factory = factoryBean.getObject();
		
		return factory;		
	}
	
	/* SqlSessionFactory
	 * - SqlSeesion객체 생성
	 * - 데이터베이스 접속, 쿼리 관리 등을 합니다.
	 * - 트랜잭션 처리, Thread-Safe하지 않으므로 thread마다 필요한 만큼 새로 생성해서 사용
	 */
	
	//쿼리문 실행을 위한 객체(Mapper 관리)
	@Bean
	public MapperFactoryBean<BoardMapper> getBoardMapper(SqlSessionFactory factory){
		MapperFactoryBean<BoardMapper> factoryBean = 
				new MapperFactoryBean<BoardMapper>(BoardMapper.class);
		factoryBean.setSqlSessionFactory(factory); 
				
		return factoryBean;		
	}
	
	/* Mapper
	 * - mapping file create
	 * - JDBC 연도에 비해 95%이상 코드가 감소
	 * - SQL작성에 집중가능하도록 
	 * - select, delete, update, insert 기능 추가 사용
	 * 
	 */
	
	//TopMenuMapper 등록
	@Bean
	public MapperFactoryBean<TopMenuMapper> getTopMenuList(SqlSessionFactory factory) {
		MapperFactoryBean<TopMenuMapper> factoryBean =
				new MapperFactoryBean<TopMenuMapper>(TopMenuMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		
		return factoryBean;
	}
	
	//UserMapper 등록
	@Bean
	public MapperFactoryBean<UserMapper> getUserMapper(SqlSessionFactory factory) {
		MapperFactoryBean<UserMapper> factoryBean =
				new MapperFactoryBean<UserMapper>(UserMapper.class);
		factoryBean.setSqlSessionFactory(factory);
			
		return factoryBean;
	}
	
	
	
	
	
	
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry); 
		
		//TopMenuInterceptor 등록
		TopMenuInterceptor topMenuInterceptor = 
				new TopMenuInterceptor(topMenuService, loginUserBean);
		
		InterceptorRegistration reg1 = registry.addInterceptor(topMenuInterceptor);
			reg1.addPathPatterns("/**");
			
			//CheckLoginInterceptor등록
			CheckLoginInterceptor checkLoginInterceptor = 
					new CheckLoginInterceptor(loginUserBean);
			
			InterceptorRegistration reg2 = registry.addInterceptor(checkLoginInterceptor);
			reg2.addPathPatterns("/user/modify", "/user/logout", "/board/*");
			reg2.excludePathPatterns("/board/main");
			
			CheckWriterInterceptor checkWriterInterceptor = new CheckWriterInterceptor(loginUserBean, boardService);
			InterceptorRegistration reg3 = registry.addInterceptor(checkWriterInterceptor);
			reg3.addPathPatterns("/board/update", "/board/delete");

	}
	


	
	//두 개의 서로다른 propertirs 설정을 충돌나지 않도록 설정
	@Bean
	public static PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	
	//메시지 등록
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
		res.setBasenames("/WEB-INF/properties/error_message");
		return res;
	}
	
	
	//spring3.1부터 사용가능
	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
	
	
	
}










