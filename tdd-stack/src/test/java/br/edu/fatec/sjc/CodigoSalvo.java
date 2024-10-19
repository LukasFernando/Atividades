package br.edu.fatec.sjc;

public class CodigoSalvo {
}

/*
package br.edu.fatec.sjc;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class NumberAscOrderTest {

    @ParameterizedTest
    @CsvSource({
            // Testes com 6 números sorteados
            "'[10, 5, 3, 8, 1, 6]', '[1, 3, 5, 6, 8, 10]'",
            "'[4, 9, 2, 7, 5, 3]', '[2, 3, 4, 5, 7, 9]'",

            // Teste com pilha vazia
            "'[]', '[]'"

            // Testes com números sorteados aleatoriamente vão estar no codigo
    })
    public void testSortWithNumbers(String actualList, String expectedList) throws StackFullException {
        CustomStack<Number> stack = new CustomStack<>(6, value -> value);

        if (!actualList.equals("[]")) {
            List<Number> numbers = parseNumbers(actualList);
            for (Number num : numbers) {
                stack.push(num);
            }
        }

        NumberAscOrder<Number> numberAscOrder = new NumberAscOrder<>(stack);
        List<Number> sortedNumbers = numberAscOrder.sort();

        if (expectedList.equals("[]")) {
            assertTrue(sortedNumbers.isEmpty());
        } else {
            List<Number> expectedNumbers = parseNumbers(expectedList);
            assertEquals(expectedNumbers, sortedNumbers);
        }
    }

    private List<Number> parseNumbers(String numberString) {
        if (numberString.equals("[]")) {
            return Arrays.asList();
        }
        return Arrays.stream(numberString.replaceAll("[\\[\\] ]", "").split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}

 */