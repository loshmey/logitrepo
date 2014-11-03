package com.lo.apps.ws.entity.invoice;


public class Demo {

	// public static void main(String[] args) throws Exception {
	// InvoiceRequest invoiceRequest = new InvoiceRequest();
	//
	// InvoiceHeader invoiceHeader = new InvoiceHeader();
	// InvoiceRecord invoiceRecord = new InvoiceRecord();
	//
	// Account account = new Account();
	// Buyer buyer = new Buyer();
	// Supplier supplier = new Supplier();
	// Transaction transaction = new Transaction();
	// Sums sums = new Sums();
	//
	// account.setAccountDate(new Date());
	// account.setAccountNumber("123");
	//
	// buyer.setAccount(account);
	// buyer.setBuyerAddress("My street");
	// buyer.setBuyerName("Buyer 1");
	// buyer.setBuyerPIB("1111");
	//
	// supplier.setSupplierAddress("Supplier address");
	// supplier.setSupplierName("Suppa");
	// supplier.setSupplierPIB("2222");
	//
	// sums.setMerchAndServiceSum(new BigDecimal(5).setScale(4,
	// RoundingMode.CEILING));
	// sums.setRebateSum(new BigDecimal(2).setScale(4, RoundingMode.CEILING));
	// sums.setTaxSum(new BigDecimal(0.5).setScale(4, RoundingMode.CEILING));
	//
	// transaction.setAmountToPay(new BigDecimal(10).setScale(4,
	// RoundingMode.CEILING));
	// transaction.setCurrencyCode("RSD");
	// transaction.setDateOfCurrency(new Date());
	// transaction.setMerchValue(new BigDecimal(20).setScale(4,
	// RoundingMode.CEILING));
	// transaction.setPayToAccount("3333");
	// transaction.setServiceValue(new BigDecimal(30).setScale(4,
	// RoundingMode.CEILING));
	// transaction.setSums(sums);
	//
	// invoiceHeader.setBuyer(buyer);
	// invoiceHeader.setSupplier(supplier);
	// invoiceHeader.setTransaction(transaction);
	//
	// invoiceRecord.setAmount(new BigDecimal(4).setScale(4,
	// RoundingMode.CEILING));
	// invoiceRecord.setMerchOrServiceName("Merch 1");
	// invoiceRecord.setRebateAmount(new BigDecimal(0.3).setScale(4,
	// RoundingMode.CEILING));
	// invoiceRecord.setRebateDeducted(new BigDecimal(0).setScale(4,
	// RoundingMode.CEILING));
	// invoiceRecord.setRebatePercentage(new BigDecimal(0.1).setScale(4,
	// RoundingMode.CEILING));
	// invoiceRecord.setRecordNumber("123");
	// invoiceRecord.setTaxTotal(new BigDecimal(0.1).setScale(4,
	// RoundingMode.CEILING));
	// invoiceRecord.setUnitOfIssue("Unit");
	// invoiceRecord.setUnitPrice(new BigDecimal(11.2).setScale(4,
	// RoundingMode.CEILING));
	// invoiceRecord.setValue(new BigDecimal(11.99).setScale(4,
	// RoundingMode.CEILING));
	//
	// invoiceRequest.setInvoiceId(1);
	// invoiceRequest.setTimestamp(new Date());
	// invoiceRequest.setInvoiceHeaderData(invoiceHeader);
	// invoiceRequest.getInvoiceRecordData().add(invoiceRecord);
	//
	// JAXBContext jc = JAXBContext.newInstance(InvoiceRequest.class);
	// Marshaller marshaller = jc.createMarshaller();
	// marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	//
	// // Marshal Billing Address
	// ObjectFactory objectFactory = new ObjectFactory();
	// JAXBElement<InvoiceRequest> ir =
	// objectFactory.createInvoiceRequest(invoiceRequest);
	// marshaller.marshal(ir, System.out);
	//
	// }

}
