package com.me.hellospring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.me.hellospring.repository.JdbcTemplateMemberRepository;
import com.me.hellospring.repository.MemberRepository;
import com.me.hellospring.service.MemberService;

@Configuration
public class SpringConfig {

	private final DataSource dataSource;

	@Autowired
	public SpringConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		return new JdbcTemplateMemberRepository(dataSource);
	}
}
