import java.util.Scanner;

class Main {
  static final int MOD = 1000000007;
  static final int INF = 1 << 30;

  Main() {
    Scanner sc = new Scanner(System.in);
    int ans = 1;
    int N = sc.nextInt();
    while (ans * 2 <= N) ans *= 2;
    System.out.println(ans);
  }

  public static void main(String[] args) {
    new Main();
  }
}
