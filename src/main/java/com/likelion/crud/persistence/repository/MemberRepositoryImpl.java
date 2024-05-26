package com.likelion.crud.persistence.repository;

import com.likelion.crud.domain.Member;
import com.likelion.crud.domain.member.MemberPatchDto;
import com.likelion.crud.domain.member.repository.MemberRepository;
import com.likelion.crud.persistence.entity.MemberEntity;
import com.likelion.crud.persistence.repository.jpa.JpaMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final JpaMemberRepository repository;

    @Override
    public Member save(Member member) {
        return repository.save(MemberEntity.fromDomain(member)).toDomain();
    }

    @Override
    public List<Member> findAll() {
        return repository.findAll().stream().map((MemberEntity::toDomain)).toList();
    }

    @Override
    public Optional<Member> findById(Long id) {
        return repository.findById(id).map(MemberEntity::toDomain);
    }

    @Override
    public Member update(Long memberId, MemberPatchDto memberPatch) {
        MemberEntity memberEntity = repository.findById(memberId).orElseThrow();
        return repository.save(applyUpdate(memberEntity, memberPatch)).toDomain();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private static MemberEntity applyUpdate(MemberEntity memberEntity, MemberPatchDto memberPatch) {
        return new MemberEntity(
                memberEntity.getMemberId(),
                memberPatch.email() != null ? memberPatch.email() : memberEntity.getEmail(),
                memberPatch.password() != null ? memberPatch.password() : memberEntity.getPassword(),
                memberEntity.getRole(),
                memberPatch.name() != null ? memberPatch.name() : memberEntity.getName(),
                memberEntity.getAge(),
                memberEntity.getIsExpiredAccount(),
                memberEntity.getIsLockedAccount()
        );
    }
}
