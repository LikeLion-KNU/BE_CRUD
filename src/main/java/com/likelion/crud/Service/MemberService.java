package com.likelion.crud.Service;

import com.likelion.crud.Entity.Member;
import com.likelion.crud.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    @Transactional
    public Member addMember(Member member){ return memberRepository.save(member);}

    @Transactional
    public List<Member> getAllMembers(){return memberRepository.findAll();}

    public Optional<Member> getMemberById(Long id){return memberRepository.findById(id);}

    @Transactional
    public Optional<Member> editMember(Long id, String name, String email, String password, int age){
        try{
            Member _member = memberRepository.findById(id).get();
            if(name != null){_member.setName(name);}
            if(email != null){_member.setEmail(email);}
            if(password != null){_member.setPassword(password);}
            if(age != 0){_member.setAge(age);}
            memberRepository.save(_member);
        }catch(NoSuchElementException e){

        }
        return memberRepository.findById(id);
    }
    @Transactional
    public void removeMember(Long id){
        memberRepository.deleteById(id);
    }
}
