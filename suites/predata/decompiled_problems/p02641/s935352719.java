import java.util.Iterator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Set;
import java.util.Scanner;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;





public final class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        scanner.nextLine();
        final Set<? super Integer> set = IntStream.rangeClosed(0, 101).boxed().collect((Collector<? super Integer, ?, Set<? super Integer>>)Collectors.toSet());
        for (int i = 0; i < nextInt2; ++i) {
            set.remove(scanner.nextInt());
        }
        int abs = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (final int intValue : set) {
            if (Math.abs(intValue - nextInt) < abs) {
                abs = Math.abs(intValue - nextInt);
                min = intValue;
            }
            else {
                if (Math.abs(intValue - nextInt) != abs) {
                    continue;
                }
                min = Math.min(min, intValue);
            }
        }
        System.out.println(min);
    }
}