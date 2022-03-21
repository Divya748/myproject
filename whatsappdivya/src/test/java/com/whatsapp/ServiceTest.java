package com.whatsapp;



import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.whatsapp.entity.TimelineDetails;
import com.whatsapp.entity.WhatsappUserDetails;
import com.whatsapp.service.WhatsappService;
import com.whatsapp.service.WhatsappServiceInterface;

public class ServiceTest {
	WhatsappServiceInterface wsi = null;
	WhatsappUserDetails wud = new WhatsappUserDetails();
	TimelineDetails tld = new TimelineDetails();
	@Before
	public void setUp() throws Exception {
		wsi = new WhatsappService();
	}

	@After
	public void tearDown() throws Exception {
		wsi = null;
	}

	@Test
	public void testViewAllprofile() {
		ArrayList<WhatsappUserDetails> viewall = wsi.viewAllprofile();
		assert viewall!=null:"view all profile test case failed";
	}

	@Test
	public void testViewProfile() {
		wud.setEmail("ranganath@gmail.com");
		WhatsappUserDetails view = wsi.viewProfile(wud);
		assert view!=null:"profile doesnot exist";
	}

	@Test
	public void testDeleteProfile() {
		wud.setEmail("sai@gmail.com");
		int i = wsi.deleteProfile(wud);
		assert i>0:"profile not deleted";
	}

	@Test
	public void testEditFirstName() {
		wud.setEmail("rangath@gmail.com");
		wud.setNewfirstname("jasmine");
		int i = wsi.editFirstName(wud);
		assert i>0:"first name not editted";
	}

	@Test
	public void testEditPassword() {
		wud.setEmail("ranganath@gmail.com");
		wud.setNewfirstname("jasmine123");
		int i = wsi.editPassword(wud);
		assert i>0:"password name not editted";
	}

	@Test
	public void testEditLastName() {
		wud.setEmail("ranganath@gmail.com");
		wud.setNewfirstname("mallela");
		int i = wsi.editLastName(wud);
		assert i>0:"last name name not editted";
	}

	@Test
	public void testSignUp() {
		/*wud.setUserid("ranga123");
		wud.setFirstname("parkan");
		wud.setLastname("ranganath");
		wud.setEmail("ranganath@gmail.com");
		wud.setPassword("ranganath123");*/
		
		wud.setUserid("sai123");
		wud.setFirstname("sai");
		wud.setLastname("krupa");
		wud.setEmail("sai@gmail.com");
		wud.setPassword("sai@123");
		int i = wsi.signUp(wud);
		
		assert i>0:"signup failed";
	}

	@Test
	public void testValidation() {
		wud.setEmail1("ranganath@gmail.com");
		wud.setPassword1("ranganath123");
		WhatsappUserDetails vali = wsi.validation(wud);
		assert vali!=null:"profile doesnot exist";
	}

	@Test
	public void testTimeline() {
		tld.setMessageid("1");
		tld.setSender("sai@gmail.com");
		tld.setMassage("hello");
		tld.setDate1("12-08-2022");
		tld.setReceiver("ranga123");
		int i = wsi.timeline(tld);
		assert i>0:"timeline failed";
	}

	@Test
	public void testSearchProfile() {
		wud.setFirstname("parkan");
		List<WhatsappUserDetails> search = wsi.searchProfile(wud);
		assert search!=null:"search not found";
	}

}
