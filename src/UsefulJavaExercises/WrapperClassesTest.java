package UsefulJavaExercises;

import java.util.ArrayList;
import java.util.List;

public class WrapperClassesTest {
    public static void main(String[] args) {
        Integer integerWrapper = 90;
        Float floatWrapper = 120f;
        Double doubleWrapper = 180d;
        Long longWrapper = 30L;

        List<Number> numbers = new ArrayList<>();
        numbers.add(integerWrapper);
        numbers.add(floatWrapper);
        numbers.add(doubleWrapper);
        numbers.add(longWrapper);

        numbers.forEach(num -> System.out.println(num.getClass()));
    }
}
