package org.server.dosopt.seminar.repository;

import org.server.dosopt.seminar.domain.Member;
import org.server.dosopt.seminar.domain.Post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostJpaRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByMemberId(Long memberId);
    List<Post> findAllByMember(Member member);

}