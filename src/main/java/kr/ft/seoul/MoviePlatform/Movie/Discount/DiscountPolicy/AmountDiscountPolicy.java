package kr.ft.seoul.MoviePlatform.Movie.Discount.DiscountPolicy;

import kr.ft.seoul.MoviePlatform.Money.Money;
import kr.ft.seoul.MoviePlatform.Movie.Discount.DiscountCondition.DiscountCondition;
import kr.ft.seoul.MoviePlatform.Screening.Screening;

public class AmountDiscountPolicy extends DiscountPolicy{
    private Money discountAmount;    

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition ... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return this.discountAmount;
    }
}
