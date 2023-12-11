package com.csye7374.inventory.designPattern.facade;

import com.csye7374.inventory.repository.InvoiceRepository;

public abstract class Facade {

	protected abstract void udpTrigger(String msg);
	
	protected abstract void pdfGen(int id, InvoiceRepository invoiceRepo);
	
}
