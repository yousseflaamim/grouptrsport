package com.example.transportmanagement.modell;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Registration {

    @Id
    @GeneratedValue
    private Long id;

    private Long groupId;
    private Long memberId;
    private Long carId;
    private Date fromDate;
    private Date endDate;
}