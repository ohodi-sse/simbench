import java.util.Scanner;

class Main
{
    public static void main(final String[] array) {
        final String nextLine = new Scanner(System.in).nextLine();
        final String s = "R";
        final int index = nextLine.indexOf(s);
        final int lastIndex = nextLine.lastIndexOf(s);
        if (nextLine.contentEquals("RRR")) {
            System.out.println("3");
        }
        else if (nextLine.contentEquals("SSR")) {
            System.out.println("1");
        }
        else if (nextLine.contentEquals("SRS")) {
            System.out.println("1");
        }
        else if (nextLine.contentEquals("RSS")) {
            System.out.println("1");
        }
        else if ((index == 0 && lastIndex == 1) || (index == 1 && lastIndex == 2)) {
            System.out.println("2");
        }
        else if ((index == 0 && lastIndex == 2) || (index == 2 && lastIndex == -1) || (index == 0 && lastIndex == -1) || (index == 1 && lastIndex == -1)) {
            System.out.println("1");
        }
        else if (nextLine.contentEquals("SSS")) {
            System.out.println("0");
        }
    }
}