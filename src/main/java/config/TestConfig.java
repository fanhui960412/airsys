package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * 应用配置（Spring配置）
 * 相当于XML的配置
 * @author 范晖
 *
 */
@Configuration
@ComponentScan({"dao","service","util"})
@Import(DBconfig.class)
@EnableAspectJAutoProxy
public class TestConfig {
	//  配置

}
