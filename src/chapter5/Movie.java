package chapter5;

import java.time.Duration;
import java.util.List;

public class Movie {
    private String title; // 영화 제목
    private Duration runningTime; // 영화 상영 시간
    private Money fee; // 영화 가격
    // private List<PeriodCondition> periodConditions; // 할인 조건 목록
    // private List<SequenceCondition> sequenceConditions; // 할인 조건 목록
    // 의존성 제거를 위해 DiscountCondition 인터페이스를 사용하도록 변경
    private List<DiscountCondition> discountConditions; // 할인 조건 목록

    private MovieType movieType; // 영화 유형
    private Money discountAmount; // 할인 금액
    private double discountPercent; // 할인 비율

    // Screening이 Movie에게 요청을 보내는 메시지를 처리하기 위한 메서드
    public Money calculateMovieFee(Screening screening){
        // 할인 가능 여부를 판단하는 메서드 호출
        if(isDiscountable(screening)){
            // 할인 가능하다면 할인 금액을 계산하는 메서드 호출
            return fee.minus(calculateDiscountAmount());
        }
        // 할인 불가능하다면 영화 가격을 그대로 반환
        return fee;
    }

//    private boolean checkPeriodConditions(Screening screening){
//        return periodConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
//    }
//
//    private boolean checkSequenceConditions(Screening screening){
//        return sequenceConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
//    }

    // 의존성을 제거함으로 하나의 메서드로 통합
    // 할인 조건들을 순회하면서 하나라도 할인 가능한 조건이 있는지 검사 -> 할인 가능 여부 반환
    // 메시지를 수신한 조건이 sequenceCondition이라면 sequenceCondition의 isSatisfiedBy 메서드 호출
    // 메시지를 수신한 조건이 periodCondition이라면 periodCondition의 isSatisfiedBy 메서드 호출
    // 즉, 다형적이다.
    private boolean isDiscountable(Screening screening){
        return discountConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    // 영화의 할인 타입에 따라 타입에 맞추어 할인 금액 계산을 요청하는 메서드
    private Money calculateDiscountAmount() {
        switch(movieType){
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountAmount();
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountAmount();
            case NONE_DISCOUNT:
                return Money.ZERO;
        }
        throw new IllegalArgumentException();
    }

    // 금액 할인 금액 계산
    private Money calculateAmountDiscountAmount(){
        return discountAmount;
    }

    // 비율 할인 금액 계산
    private Money calculatePercentDiscountAmount(){
        return fee.times(discountPercent);
    }

    // 할인 금액이 0인 경우
    private Money calculateNoneDiscountAmount(){
        return Money.ZERO;
    }


}
