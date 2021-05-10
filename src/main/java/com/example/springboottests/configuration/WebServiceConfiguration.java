package com.example.springboottests.configuration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfiguration {
  @Bean
  public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
    servlet.setApplicationContext(applicationContext);
    servlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean<>(servlet, "/ws/*");
  }

  @Bean(name = "people")
  public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema peopleSchema) {
    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
    wsdl11Definition.setPortTypeName("PeoplePort");
    wsdl11Definition.setLocationUri("/ws");
    wsdl11Definition.setTargetNamespace("https://springboottests.example.com/ws/person-service");
    wsdl11Definition.setSchema(peopleSchema);
    return wsdl11Definition;
  }

  @Bean
  public XsdSchema peopleSchema() {
    return new SimpleXsdSchema(new ClassPathResource("xsd/people.xsd"));
  }
}
