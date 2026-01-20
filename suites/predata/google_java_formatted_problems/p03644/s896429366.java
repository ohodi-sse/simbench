import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
  public static void main(final String[] args) throws Exception {

    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); ) {
      int N = Integer.parseInt(br.readLine());

      int ans = 1;
      while (ans < N) {
        ans *= 2;
      }

      if (ans > N) {
        ans /= 2;
      }

      System.out.println(ans);
    } catch (IOException | NumberFormatException e) {
      e.printStackTrace();
      System.exit(0);
    } catch (final Exception e) {
      e.printStackTrace();
      System.exit(0);
    }
  }
}
