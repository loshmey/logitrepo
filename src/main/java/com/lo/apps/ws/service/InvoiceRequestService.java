package com.lo.apps.ws.service;

import java.util.List;

import com.lo.apps.ws.entity.invoice.InvoiceRequest;

/**
 * Interface for persisting invoice requests.
 * 
 * @author milos.poljak
 *
 */
public interface InvoiceRequestService {

	/**
	 * Save invoice request.
	 * 
	 * @param request
	 */
	public void saveInvoiceRequest(InvoiceRequest request);

	/**
	 * Delete invoice request.
	 * 
	 * @param request
	 */
	public void deleteInvoiceRequest(InvoiceRequest request);

	/**
	 * Find invoice request by invoice request id.
	 * 
	 * @param invoiceId
	 *            Invoice request id.
	 * @return Invoice request entity.
	 */
	public InvoiceRequest findById(Long invoiceId);

	/**
	 * Find all invoice requests.
	 * 
	 * @return List of all invoice requests.
	 */
	public List<InvoiceRequest> findAllInvoices();

}
