package com.lo.apps.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lo.apps.ws.entity.invoice.InvoiceRequest;
import com.lo.apps.ws.repository.InvoiceRequestRepository;
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

	@Autowired
	private InvoiceRequestRepository repo;

	@Override
	public void saveInvoiceRequest(InvoiceRequest request) {
		logger.debug("In saveInvoiceRequest method, saving: {}", request);
		repo.save(request);
		logger.debug("In saveInvoiceRequest method, saved: {}", request);
	}

	@Override
	public void deleteInvoiceRequest(InvoiceRequest request) {
		logger.debug("In deleteInvoiceRequest method, deleting: {}", request);
		repo.delete(request);
		logger.debug("In saveInvoiceRequest method finish...");
	}

	@Override
	public InvoiceRequest findById(Long invoiceId) {
		logger.debug("In findById method, find by id: {}", invoiceId);
		InvoiceRequest invReqFromDb = new InvoiceRequest();
		invReqFromDb = repo.findOne(invoiceId);
		logger.debug("In findById method, found: {}", invReqFromDb);

		return invReqFromDb;
	}

	@Override
	public List<InvoiceRequest> findAllInvoices() {
		logger.debug("In findAllInvoices method start...");
		List<InvoiceRequest> allInvoices = new ArrayList<InvoiceRequest>();
		allInvoices = (List<InvoiceRequest>) repo.findAll();
		logger.debug("In findAllInvoices method, found: {}", allInvoices);

		return allInvoices;
	}
}
