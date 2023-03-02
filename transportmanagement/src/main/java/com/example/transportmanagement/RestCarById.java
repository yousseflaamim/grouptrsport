package com.example.transportmanagement;

import com.example.transportmanagement.modell.CarDetails;
@FunctionalInterface
public interface RestCarById {
    CarDetails find(Long id);
}
