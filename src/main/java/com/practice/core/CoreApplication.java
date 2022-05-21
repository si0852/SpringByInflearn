package com.practice.core;

import com.practice.core.member.Grade;
import com.practice.core.member.Member;
import com.practice.core.member.MemberService;
import com.practice.core.member.MemberServiceImpl;
import com.practice.core.order.Order;
import com.practice.core.order.OrderService;
import com.practice.core.order.OrderServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
//		AppConfig appConfig = new AppConfig();
//
//		MemberService memberService = appConfig.memberService();
//		OrderService orderService = appConfig.orderService();
//
//		long memberId = 1L;
//
//		Member member = new Member(memberId, "memberA", Grade.VIP);
//		memberService.join(member);
//
////		Order order = orderService.createOrder(memberId, "itemA", 10000);
//
////		System.out.println("order = " + order);
//		Member findMember = memberService.findMember(1L);
//		System.out.println("new member = " + member.getName());
//		System.out.println("findMember = " + findMember.getName());
		SpringApplication.run(CoreApplication.class, args);
	}

}
