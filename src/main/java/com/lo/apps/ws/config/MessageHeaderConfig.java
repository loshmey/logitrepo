package com.lo.apps.ws.config;

import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageHeaderConfig implements SOAPHandler<SOAPMessageContext> {

	private static final Logger logger = LoggerFactory.getLogger(MessageHeaderConfig.class);

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		logger.debug("SOAPMessageContext: {}", context);

		return false;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		logger.debug("SOAPMessageContext: {}", context);

		return false;
	}

	@Override
	public void close(MessageContext context) {
		logger.debug("SOAPMessageContext: {}", context);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Set<QName> getHeaders() {
		final QName securityHeader1 = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Security", "wsse");
		final QName securityHeader2 = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", "Security", "wsu");
		final HashSet headers = new HashSet();
		headers.add(securityHeader1);
		headers.add(securityHeader2);

		// notify the runtime that this is handled
		return headers;
	}

}
