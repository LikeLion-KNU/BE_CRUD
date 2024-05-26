package com.likelion.crud.Controller;


import com.likelion.crud.Entity.Member;
import com.likelion.crud.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;
    @PostMapping("/members")
    public Member newMember(@RequestBody Member member) {return memberService.addMember(member);}

    @GetMapping("/members")
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }

    @GetMapping("/member")
    public Optional<Member> getMemberById(@RequestParam("id") Long id){
        return memberService.getMemberById(id);
    }

    @PutMapping("/member")
    public Optional<Member> editMember(@RequestParam("id") Long id, @RequestBody Member target){
        memberService.editMember(id,target.getName(),target.getEmail(),target.getPassword(), target.getAge());
        return memberService.getMemberById(id);

    }
    @DeleteMapping("/member")
    public List<Member> removeMember(@RequestParam("id") Long id){
        memberService.removeMember(id);
        return memberService.getAllMembers();
    }
}
