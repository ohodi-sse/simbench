import java.util.Scanner;

public class Main
{
    Scanner sc;
    String S;
    
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final Main main = new Main(scanner);
        main.show(main.solve());
        scanner.close();
    }
    
    Main(final Scanner sc) {
        this.sc = sc;
        this.S = sc.next();
    }
    
    private int solve() {
        int n = 0;
        int n2 = 0;
        for (int i = 0; i < this.S.length() - 1; ++i) {
            if (this.S.charAt(i) == 'R' || this.S.charAt(2) == 'R') {
                n = 1;
            }
            if (this.S.charAt(i) == 'R' && this.S.charAt(i + 1) == 'R') {
                ++n2;
            }
        }
        if (n2 == 1) {
            n = 2;
        }
        else if (n2 == 2) {
            n = 3;
        }
        return n;
    }
    
    public void show(final int x) {
        System.out.println(x);
    }
}