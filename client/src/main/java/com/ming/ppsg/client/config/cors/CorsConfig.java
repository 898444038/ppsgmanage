package com.ming.ppsg.client.config.cors;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 支持跨域
 */
/*@Configuration
public class CorsConfig {
    @Bean
    public FilterRegistrationBean corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        //这个请求头在https中会出现,但是有点问题，下面我会说
        //config.addExposedHeader("X-forwared-port, X-forwarded-host");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}*/

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")	// 允许跨域访问的路径
        .allowedOrigins("*")	// 允许跨域访问的源
        .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")	// 允许请求方法
        .maxAge(168000)	// 预检间隔时间
        .allowedHeaders("*")  // 允许头部设置
        .allowCredentials(true);	// 是否发送cookie
    }
}