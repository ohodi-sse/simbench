final class Main
{
    private Scanner sc;
    
    Main() {
        this.sc = new Scanner(System.in);
    }
    
    private static void main$3231c38a() {
        final Main main;
        final String next = (main = new Main()).sc.next();
        final String next2 = main.sc.next();
        int x = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == next2.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    private void run() {
        final String next = this.sc.next();
        final String next2 = this.sc.next();
        int x = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == next2.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
    }
}