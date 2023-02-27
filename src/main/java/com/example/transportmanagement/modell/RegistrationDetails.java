package com.example.transportmanagement.modell;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class RegistrationDetails {
    private  String groupName;
    private String carName;
    private String memberName;
    private Date fromDate;
    private Date endDate;
}