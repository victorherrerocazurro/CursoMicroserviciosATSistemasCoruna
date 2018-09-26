package com.example.demo;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class Configuracion implements WebMvcConfigurer{

	//LocaleResolver: Donde se almacena del codigo idiomatico
	//No es necesario definir, ya que por defecto se dispone de un AcceptHeaderLocaleResolver
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		
		sessionLocaleResolver.setLocaleAttributeName("locale");
		sessionLocaleResolver.setDefaultLocale(Locale.ENGLISH);
		
		return sessionLocaleResolver;
	}
	
	//LocaleChangeInterceptor: El que permite cambiar el codigo idiomatico
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		
		localeChangeInterceptor.setParamName("lang");//Cambiamos el parametro de request que permite el cambio de codigo idiomatico
		
		return localeChangeInterceptor;
	}
	
	//Registrar el bean Interceptor
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
	
	//MessageSource: Abstrae la seleccion del mensaje basandose en el codigo idiomatico
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
		
		reloadableResourceBundleMessageSource.setBasenames("message");
		
		return reloadableResourceBundleMessageSource;
	}
}
