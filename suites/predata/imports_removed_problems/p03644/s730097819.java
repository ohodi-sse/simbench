public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
    
		
		int n = sc.nextInt();
        int standard = 1;
        while (true) {
          int target = standard * 2;
          if (target <= n) {
            standard = target;
          } else {
            break;
          }
        }
        
		
		System.out.println(standard);
	}
}