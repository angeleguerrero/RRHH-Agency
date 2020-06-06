package net.ag.empleos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class WebConfig implements WebMvcConfigurer {
	@Value("${empleos.ruta.imagenes}")
	private String rutaImagenes;
	

public void addResourceHandlers( ResourceHandlerRegistry registry) {
//registry.addResourceHandler("/logos/**").addResourceLocations("file:c:/Users/HELLAS/Spring workspace/empleos/img/");
	
	registry.addResourceHandler("/logos/**").addResourceLocations("file:" +  rutaImagenes);
}
	
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		//registry.addResourceHandler("/logos/**").addResourceLocations("file:/empleos/img-vacantes/"); // Linux
//		//registry.addResourceHandler("/logos/**").addResourceLocations("file:c:/Users/HELLAS/Spring workspace/empleos/img-empleos/"); // Windows
//		registry.addResourceHandler("/logos/**").addResourceLocations("file:" +  rutaImagenes); // Windows
//	}	



	
}
