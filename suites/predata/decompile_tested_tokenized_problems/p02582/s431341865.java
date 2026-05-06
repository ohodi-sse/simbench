import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    String f;
    int result;
    
    public static void main(final String[] array) {
        final Main main = new Main();
        main.input();
        main.solve();
        main.output();
    }
    
    private void input() {
        this.f = new Scanner(System.in).next();
        this.result = 0;
    }
    
    private void solve() {
        if (this.f.equals("RRR")) {
            this.result = 3;
        }
        else if (this.f.equals("SRR") || this.f.equals("RRS")) {
            this.result = 2;
        }
        else if (this.f.contains("R")) {
            this.result = 1;
        }
        else {
            this.result = 0;
        }
    }
    
    private void output() {
        System.out.println(this.result);
    }
}
