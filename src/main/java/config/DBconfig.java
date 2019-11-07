package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 数据库配置
 * 1.配置类
 * 2.告诉配置类你的配置信息的位置 @PropertySource
 * 3.利用IOC功能 注入配置信息 @value
 * @author 范晖
 *
 */
@Configuration
@PropertySource("classpath:jdbc.properties") // 配置信息的位置
public class DBconfig {
	// 获取配置信息
	@Value("${jdbc.driverClass}")
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;

	// DataSource Bean
	@Bean(name="dataSource")
	public DataSource creatDataSource() {
		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}
	// JDBCTemplate
	@Bean(name="jdbcTemple")
	public JdbcTemplate creatJdbcTemplat(DataSource ds) {
		return new JdbcTemplate(ds);
	}
}
