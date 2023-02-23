package com.example.blog.config;
import com.example.blog.interceptor.UserInfoInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


@Slf4j
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 配置静态资源路径。
     * 将/static/**请求映射到classpath:/static/下，
     * 将/**请求映射到classpath:/templates/themes/和classpath:/robots.txt下，
     * 将/upload/**请求映射到用户主目录下的/sens/upload/下，
     * 将/favicon.ico请求映射到classpath:/static/images/favicon.ico下。
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/themes/", "classpath:/robots.txt");
        String userHome = System.getProperties().getProperty("user.home");
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + userHome + "/sens/upload/");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("classpath:/static/images/favicon.ico");
    }


    /**
     * 配置用户信息拦截器。
     * 拦截/admin和/admin/**请求
     * 并排除/admin/login和/admin/logout请求。
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInfoInterceptor())
                .addPathPatterns("/admin", "/admin/**")
                .excludePathPatterns("/admin/login", "/admin/logout");
    }
}
