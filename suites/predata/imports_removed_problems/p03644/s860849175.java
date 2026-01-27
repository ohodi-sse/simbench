public class Main {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
       	int A = 0;
      	int base = 2;
		
		for (int i = 0; i <= N; i++){
       		if(Math.pow(base,i)<=N){
            	A = (int)Math.pow(base,i);
            }
          	else{
              break;
            }
            	
        }
		
		
		
		System.out.println(A);
	}
}