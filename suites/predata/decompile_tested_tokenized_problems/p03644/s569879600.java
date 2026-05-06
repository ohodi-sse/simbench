import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    static final int MOD = 1000000007;
    static final int INF = 1073741824;
    
    Main() {
        Scanner scanner;
        int x;
        for (scanner = new Scanner(System.in), x = 1; x * 2 <= scanner.nextInt(); x *= 2) {}
        System.out.println(x);
    }
    
    public static void main(final String[] array) {
        new Main();
    }
}
