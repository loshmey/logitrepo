package com.lo.apps.ws.service;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
	public void saveRequestAsXML(Element element) throws Exception;

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
