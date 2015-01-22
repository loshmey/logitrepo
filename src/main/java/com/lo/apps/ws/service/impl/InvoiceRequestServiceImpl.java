package com.lo.apps.ws.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lo.apps.exception.InvoiceException;
import com.lo.apps.ws.entity.invoice.Invoice;
import com.lo.apps.ws.entity.invoice.SendInvoiceResponse;
import com.lo.apps.ws.service.InvoiceRequestService;

/**
 * Implementation of InvoiceRequestService, handles crud operations.
 * 
 * @author milos.poljak
 *
 */
@Service
public class InvoiceRequestServiceImpl implements InvoiceRequestService {

	private static final Logger logger = LoggerFactory.getLogger(InvoiceRequestServiceImpl.class);

	@Override
	public SendInvoiceResponse sendInvoice(Invoice invoice) throws InvoiceException {

		return null;
	}

}
