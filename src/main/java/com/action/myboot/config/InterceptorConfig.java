package com.action.myboot.config;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.action.myboot.interceptor.MyInterceptor;
import com.action.myboot.util.DateConverter;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
	private RequestMappingHandlerAdapter handlerAdapter;
	@Resource(name = "myInterceptor")
	private MyInterceptor myInterceptor;

	// 关于类型转换器的使用
	@PostConstruct
	public void initEditableAvlidation() {
		ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) handlerAdapter
				.getWebBindingInitializer();
		if (initializer.getConversionService() != null) {
			GenericConversionService genericConversionService = (GenericConversionService) initializer
					.getConversionService();
			genericConversionService.addConverter(new DateConverter());// 添加自定义的类型转换器
		}
	}

	// 拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println(myInterceptor);
		// TODO Auto-generated method stub
		//自定义拦截器
		registry.addInterceptor(myInterceptor).addPathPatterns("/**");
		//国际化拦截器
		registry.addInterceptor(localeChangeInterceptor());
	}

	// 国际化拦截器
	private LocaleChangeInterceptor lci = null;

	// 国际化解析器。注意，这个Bean Name要为localeResolver
	@Bean(name="localeResolver")
	public SessionLocaleResolver initLocaleResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		// 默认国际化区域
		slr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
		return slr;
	}
	
	// 创建国际化拦截器
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
	    if (lci != null) {
	        return lci;
	    }
	    lci = new LocaleChangeInterceptor();
	    // 设置参数名
	    lci.setParamName("language");
	    return lci;
	}
}
