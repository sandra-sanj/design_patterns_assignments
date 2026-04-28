package iterator.fibonacci_sequence_generator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        FibonacciSequence sequence = new FibonacciSequence(10);
        Iterator iterator = sequence.iterator();

        System.out.println(sequence.getCurrent());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // test:
        // this will not generate numbers more than sequence allows, even though same sequence is reused
        System.out.println("\n\nTest 1:");

        Iterator iterator2 = new FibonacciIterator(sequence);
        System.out.println(sequence.getCurrent());
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        // test:
        // two iterators for one sequence
        System.out.println("\n\nTest 2:");

        FibonacciSequence sequence3 = new FibonacciSequence(5);
        Iterator iterator3 = sequence3.iterator();
        Iterator iterator4 = sequence3.iterator();

        System.out.println(sequence3.getCurrent());
        while (iterator3.hasNext()) {
            System.out.println("#1: " + iterator3.next());
            if (iterator4.hasNext()) {
                System.out.println("#2: " + iterator4.next());
            }
        }
    }
}
