package com.example.grupptransportmember.service;

import com.example.grupptransportmember.error.MemberNotFoundException;
import com.example.grupptransportmember.modell.Member;
import com.example.grupptransportmember.repositroy.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException(id));

    }

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public void deleteMemberById(Long id) {
        if (!memberRepository.existsById(id)) {
            throw new MemberNotFoundException(id);
        }
        memberRepository.deleteById(id);
    }
    public void deleteAllMembers() {
        memberRepository.deleteAll();
    }

}
