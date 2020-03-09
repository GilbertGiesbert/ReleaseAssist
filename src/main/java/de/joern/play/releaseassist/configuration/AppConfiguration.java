package de.joern.play.releaseassist.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "de.joern.play.releaseassist")
public class AppConfiguration implements WebMvcConfigurer {
	   
	   @Bean
	   public ViewResolver internalResourceViewResolver() {
	       InternalResourceViewResolver bean = new InternalResourceViewResolver();
	       bean.setViewClass(JstlView.class);
	       bean.setPrefix("/WEB-INF/views/");
	       bean.setSuffix(".jsp");
	       return bean;
	   }
	   
		@Bean
		public ResourceBundleMessageSource messageSource() {
			ResourceBundleMessageSource bean = new ResourceBundleMessageSource();
			bean.setBasenames(new String[] { "i18n/message", "i18n/validation" });
			return bean;
		}
	   
	   @Override
	   public void addResourceHandlers(ResourceHandlerRegistry registry) {

	      // Register resource handler for css
	      registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
	      
	      // Register resource handler for js
	      registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
	      
	      // Register resource handler for images
	      registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/");
	      // use cache
	      // .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());

		   registry
				   .addResourceHandler("/webjars/**")

				   // not working when using webjar sources without version number
				   // .addResourceLocations("/webjars/")
				   .addResourceLocations("classpath:/META-INF/resources/webjars/")

				   // use webjar sources without version number
				   .resourceChain(false);
	   }

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
 
}