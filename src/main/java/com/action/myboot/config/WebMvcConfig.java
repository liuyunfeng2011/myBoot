//package com.action.myboot.config;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.convert.support.GenericConversionService;
//import org.springframework.format.FormatterRegistry;
//import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
//
//import com.action.myboot.interceptor.MyInterceptor;
//import com.action.myboot.util.DateConverter;
//
//@Configuration
//public class WebMvcConfig extends WebMvcConfigurationSupport {
//	@Autowired
//	private RequestMappingHandlerAdapter handlerAdapter;
//	@Resource(name="myInterceptor")
//	private MyInterceptor myInterceptor;
//	//关于类型转换器的使用
//	@PostConstruct
//	public void initEditableAvlidation() {
//		ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) handlerAdapter
//				.getWebBindingInitializer();
//		if (initializer.getConversionService() != null) {
//			GenericConversionService genericConversionService = (GenericConversionService) initializer
//					.getConversionService();
//			genericConversionService.addConverter(new DateConverter());// 添加自定义的类型转换器
//		}
//	}
//
//	@Override
//	protected void addInterceptors(InterceptorRegistry registry) {
//		System.out.println(myInterceptor);
//		registry.addInterceptor(myInterceptor).addPathPatterns("/**");
//		super.addInterceptors(registry);
//	}
//	
//	
//}
