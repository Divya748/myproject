package com.whatsapp.view;

import java.util.Scanner;
import java.util.logging.Logger;
import com.whatsapp.controller.WhatsappControllerInterface;

import com.whatsapp.utility.ControllerFactory;

public class Whatsappview {
	static int ch ;
	
	static Scanner sc = new Scanner(System.in);
	static Logger log =Logger.getLogger("Whatsappview");
	public static void main(String[] args)  {
		
		WhatsappControllerInterface wc=ControllerFactory.controllerObject();
		int s1;
		
		String s = "y";
		while(s.equals("y")) {
			log.info("**************************************************");
			log.info("                                                  ");
			log.info("Welcome! Sign-In or Sign-Up to reach our website");
			log.info("                                                  ");
			log.info("**************************************************");
			log.info("press 1 to sign-up");
			log.info("press 2 to sign-in");
			
			log.info("enter your choice");
			ch = sc.nextInt();
		switch(ch) {
			case 1: wc.signUp();
					break;
			case 2: s1 = wc.signIn();
					if(s1==1) {
						while(s.equals("y")) {
							
							log.info("                         ******Main Menu*******");
							log.info("                         press 1 to view all profile");
							log.info("                         press 2 to view profile");
							log.info("                         press 3 to delete profile");
							log.info("                         press 4 to edit profile");
							log.info("                         press 5 to create timeline");
							log.info("                         press 6 to search profile");
							
							log.info("enter your choice");
							
							ch = sc.nextInt();
							
							
							
							
							switch(ch) {
								
								case 1: wc.viewAllProfile();
										break;
								case 2: wc.viewProfile();
										break;
								case 3: wc.deleteProfile();
										break;
								case 4: wc.editProfile();
										break;
								case 5: wc.timeline();
										break;
								case 6: wc.searchProfile();
										break;
							}
							log.info("press y/n to continue");
							s=sc.next();
						}
					}
					
					else {
						log.info("Opps! enter correct password or if you are not registered.. please press 1 to sigh-up");
					}
					break;
		}
		log.info("press y/n to continue");
		s=sc.next();
		
		
	}
}
}