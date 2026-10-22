import java.math.BigInteger;
import libraries.Timer;

public class TrialDivision {
    public static void main(String[] args) {
        Timer timer = new Timer();

        BigInteger number = new BigInteger("59842579175171731");
        System.out.println("Testing primality for the number " + number + " with the amount of digits " + number.toString().length() + ".");
        System.out.println("This process will need to have an iteration of at most " + number.sqrt().toString() + " iterations.");

        timer.start();

        boolean primality = isPrime(number);

        String primalityStr = primality ? "PRIME" : "NOT PRIME";
        System.out.println("The number " + number + " is " + primalityStr + ".");

        long endTime = System.nanoTime();
        System.out.println("Process took " + timer.quickRetrieve() + " milliseconds.");
    }

    static boolean isPrime(BigInteger num) {
        if (num.compareTo(BigInteger.TWO) < 0) return false;
        for (
                BigInteger i = new BigInteger("2");
                i.pow(2).compareTo(num) < 0;
                i = i.add(BigInteger.ONE)
        ) {
            if (num.remainder(i).compareTo(BigInteger.ZERO) == 0) {
                System.out.println("First number that the original number is divisible by: " + i.toString());
                System.out.println("The expression: " + i.toString() + " * " + num.divide(i));
                return false;
            }
            if (i.bitCount() == 1) {
                System.out.println("Process passed " + i.toString());
            }
        }
        return true;
    }
}
