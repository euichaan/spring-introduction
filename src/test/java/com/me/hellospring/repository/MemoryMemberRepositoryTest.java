package com.me.hellospring.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.me.hellospring.domain.Member;

class MemoryMemberRepositoryTest {
	MemoryMemberRepository repository = new MemoryMemberRepository();

	@AfterEach
	void afterEach() {
		repository.clearStore();
	}

	@Test
	@DisplayName("회원 저장 테스트")
	void save_member() {
		//given
		Member member = new Member();
		member.setName("spring");

		//when
		repository.save(member);

		//then
		Member result = repository.findById(member.getId()).get();
		assertThat(result).isEqualTo(member);
	}

	@Test
	@DisplayName("회원 조회 테스트")
	void find_by_name() {
		//given
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);

		//when
		Member result = repository.findByName("spring1").get();

		//then
		assertThat(result).isEqualTo(member1);
	}

	@Test
	@DisplayName("회원 전체 조회 테스트")
	void findAll_member() {
		//given
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);

		//when
		List<Member> result = repository.findAll();

		//then
		assertThat(result.size()).isEqualTo(2);
	}
}
