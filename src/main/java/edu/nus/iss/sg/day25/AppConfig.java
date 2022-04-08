package edu.nus.iss.sg.day25;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.nus.iss.sg.day25.filters.AuthenticationFilter;

@Configuration
public class AppConfig {
    
    @Bean
    public FilterRegistrationBean<AuthenticationFilter> registerFilters() {
        FilterRegistrationBean<AuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AuthenticationFilter());
        registrationBean.addUrlPatterns("/protected/*");
        return registrationBean;
    }
}
