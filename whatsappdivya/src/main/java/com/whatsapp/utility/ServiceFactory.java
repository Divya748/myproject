package com.whatsapp.utility;

import com.whatsapp.service.WhatsappService;
import com.whatsapp.service.WhatsappServiceInterface;

public class ServiceFactory {

	public static WhatsappServiceInterface serviceObject() {
		// TODO Auto-generated method stub
		return new WhatsappService();
	}

}
