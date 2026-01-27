public class Main
{
    public static void main(final String[] array) {
        final String[] split = new Scanner(System.in).nextLine().split("");
        final int n = 0;
        final String anObject = "R";
        int n2;
        if (split[0].equals(anObject)) {
            n2 = n + 1;
        }
        else {
            n2 = n;
        }
        int n3;
        if (split[1].equals(anObject)) {
            n3 = n2 + 1;
        }
        else {
            n3 = n2;
        }
        int x;
        if (split[2].equals(anObject)) {
            x = n3 + 1;
        }
        else {
            x = n3;
        }
        if (x == 1 || x == 3 || x == 0) {
            System.out.println(x);
        }
        else if (x == 2 && split[0].equals(anObject) && split[2].equals(anObject)) {
            System.out.println(1);
        }
        else {
            System.out.println(2);
        }
    }
}