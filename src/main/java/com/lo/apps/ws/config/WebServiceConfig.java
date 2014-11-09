package com.lo.apps.ws.config;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

	@Bean
	public ServletRegistrationBean dispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/*");
	}

	@Bean(name = "invoice")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema invoiceSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("InvoicePort");
		wsdl11Definition.setLocationUri("/InvoiceRequest");
		wsdl11Definition.setTargetNamespace("http://localhost:8080/holidayService/");
		wsdl11Definition.setSchema(invoiceSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema invoiceSchema() {
		return new SimpleXsdSchema(new ClassPathResource("invoice.xsd"));
	}

}
