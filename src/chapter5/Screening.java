package chapter5;

import java.time.LocalDateTime;

public class Screening {

    private Movie movie; // 가격 계산하라는 메시지 전송을 위한 영화에 대한 참조
    private int sequence; // 상영 순번
    private LocalDateTime whenScreened; // 상영 시간

    // Reservation의 창조자이기 때문에 생성자 포함
    public Reservation reserve(Customer customer, int audienceCount){
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    // Movie에서 반환받은 영화 가격에 관객 수를 곱하여 전체 애매 금액을 계산
    private Money calculateFee(int audienceCount){
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    // DiscountCondition에서 할인 조건 판단 시 상영 시간을 확인하기 위한 메서드
    public LocalDateTime getWhenScreened(){
        return whenScreened;
    }

    // DiscountCondition에서 할인 조건 판단 시 상영 순번을 확인하기 위한 메서드
    public int getSequence(){
        return sequence;
    }
}
