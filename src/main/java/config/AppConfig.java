package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * 应用配置（Spring配置）
 * 相当于XML的配置
 * @author 范晖
 *
 */
@Configuration
@ComponentScan({"dao","service","controller"})
//@EnableWebMvc
@Import(DBconfig.class)
@EnableAspectJAutoProxy
public class AppConfig extends WebMvcConfigurationSupport{
	//  配置
	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/"); // 位置 【受保护的，不可以直接访问】
		resolver.setSuffix(".jsp"); // -- jsp文件的后缀，你再写页面的时候就省略掉后缀
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
    /**
     * 配置处理静态方法
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
    	super.addResourceHandlers(registry);
    }
}
