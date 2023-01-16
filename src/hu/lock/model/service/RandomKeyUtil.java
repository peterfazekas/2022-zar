package hu.lock.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomKeyUtil {

    private static final Random random = new Random();

    public static String generateKey(int length) {
        StringBuilder sb = new StringBuilder();
        List<Integer> numbers = new ArrayList<>(
                List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        IntStream.range(0, length).forEach(i -> {
            int num = random.nextInt(numbers.size());
            sb.append(numbers.remove(num));
        });
        return sb.toString();
    }
}
