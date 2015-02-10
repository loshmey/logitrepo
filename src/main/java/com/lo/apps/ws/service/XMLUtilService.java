package com.lo.apps.ws.service;

import org.w3c.dom.Document;

import com.lo.apps.ws.entity.invoice.SendInvoiceRequest;

/**
 * XML handling service.
 * 
 * @author milos.poljak
 *
 */
public interface XMLUtilService {

	/**
	 * Saves request to XML database.
	 * 
	 * @param request
	 * @throws Exception
	 */
	public void saveRequestAsXML(SendInvoiceRequest request) throws Exception;

	/**
	 * Fetches XML from DB by id.
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Document fetchXMLFromDBById(String id) throws Exception;

	/**
	 * Fetches all XML documents from db.
	 * 
	 * @return
	 * @throws Exception
	 */
	public String[] fetchAllXMLDocuments() throws Exception;

}
