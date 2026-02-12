import java.math.BigDecimal;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private Scanner sc;
    
    Main() {
        this.sc = new Scanner(System.in);
    }
    
    private static void main$3231c38a() {
        final Main main = new Main();
        System.out.println(BigDecimal.valueOf(main.sc.nextLong()).multiply(BigDecimal.valueOf(main.sc.nextDouble())).longValue());
    }
    
    private void run() {
        System.out.println(BigDecimal.valueOf(this.sc.nextLong()).multiply(BigDecimal.valueOf(this.sc.nextDouble())).longValue());
    }
}
