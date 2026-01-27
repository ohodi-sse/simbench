public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
      	int N = sc.nextInt();
      
      List <Integer> a = new ArrayList <Integer>();
      
      for(int i=0; i<N; i++){
          a.add(sc.nextInt());
      }
      
      for(int i=0; i<100; i++){
      if(!a.contains(X-i)){
         System.out.println(X-i);
         break;
      }
      else if(!a.contains(X+i)){
              System.out.println(X+i);
              break;
      }
      }
    }
}