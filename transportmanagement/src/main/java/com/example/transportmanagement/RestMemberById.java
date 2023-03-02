package com.example.transportmanagement;

import com.example.transportmanagement.modell.MemberDetails;
@FunctionalInterface
public interface RestMemberById {
    MemberDetails find(Long id);
}
