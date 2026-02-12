// 
// Decompiled by Procyon v0.6.0
// 

public final class Main extends Reader
{
    private int x;
    private int n;
    private int[] a;
    
    private static void main$3231c38a() {
        final Main main = new Main();
        int x = 0;
        int x2 = main.x;
        final int[] array = new int[102];
        for (int i = 0; i < main.n; ++i) {
            array[main.a[i]] = 1;
        }
        for (int j = 0; j <= 101; ++j) {
            final int abs;
            if (array[j] == 0 && (abs = Math.abs(j - main.x)) < x2) {
                x2 = abs;
                x = j;
            }
        }
        System.out.println(x);
    }
    
    public Main() {
        this.x = super.ini();
        this.n = super.ini();
        this.a = super.vi(this.n);
    }
    
    private int solve() {
        int n = 0;
        int x = this.x;
        final int[] array = new int[102];
        for (int i = 0; i < this.n; ++i) {
            array[this.a[i]] = 1;
        }
        for (int j = 0; j <= 101; ++j) {
            final int abs;
            if (array[j] == 0 && (abs = Math.abs(j - this.x)) < x) {
                x = abs;
                n = j;
            }
        }
        return n;
    }
    
    private static int calc(int i, final int n) {
        int n2 = 0;
        while (i <= n) {
            n2 += i;
            ++i;
        }
        return n2;
    }
    
    private static void show(final int x) {
        System.out.println(x);
    }
}
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Reader
{
    private Scanner sc;
    
    Reader() {
        this.sc = new Scanner(System.in);
    }
    
    public int ini() {
        return this.sc.nextInt();
    }
    
    public int[] vi(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.sc.nextInt();
        }
        return array;
    }
}
