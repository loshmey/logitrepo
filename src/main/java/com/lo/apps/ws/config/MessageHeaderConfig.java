package com.lo.apps.ws.config;

import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.ws.security.WSConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageHeaderConfig implements SOAPHandler<SOAPMessageContext> {

	private static final Logger logger = LoggerFactory.getLogger(MessageHeaderConfig.class);

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		logger.debug("SOAPMessageContext: {}", context);

		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		logger.debug("SOAPMessageContext: {}", context);

		return true;
	}

	@Override
	public void close(MessageContext context) {
		logger.debug("SOAPMessageContext: {}", context);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<QName> getHeaders() {
		HashSet headers = new HashSet();
		headers.add(new QName(WSConstants.WSSE_NS, "Security", "wsse"));
		headers.add(new QName(WSConstants.WSU_NS, "Security", "wsu"));

		// notify the runtime that this is handled
		return headers;
	}

}

