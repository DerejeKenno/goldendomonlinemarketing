package miu.cs545.goldendomonlinemarketing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class ImgHandleConfig implements WebMvcConfigurer{
    public void addResourceHandlers(ResourceHandlerRegistration registry){
        Path productUploader= Paths.get("./product-image");
        String productUploadPath=productUploader.toFile().getAbsolutePath();
        registry.addResourceLocations("./product-image/**").addResourceLocations("file:/"+productUploadPath+"/");
    }

    /*@Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        resolver.setMaxUploadSize(10240000);
        return resolver;
    }*/

}
