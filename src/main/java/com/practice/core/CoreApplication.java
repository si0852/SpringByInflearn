package com.practice.core;

import com.practice.core.member.Grade;
import com.practice.core.member.Member;
import com.practice.core.member.MemberService;
import com.practice.core.member.MemberServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl();
		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);

		Member findMember = memberService.findMember(1L);
		System.out.println("new member = " + member.getName());
		System.out.println("findMember = " + findMember.getName());
		SpringApplication.run(CoreApplication.class, args);
	}

}
