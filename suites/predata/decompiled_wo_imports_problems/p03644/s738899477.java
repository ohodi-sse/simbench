public final class Main
{
    private static void main$3231c38a() throws Exception {
        final int int1;
        if ((int1 = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())) == 1) {
            System.out.println(int1);
            return;
        }
        int i;
        for (i = 1; i <= int1; i <<= 1) {}
        System.out.println(i / 2);
    }
}