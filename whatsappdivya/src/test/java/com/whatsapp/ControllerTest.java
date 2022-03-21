package com.whatsapp;



import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.whatsapp.controller.WhatsappController;
import com.whatsapp.controller.WhatsappControllerInterface;
import com.whatsapp.entity.WhatsappUserDetails;

public class ControllerTest {

	WhatsappControllerInterface ws = null;

	@Before
	public void setUp() throws Exception {
		ws = new WhatsappController();
	}

	@After
	public void tearDown() throws Exception {
		ws=null;
	}
	
	@Test
	public void testSignUp() {
		int i = ws.signUp();
		assert i>0:"test sign up is failed";
	}
	
	@Test
	public void testSignIn() {
		int i = ws.signIn();
		assert i>0:"test sign in is failed";
	}

	@Test
	public void testViewAllProfile() {
		ArrayList<WhatsappUserDetails> viewall = ws.viewAllProfile();
		assert viewall!=null:"test view all profile is failed";
		
	}

	@Test
	public void testViewProfile() {
		WhatsappUserDetails view = ws.viewProfile();
		assert view!= null:"test view profile is failed";
	}

	@Test
	public void testDeleteProfile() {
		int i = ws.deleteProfile();
		assert i>0:"test delete profile is failed";
	}

	@Test
	public void testEditProfile() {
		WhatsappUserDetails i = ws.editProfile();
		assert i!=null:"test edit profile is failed";
	}

	

	

	@Test
	public void testTimeline() {
		int i = ws.timeline();
		assert i>0:"test timeline is failed";
	}

	@Test
	public void testSearchProfile() {
		List<WhatsappUserDetails> search = ws.searchProfile();
		assert search!=null:"test search profile is failed";
	}

}
