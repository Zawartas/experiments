package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class SomeStreams {


    void iterateThroughTime(long days, int limit) {
        Stream.iterate(LocalDate.now(), ld -> ld.plusDays(days))
            .limit(limit)
            .forEach(System.out::println);
    }

    void iterateThroughBigDecimals(int limit, BigDecimal bigDecimal) {
        List<BigDecimal> nums =
            Stream.iterate(BigDecimal.ONE, n -> n.add(bigDecimal) )
                .limit(limit)
                .collect(Collectors.toList());
        System.out.println(nums);
    }

    void generateRandom(int limit) {
        Stream.generate(Math::random)
            .limit(limit)
            .forEach(System.out::println);
    }

    void intStreams(int limit) {
        List<Integer> ints = IntStream.range(10, 15)
            .boxed()
            .collect(Collectors.toList());
        System.out.println(ints);

        List<Long> longs = LongStream.rangeClosed(10, 15)
            .boxed()
            .collect(Collectors.toList());
        System.out.println(longs);
    }

    int reduce(int limit) {
        return IntStream.rangeClosed(1, limit)
            .reduce(0, (x, y) -> x + 2 * y);
    }

    Map<Boolean, Long> partitioningBy(int limit) {
        List<String> strings = List.of("Szymon", "Stach", "Jula", "Urszula", "Elżbieta", "Jerzy");
        return strings.stream()
            .collect(Collectors.partitioningBy(
                s -> s.length() % 2 == limit,
                Collectors.counting()));
    }
}
