public class Main
{
    public static void main(final String[] array) {
        int i = new Scanner(new BufferedReader(new InputStreamReader(System.in))).nextInt();
        if (i == 1) {
            System.out.println(1);
            return;
        }
        int n = 0;
        while (i != 1) {
            ++n;
            i /= 2;
        }
        System.out.println((int)Math.pow(2.0, n));
    }
}