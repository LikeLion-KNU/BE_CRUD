package likelion.festival.assignment.domain.member.service;


import likelion.festival.assignment.domain.member.dto.request.MemberSaveRequest;
import likelion.festival.assignment.domain.member.dto.request.MemberUpdateRequest;
import likelion.festival.assignment.domain.member.dto.response.MemberAllReadResponse;
import likelion.festival.assignment.domain.member.dto.response.MemberIdReadResponse;
import likelion.festival.assignment.domain.member.entity.Member;
import likelion.festival.assignment.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService{

    MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    @Transactional
    public Long saveMember(MemberSaveRequest memberSaveRequest){
        Member member = Member.builder()
                .email(memberSaveRequest.email())
                .password(memberSaveRequest.password())
                .name(memberSaveRequest.name())
                .role(memberSaveRequest.role())
                .age(memberSaveRequest.age())
                .is_account_expired(memberSaveRequest.is_account_expired())
                .is_account_locked(memberSaveRequest.is_account_locked())
                .build();

        memberRepository.save(member);

        return member.getId();
    }

    public List<MemberAllReadResponse> getAllMember(){
        try {
            List<Member> MemberList = memberRepository.findAll();

            List<MemberAllReadResponse> responseList = new ArrayList<>();

            for (Member member : MemberList) {
                responseList.add(
                        new MemberAllReadResponse(member.getId(), member.getEmail(), member.getName(), member.getRole(), member.getAge()
                        ));
            }
            return responseList;
        }catch(Exception e){
        }
        return null;
    }

    public MemberIdReadResponse findOneMember(Long id)throws IOException{
        Member member = memberRepository.findById(id)
                .orElseThrow();
        return MemberIdReadResponse.builder()
                .member_id(member.getId())
                .email(member.getEmail())
                .name(member.getName())
                .role(member.getRole())
                .age(member.getAge())
                .build();
    }

    @Transactional
    public Long updateMember(MemberUpdateRequest memberUpdateRequest, Long memberId)throws IOException{
        Member member = memberRepository.findById(memberId)
                .orElseThrow();

        member.updateMember(memberUpdateRequest);

        return member.getId();
    }

    @Transactional
    public void deleteMember(Long memberId) throws IOException{
        Member member = memberRepository.findById(memberId)
                .orElseThrow();

        memberRepository.delete(member);
    }
}
