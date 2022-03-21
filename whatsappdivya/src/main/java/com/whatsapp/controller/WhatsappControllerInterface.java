package com.whatsapp.controller;

import java.util.ArrayList;
import java.util.List;

import com.whatsapp.entity.WhatsappUserDetails;

public interface WhatsappControllerInterface {

	//int createProfile();

	ArrayList<WhatsappUserDetails> viewAllProfile();

	WhatsappUserDetails viewProfile();

	int deleteProfile();

	WhatsappUserDetails editProfile();

	int signUp();

	int signIn();

	int timeline();

	List<WhatsappUserDetails> searchProfile();

	

}
