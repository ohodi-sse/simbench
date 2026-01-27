public class Main
{
    public static void main(final String[] array) {
        int i = new Scanner(System.in).nextInt();
        int n = 0;
        boolean b = true;
        if (i >= 2) {
            while (i > 0) {
                ++n;
                i /= 2;
            }
        }
        else {
            b = false;
        }
        if (!b) {
            System.out.println(i);
        }
        else {
            System.out.println((int)Math.pow(2.0, n - 1));
        }
    }
}