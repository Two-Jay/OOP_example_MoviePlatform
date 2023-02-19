package kr.ft.seoul.MoviePlatform.Movie;

import java.time.Duration;

import kr.ft.seoul.MoviePlatform.Screening.Screening;
import kr.ft.seoul.MoviePlatform.Money.Money;
import kr.ft.seoul.MoviePlatform.Movie.Discount.DiscountPolicy.DiscountPolicy;

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

// Compile time dependency VS Runtime dependency

// 컴파일 타임에서 의존성과 런타임 시점에서의 의존성은 서로 다를 수 있다.
// 현재 Movie 에서는 DiscountPolicy 단 하나만 연결되어 있는 구조여서 DiscountPolicy에만 의존성이 존재한다.
// Runtime 시점에서는 DiscountPolicy에 할당된 Constant한 DiscountPolicy 구현 클래스에 의존성을 가진다.
// 따라서 컴파일 시점에서는 단 하나의 의존성을 가진다고 하더라도, 다수의 클래스에 의존성을 가질 수 있다.
// 이런 의존성의 다변화 속에서도 객체간의 메세지 루트만 합의된다면 안전하게 사용할 수 있다.

// 그렇다면 이런 Runtime 시점에서 의존성의 변화는 어떻게 측정할 수 있는가?
// 위와 같이 Movie 클래스가 가지는 Runtime dependency를 알아보기 위해서는 Movie 클래스를 생성하는 시점을 찾아가서 어떤 클래스를 DiscountPolicy에 해당하는 인자로 넣어주는 지 확인해야 한다.
// Runtime dependency를 이용하면 유연한 설계는 확보할 수 있지만, 코드의 디펜던시를 바로바로 측정할 수 없고, 이는 곧 디버깅의 어려움으로 이어진다.
// 반면 코드의 즉각적인 파악을 위해 유연한 설계를 억제한다면, 재사용성과 확장성은 낮아진다는 점도 기억하라.
// ++ 무조건 파악하기 쉬운 설계도, 극도로 유연한 설계도 정답은 아니다. 둘 사이에서 절충안을 찾아라.