import java.lang.Math;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class SieveOfErathosthenes {
    static int max = (int)Math.pow(2, 29) - 1;
    public static void main(String[] args) {
        System.out.println("Initiating prime computation for numbers below " + max);
        long startTime = System.nanoTime();

        int[] numberSet = new int[max - 1];

        for (int i = 0; i < max - 1; i++) {
            numberSet[i] = i + 2;
        }

        int mult;
        int t;

        for (int i = 0; i < Math.sqrt(numberSet.length - 1); i++) {
            if (numberSet[i] != 0) {
                t = 0;
                mult = numberSet[i];

                while (t < numberSet.length) {
                    t = numberSet[i] * mult;
                    mult++;

                    if (t - 2 < numberSet.length && numberSet[t - 2] != 0)
                        numberSet[t - 2] = 0;
                }
            }
        }

        long endAlg = System.nanoTime();
        long algTime = (endAlg - startTime) / (long)1_000_000;
        System.out.println("Algorithm time elapsed: " + algTime + " milliseconds.");
        System.out.println("Algorithm complete. Proceeding to writing.");

        // to print out
        // print(numberSet, startTime);

        // to write
        write(numberSet, startTime);
    }
    private static void write(int[] set, long startTime) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output/primenum.txt"))) {
            for (int value : set) {
                if (value != 0) {
                    writer.write(String.valueOf(value));
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endWrite = System.nanoTime();
        long totalTime = (endWrite - startTime) / (long)1_000_000;
        System.out.println("Total time elapsed: " + totalTime + " milliseconds.");
    }
    private static void print(int[] set, long startTime) {
        System.out.println(" ");
        for (int value : set) {
            if (value != 0) System.out.print(value + " ");
        }

        long endPrint = System.nanoTime();
        long totalTime = (endPrint - startTime) / (long)1_000_000;
        System.out.println("Total time elapsed: " + totalTime + " milliseconds.");
    }
}
