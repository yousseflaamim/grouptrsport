package com.example.transportmanagement.service;

import com.example.transportmanagement.RestCarById;
import com.example.transportmanagement.RestGroupById;
import com.example.transportmanagement.RestMemberById;
import com.example.transportmanagement.chek.CarNotFreeException;
import com.example.transportmanagement.modell.*;
import com.example.transportmanagement.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class RegistrationService {

   @Autowired
   private RegistrationRepository registrationRepository;


   @Autowired
   private RestCarById restCarById;
   @Autowired
   private RestMemberById restMemberById;
   @Autowired
   private RestGroupById restGroupById;

   public RegistrationDetails save (Registration registration) {

      if (registrationRepository.existsByCarIdAndEndDateIsNull(registration.getCarId())) {
         throw new CarNotFreeException(registration.getCarId(), registration.getEndDate());
      }

         GroupDetails groupDetails = restGroupById.find(registration.getId());
         CarDetails carDetails = restCarById.find(registration.getId());
         MemberDetails memberDetails = restMemberById.find(registration.getId());
         System.out.println("group name =" + groupDetails.getName());
         System.out.println("member name =" + memberDetails.getName());
         System.out.println("car name =" + carDetails.getName());

         registrationRepository.save(registration);


         return new RegistrationDetails(groupDetails.getName(),
                 memberDetails.getName(), carDetails.getName(),
                 new Date(), new Date());
      }
   public List<Registration> getAllRegistrations() {
      return registrationRepository.findAll();
   }

   public List<Registration> getRegistrationsByCarId(Long carId) {
      return registrationRepository.findByCarId(carId);
   }

   public List<Registration> getRegistrationsByMemberId(Long memberId) {
      return registrationRepository.findByMemberId(memberId);
   }

   public List<Registration> getRegistrationsByGroupId(Long groupId) {
      return registrationRepository.findByGroupId(groupId);
   }




}
