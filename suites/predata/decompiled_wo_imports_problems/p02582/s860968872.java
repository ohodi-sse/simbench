public class Main
{
    public static void main(final String[] array) {
        final char[] charArray = new Scanner(System.in).next().toCharArray();
        int n = 0;
        boolean b = false;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == 'R') {
                b = true;
                if (i < 2 && charArray[i + 1] == 'R') {
                    ++n;
                }
            }
        }
        if (b) {
            System.out.println(n + 1);
        }
        else {
            System.out.println(0);
        }
    }
}