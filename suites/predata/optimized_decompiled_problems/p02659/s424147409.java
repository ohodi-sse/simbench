import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(BigDecimal.valueOf(Long.parseLong(scanner.next())).multiply(BigDecimal.valueOf(Double.parseDouble(scanner.next()))).longValue());
    }
    
    private static double getDouble(final Scanner scanner) {
        return Double.parseDouble(scanner.next());
    }
    
    private static List<Integer[]> getPermutation(final int[] array) {
        return buildPermutaion(new ArrayList<Integer[]>(), array, new Integer[array.length], new boolean[array.length], 0);
    }
    
    private static List<Integer[]> buildPermutaion(List<Integer[]> buildPermutaion, final int[] array, final Integer[] array2, final boolean[] array3, final int n) {
        if (n == array.length) {
            buildPermutaion.add(array2.clone());
            return buildPermutaion;
        }
        for (int i = 0; i < array.length; ++i) {
            if (!array3[i]) {
                array2[n] = array[i];
                array3[i] = true;
                buildPermutaion = buildPermutaion(buildPermutaion, array, array2, array3, n + 1);
                array3[i] = false;
            }
        }
        return buildPermutaion;
    }
    
    private static long getLong(final Scanner scanner) {
        return Long.parseLong(scanner.next());
    }
    
    private static int getInt(final Scanner scanner) {
        return Integer.parseInt(scanner.next());
    }
    
    private static String getString(final Scanner scanner) {
        return scanner.next();
    }
    
    private static int[] getIntArray(final Scanner scanner) {
        String nextLine;
        for (nextLine = ""; nextLine.equals(""); nextLine = scanner.nextLine()) {}
        final String[] split;
        final int[] array = new int[(split = nextLine.split(" ")).length];
        for (int i = 0; i < split.length; ++i) {
            array[i] = Integer.parseInt(split[i]);
        }
        return array;
    }
}
// 
// Decompiled by Procyon v0.6.0
// 

final class Status
{
    private int row;
    private int col;
    private int candies;
    
    private Status(final int row, final int col, final int candies) {
        this.row = 0;
        this.col = 0;
        this.candies = 0;
        this.row = row;
        this.col = col;
        this.candies = candies;
    }
}
