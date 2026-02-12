import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private String f;
    private int result;
    
    private static void main$3231c38a() {
        final Main main2;
        final Main main = main2 = new Main();
        main2.f = new Scanner(System.in).next();
        main2.result = 0;
        final Main main3;
        if ((main3 = main).f.equals("RRR")) {
            main3.result = 3;
        }
        else if (main3.f.equals("SRR") || main3.f.equals("RRS")) {
            main3.result = 2;
        }
        else if (main3.f.contains("R")) {
            main3.result = 1;
        }
        else {
            main3.result = 0;
        }
        System.out.println(main.result);
    }
    
    private void input() {
        this.f = new Scanner(System.in).next();
        this.result = 0;
    }
    
    private void solve() {
        if (this.f.equals("RRR")) {
            this.result = 3;
            return;
        }
        if (this.f.equals("SRR") || this.f.equals("RRS")) {
            this.result = 2;
            return;
        }
        if (this.f.contains("R")) {
            this.result = 1;
            return;
        }
        this.result = 0;
    }
    
    private void output() {
        System.out.println(this.result);
    }
}
