package chapter5;

import java.time.DayOfWeek;
import java.time.LocalTime;

//// 할인 조건을 나타내는 클래스
//public class DiscountCondition {
//    private DiscountConditionType type; // 할인 조건의 유형 -> 할인 조건 판단을 위한 필드
//    private int sequence; // 순번 -> 순번 조건 판단을 위한 필드
//    private DayOfWeek dayOfWeek; // 요일 -> 기간 조건 판단을 위한 필드
//    private LocalTime startTime; // 시작 시간 -> 기간 조건 판단을 위한 필드
//    private LocalTime endTime; // 종료 시간 -> 기간 조건 판단을 위한 필드
//
//
//    // 할인 조건을 판단하기 위한 메서드
//    public boolean isSatisfiedBy(Screening screening){
//        // 할인 조건의 유형에 따라 판단하는 메서드 호출
//        if(type == DiscountConditionType.PERIOD){
//            return isSatisfiedByPeriod(screening);
//        }
//        return isSatisfiedBySequence(screening);
//    }
//
//    // 기간 조건을 판단하는 메서드
//    private boolean isSatisfiedByPeriod(Screening screening){
//        // 상영 시간이 기간에 포함되는지 판단
//        return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) && // 요일이 같은지 판단
//                startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 && // 시작 시간이 같거나 이후인지 판단
//                endTime.isAfter(screening.getWhenScreened().toLocalTime()); // 종료 시간이 이전인지 판단
//    }
//
//    // 순번 조건을 판단하는 메서드
//    private boolean isSatisfiedBySequence(Screening screening){
//        // 순번이 같은지 판단
//        return sequence == screening.getSequence();
//    }
//}


// 의존성 제거를 위해 인터페이스로 변경
public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}