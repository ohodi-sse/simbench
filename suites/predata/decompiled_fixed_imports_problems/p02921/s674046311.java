import java.util.Scanner;

public class Main
{
    Scanner sc;
    String S;
    String T;
    
    public Main() {
        this.sc = new Scanner(System.in);
    }
    
    private void calc() {
        this.S = this.sc.next();
        this.T = this.sc.next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (this.S.charAt(i) == this.T.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
        System.out.flush();
    }
    
    public static void main(final String[] array) {
        new Main().calc();
    }
}