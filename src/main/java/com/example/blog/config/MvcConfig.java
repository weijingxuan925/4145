package com.example.blog.config;
import com.example.blog.interceptor.UserInfoInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


@Slf4j
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    /**
     * 静态资源映射用于访问静态资源, 比如图片, js, css等储存好的文件和文件夹
     */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/themes/", "classpath:/robots.txt");
        registry.addResourceHandler("/upload/**").addResourceLocations("file:~/sens/upload/");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("classpath:/static/images/favicon.ico");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new UserInfoInterceptor())
                .addPathPatterns("/admin", "/admin/**")
                .excludePathPatterns("/admin/login", "/admin/logout");
    }
}
