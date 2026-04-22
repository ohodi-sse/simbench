import java.util.Scanner;

public class Main
{
    static Scanner scan;
    
    public static int pow(final int n) {
        int n2 = 1;
        for (int i = 0; i < n; ++i) {
            n2 *= 10;
        }
        return n2;
    }
    
    public static void main(final String[] array) {
        final String[] split = line().split(" ");
        final String[] split2 = split[1].split("\\.");
        final Long[] array2 = { Long.parseLong(split[0]), Long.parseLong(split2[0]), Long.parseLong(split2[1]) };
        final String s = String.valueOf((Object)(array2[0] * (array2[1] * pow(split2[1].length()) + array2[2]))).split("\\.")[0];
        if (s.length() - split2[1].length() <= 0) {
            puts("0");
            return;
        }
        puts(s.substring(0, s.length() - split2[1].length()));
        Main.scan.close();
    }
    
    public static String line() {
        return Main.scan.nextLine();
    }
    
    public static int[] lineInts() {
        final String[] split = line().split(" ");
        final int[] array = new int[split.length];
        for (int i = 0; i < split.length; ++i) {
            array[i] = Integer.parseInt(split[i]);
        }
        return array;
    }
    
    public static int[] split_piriod_Ints(final String[] array) {
        line();
        final int[] array2 = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = Integer.parseInt(array[i]);
        }
        return array2;
    }
    
    public static long[] lineLongs() {
        final String[] split = line().split(" ");
        final long[] array = new long[split.length];
        for (int i = 0; i < split.length; ++i) {
            array[i] = Long.parseLong(split[i]);
        }
        return array;
    }
    
    public static void puts(final Object x) {
        System.out.println(x);
    }
    
    public static void puts(final Object... array) {
        for (int i = 0; i < array.length; ++i) {
            System.out.println(array[i]);
        }
    }
    
    static {
        Main.scan = new Scanner(System.in);
    }
}