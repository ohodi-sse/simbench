public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int i = 1;
        if (nextInt == i) {
            System.out.println("1");
        }
        else {
            while (i <= nextInt) {
                i *= 2;
            }
            System.out.println(i / 2);
        }
    }
}