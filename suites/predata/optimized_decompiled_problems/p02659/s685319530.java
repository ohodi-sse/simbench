import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static Scanner scan;
    
    private static int pow(final int n) {
        int n2 = 1;
        for (int i = 0; i < n; ++i) {
            n2 *= 10;
        }
        return n2;
    }
    
    private static void main$3231c38a() {
        final String[] split2;
        final String[] split = (split2 = Main.scan.nextLine().split(" "))[1].split("\\.");
        final Long[] array;
        final Long n = (array = new Long[] { Long.parseLong(split2[0]), Long.parseLong(split[0]), Long.parseLong(split[1]) })[0];
        final long longValue = array[1];
        final int length = split[1].length();
        int n2 = 1;
        for (int i = 0; i < length; ++i) {
            n2 *= 10;
        }
        final String s;
        if ((s = String.valueOf((Object)(n * (longValue * n2 + array[2]))).split("\\.")[0]).length() - split[1].length() <= 0) {
            System.out.println((Object)"0");
            return;
        }
        System.out.println((Object)s.substring(0, s.length() - split[1].length()));
        Main.scan.close();
    }
    
    private static String line() {
        return Main.scan.nextLine();
    }
    
    private static int[] lineInts() {
        final String[] split;
        final int[] array = new int[(split = Main.scan.nextLine().split(" ")).length];
        for (int i = 0; i < split.length; ++i) {
            array[i] = Integer.parseInt(split[i]);
        }
        return array;
    }
    
    private static int[] split_piriod_Ints(final String[] array) {
        Main.scan.nextLine();
        final int[] array2 = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = Integer.parseInt(array[i]);
        }
        return array2;
    }
    
    private static long[] lineLongs() {
        final String[] split;
        final long[] array = new long[(split = Main.scan.nextLine().split(" ")).length];
        for (int i = 0; i < split.length; ++i) {
            array[i] = Long.parseLong(split[i]);
        }
        return array;
    }
    
    private static void puts(final Object x) {
        System.out.println(x);
    }
    
    private static void puts(final Object... array) {
        for (int i = 0; i < array.length; ++i) {
            System.out.println(array[i]);
        }
    }
    
    static {
        Main.scan = new Scanner(System.in);
    }
}
