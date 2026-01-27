/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        A solver = new A();
        solver.solve(1, in, out);
        out.close();
    }

    static class A {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            
            String S = in.next();
            String T = in.next();
            int ans = 0;

            if (S.charAt(0) == T.charAt(0)) ans++;
            if (S.charAt(1) == T.charAt(1)) ans++;
            if (S.charAt(2) == T.charAt(2)) ans++;


            
            out.println(ans);

        }

    }
}