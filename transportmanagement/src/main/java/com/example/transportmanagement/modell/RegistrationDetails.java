package com.example.transportmanagement.modell;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
@Table(name = "registrationDetails")
public class RegistrationDetails {
    private  String groupName;
    private String carName;
    private String memberName;
    private Date fromDate;
    private Date endDate;
}