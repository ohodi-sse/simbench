public final class Main
{
    private static void main$3231c38a() {
        final String next;
        if ((next = new Scanner(System.in).next()).charAt(0) == 'R' && next.charAt(1) == 'R' && next.charAt(2) == 'R') {
            System.out.println(3);
            return;
        }
        if ((next.charAt(0) == 'R' && next.charAt(1) == 'R') || (next.charAt(1) == 'R' && next.charAt(2) == 'R')) {
            System.out.println(2);
            return;
        }
        if (next.charAt(0) == 'R' || next.charAt(1) == 'R' || next.charAt(2) == 'R') {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }
}