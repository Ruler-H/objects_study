package chapter5;

// DC 인터페이스를 실체화하는 방식으로 변경
public class SequenceCondition implements DiscountCondition {
    private int sequence; // 순번 조건

    // 생성자
    public SequenceCondition(int sequence){
        this.sequence = sequence;
    }

    // 순번 조건을 판단하는 메서드
    public boolean isSatisfiedBy(Screening screening){
        // 상영 순번이 일치하는지 판단
        return screening.getSequence() == sequence;
    }
}
