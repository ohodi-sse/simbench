static class Multiplication3
{
    public void solve(final int n, final Scanner scanner, final PrintWriter printWriter) {
        final String[] split = scanner.nextLine().split(" ");
        printWriter.append(String.valueOf(Long.parseLong(split[0]) * Long.parseLong(split[1].replaceAll("\\.", "")) / 100L));
    }
}public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final Scanner scanner = new Scanner(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new Multiplication3().solve(1, scanner, printWriter);
        printWriter.close();
    }
    
    static class Multiplication3
    {
        public void solve(final int n, final Scanner scanner, final PrintWriter printWriter) {
            final String[] split = scanner.nextLine().split(" ");
            printWriter.append(String.valueOf(Long.parseLong(split[0]) * Long.parseLong(split[1].replaceAll("\\.", "")) / 100L));
        }
    }
}