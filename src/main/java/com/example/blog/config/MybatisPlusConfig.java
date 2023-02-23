package com.example.blog.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis Plus配置类
 * @author JingxuanWei
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * MyBatis Plus分页
     * @return PaginationInterceptor 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 配置MyBatis Plus性能分析插件, 设置最长查询时间和是否格式化SQL语句
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor()
                .setMaxTime(1000)
                .setFormat(false);
    }
}
