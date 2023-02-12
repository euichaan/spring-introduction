package com.me.hellospring;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.me.hellospring.repository.JpaMemberRepository;
import com.me.hellospring.repository.MemberRepository;
import com.me.hellospring.service.MemberService;

@Configuration
public class SpringConfig {

	private final EntityManager em;

	@Autowired
	public SpringConfig(EntityManager em) {
		this.em = em;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		return new JpaMemberRepository(em);
	}
}
