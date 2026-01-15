import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    Scanner sc;
    int X;
    int N;
    List<Integer> p;
    
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final Main main = new Main(scanner);
        main.show(main.solve());
        scanner.close();
    }
    
    Main(final Scanner sc) {
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
    
    public void show(final int x) {
        System.out.println(x);
    }
}
