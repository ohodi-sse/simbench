public final class Main
{
    private int n;
    private int ans;
    
    public Main() {
        this.ans = 1;
    }
    
    private static void main$3231c38a() {
        final Main main;
        (main = new Main()).n = new Scanner(System.in).nextInt();
        int n = 0;
        for (int i = 1; i <= main.n; ++i) {
            int n2 = 0;
            for (int n3 = i; n3 % 2 == 0; n3 /= 2) {
                ++n2;
            }
            if (n < n2) {
                n = n2;
                main.ans = i;
            }
        }
        System.out.println(main.ans);
    }
    
    private void run() {
        this.n = new Scanner(System.in).nextInt();
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
        System.out.println(this.ans);
    }
    
    private void in() {
        this.n = new Scanner(System.in).nextInt();
    }
    
    private void out() {
        System.out.println(this.ans);
    }
}