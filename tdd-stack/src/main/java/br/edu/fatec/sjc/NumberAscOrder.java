package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAscOrder<E extends Number> {

    private CustomStack<E> stack;

    public NumberAscOrder(CustomStack<E> stack) {
        this.stack = stack;
    }

    public List<E> sort() {
        if (stack.isEmpty()) {
            return new ArrayList<>();
        }

        List<E> numbers = new ArrayList<>();

        while (!stack.isEmpty()) {
            try {
                numbers.add(stack.pop());
            } catch (StackEmptyException e) {
                e.printStackTrace();
            }
        }

        Collections.sort(numbers, (a, b) -> Double.compare(a.doubleValue(), b.doubleValue()));

        for (E num : numbers) {
            try {
                stack.push(num);
            } catch (StackFullException e) {
                e.printStackTrace();
            }
        }

        return numbers;
    }
}
