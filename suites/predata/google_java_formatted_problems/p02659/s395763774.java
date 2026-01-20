import static java.lang.Math.*;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    // 入力
    long a = sc.nextLong();
    String b = sc.next();
    BigDecimal A = new BigDecimal(a);
    BigDecimal B = new BigDecimal(b);

    // 計算

    // 出力
    System.out.println(A.multiply(B).toBigInteger());
  }
}
