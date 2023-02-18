package kr.ft.seoul.MoviePlatform.Movie.Discount.Policy;

import java.util.Arrays;
import java.util.List;

import kr.ft.seoul.MoviePlatform.Money.Money;
import kr.ft.seoul.MoviePlatform.Movie.Discount.Condition.DiscountCondition;
import kr.ft.seoul.MoviePlatform.Screening.Screening;

public abstract class DiscountPolicy {
    private List<DiscountCondition> conditions;

    public DiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);
}
