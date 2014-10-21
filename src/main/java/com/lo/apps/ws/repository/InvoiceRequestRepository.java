package com.lo.apps.ws.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lo.apps.ws.entity.invoice.InvoiceRequest;

@Repository
public interface InvoiceRequestRepository extends CrudRepository<InvoiceRequest, Long> {

}
