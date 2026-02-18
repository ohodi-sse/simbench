public final class Main
{
    private static final Scanner sc;
    
    private static void main$3231c38a() {
        final String next = Main.sc.next();
        final String next2 = Main.sc.next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (next2.charAt(i) == next.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    static {
        sc = new Scanner(System.in);
    }
}