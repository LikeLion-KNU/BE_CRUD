package LikeLion.CRUD.repository;

import LikeLion.CRUD.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}