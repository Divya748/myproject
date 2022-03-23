package com.whatsapp.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;



import com.whatsapp.entity.TimelineDetails;
import com.whatsapp.entity.WhatsappUserDetails;

import com.whatsapp.service.WhatsappServiceInterface;
import com.whatsapp.utility.EntityFactory;
import com.whatsapp.utility.ServiceFactory;
 


public class WhatsappController implements WhatsappControllerInterface {
	WhatsappServiceInterface ws=null;
	Logger log =Logger.getLogger("WhatsappController");
	Scanner sc = new Scanner(System.in);
	static String userid;
	
	static int i,v;
	
	public WhatsappController() {
		ws= ServiceFactory.serviceObject();
	}
	
	
	
	/*public int createProfile() {
		/*
		 Function-Name 	: createProfile
		 Params 		: None
		 Description 	: Function task is to create profile of the user using their name,password,email and address
		 Output 		: Profile created or not
		 Return-type 	: Integer
		 
		 written by : Mallela Divya
		 
		
		log.info("enter your name");
		String name = sc.next();
		
		log.info("enter your password");
		String password = sc.next();
		
		log.info("enter your email");
		String email = sc.next();
		
		log.info("enter your address");
		String address = sc.next();
		
		WhatsappUserDetails wud = EntityFactory.entityObject();
		
		wud.setName(name);
		wud.setPassword(password);
		wud.setEmail(email);
		wud.setAddress(address);
		
		
				
		
		i = ws.createProfile(wud);
		
		if(i>0) {
			log.info("profile created");
		}
		else {
			log.info("profile not created");
		}
		return i;
	}*/

public int signUp() {
		
		log.info("Enter your First name");
		String firstname = sc.next();
		
		log.info("Enter your Last name");
		String lastname = sc.next();
		
		log.info("Enter userid with special characters and numbers");
		userid = sc.next();
		
		log.info("Enter email");
		String email = sc.next();
		
		log.info("Enter password");
		String password = sc.next();
		
		
		
		
		WhatsappUserDetails wud = EntityFactory.entityObject();
		
		wud.setUserid(userid);
		wud.setFirstname(firstname);
		wud.setLastname(lastname);
		wud.setEmail(email);
		wud.setPassword(password);
		
		
		i = ws.signUp(wud);
		
		if(i>0) {
			log.info("Profile Created");
		}
		else {
			log.info("oops! something went wrong");
		}
		return i;
		
	}

@Override
public int signIn() {
	log.info("Enter email");
	String email1 = sc.next();
	
	log.info("Enter password");
	String password1 = sc.next();
	
	WhatsappUserDetails wud = EntityFactory.entityObject();
	
	wud.setEmail1(email1);
	wud.setPassword1(password1);
	
	
	WhatsappUserDetails s1=ws.validation(wud);
	if(s1!=null) {
	if((s1.getPassword().equals(wud.getPassword1())) && (s1.getEmail().equals(wud.getEmail1()))) {
		v=1;
	
	}
	}
	else {
		log.info("record not found for email "+email1);
	}
	return v;
	
	
}


	public ArrayList<WhatsappUserDetails> viewAllProfile() {
		
		/*
		 Function-Name 	: viewprofile
		 Params 		: None
		 Description 	: Function task is to view all profiles in the database.
		 Output			: All profiles in the database
		 Return-type 	: None
		 
		 written by : Mallela Divya
		 */
		
		
		
		ArrayList<WhatsappUserDetails> l1= ws.viewAllprofile();
		l1.forEach(i->{
			log.info("******************");
			log.info("First name is "+i.getFirstname());
			log.info("Name is "+i.getLastname());
			log.info("User-Id is "+i.getUserid());
			log.info("Email is "+i.getEmail());
			log.info("Password is "+i.getPassword());
			
			});
		/*for(WhatsappUserDetails i:l1) {
			log.info("******************");
			log.info("Name is "+i.getName());
			log.info("Email is "+i.getPassword());
			log.info("Password is "+i.getEmail());
			log.info("Address is "+i.getAddress());
			
		}*/
		//log.info("after sorting");
		
		//Collections.sort(l1, new SortByFirstName());
		return l1;
	}

	public WhatsappUserDetails viewProfile() {
		
		/*
		 Function-Name 	: viewprofile
		 Params 		: None
		 Description 	: Function task is to view profile of the user based on the email given by the user.
		 Output			: Profile of a user
		 Return-type 	: None
		 
		 written by : Mallela Divya
		 */
		
		
		
		log.info("enter email to see profile of that email");
		String email = sc.next();
		
		WhatsappUserDetails wud = EntityFactory.entityObject();
		wud.setEmail(email);
		
		WhatsappUserDetails s1=ws.viewProfile(wud);
		
		if(s1!=null) {
			log.info("***************************************************");
			log.info("FirstName \t LastName \t Email \t password");
			log.info("---------------------------------------------------");
			log.info(s1.getFirstname()+"\t"+s1.getLastname()+"\t"+s1.getEmail()+"\t"+s1.getPassword());
			log.info("***************************************************");
		}
		else {
			log.info("Profile not found");
		}
		
		return s1;
	}

