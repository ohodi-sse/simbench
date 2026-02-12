import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private Scanner sc;
    
    public Main() {
        this.sc = new Scanner(System.in);
    }
    
    private static void main$3231c38a() {
        final Main main;
        final long nextLong = (main = new Main()).sc.nextLong();
        final double nextDouble = main.sc.nextDouble();
        long n = 0L;
        for (int i = 0; i < 1000; ++i) {
            if (i / 100.0 == nextDouble) {
                n = i;
            }
        }
        System.out.println(nextLong * n / 100L);
    }
    
    private void run() {
        final long nextLong = this.sc.nextLong();
        final double nextDouble = this.sc.nextDouble();
        long n = 0L;
        for (int i = 0; i < 1000; ++i) {
            if (i / 100.0 == nextDouble) {
                n = i;
            }
        }
        System.out.println(nextLong * n / 100L);
    }
}
