package chapter5;

import java.time.DayOfWeek;
import java.time.LocalTime;

// DC 인터페이스를 실체화하는 방식으로 변경
public class PeriodCondition implements DiscountCondition{
    private DayOfWeek dayOfWeek; // 요일
    private LocalTime startTime; // 시작 시간
    private LocalTime endTime; // 종료 시간

    // 생성자
    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime){
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // 기간 조건을 판단하는 메서드
    public boolean isSatisfiedBy(Screening screening){
        // 상영 시간이 기간에 포함되는지 판단
        return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) && // 요일이 같은지 판단
                startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 && // 시작 시간이 같거나 이후인지 판단
                endTime.isAfter(screening.getWhenScreened().toLocalTime()); // 종료 시간이 이전인지 판단
    }
}
