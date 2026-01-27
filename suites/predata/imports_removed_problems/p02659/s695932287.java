public class Main {
  public static void main(String[] args) throws Exception {
    solve(System.in, System.out);
  }

  static void solve(InputStream is, PrintStream os) {
    
    Scanner scan = new Scanner(is);
    long A = scan.nextLong();
    Double B = scan.nextDouble();
    BigDecimal BB = new BigDecimal(B.toString());
    BigDecimal BD = BB.multiply(new BigDecimal(A));

    os.println(BD.longValue());
  }
}