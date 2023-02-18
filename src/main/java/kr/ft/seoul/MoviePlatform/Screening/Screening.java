package kr.ft.seoul.MoviePlatform.Screening;

import java.time.LocalDateTime;

import kr.ft.seoul.MoviePlatform.Movie.Movie;
import kr.ft.seoul.MoviePlatform.Reservation.Reservation;
import kr.ft.seoul.MoviePlatform.Customer.Customer;
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

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return this.movie.calculateMovieFee(this).times(audienceCount);
    }
}

// 클래스의 상태와 행동을 정한 이후라면, 이 요소들의 경계를 정하고 클래스의 내부와 외부를 구분해야한다.
// 인스턴스가 가지고 있는 상태, 즉 인스턴스 변수의 가시성은 private로 정하고, 가려진 인스턴스 변수들을 조정하는 메서드의 가시성은 public으로 정했다.
// 어떤 부분을 클래스 외부로 공개하고, 클래스 내부로 숨겨둘지가 좋은 클래스 설계의 핵심이다.
// 경계가 명확하게 짜여지면 자신의 private한 변수를 다루기 위해 객체는 일하게 되며, 이렇게 일하는 클래스 로직은 객체를 자율적인 역할을 하도록 이끈다.

// 인스턴스의 상태가 private와 public으로 나뉘면서 공개될 구현과 감출 구현을 선택할 수 있다.
// 이를 통해 객체가 더 자율적으로 발전하게 됨은 물론, 해당 객체를 활용하는 클라이언트에서 접근할 수 있는 반경을 한정하여
// 외부의 간섭에 대한 사이드 이펙트를 고려하지 않고도 내부 로직을 바꿀 수 있다.
// 이를 구현 은닉 (implementation hiding)이라고 칭한다.

// 구현 은닉은 클라이언트 입장에서도 이득이 되는 행위이다.
// 객체가 접촉해야하는 메세지에 대한 루트를 명확히 해줄 때에 클라이언트는 약속된 루트를 통해 메세지를 보내어 협력할 수 있게 되고
// 이를 통해 간결하게 메세지 루트를 확보하고 불필요한 접촉을 방지할 수 있다.

// "설계가 필요한 이유는 변경을 관리하기 위해서이다."
// "변경으로 오는 혼란은 먼저 객체 외부에 혼란이 될만한 요소를 감춤으로 다스리기 시작하라."
