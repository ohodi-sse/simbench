public class Main
{
    static BufferedReader br;
    static StringTokenizer st;
    
    public static void main(final String[] array) throws IOException {
        Main.br = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter printWriter = new PrintWriter(System.out);
        final String next = next();
        final String next2 = next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == next2.charAt(i)) {
                ++x;
            }
        }
        printWriter.println(x);
        printWriter.close();
    }
    
    static String next() throws IOException {
        while (!Main.st.hasMoreTokens()) {
            Main.st = new StringTokenizer(Main.br.readLine());
        }
        return Main.st.nextToken();
    }
    
    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    
    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
    
    static {
        Main.st = new StringTokenizer("");
    }
}