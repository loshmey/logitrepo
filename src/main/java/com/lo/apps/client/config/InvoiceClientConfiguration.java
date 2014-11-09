package com.lo.apps.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.lo.apps.client.invoice.InvoiceClient;

@Configuration
public class InvoiceClientConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.lo.apps.ws.entity.invoice");

		return marshaller;
	}

	@Bean
	public InvoiceClient invoiceClient(Jaxb2Marshaller marshaller) {
		InvoiceClient client = new InvoiceClient();
		String defaultUri = "http://localhost:8080/holidayService/ws";
		client.setDefaultUri(defaultUri);
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);

		return client;
	}

}
