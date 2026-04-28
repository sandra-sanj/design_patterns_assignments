package iterator.fibonacci_sequence_generator;

import java.util.Iterator;

// Iterator is tied to one sequence, but a sequence may have multiple iterators.
public class FibonacciIterator implements Iterator<Integer> {
    private FibonacciSequence sequence;

    public FibonacciIterator(FibonacciSequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean hasNext() {
        return this.sequence.getGeneratedCount() < this.sequence.getToGenerateCount();
    }

    @Override
    public Integer next() {
        return this.sequence.generateNext();
    }
}
