import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int int1 = Integer.parseInt((scanner = new Scanner(System.in)).next());
        scanner.close();
        final Integer[] array;
        Arrays.sort(array = new Integer[] { 2, 4, 8, 16, 32, 64 }, Collections.reverseOrder());
        int intValue = 1;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] <= int1) {
                intValue = array[i];
                break;
            }
        }
        System.out.println(intValue);
    }
}
