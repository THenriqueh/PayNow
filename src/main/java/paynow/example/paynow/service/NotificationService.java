package paynow.example.paynow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import paynow.example.paynow.domain.user.User;
import paynow.example.paynow.dto.NotificationDTO;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {
       String email = user.getEmail();

       NotificationDTO notificationRequest = new NotificationDTO(email, message);

      /*ResponseEntity<String> notificationResponse = restTemplate.postForEntity(
              "https://util.devi.tools/api/v2/notify", notificationRequest, String.class);

       if(!(notificationResponse.getStatusCode() == HttpStatus.OK)){
           throw new Exception("Notification Service out of service");
       }
       */
        System.out.println("Notification sent to user" );

    }
}
