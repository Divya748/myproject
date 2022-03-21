package com.whatsapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.whatsapp.entity.TimelineDetails;
import com.whatsapp.entity.WhatsappUserDetails;

public interface WhatsappDAOinterface {

	//int createProfile(WhatsappUserDetails wud);

	ArrayList<WhatsappUserDetails> viewAllProfile();

	WhatsappUserDetails viewProfile(WhatsappUserDetails wud);

	int deleteProfile(WhatsappUserDetails wud);

	//int editProfile(WhatsappUserDetails wud);

	int editFirstName(WhatsappUserDetails wud);

	int editPassword(WhatsappUserDetails wud);

	int editLastName(WhatsappUserDetails wud);

	int signUp(WhatsappUserDetails wud);

	WhatsappUserDetails validation(WhatsappUserDetails wud);

	int timeline(TimelineDetails tld);

	List<WhatsappUserDetails> searchProfile(WhatsappUserDetails wud);

}
