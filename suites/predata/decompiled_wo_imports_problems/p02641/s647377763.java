public final class Main
{
    private Scanner sc;
    private int MOD = 998244353;
    private int MAX = Integer.MAX_VALUE;
    private long LMAX = Long.MAX_VALUE;
    private int len;
    
    public Main() {
        this.sc = new Scanner(System.in);
        this.len = 1000001;
    }
    
    private void doIt() {
        final int nextInt = this.sc.nextInt();
        final int nextInt2 = this.sc.nextInt();
        final boolean[] array;
        Arrays.fill(array = new boolean[201], true);
        for (int i = 0; i < nextInt2; ++i) {
            array[this.sc.nextInt()] = false;
        }
        for (int j = 0; j <= 100; ++j) {
            if (array[nextInt - j]) {
                System.out.println(nextInt - j);
                return;
            }
            if (array[nextInt + j]) {
                System.out.println(nextInt + j);
                return;
            }
        }
    }
    
    private static void main$3231c38a() {
        final Main main;
        final int nextInt = (main = new Main()).sc.nextInt();
        final int nextInt2 = main.sc.nextInt();
        final boolean[] array;
        Arrays.fill(array = new boolean[201], true);
        for (int i = 0; i < nextInt2; ++i) {
            array[main.sc.nextInt()] = false;
        }
        for (int j = 0; j <= 100; ++j) {
            if (array[nextInt - j]) {
                System.out.println(nextInt - j);
                return;
            }
            if (array[nextInt + j]) {
                System.out.println(nextInt + j);
                return;
            }
        }
    }
}