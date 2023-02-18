package kr.ft.seoul.MoviePlatform.Movie.Discount.DiscountPolicy;

import kr.ft.seoul.MoviePlatform.Movie.Discount.DiscountCondition.DiscountCondition;
import kr.ft.seoul.MoviePlatform.Screening.Screening;

public class PercentDiscountPolicy extends DiscountPolicy {
    private double percent;
    
    public PercentDiscountPolicy(double percent, DiscountCondition ... conditions) {
        super(conditions);
        this.percent = percent; // 10% == 0.1;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
