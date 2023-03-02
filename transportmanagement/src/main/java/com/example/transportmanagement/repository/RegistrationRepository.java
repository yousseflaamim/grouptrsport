package com.example.transportmanagement.repository;

import com.example.transportmanagement.modell.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    boolean existsByCarIdAndEndDateIsNull(Long carId);



    List<Registration> findByCarId(Long carId);


    List<Registration> findByMemberId(Long memberId);

    List<Registration> findByGroupId(Long groupId);


}