package com.inventry.project.configuration;

import org.apache.catalina.Container;
import org.apache.catalina.core.StandardHost;
import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class MyConfig {
    // https://docs.spring.io/spring-boot/docs/2.4.4/reference/htmlsingle/#howto-use-tomcat-legacycookieprocessor
    // https://github.com/spring-projects/spring-boot/issues/21257#issuecomment-745565376
    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> errorReportValveCustomizer() {

        return (factory) -> {
            factory.addContextCustomizers(context -> {
                final Container parent = context.getParent();
                if (parent instanceof StandardHost) {
                    ((StandardHost) parent).setErrorReportValveClass(
                        "com.inventry.project.configuration.CustomError");
                }
            });
        };
    }
    

}