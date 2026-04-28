package iterator.fibonacci_sequence_generator;

import java.util.Iterator;

// Sequence keeps track of its own state.
// If one sequence has multiple iterators,
// the sequence may still only generate set count of numbers.
public class FibonacciSequence implements Sequence {

    private int previous = 0;
    private int current = 1;

    // default to generating 200 numbers of sequence
    private int toGenerateCount = 200;
    private int generatedCount = 1;

    public FibonacciSequence(int toGenerateCount) {
        this.toGenerateCount = toGenerateCount;
    }

    public FibonacciSequence() {
        // empty constructor
    }

    public int getCurrent() {
        return current;
    }

    public int getPrevious() {
        return previous;
    }

    public int getToGenerateCount() {
        return toGenerateCount;
    }

    public int getGeneratedCount() {
        return generatedCount;
    }

    public int generateNext() {
        int next = this.previous + this.current;
        this.previous = current;
        this.current = next;

        this.generatedCount++;
        return next;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(this);
    }
}
