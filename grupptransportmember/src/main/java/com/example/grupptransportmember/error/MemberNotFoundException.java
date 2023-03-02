package com.example.grupptransportmember.error;


public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(Long id) {
        super("Could not find member with id " + id);
    }
}
