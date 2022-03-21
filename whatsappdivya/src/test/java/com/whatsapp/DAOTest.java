package com.whatsapp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.whatsapp.dao.WhatsappDAO;
import com.whatsapp.dao.WhatsappDAOinterface;
import com.whatsapp.entity.TimelineDetails;
import com.whatsapp.entity.WhatsappUserDetails;

public class DAOTest {
	WhatsappDAOinterface wd=null;
	WhatsappUserDetails wud = new WhatsappUserDetails();
	TimelineDetails tld = new TimelineDetails();
	@Before
	public void setUp() throws Exception {
		wd = new WhatsappDAO();
	}

	@After
	public void tearDown() throws Exception {
		wd = null;
	}

	@Test
	public void testSignUp() {
		wud.setUserid("sai123");
		wud.setFirstname("sai");
		wud.setLastname("krupa");
		wud.setEmail("sai@gmail.com");
		wud.setPassword("sai@123");
		int i = wd.signUp(wud);
		
		assert i>0:"signup failed";
	}

	@Test
	public void testValidation() {
		wud.setEmail1("ranganath@gmail.com");
		wud.setPassword1("ranganath123");
		WhatsappUserDetails vali = wd.validation(wud);
		assert vali!=null:"profile doesnot exist";
	}

	@Test
	public void testViewAllProfile() {
		ArrayList<WhatsappUserDetails> viewall = wd.viewAllProfile();
		assert viewall!=null:"view all profile test case failed";
	}

	@Test
	public void testViewProfile() {
		wud.setEmail("ranganath@gmail.com");
		WhatsappUserDetails view = wd.viewProfile(wud);
		assert view!=null:"profile doesnot exist";
	}

	@Test
	public void testEditFirstName() {
		wud.setEmail("rangath@gmail.com");
		wud.setNewfirstname("jasmine");
		int i = wd.editFirstName(wud);
		assert i>0:"first name not editted";
	}

	@Test
	public void testEditLastName() {
		wud.setEmail("ranganath@gmail.com");
		wud.setNewfirstname("mallela");
		int i = wd.editLastName(wud);
		assert i>0:"last name name not editted";
	}

	@Test
	public void testEditPassword() {
		wud.setEmail("ranganath@gmail.com");
		wud.setNewfirstname("jasmine123");
		int i = wd.editPassword(wud);
		assert i>0:"password name not editted";

	}

	@Test
	public void testTimeline() {
		tld.setMessageid("1");
		tld.setSender("sai@gmail.com");
		tld.setMassage("hello");
		tld.setDate1("12-08-2022");
		tld.setReceiver("ranga123");
		int i = wd.timeline(tld);
		assert i>0:"timeline failed";
	}

	@Test
	public void testSearchProfile() {
		wud.setFirstname("parkan");
		List<WhatsappUserDetails> search = wd.searchProfile(wud);
		assert search!=null:"search not found";
	}

	@Test
	public void testDeleteProfile() {
		wud.setEmail("sai@gmail.com");
		int i = wd.deleteProfile(wud);
		assert i>0:"profile not deleted";
	}

}
