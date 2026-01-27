public class Main {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Main m = new Main(sc);
        m.show(m.solve());
        sc.close();
    }
    
	
    Scanner sc;
    int X;
    int N;
    List<Integer> p = new ArrayList<Integer>();;
    
    
    Main(Scanner sc) {
        this.sc = sc;
        this.X = sc.nextInt();
        this.N = sc.nextInt();
        for (int i = 0; i< N; i++) {
        	p.add(sc.nextInt());
        }
    }
    
    
    private int solve() {
        int answer = 0;
        
        for (int i = 0; i<= 100; i++) {
        	if (!p.contains(X - i)) {
        		answer = X - i;
        		break;
        	} else if (!p.contains(X + i)) {
        		answer = X + i;
        		break;
        	}
        }
        
        return answer;
    }
    
    
    public void show(int answer) {
        System.out.println(answer);
    }

}