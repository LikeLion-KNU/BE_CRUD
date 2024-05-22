package likelion.festival.assignment.domain.member.repository;

import likelion.festival.assignment.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
