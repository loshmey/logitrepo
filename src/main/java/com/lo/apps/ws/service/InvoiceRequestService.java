package com.lo.apps.ws.service;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;

import com.lo.apps.ws.entity.invoice.SendInvoiceResponse;

/**
 * Interface for persisting invoice requests.
 * 
 * @author milos.poljak
 *
 */
public interface InvoiceRequestService {

	SendInvoiceResponse sendInvoice(Element request) throws ParserConfigurationException, IOException;

}
