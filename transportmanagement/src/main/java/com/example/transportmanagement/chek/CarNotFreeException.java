package com.example.transportmanagement.chek;

import java.util.Date;

public class CarNotFreeException extends RuntimeException {
    public CarNotFreeException(Long carId ,Date endDate) {
        super("Car " + carId + " is not free now."+ "/n"+"after this  time will be free"+ endDate);
    }
}
