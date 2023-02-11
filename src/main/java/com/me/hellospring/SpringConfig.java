package com.me.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.me.hellospring.repository.MemberRepository;
import com.me.hellospring.repository.MemoryMemberRepository;
import com.me.hellospring.service.MemberService;

@Configuration
public class SpringConfig {
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
}
