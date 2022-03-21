package com.whatsapp.utility;

import com.whatsapp.dao.WhatsappDAO;
import com.whatsapp.dao.WhatsappDAOinterface;

public class DAOFactory {

	public static WhatsappDAOinterface daoObject() {
		// TODO Auto-generated method stub
		return new WhatsappDAO();
	}

}
