package br.edu.fatec.sjc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class NumberAscOrderTest {
    private CustomStack<Integer> stack;
    private static final int stackLimit = 6;

    @BeforeEach
    void setUp() {
        stack = new CustomStack<>(stackLimit, value -> value);
    }

    @ParameterizedTest
    @CsvSource({
            "'[10, 5, 2, 8, 1, 9]', '[1, 2, 5, 8, 9, 10]'",
            "'[]', '[]'"
    })
    public void testSort(String actualList, String expectedList) throws StackFullException {
        CustomStack<Integer> stack = new CustomStack<>(6, value -> value);

        if (!actualList.equals("[]")) {
            List<Integer> numbers = parseNumbers(actualList);
            for (Integer num : numbers) {
                stack.push(num);
            }
        }

        NumberAscOrder<Integer> numberAscOrder = new NumberAscOrder<>(stack);
        List<Integer> sortedNumbers = numberAscOrder.sort();

        if (expectedList.equals("[]")) {
            assertTrue(sortedNumbers.isEmpty());
        } else {
            List<Integer> expectedNumbers = parseNumbers(expectedList);
            assertEquals(expectedNumbers, sortedNumbers);
        }
    }

    private List<Integer> parseNumbers(String numberString) {
        if (numberString.equals("[]")) {
            return Arrays.asList();
        }
        return Arrays.stream(numberString.replaceAll("[\\[\\] ]", "").split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    @Test
    void testSortRandomNumbers() throws StackFullException {
        Random random = new Random();
        List<Integer> randomNumbers = random.ints(stackLimit, 0, 100).boxed().collect(Collectors.toList());

        for (Integer num : randomNumbers) {
            stack.push(num);
        }

        NumberAscOrder<Integer> numberAscOrder = new NumberAscOrder<>(stack);
        List<Integer> sortedNumbers = numberAscOrder.sort();

        List<Integer> expectedNumbers = randomNumbers.stream().sorted().collect(Collectors.toList());
        assertEquals(expectedNumbers, sortedNumbers);
    }

    @Test
    void testEmptyStack() {
        assertTrue(stack.isEmpty());
        assertThrows(StackEmptyException.class, () -> stack.pop());
    }
}
