import java.util.Iterator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Set;
import java.util.Scanner;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))).nextInt();
        final int nextInt2 = scanner.nextInt();
        scanner.nextLine();
        final Set<? super Integer> set = IntStream.rangeClosed(0, 101).boxed().collect((Collector<? super Integer, ?, Set<? super Integer>>)Collectors.toSet());
        for (int i = 0; i < nextInt2; ++i) {
            set.remove(scanner.nextInt());
        }
        int abs = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        final Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            final int intValue;
            if (Math.abs((intValue = iterator.next()) - nextInt) < abs) {
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
