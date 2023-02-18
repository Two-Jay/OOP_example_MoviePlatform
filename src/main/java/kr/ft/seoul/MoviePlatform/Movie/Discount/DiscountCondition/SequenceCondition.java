package kr.ft.seoul.MoviePlatform.Movie.Discount.DiscountCondition;

import kr.ft.seoul.MoviePlatform.Screening.Screening;

public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(this.sequence);
    }
}
