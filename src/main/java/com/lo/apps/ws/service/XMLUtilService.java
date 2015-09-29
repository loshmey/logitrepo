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
	 * @param element Request as element.
	 * @throws Exception
	 */
	void saveRequestAsXML(Element element) throws Exception;

	/**
	 * Fetches XML from DB by id.
	 * 
	 * @param id xml id
	 * @return xml document
	 * @throws Exception
	 */
	Document fetchXMLFromDBById(String id) throws Exception;

	/**
	 * Fetches all XML documents from db.
	 * 
	 * @return all xml documents
	 * @throws Exception
	 */
	String[] fetchAllXMLDocuments() throws Exception;

}
