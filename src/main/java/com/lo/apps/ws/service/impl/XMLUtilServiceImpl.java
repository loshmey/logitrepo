package com.lo.apps.ws.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import com.lo.apps.ws.service.XMLUtilService;

/**
 * XMLUtilService implementation.
 * 
 * @author milos.poljak
 *
 */
@Service
public class XMLUtilServiceImpl implements XMLUtilService {

	@Value("${exist.db.url}")
	private String dbUrl;

	@Value("${exist.db.collection}")
	private String dbCollectionName;

	@Value("${exist.db.username}")
	private String dbUsername;

	@Value("${exist.db.password}")
	private String dbPass;

	@Value("${exist.db.driver-class-name}")
	private String dbDriver;

	@Override
	public void saveRequestAsXML(Element element) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		Long timestamp = cal.getTimeInMillis();

		Database db = (Database) Class.forName(dbDriver).newInstance();
		DatabaseManager.registerDatabase(db);

		Collection col = DatabaseManager.getCollection(dbUrl + dbCollectionName, dbUsername, dbPass);

		XMLResource res = (XMLResource) col.createResource(timestamp.toString() + ".xml", "XMLResource");
		res.setContentAsDOM(element.getOwnerDocument());
		col.storeResource(res);

		if (col.isOpen()) {
			col.close();
		}
	}

	@Override
	public Document fetchXMLFromDBById(String id) throws Exception {
		return null;
	}

	@SuppressWarnings("unused")
	@Override
	public String[] fetchAllXMLDocuments() throws Exception {
		String[] result = null;
		Collection dbCollection;
		Resource document;

		try {
			Database db = (Database) Class.forName(dbDriver).newInstance();
			DatabaseManager.registerDatabase(db);

			dbCollection = DatabaseManager.getCollection(dbUrl + dbCollectionName, dbUsername, dbPass);

			result = dbCollection.listResources();
			document = dbCollection.getResource(result[0]);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | XMLDBException e) {
			e.printStackTrace();
		}

		return result;
	}

}
