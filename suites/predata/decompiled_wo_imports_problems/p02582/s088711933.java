class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int x;
        if (next.charAt(0) == 'R' && next.charAt(1) == 'R' && next.charAt(2) == 'R') {
            x = 3;
        }
        else if (next.charAt(0) == 'R' && next.charAt(1) == 'R') {
            x = 2;
        }
        else if (next.charAt(1) == 'R' && next.charAt(2) == 'R') {
            x = 2;
        }
        else if (next.charAt(0) != 'R' && next.charAt(1) != 'R' && next.charAt(2) != 'R') {
            x = 0;
        }
        else {
            x = 1;
        }
        System.out.println(x);
    }
}