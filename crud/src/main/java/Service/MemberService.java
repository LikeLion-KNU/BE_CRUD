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
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;
    @Transactional
    public MemberRegisterResponseDTO registerMember(MemberRegisterRequestDTO memberRegisterRequestDTO){
        Member member = Member.builder()
                .age(memberRegisterRequestDTO.getAge())
                .name(memberRegisterRequestDTO.getName())
                .email(memberRegisterRequestDTO.getEmail())
                .password(memberRegisterRequestDTO.getPassword())
                .role(Role.User)
                .isAccountExpired(false)
                .isAccountLocked(false)
                .build();
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
    @Transactional
    public MemberUpdateResponseDTO editMember(Long memberId, MemberUpdateRequestDTO memberUpdateDTO){
        Member findMember = memberRepository.findById(memberId).orElseThrow();
        findMember.update(memberUpdateDTO);
        MemberUpdateResponseDTO memberUpdateResponseDTO = new MemberUpdateResponseDTO();
        memberUpdateResponseDTO.update(findMember);
        return memberUpdateResponseDTO;
    }
    @Transactional
    public void deleteMember(Long memberId){
        memberRepository.deleteById(memberId);
    }
}
