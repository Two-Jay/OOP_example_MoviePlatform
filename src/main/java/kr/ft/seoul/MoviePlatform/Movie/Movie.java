package kr.ft.seoul.MoviePlatform.Movie;

import java.time.Duration;

import kr.ft.seoul.MoviePlatform.Screening.Screening;
import kr.ft.seoul.MoviePlatform.Money.Money;
import kr.ft.seoul.MoviePlatform.Movie.Discount.Policy.DiscountPolicy;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return this.fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
