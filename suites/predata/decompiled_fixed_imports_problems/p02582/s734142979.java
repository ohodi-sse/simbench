import java.util.Scanner;

class Main
{
    public static void main(final String[] array) {
        int n = 0;
        int x = 0;
        final String nextLine = new Scanner(System.in).nextLine();
        final String[] array2 = new String[nextLine.length()];
        for (int i = 0; i < nextLine.length(); ++i) {
            array2[i] = String.valueOf(nextLine.charAt(i));
        }
        for (int j = 0; j < nextLine.length(); ++j) {
            if (array2[j].equals("R")) {
                x = ++n;
            }
            else if (array2[j].equals("S")) {
                n = 0;
            }
        }
        System.out.println(x);
    }
}