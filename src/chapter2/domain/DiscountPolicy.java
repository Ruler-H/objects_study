package chapter2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface DiscountPolicy {
    List<DiscountCondition> conditions = new ArrayList<>();

    Money calculateDiscountAmount(Screening screening);
}
