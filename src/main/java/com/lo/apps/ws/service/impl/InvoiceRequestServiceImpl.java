package com.lo.apps.ws.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lo.apps.exception.InvoiceException;
import com.lo.apps.ws.entity.invoice.Invoice;
import com.lo.apps.ws.entity.invoice.ObjectFactory;
import com.lo.apps.ws.entity.invoice.SendInvoiceResponse;
import com.lo.apps.ws.entity.invoice.Status;
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
		// TODO Snimiti invoice u XML bazu

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		SendInvoiceResponse response = new ObjectFactory().createSendInvoiceResponse();
		response.setDescription("Uspesno poslata faktura!");
		response.setStatus(Status.OK);
		response.setTimestamp(sdf.format(new Date()));

		logger.debug("Slanje response-a: {}", response);

		return response;
	}

}
