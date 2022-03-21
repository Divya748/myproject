package com.whatsapp.service;

import java.util.ArrayList;
import java.util.List;

import com.whatsapp.dao.WhatsappDAOinterface;
import com.whatsapp.entity.TimelineDetails;
import com.whatsapp.entity.WhatsappUserDetails;
import com.whatsapp.utility.DAOFactory;

public class WhatsappService implements WhatsappServiceInterface {

	/*public int createProfile(WhatsappUserDetails wud) {
		WhatsappDAOinterface dao = DAOFactory.daoObject();
		int i = dao.createProfile(wud);
		return i;
	}*/

	public ArrayList<WhatsappUserDetails> viewAllprofile() {
		/*
		 Function Name : viewAllProfile()
		 Params		   : Null
		 Description   : method viewallprofile in controller layer will call
		 				 this function is responsible to call function in 
		 				 dao layer and returns data of all profiles in database.
		 return		   : It returns all profiles to controller layer.
		 
		 
		 written by : MALLELA DIVYA
		 */
		WhatsappDAOinterface dao = DAOFactory.daoObject();
		ArrayList<WhatsappUserDetails> s = dao.viewAllProfile();
		return s;
	}

	public WhatsappUserDetails viewProfile(WhatsappUserDetails wud) {
		/*
		 Function Name : viewProfile()
		 Params		   : WhatsappUserDetails wud i.e; data of entity layer
		 Description   : method viewprofile in controller layer will call
		 			     this function and this function is responsible to call 
		 			     function in dao layer and returns data of a profile 
		 			     from the database based on email given by user.
		 return		   : It returns profile to controller layer.
		 
		 
		 written by : MALLELA DIVYA
		 */
		WhatsappDAOinterface dao = DAOFactory.daoObject();
		WhatsappUserDetails s=dao.viewProfile(wud);
		return s;
	}

	public int deleteProfile(WhatsappUserDetails wud) {
		/*
		 Function Name : deleteProfile()
		 Params		   : WhatsappUserDetails wud i.e; data of entity layer
		 Description   : method deleteprofile in controller layer will call
		 			     this function and this function is responsible to call 
		 			     function in dao layer and deletes data of a profile 
		 			     from the database based on email given by user.
		 return		   : It returns an integer represents whether profile is 
		  				 deleted or not to controller layer.
		 
		 
		 written by : MALLELA DIVYA
		 */

		WhatsappDAOinterface dao = DAOFactory.daoObject();
		int i = dao.deleteProfile(wud);
		return i;
	}

	public int editFirstName(WhatsappUserDetails wud) {
		WhatsappDAOinterface dao = DAOFactory.daoObject();
		int i = dao.editFirstName(wud);
		return i;
	}

	public int editPassword(WhatsappUserDetails wud) {
		WhatsappDAOinterface dao = DAOFactory.daoObject();
		int i = dao.editPassword(wud);
		return i;
		
	}

	public int editLastName(WhatsappUserDetails wud) {
		WhatsappDAOinterface dao = DAOFactory.daoObject();
		int i = dao.editLastName(wud);
		return i;
	}

	@Override
	public int signUp(WhatsappUserDetails wud) {
		WhatsappDAOinterface dao = DAOFactory.daoObject();
		int i = dao.signUp(wud);
		return i;
	}

	@Override
	public WhatsappUserDetails validation(WhatsappUserDetails wud) {
		WhatsappDAOinterface dao = DAOFactory.daoObject();
		WhatsappUserDetails s=dao.validation(wud);
		return s;
	}

	@Override
	public int timeline(TimelineDetails tld) {
		WhatsappDAOinterface dao = DAOFactory.daoObject();
		int t=dao.timeline(tld);
		return t;
		
	}

	@Override
	public List<WhatsappUserDetails> searchProfile(WhatsappUserDetails wud) {
		WhatsappDAOinterface dao = DAOFactory.daoObject();
		List<WhatsappUserDetails> s = dao.searchProfile(wud);
		return s;
	}

	

	

	/*public int editProfile(WhatsappUserDetails wud) {
		WhatsappDAOinterface dao = new WhatsappDAO();
		int i = dao.editProfile(wud);
		return i;
		
	}*/

}
