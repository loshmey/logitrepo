package com.lo.apps.ws.service;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Element;

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

	public Element sendInvoice(Element request) throws ParserConfigurationException, IOException;

}
