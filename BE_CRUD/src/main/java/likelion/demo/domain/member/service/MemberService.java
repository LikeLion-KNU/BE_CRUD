package likelion.demo.domain.member.service;

import jakarta.persistence.EntityNotFoundException;
import likelion.demo.domain.holder.entity.CouponHolder;
import likelion.demo.domain.member.dto.request.MemberCreateRequest;
import likelion.demo.domain.member.dto.request.MemberUpdateRequest;
import likelion.demo.domain.member.entity.Member;
import likelion.demo.domain.member.entity.Role;
import likelion.demo.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     *  멤버 생성
     * @param memberCreateRequest
     * @return 생성된 멤버 id
     */
    @Transactional
    public Long createMember(MemberCreateRequest memberCreateRequest){
        Member member= Member.builder()
                .email(memberCreateRequest.email())
                .password(memberCreateRequest.password())
                .name(memberCreateRequest.name())
                .age(memberCreateRequest.age())
                .role(Role.valueOf("USER"))
                .build();

        memberRepository.save(member);

        return member.getId();
    }
    /**
     *  id로 멤버 찾기 (1명)
     * @param id
     * @return member
     */
    public Member findMemberById(Long id){
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException( "멤버를 찾지 못했습니다"));
        return member;
    }

    /**
     *  멤버 전부 찾기
     * @return all
     */
    public List<Member> findMemberAll(){
        List<Member> all = memberRepository.findAll();

        return all;
    }


    /**
     *  멤버의 name, age 변경
     * @param memberUpdateRequest
     * @param id
     * @return 변경된 멤버의 이메일
     */
    @Transactional
    public String updateMember(MemberUpdateRequest memberUpdateRequest,Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("멤버를 찾지 못했습니다."));

        member.update(memberUpdateRequest);

        return member.getEmail();
    }

    /**
     *  멤버 삭제
     * @param id
     */
    @Transactional
    public void deleteMember(Long id){
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("멤버를 찾지 못했습니다."));

        memberRepository.delete(member);
    }



}
