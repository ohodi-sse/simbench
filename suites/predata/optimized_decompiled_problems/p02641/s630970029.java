import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private Scanner sc;
    private int X;
    private int N;
    private List<Integer> p;
    
    private static void main$3231c38a() throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final Main main = new Main(scanner);
        int x = 0;
        for (int i = 0; i <= 100; ++i) {
            if (!main.p.contains(main.X - i)) {
                x = main.X - i;
                break;
            }
            if (!main.p.contains(main.X + i)) {
                x = main.X + i;
                break;
            }
        }
        System.out.println(x);
        scanner.close();
    }
    
    private Main(final Scanner sc) {
        this.p = new ArrayList<Integer>();
        this.sc = sc;
        this.X = sc.nextInt();
        this.N = sc.nextInt();
        for (int i = 0; i < this.N; ++i) {
            this.p.add(sc.nextInt());
        }
    }
    
    private int solve() {
        int n = 0;
        for (int i = 0; i <= 100; ++i) {
            if (!this.p.contains(this.X - i)) {
                n = this.X - i;
                break;
            }
            if (!this.p.contains(this.X + i)) {
                n = this.X + i;
                break;
            }
        }
        return n;
    }
    
    private static void show(final int x) {
        System.out.println(x);
    }
}
