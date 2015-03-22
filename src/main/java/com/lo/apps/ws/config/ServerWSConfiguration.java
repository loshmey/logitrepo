package com.lo.apps.ws.config;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.ws.soap.security.wss4j.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j.callback.KeyStoreCallbackHandler;
import org.springframework.ws.soap.security.wss4j.support.CryptoFactoryBean;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
@PropertySource(value = { "application.properties" })
public class ServerWSConfiguration extends WsConfigurerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(ServerWSConfiguration.class);

	/**
	 * Dispatcher servlet configuration.
	 * 
	 * @param applicationContext
	 * @return
	 */
	@Bean
	public ServletRegistrationBean dispatcherServlet(ApplicationContext applicationContext) {
		logger.debug("In dispatcherServlet()...");
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);

		return new ServletRegistrationBean(servlet, "/*");
	}

	/**
	 * WSDL configuration.
	 * 
	 * @param invoiceSchema
	 * @return WSDL definition.
	 */
	@Bean(name = "invoice")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema invoiceSchema) {
		logger.debug("In defaultWsdl11Definition()...");
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
		logger.debug("In invoiceSchema()...");
		return new SimpleXsdSchema(new ClassPathResource("invoice.xsd"));
	}

	/**
	 * Interceptor for logging.
	 * 
	 * @return Logging interceptor.
	 */
	@Bean
	public EndpointInterceptor loggingInterceptor() {
		logger.debug("In loggingInterceptor()...");
		PayloadLoggingInterceptor loggingInterceptor = new PayloadLoggingInterceptor();

		return loggingInterceptor;
	}

	/**
	 * Interceptors.
	 */
	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
		logger.debug("In addInterceptors(), registering interceptors...");
		interceptors.add(loggingInterceptor());
		interceptors.add(securityInterceptor());
		interceptors.add(payloadValidatingInterceptor());
	}

	/**
	 * Marshaller configuration.
	 * 
	 * @return Marshaller.
	 */
	@Bean
	public Jaxb2Marshaller marshaller() {
		logger.debug("In marshaller()...");
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
		logger.debug("In unmarshaller()...");
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
		logger.debug("In marshallingConverter()...");
		return new MarshallingHttpMessageConverter(marshaller(), unmarshaller());
	}

	/**
	 * Security Interceptor.
	 * 
	 * @return securityInterceptor
	 */
	@Bean
	public Wss4jSecurityInterceptor securityInterceptor() {
		logger.debug("In securityInterceptor()...");
		Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
		configureValidation(securityInterceptor);
		configureSecurement(securityInterceptor);

		return securityInterceptor;
	}

	/**
	 * Payload Validating Interceptor.
	 * 
	 * @return payloadValidatingInterceptor
	 */
	@Bean
	public PayloadValidatingInterceptor payloadValidatingInterceptor() {
		PayloadValidatingInterceptor payloadValidatingInterceptor = new PayloadValidatingInterceptor();
		payloadValidatingInterceptor.setSchema(new ClassPathResource("invoice.xsd"));
		payloadValidatingInterceptor.setValidateRequest(true);
		payloadValidatingInterceptor.setValidateResponse(true);

		return payloadValidatingInterceptor;
	}

	/**
	 * Sets validation actions to interceptor.
	 * 
	 * @param securityInterceptor
	 * @return
	 */
	private void configureValidation(Wss4jSecurityInterceptor securityInterceptor) {
		try {
			securityInterceptor.setValidationActions("Timestamp Signature Encrypt");

			securityInterceptor.setTimestampStrict(true);
			securityInterceptor.setValidationTimeToLive(10);
			securityInterceptor.setFutureTimeToLive(10);

			securityInterceptor.setEnableSignatureConfirmation(true);

			securityInterceptor.setValidationSignatureCrypto(keyStore().getObject());
			securityInterceptor.setValidationDecryptionCrypto(keyStore().getObject());
			securityInterceptor.setValidationCallbackHandler(validationCallbackHandler());
		} catch (Exception e) {
			logger.debug("!!! Error setting validation crypto !!!");
			logger.debug("!!! Error message: {}", e.getMessage());
			e.printStackTrace();
		}
	}

	@Bean
	public KeyStoreCallbackHandler validationCallbackHandler() {
		KeyStoreCallbackHandler validationCallbackHandler = new KeyStoreCallbackHandler();
		validationCallbackHandler.setPrivateKeyPassword("bank2_pass");

		return validationCallbackHandler;
	}

	/**
	 * Sets securement actions to interceptor.
	 * 
	 * @param securityInterceptor
	 * @return
	 */
	private void configureSecurement(Wss4jSecurityInterceptor securityInterceptor) {
		try {
			securityInterceptor.setSecurementActions("Timestamp Signature Encrypt");

			securityInterceptor.setSecurementEncryptionKeyIdentifier("IssuerSerial");
			securityInterceptor.setSecurementEncryptionKeyTransportAlgorithm("http://www.w3.org/2001/04/xmlenc#rsa-1_5");
			securityInterceptor.setSecurementEncryptionSymAlgorithm("http://www.w3.org/2001/04/xmlenc#aes128-cbc");

			securityInterceptor.setSecurementTimeToLive(10);
			securityInterceptor.setFutureTimeToLive(10);
			securityInterceptor.setTimestampPrecisionInMilliseconds(true);
			securityInterceptor.setTimestampStrict(true);

			securityInterceptor.setSecurementUsername("bank2");
			securityInterceptor.setSecurementPassword("bank2_pass");
			securityInterceptor.setSecurementSignatureCrypto(keyStore().getObject());

			securityInterceptor.setSecurementEncryptionUser("bank1");
			securityInterceptor.setSecurementEncryptionCrypto(keyStore().getObject());
			securityInterceptor.setSecurementEncryptionParts("{Content}{http://localhost:8080/invoice/schema}SendInvoiceResponse");
		} catch (Exception e) {
			logger.debug("!!! Error setting signature crypto !!!");
			logger.debug("!!! Error message: {}", e.getMessage());
			e.printStackTrace();
		}
	}

	@Bean
	public CryptoFactoryBean keyStore() throws IOException {
		logger.debug("In signatureCrypto()...");
		CryptoFactoryBean signatureCrypto = new CryptoFactoryBean();
		signatureCrypto.setKeyStoreLocation(new ClassPathResource("/security/keys/bank2.jks"));
		signatureCrypto.setKeyStorePassword("bank2_pass");

		return signatureCrypto;
	}

}
