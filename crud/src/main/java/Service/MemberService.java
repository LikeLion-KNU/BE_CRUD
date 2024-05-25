package Service;

import dto.member.MemberRegisterRequestDTO;
import domain.Member;
import dto.member.MemberRegisterResponseDTO;
import dto.member.MemberUpdateRequestDTO;
import domain.Role;
import dto.member.MemberUpdateResponseDTO;
import repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberRegisterResponseDTO registerMember(MemberRegisterRequestDTO memberRegisterRequestDTO){
        Member member = new Member();
        member.setAge(memberRegisterRequestDTO.getAge());
        member.setName(memberRegisterRequestDTO.getName());
        member.setEmail(memberRegisterRequestDTO.getEmail());
        member.setPassword(memberRegisterRequestDTO.getPassword());
        member.setRole(Role.User);
        member.setAccountExpired(false);
        member.setAccountLocked(false);
        memberRepository.save(member);
        MemberRegisterResponseDTO memberRegisterResponseDTO = new MemberRegisterResponseDTO();
        memberRegisterResponseDTO.update(member);
        return memberRegisterResponseDTO;
    }
    public List<Member> findAllMembers(){
        return memberRepository.findAll();
    }
    public Optional<Member> findMember(Long id){
        return memberRepository.findById(id);
    }
    public MemberUpdateResponseDTO editMember(Long memberId, MemberUpdateRequestDTO memberUpdateDTO){
        Member findMember = memberRepository.findById(memberId).orElseThrow();
        findMember.update(memberUpdateDTO);
        MemberUpdateResponseDTO memberUpdateResponseDTO = new MemberUpdateResponseDTO();
        memberUpdateResponseDTO.update(findMember);
        return memberUpdateResponseDTO;
    }
    public void deleteMember(Long memberId){
        memberRepository.deleteById(memberId);
    }
}
