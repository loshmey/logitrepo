package com.lo.apps.ws.config;

import java.util.List;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.interceptor.PayloadLoggingInterceptor;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
@PropertySource(value = { "application.properties" })
public class WebServiceConfig extends WsConfigurerAdapter {

	/**
	 * Dispatcher servlet configuration.
	 * 
	 * @param applicationContext
	 * @return
	 */
	@Bean
	public ServletRegistrationBean dispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);

		return new ServletRegistrationBean(servlet, "/*");
	}

	/**
	 * WSDL configuration.
	 * 
	 * @param invoiceSchema
	 * @return WSDL definition.s
	 */
	@Bean(name = "invoice")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema invoiceSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("Invoice");
		wsdl11Definition.setLocationUri("/services");
		wsdl11Definition.setTargetNamespace("http://localhost:8080/invoice/schema");
		wsdl11Definition.setSchema(invoiceSchema);

		return wsdl11Definition;
	}

	/**
	 * Path to XSD schema.
	 * 
	 * @return XSD schema.
	 */
	@Bean
	public XsdSchema invoiceSchema() {
		return new SimpleXsdSchema(new ClassPathResource("invoice.xsd"));
	}

	/**
	 * Interceptor for logging.
	 * 
	 * @return Logging interceptor.
	 */
	@Bean
	public EndpointInterceptor loggingInterceptor() {
		PayloadLoggingInterceptor loggingInterceptor = new PayloadLoggingInterceptor();

		return loggingInterceptor;
	}

	/**
	 * Payload validating interceptor.
	 * 
	 * @return Validating intercptor.
	 */
	@Bean
	public EndpointInterceptor payloadValidatingInterceptor() {
		PayloadValidatingInterceptor validatingInterceptor = new PayloadValidatingInterceptor();
		validatingInterceptor.setXsdSchema(invoiceSchema());
		validatingInterceptor.setValidateRequest(true);
		validatingInterceptor.setValidateResponse(true);

		return validatingInterceptor;
	}

	/**
	 * Interceptors.
	 */
	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
		interceptors.add(loggingInterceptor());
		interceptors.add(payloadValidatingInterceptor());
	}

	/**
	 * Marshaller configuration.
	 * 
	 * @return Marshaller.
	 */
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.lo.apps.ws.entity.invoice");
		marshaller.setSchema(new ClassPathResource("invoice.xsd"));

		return marshaller;
	}

	/**
	 * Unmarshaller configuration.
	 * 
	 * @return Unmarshaller.
	 */
	@Bean
	public Jaxb2Marshaller unmarshaller() {
		Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();
		unmarshaller.setContextPath("com.lo.apps.ws.entity.invoice");
		unmarshaller.setSchema(new ClassPathResource("invoice.xsd"));

		return unmarshaller;
	}

	/**
	 * Marshalling/unmarshalling configuration.
	 * 
	 * @return
	 */
	@Bean
	public MarshallingHttpMessageConverter marshallingConverter() {
		return new MarshallingHttpMessageConverter(marshaller(), unmarshaller());
	}

}
