public class Main {
  public static void main(String[] args){
    
    int answer = 0; 
    
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    if(!sc.hasNext()){
      System.out.println(answer);
       return;
    }
    int n = sc.nextInt();
    
    
    if(n == 0){
      answer = x;
      System.out.println(answer);
      return;
    }
    
    
    Set<Integer> pSet = new HashSet<Integer>();
    while(sc.hasNext()){
      pSet.add(sc.nextInt());
    }
    
    
    int a = 0;
    while(true){
      if(!pSet.contains(x - a)){
        answer = x - a;
        break;
      }
      if(!pSet.contains(x + a)){
        answer = x + a;
        break;
      }
      a++;
    }
    
    System.out.println(answer);
  }
}