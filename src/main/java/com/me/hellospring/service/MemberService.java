package com.me.hellospring.service;

import java.util.List;
import java.util.Optional;

import com.me.hellospring.domain.Member;
import com.me.hellospring.repository.MemberRepository;
import com.me.hellospring.repository.MemoryMemberRepository;

public class MemberService {
	private final MemberRepository memberRepository = new MemoryMemberRepository();

	public Long join(Member member) {
		validateDuplicateMember(member);
		memberRepository.save(member);
		return member.getId();
	}

	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName())
				.ifPresent(m -> {
					throw new IllegalStateException("이미 존재하는 회원입니다.");
				});
	}

	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}
}