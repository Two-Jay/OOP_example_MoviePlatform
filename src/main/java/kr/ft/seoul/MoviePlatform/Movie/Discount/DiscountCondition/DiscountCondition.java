package kr.ft.seoul.MoviePlatform.Movie.Discount.DiscountCondition;

import kr.ft.seoul.MoviePlatform.Screening.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
