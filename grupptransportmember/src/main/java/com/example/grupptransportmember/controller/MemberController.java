package com.example.grupptransportmember.controller;

import com.example.grupptransportmember.modell.Member;
import com.example.grupptransportmember.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {

        return memberService.getMemberById(id);
    }

    @PostMapping("/addMember")
    public ResponseEntity<List<Member>> addMember(@RequestBody Member member) {
        memberService.addMember(member);
        List<Member> addedMember = memberService.getAllMembers();
        return ResponseEntity.status(201).body(addedMember);
                //ResponseEntity.status(HttpStatus.CREATED).body(addedMember);
               // List<Course> courses = courseService.getAll();
       // return ResponseEntity.status(201).body(courses);
    }

    @DeleteMapping("/{id}")
    public void deleteMemberById(@PathVariable Long id) {

        memberService.deleteMemberById(id);
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<String> deleteAllMembers() {
        memberService.deleteAllMembers();
        return ResponseEntity.ok("All members deleted successfully");
    }

}
