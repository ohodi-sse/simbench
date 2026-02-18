public final class Main
{
    private Scanner sc;
    private String S;
    private String T;
    
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
    
    private static void main$3231c38a() {
        final Main main2;
        final Main main = main2 = new Main();
        main.S = main.sc.next();
        final Main main3 = main2;
        main3.T = main3.sc.next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (main2.S.charAt(i) == main2.T.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
        System.out.flush();
    }
}