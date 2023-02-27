package com.example.transportmanagement;

import com.example.transportmanagement.modell.MemberDetails;

public interface RestMemberById {
    MemberDetails find(Long id);
}
