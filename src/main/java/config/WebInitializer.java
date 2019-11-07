package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
/**
 * Tomcat启动的时候会检测时候有WebApplicationInitializer接口的类
 * 若检测到有，就会实例化它，并调用它的onStartup方法
 * @author 范晖
 *
 */
public class WebInitializer implements WebApplicationInitializer{

	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// 构建Spring容器
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		//  Spring 容器加载配置
		ctx.register(AppConfig.class);
		// Spring 容器接管ServletContext应用上下文对象
		ctx.setServletContext(servletContext);
		//  添加Servlet（至少添加一个Servlet，SpringMVC框架实现的入口Servlet）
		ServletRegistration.Dynamic  servlet  = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

}
/*
 * 你要使用Spring，就得有Spring容器的实例
 * 你想使用SpringMVC，就得配置DispatcherServlet的实例
 * 还要把这两个东西放到ServletContext对象里，为什么呢 因为他们两都是重量级对象
 */