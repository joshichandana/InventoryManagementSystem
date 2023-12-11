package com.csye7374.inventory.designPattern.factory;

import com.csye7374.inventory.designPattern.command.Communication;

public abstract class AbstractFactoryAPI {
	/**
	 * Returns an object
	 */
	public abstract Communication getObject();
}
