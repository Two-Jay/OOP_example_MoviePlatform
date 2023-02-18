package kr.ft.seoul.MoviePlatform.Screening;

import java.time.LocalDateTime;

import kr.ft.seoul.MoviePlatform.Movie.Movie;
import kr.ft.seoul.MoviePlatform.Money.Money;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenStarted;

    public Screening(Movie movie, int sequence, LocalDateTime whenStarted) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenStarted = whenStarted;
    }

    public LocalDateTime getStartTime() {
        return this.whenStarted;
    }

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }
}

// 클래스의 상태와 행동을 정한 이후라면, 이 요소들의 경계를 정하고 클래스의 내부와 외부를 구분해야한다.
// 인스턴스가 가지고 있는 상태, 즉 인스턴스 변수의 가시성은 private로 정하고, 가려진 인스턴스 변수들을 조정하는 메서드의 가시성은 public으로 정했다.
// 어떤 부분을 클래스 외부로 공개하고, 클래스 내부로 숨겨둘지가 좋은 클래스 설계의 핵심이다.
// 경계가 명확하게 짜여지면 자신의 private한 변수를 다루기 위해 객체는 일하게 되며, 이렇게 일하는 클래스 로직은 객체를 자율적인 역할을 하도록 이끈다.