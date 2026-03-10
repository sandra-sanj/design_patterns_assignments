package strategy.algorithm_performance_comparison;

import java.util.Random;

public class Main {
    private static String sortArray(SortingContext sortingContext, int[] array) {
        long start = System.nanoTime();
        sortingContext.sort(array);
        long end = System.nanoTime();

        int duration = Math.toIntExact(end - start);
        return String.format("Sorting array of %d numbers took %d ns", array.length, duration);
    }

    public static void main(String[] args) {

        int nSmall = 30;
        int nLarge = 100000;

        Random random = new Random();

        // generate a small array of integers (30)
        int[] arrSmall = new int[nSmall];
        for (int i = 0; i < arrSmall.length; i++) {
            arrSmall[i] = random.nextInt(nSmall);
        }

        // generate a large array of integers (100 000)
        int[] arrLarge = new int[nLarge];
        for (int i = 0; i < arrLarge.length; i++) {
            arrLarge[i] = random.nextInt(nLarge);
        }

        // sort small and large array with all different algorithms (2 arrays x 3 algorithms = 6 times total)
        // save duration results

        SortingContext sortingContext = new SortingContext(new HeapSorting());
        System.out.println("\nHeap Sort");
        System.out.println(sortArray(sortingContext, arrSmall));
        System.out.println(sortArray(sortingContext, arrLarge));

        sortingContext.setStrategy(new InsertionSorting());
        System.out.println("\nInsertion Sort");
        System.out.println(sortArray(sortingContext, arrSmall));
        System.out.println(sortArray(sortingContext, arrLarge));

        sortingContext.setStrategy(new CycleSorting());
        System.out.println("\nCycle Sort");
        System.out.println(sortArray(sortingContext, arrSmall));
        System.out.println(sortArray(sortingContext, arrLarge));
    }
}
