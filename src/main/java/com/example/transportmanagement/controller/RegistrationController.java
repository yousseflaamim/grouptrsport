package com.example.transportmanagement.controller;

import com.example.transportmanagement.modell.Registration;
import com.example.transportmanagement.modell.RegistrationDetails;
import com.example.transportmanagement.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/addRegistration")
    public RegistrationDetails addRegistration(@RequestBody Registration registration) {
        return registrationService.save(registration);
    }

    @GetMapping("/getAllRegistrations")
    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }

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
    }
}
