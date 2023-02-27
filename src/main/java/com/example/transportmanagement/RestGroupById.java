package com.example.transportmanagement;


import com.example.transportmanagement.modell.GroupDetails;
import org.springframework.beans.factory.annotation.Autowired;

@FunctionalInterface
public interface RestGroupById {

GroupDetails find(Long id);



}


