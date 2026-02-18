public final class Main
{
    private static void main$3231c38a() throws IOException {
        final char[] charArray;
        if ((charArray = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray())[0] == 'R' && charArray[1] == 'R' && charArray[2] == 'R') {
            System.out.println(3);
            return;
        }
        if ((charArray[0] == 'R' && charArray[1] == 'R') || (charArray[1] == 'R' && charArray[2] == 'R')) {
            System.out.println(2);
            return;
        }
        if (charArray[0] == 'R' || charArray[1] == 'R' || charArray[2] == 'R') {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }
}