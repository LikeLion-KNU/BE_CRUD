package Assignment.crud.service;

import Assignment.crud.domain.Member;
import Assignment.crud.dto.MemberEditRequestDto;
import Assignment.crud.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {

        Member savedMember = memberRepository.save(member);

        return savedMember.getId();
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).get();
    }

    @Transactional
    public void editMember(Long id, MemberEditRequestDto member) {

        Member findMember = memberRepository.findById(id).get();

        findMember.setName(member.getName());
        findMember.setAge(member.getAge());
        findMember.setRole(member.getRole());
        findMember.setEmail(member.getEmail());
    }

    @Transactional
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
