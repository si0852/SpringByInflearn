package com.practice.core.order;

import com.practice.core.annotation.MainDiscountPolicy;
import com.practice.core.discount.DiscountPolicy;
import com.practice.core.discount.FixDiscountPolicy;
import com.practice.core.member.Member;
import com.practice.core.member.MemberRepository;
import com.practice.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository ;
    private final DiscountPolicy discountPolicy ;


    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 수정자 자동 주입 예시
//    @Autowired
//    public DiscountPolicy setDiscountPolicy(@MainDiscountPolicy DiscountPolicy discountPolicy) {
//        return discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discoutPolicy = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discoutPolicy);
    }
}
