package com.example.transportmanagement.controller;

import com.example.transportmanagement.RestCarById;
import com.example.transportmanagement.RestGroupById;
import com.example.transportmanagement.RestMemberById;
import com.example.transportmanagement.modell.*;
import com.example.transportmanagement.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;
    @Autowired
   private RestGroupById restGroupById ;
    @Autowired
    RestCarById restCarById;
    @Autowired
    RestMemberById restMemberById;

    @PostMapping("register")

    public ResponseEntity<RegistrationDetails> register(@RequestBody Registration registration) {
        RegistrationDetails details = registrationService.save(registration);
        return ResponseEntity.ok(details);
    }



    @PostMapping("/addRegistration")
    public RegistrationDetails addRegistration(@RequestBody Registration registration) {
        return registrationService.save(registration);
    }

    @GetMapping("/getAllRegistrations")
    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }

/*
    @GetMapping("/car/{carId}")
    public List<Registration> getRegistrationsByCarId(@PathVariable Long carId) {
        return registrationService.getRegistrationsByCarId(carId);
    }

    @GetMapping("/member/{memberId}")
    public List<Registration> getRegistrationsByMemberId(@PathVariable Long memberId) {
        return registrationService.getRegistrationsByMemberId(memberId);
    }

    @GetMapping("/group/{groupId}")
    public List<Registration> getRegistrationsByGroupId(@PathVariable Long groupId) {
        return registrationService.getRegistrationsByGroupId(groupId);
    }*/
}
