package org.server.dosopt.seminar.repository;

import org.server.dosopt.seminar.domain.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    @PersistenceContext
    private final EntityManager em;

    void removeMemberEntity(Member member) {
        em.remove(member);
    }
}