	public int deleteProfile() {
		
		/*
		 Function-Name 		: createProfile
		 Params 			: None
		 Description 		: Function task is to delete profile of the user based on the email given by the user.
		 Output				: Profile deleted or not.
		 Return-type 		: None
		 
		 written by : Mallela Divya
		 */
		
		log.info("enter email to delete the profile");
		String sender_email= sc.next();
		
		
		WhatsappUserDetails wud = EntityFactory.entityObject();
		wud.setEmail(sender_email);
		
		
		i = ws.deleteProfile(wud);
		
		if(i>0) { 
			log.info("profile deleted");
		}
		else {
			log.info("profile not deleted");
		}
		return i;
	}

	public WhatsappUserDetails editProfile() {
		
		/*
		 Function-Name 		: editProfile
		 Params 			: None
		 Description 		: Function task is to edit profile of the user based on the email given by the user.
		 						based on their choice..
		 						1. If they want to edit name press 1
		 						2. If they want to edit password press 2
		 						3. If they want to edit address press 3
		 Output				: Profile edited or not.
		 Return-type 		: None
		 
		 written by : Mallela Divya
		 */
		
		log.info("enter email to edit the profile");
		String email = sc.next();
		
		
		
		WhatsappUserDetails wud = EntityFactory.entityObject();
		wud.setEmail(email);
		
		WhatsappUserDetails s1=ws.viewProfile(wud);
		
		log.info("Profile details");
		if(s1!=null) {
			log.info("***************************************************");
			log.info("FirstName \t LastName \t Password \t Email");
			log.info("---------------------------------------------------");
			log.info(s1.getFirstname()+"\t"+s1.getLastname()+"\t"+s1.getPassword()+"\t"+s1.getEmail());
			log.info("***************************************************");
			
			log.info("enter your choice to edit particular field");
			log.info("press 1 to edit First Name \n"
								+"press 2 to edit Password \n"
								+"press 3 to edit Last name");
			int ch=sc.nextInt();
			
			switch(ch) {
				case 1: log.info("enter new firstname");
						String newfirstname = sc.next();
						wud.setNewfirstname(newfirstname);
						i = ws.editFirstName(wud);
						
						if(i>0) { 
							log.info("First Name edited");
						}
						else {
							log.info("oops! Name not updated");
						}
						break;
				
				case 2: log.info("enter new password");
						String newpassword = sc.next();
						wud.setNewpassword(newpassword);
						i = ws.editPassword(wud);
						
						if(i>0) { 
							log.info("Password updated");
						}
						else {
							log.info("oops! Address not updated");
						}
						break;
				
				case 3: log.info("enter new last name");
						String newlastname = sc.next();
						wud.setNewlastname(newlastname);
						i = ws.editLastName(wud);
						
						if(i>0) { 
							log.info("Last name updated");
						}
						else {
							log.info("oops! Address not updated");
						}
						break;
					}
				
				 }
		else {
			log.info("Profile not found");
		}	
	return s1;
	}
	



	//@Override
	

	



	@Override
	public int timeline() {
		
		log.info("enter message id");
		String messageid = sc.next();
		
		log.info("enter sender emailid");
		String sender = sc.next();
		
		//receiver id should be in userdetails table
		log.info("enter reciver id");
		String receiver = sc.next();
		
		log.info("enter message");
		String message = sc.next();
		
		log.info("enter date");
		String date = sc.next();
		
		
		
		
		
		TimelineDetails tld = new TimelineDetails();
		tld.setMessageid(messageid);
		tld.setSender(sender);
		tld.setMassage(message);
		tld.setDate1(date);
		tld.setReceiver(receiver);
	
		
		int i= ws.timeline(tld);
		
		if(i>0) {
			log.info("timeline updated");
		}
		else {
			log.info("oops! something went wrong");
		}
		return i;
		
	}



	@Override
	public List<WhatsappUserDetails> searchProfile() {
		
		log.info("Enter first name");
		String firstname = sc.next();
		
		WhatsappUserDetails wud = EntityFactory.entityObject();
		
		wud.setFirstname(firstname);
		List<WhatsappUserDetails> l1= ws.searchProfile(wud);
		l1.forEach(i->{
			log.info("******************");
			log.info("First name is "+i.getFirstname());
			log.info("Name is "+i.getLastname());
			log.info("Email is "+i.getEmail());
			log.info("Password is "+i.getPassword());
			
			});
		return l1;
		
	}

}
