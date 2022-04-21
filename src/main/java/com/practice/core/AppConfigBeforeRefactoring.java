package com.practice.core;

import com.practice.core.discount.FixDiscountPolicy;
import com.practice.core.member.MemberService;
import com.practice.core.member.MemberServiceImpl;
import com.practice.core.member.MemoryMemberRepository;
import com.practice.core.order.OrderService;
import com.practice.core.order.OrderServiceImpl;

public class AppConfigBeforeRefactoring {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FixDiscountPolicy()
        );
    }
}
