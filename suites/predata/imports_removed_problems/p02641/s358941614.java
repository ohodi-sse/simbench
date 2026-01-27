public class Main {

  public static void main(String[] args) {

    
    Scanner sc = new Scanner(System.in);
    Integer target = new Integer(Integer.parseInt(sc.next()));
    int n = Integer.parseInt(sc.next()); 

    
    if (n == 0) {
      System.out.println(target);
      return;
    }

    
    Integer x[] = new Integer[n];
    for (int i = 0; i < n; i++) {
      x[i] = new Integer(Integer.parseInt(sc.next()));
    }

    
    if (!Arrays.asList(x).contains(target)) {
      System.out.println(target);
      return;
    }

    
    Arrays.sort(x);
    

    
    int index = Arrays.asList(x).indexOf(target);

    
    int now = target.intValue();
    int minus = 0;
    while (now <= x[x.length - 1].intValue()) {

      
      minus++;

      
      now = target.intValue() - minus;
      

      
      if (!Arrays.asList(x).contains(new Integer(now))) {
        break;
      }
    }

    
    now = target.intValue();
    int plus = 0;
    while (x[0].intValue() <= now) {

      
      plus++;

      
      now = target.intValue() + plus;
      

      
      if (!Arrays.asList(x).contains(new Integer(now))) {
        break;
      }
    }

    

    
    if (minus <= plus) {
      System.out.println(target.intValue() - minus);
    } else {
      System.out.println(target.intValue() + plus);
    }
  }
}