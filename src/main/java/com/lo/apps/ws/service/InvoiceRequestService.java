package com.lo.apps.ws.service;

import com.lo.apps.exception.InvoiceException;
import com.lo.apps.ws.entity.invoice.Invoice;
import com.lo.apps.ws.entity.invoice.SendInvoiceResponse;

/**
 * Interface for persisting invoice requests.
 * 
 * @author milos.poljak
 *
 */
public interface InvoiceRequestService {

	public SendInvoiceResponse sendInvoice(Invoice invoice) throws InvoiceException;

}
