package com.whatsapp.utility;

import com.whatsapp.controller.WhatsappController;
import com.whatsapp.controller.WhatsappControllerInterface;

public class ControllerFactory {

	public static WhatsappControllerInterface controllerObject() {
		// TODO Auto-generated method stub
		return new WhatsappController();
	}

}
