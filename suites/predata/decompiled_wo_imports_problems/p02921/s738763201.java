public class Main
{
    static Scanner sc;
    static int mod;
    
    public static void main(final String[] array) {
        final String next = Main.sc.next();
        final String next2 = Main.sc.next();
        System.out.println(0 + ((next.charAt(0) == next2.charAt(0)) ? 1 : 0) + ((next.charAt(1) == next2.charAt(1)) ? 1 : 0) + ((next.charAt(2) == next2.charAt(2)) ? 1 : 0));
    }
    
    static {
        Main.sc = new Scanner(System.in);
        Main.mod = 1000000007;
    }
}