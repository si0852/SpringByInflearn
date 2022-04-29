package com.practice.core.order;

import com.practice.core.discount.DiscountPolicy;
import com.practice.core.discount.FixDiscountPolicy;
import com.practice.core.member.Member;
import com.practice.core.member.MemberRepository;
import com.practice.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository ;
    private final DiscountPolicy discountPolicy ;

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discoutPolicy = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discoutPolicy);
    }
}
