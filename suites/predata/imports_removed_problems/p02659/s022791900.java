public class Main {

  public static void main(String[] args) {
    
    
    
    abc169_c();
  }

  public static void abc169_c() {
    try (Scanner sc = new Scanner(System.in)) {
      BigDecimal a = new BigDecimal(sc.next());
      BigDecimal b = new BigDecimal(sc.next());

      System.out.println(a.multiply(b).setScale(0, RoundingMode.DOWN));

    } catch (Exception e) {
      System.out.println("エラー" + e);
    }
  }
}