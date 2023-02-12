package com.me.hellospring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.hellospring.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

	// select m from Member m where m.name = ?
	@Override
	Optional<Member> findByName(String name);
}
