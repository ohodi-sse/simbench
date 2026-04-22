import java.util.Scanner;

public class Main
{
    Scanner sc;
    int MOD;
    
    public Main() {
        this.sc = new Scanner(System.in);
        this.MOD = 998244353;
    }
    
    public static void main(final String[] array) {
        new Main().run();
    }
    
    void run() {
        System.out.println(this.sc.nextLong() * Math.round(this.sc.nextDouble() * 100.0) / 100L);
    }
}