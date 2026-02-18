public final class Main
{
    private static void main$3231c38a() {
        int int1 = 0;
        int x = 1;
        int n = 0;
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int1 = Integer.parseInt(bufferedReader.readLine());
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
        for (int i = 1; i <= int1; ++i) {
            int n2 = 0;
            int n3 = i;
            boolean b = true;
            do {
                if (n3 % 2 != 0) {
                    if (n < n2) {
                        x = i;
                        n = n2;
                    }
                    b = false;
                }
                else {
                    n3 /= 2;
                    ++n2;
                }
            } while (b);
        }
        System.out.println(x);
    }
}