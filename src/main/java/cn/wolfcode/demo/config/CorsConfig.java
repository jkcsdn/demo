//package cn.wolfcode.demo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class CorsConfig implements WebMvcConfigurer {
//    @Bean
//    public CorsFilter corsFilter(){
//        //创建一个CorsConfiguration对象
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        //允许任何域名的跨域
//        corsConfiguration.addAllowedOrigin("http://localhost:8080");
//        //允许任何消息头的跨域
//        corsConfiguration.addAllowedHeader("*");
//        //允许任何请求方法的访问
//        corsConfiguration.addAllowedMethod("*");
//
//        corsConfiguration.setAllowCredentials(true);
//
//        //创建UrlBasedCorsConfigurationSource
//        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
//        //注册跨域配置
//        configurationSource.registerCorsConfiguration("/**",corsConfiguration);
//        //返回CorsFilter
//        return new CorsFilter(configurationSource);
//    }
//}
