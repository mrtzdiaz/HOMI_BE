package mx.homi.homi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import mx.homi.homi.model.Usuario;
import mx.homi.homi.security.JwtFilter;

@SpringBootApplication
public class HomiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomiApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<JwtFilter> jwfFilter(){
		FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<JwtFilter>();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/*");
		return registrationBean;
	}

}
