import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    int n;
    int ans;
    
    public Main() {
        this.ans = 1;
    }
    
    public static void main(final String[] array) {
        new Main().run();
    }
    
    void run() {
        this.in();
        int n = 0;
        for (int i = 1; i <= this.n; ++i) {
            int n2 = 0;
            for (int n3 = i; n3 % 2 == 0; n3 /= 2) {
                ++n2;
            }
            if (n < n2) {
                n = n2;
                this.ans = i;
            }
        }
        this.out();
    }
    
    void in() {
        this.n = new Scanner(System.in).nextInt();
    }
    
    void out() {
        System.out.println(this.ans);
    }
}
