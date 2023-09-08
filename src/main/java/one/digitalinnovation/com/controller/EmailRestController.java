package one.digitalinnovation.com.controller;

import one.digitalinnovation.com.model.Email;
import one.digitalinnovation.com.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailRestController {

    @Autowired
    EmailSenderService emailSenderService;

    @PostMapping
    public ResponseEntity sendEmail(@RequestBody Email email){
        emailSenderService.sendEmail(email);
        return ResponseEntity.ok("Success");
    }

}
