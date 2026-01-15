import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    static final long MOD = 1000000007L;
    static final int MAX = 2147483646;
    static final int INF = 1000000000;
    
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextBigDecimal().multiply(scanner.nextBigDecimal()).toBigInteger());
    }
}
