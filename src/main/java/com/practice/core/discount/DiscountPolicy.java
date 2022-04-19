package com.practice.core.discount;

import com.practice.core.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
