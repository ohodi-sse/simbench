import java.util.Scanner;

public class Main {
  public static void main(final String[] array) {
    final Scanner scanner = new Scanner(System.in);
    final String next = scanner.next();
    final String next2 = scanner.next();
    final char[] charArray = next.toCharArray();
    final char[] charArray2 = next2.toCharArray();
    int x = 0;
    for (int i = 0; i < charArray.length; ++i) {
      if (charArray[i] == charArray2[i]) {
        ++x;
      }
    }
    System.out.println(x);
  }
}