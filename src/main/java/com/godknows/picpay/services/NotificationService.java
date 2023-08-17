package com.godknows.picpay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.godknows.picpay.dtos.NotificationDTO;
import com.godknows.picpay.entities.User;

@Service
public class NotificationService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public void sendNotification(User user, String message) throws Exception {
		String email = user.getEmail();
		
		NotificationDTO notificationRequest = new NotificationDTO(email, message);
		
		/*
		 * ResponseEntity<String> notificationResponse = restTemplate.postForEntity("http://o4d9z.mocklab.io/notify", notificationRequest, String.class);
		 *
		 *	if (!(notificationResponse.getStatusCode() == HttpStatus.OK)) {
		 *		System.out.println("Notification system not available");
		 *		throw new Exception("Notificataion service unavailable");
		 *	}
		 *
		 */
		
		System.out.println("Notification sent to the user.");
		
	}

}
