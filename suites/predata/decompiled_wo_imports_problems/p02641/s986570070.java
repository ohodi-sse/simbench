public final class Main
{
    private Scanner sc;
    
    public Main() {
        this.sc = new Scanner(System.in);
    }
    
    private static void main$3231c38a() {
        final Main main;
        final int nextInt = (main = new Main()).sc.nextInt();
        final int nextInt2 = main.sc.nextInt();
        final ArrayList list = new ArrayList();
        for (int i = -200; i <= 200; ++i) {
            list.add(i);
        }
        for (int j = 0; j < nextInt2; ++j) {
            list.remove((Object)main.sc.nextInt());
        }
        int intValue = 1000;
        int abs = 10000;
        for (final Integer n : list) {
            if (Math.abs(nextInt - n) < abs) {
                abs = Math.abs(nextInt - n);
                intValue = n;
            }
        }
        System.out.println(intValue);
    }
    
    private void run() {
        final int nextInt = this.sc.nextInt();
        final int nextInt2 = this.sc.nextInt();
        final ArrayList list = new ArrayList();
        for (int i = -200; i <= 200; ++i) {
            list.add(i);
        }
        for (int j = 0; j < nextInt2; ++j) {
            list.remove((Object)this.sc.nextInt());
        }
        int intValue = 1000;
        int abs = 10000;
        for (final Integer n : list) {
            if (Math.abs(nextInt - n) < abs) {
                abs = Math.abs(nextInt - n);
                intValue = n;
            }
        }
        System.out.println(intValue);
    }
}