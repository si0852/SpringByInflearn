package com.practice.core.order;

import com.practice.core.discount.DiscountPolicy;
import com.practice.core.discount.FixDiscountPolicy;
import com.practice.core.member.Member;
import com.practice.core.member.MemberRepository;
import com.practice.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository ;
//    private final DiscountPolicy discountPolicy ;

    private MemberRepository memberRepository ;
    private DiscountPolicy discountPolicy ;

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    @Autowired
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
