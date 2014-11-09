package com.lo.apps.ws.testrepo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.lo.apps.ws.entity.invoice.Account;
import com.lo.apps.ws.entity.invoice.Buyer;
import com.lo.apps.ws.entity.invoice.InvoiceHeader;
import com.lo.apps.ws.entity.invoice.InvoiceRecord;
import com.lo.apps.ws.entity.invoice.InvoiceRequest;
import com.lo.apps.ws.entity.invoice.Sums;
import com.lo.apps.ws.entity.invoice.Supplier;
import com.lo.apps.ws.entity.invoice.Transaction;

/**
 * Test invoice dok se ne sredi citanje/upis u bazu.
 * 
 * @author milos.poljak
 *
 */
@Component
public class InvoiceRepo {

	private static final List<InvoiceRequest> invoices = new ArrayList<InvoiceRequest>();

	@PostConstruct
	public void initData() {
		InvoiceRequest invoiceRequest = new InvoiceRequest();

		InvoiceHeader invoiceHeader = new InvoiceHeader();
		InvoiceRecord invoiceRecord = new InvoiceRecord();

		Account account = new Account();
		Buyer buyer = new Buyer();
		Supplier supplier = new Supplier();
		Transaction transaction = new Transaction();
		Sums sums = new Sums();

		account.setAccountDate(new Date());
		account.setAccountNumber("123");

		buyer.setAccount(account);
		buyer.setBuyerAddress("My street");
		buyer.setBuyerName("Buyer 1");
		buyer.setBuyerPIB("1111");

		supplier.setSupplierAddress("Supplier address");
		supplier.setSupplierName("Suppa");
		supplier.setSupplierPIB("2222");

		sums.setMerchAndServiceSum(new BigDecimal(5));
		sums.setRebateSum(new BigDecimal(2));
		sums.setTaxSum(new BigDecimal(0.5));

		transaction.setAmountToPay(new BigDecimal(10));
		transaction.setCurrencyCode("RSD");
		transaction.setDateOfCurrency(new Date());
		transaction.setMerchValue(new BigDecimal(20));
		transaction.setPayToAccount("3333");
		transaction.setServiceValue(new BigDecimal(30));
		transaction.setSums(sums);

		invoiceHeader.setBuyer(buyer);
		invoiceHeader.setSupplier(supplier);
		invoiceHeader.setTransaction(transaction);

		invoiceRecord.setAmount(new BigDecimal(4));
		invoiceRecord.setMerchOrServiceName("Merch 1");
		invoiceRecord.setRebateAmount(new BigDecimal(0.3));
		invoiceRecord.setRebateDeducted(new BigDecimal(0));
		invoiceRecord.setRebatePercentage(new BigDecimal(0.1));
		invoiceRecord.setRecordNumber("123");
		invoiceRecord.setTaxTotal(new BigDecimal(0.1));
		invoiceRecord.setUnitOfIssue("Unit");
		invoiceRecord.setUnitPrice(new BigDecimal(11.2));
		invoiceRecord.setValue(new BigDecimal(11.99));

		invoiceRequest.setRequestDateTime(new Date());
		invoiceRequest.setInvoiceHeaderData(invoiceHeader);
		invoiceRequest.getInvoiceRecordData().add(invoiceRecord);

		invoices.add(invoiceRequest);
	}

	public InvoiceRequest getInvoice() {
		InvoiceRequest result = null;
		if (!invoices.isEmpty()) {
			result = invoices.get(0);
		}

		return result;
	}

}
