public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
      
      
      int x =sc.nextInt();
      int n =sc.nextInt();
      int ans = 0;
      int min = 100;
      
      
      List<Integer> s = new ArrayList<Integer>();
      
      
      for(int i =0; i<n; i++){
      		s.add(sc.nextInt());
      } 
      
		if(n == 0 || !(s.contains(x))) {
			System.out.println(x);
		}
      
      	else {
			for(int i =0; i<=200; i++) {
                
				if(!(s.contains(i))) {
                    
					if(Math.abs(x - i) < min) {
                        
						min = Math.abs(x - i);
						ans = i;
                    }
                }
            }
          System.out.println(ans);
        }
    }
}