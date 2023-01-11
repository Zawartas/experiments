package org.example;

import java.util.stream.Stream;

import static org.example.ImplementPredicate.LENGTH_FIVE;
import static org.example.ImplementPredicate.STARTS_WITH_S;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ImplementPredicateTest {

    private ImplementPredicate demo = new ImplementPredicate();
    private String[] names;

    @BeforeAll
    void setUo() {
        names = Stream.of("Mal", "Wash", "Kaylee", "Inara", "Zoe", "Jayne", "Simon", "River", "Shepherd Book")
            .sorted()
            .toArray(String[]::new);
    }

    @Test
    void getNamesOfLengthFive() {
        assertEquals("Inara, Jayne, River, Simon",
            demo.getNamesOfLength(5, names));
    }

    @Test
    void getNamesStartingWithS() throws Exception {
        assertEquals("Shepherd Book, Simon",
            demo.getNamesStartingWith("S", names));
    }

    @Test
    void getNamesSatisfyingCondition() throws Exception {
        assertEquals("Inara, Jayne, River, Simon",
            demo.getNamesSatisfyingCondition(s -> s.length() == 5, names));
        assertEquals("Shepherd Book, Simon",
            demo.getNamesSatisfyingCondition(s -> s.startsWith("S"), names));
        assertEquals("Inara, Jayne, River, Simon",
            demo.getNamesSatisfyingCondition(LENGTH_FIVE, names));
        assertEquals("Shepherd Book, Simon",
            demo.getNamesSatisfyingCondition(STARTS_WITH_S, names));

    }

    @Test
    void composedPredicate() {
        assertEquals("Simon",
            demo.getNamesSatisfyingCondition(LENGTH_FIVE.and(STARTS_WITH_S), names));
        assertEquals("Kaylee, Mal, Shepherd Book, Wash, Zoe",
            demo.getNamesSatisfyingCondition(LENGTH_FIVE.negate(), names));
        assertEquals("Inara, Jayne, River, Shepherd Book, Simon",
            demo.getNamesSatisfyingCondition(LENGTH_FIVE.or(STARTS_WITH_S), names));
    }
}