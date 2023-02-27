package com.example.transportmanagement;

import com.example.transportmanagement.modell.CarDetails;

public interface RestCarById {
    CarDetails find(Long id);
}
