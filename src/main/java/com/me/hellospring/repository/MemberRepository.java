package com.me.hellospring.repository;

import java.util.List;
import java.util.Optional;

import com.me.hellospring.domain.Member;

public interface MemberRepository {
	Member save(Member member);
	Optional<Member> findById(Long id);
	Optional<Member> findByName(String name);
	List<Member> findAll();
}
