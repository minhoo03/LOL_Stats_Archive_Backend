package com.standard.lolweb.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;

@Configuration
@EnableAsync
@EnableScheduling
@EnableAutoConfiguration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private Environment env;


//    @Bean
//    public BasicErrorController errorController(ErrorAttributes errorAttributes, ServerProperties serverProperties){
//        return new ErrorController(errorAttributes, serverProperties.getError());
//    }
//

    //ResourceHandlerRegistry = 정적 리소스 설정(제공)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.setOrder(1); // 시큐리티 필터간 우선순위 정하기
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/")
//                .resourceChain(true)
//                .addResolver(new PathResourceResolver() {
//                    @Override
//                    protected Resource getResource(String resourcePath,
//                                                   Resource location) throws IOException {
//                        Resource requestedResource = location.createRelative(resourcePath);
//                        return requestedResource.exists() && requestedResource.isReadable() ? requestedResource
//                                : new ClassPathResource("/static/index.html");
//                    }
//                });
    }

//    private Connector createSslConnector() {
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setScheme("http");
//        connector.setSecure(false);
//        connector.setPort(80);
//        connector.setRedirectPort(443);
//        return connector;
//    }
//
//    private ServletContainerInitializer getServletContextInitializer(String contextPath) {
//        return (c, context) -> {
//            Servlet servlet = new HttpServlet() {
//                @Override
//                protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//                    resp.sendRedirect(contextPath);
//                }
//            };
//            context.addServlet("root", servlet).addMapping("/*");
//        };
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authorizationInterceptor).excludePathPatterns(PermitUrls.urls.toArray(new String[0]));
//    }
//
}
