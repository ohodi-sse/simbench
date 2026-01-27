public class Main {
    public static void main(String[] args) throws Exception {
        
    	Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
	    
        if(N==1){
            System.out.println(1);
        }else if(N<=3){
            System.out.println(2);
        }else if(N>3 && N<8){
            System.out.println(4);
        }else if(N>=8 && N<16){
            System.out.println(8);
        }else if(N>=16 && N<31){
            System.out.println(16);
        }else if(N>=32 && N<64){
            System.out.println(32);
        }else{
            System.out.println(64);
        }
	    

    }
}