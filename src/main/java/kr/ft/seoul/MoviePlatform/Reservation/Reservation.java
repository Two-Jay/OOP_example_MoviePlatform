package kr.ft.seoul.MoviePlatform.Reservation;

import kr.ft.seoul.MoviePlatform.Customer.Customer;
import kr.ft.seoul.MoviePlatform.Money.Money;
import kr.ft.seoul.MoviePlatform.Screening.Screening;

public class Reservation {
    private Customer customer;
    private Screening screening;
    private Money fee;
    private int audienceCount;

    public Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
        this.customer = customer;
        this.screening = screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }
}
