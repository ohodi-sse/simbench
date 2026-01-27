public class Main {
    static List<Integer> al = new ArrayList<>();
    static int[] a;

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static Set<Integer> s=new HashSet<>();

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        
      
            
            
            
            
            
            
            
            
            
            
          
            
            String s=sc.nextLine();

            int c=0;
            boolean flag=false;
            for(int i=0;i<s.length();i++ )
           { if(s.charAt(i)=='R')
           {
               c=1;
               break;
           }
            }
            for(int i=0;i<s.length()-1;i++)
            {
                
                if(s.charAt(i)=='R' && s.charAt(i+1)=='R')
                c++;
            }
            
            System.out.println(c);
        
           
            

            
    
       

    }


    static void chess(int n,int m,int x,int y)
    {
        if(x<0|| y<0 ||x>=n||y>=m)
        return;

        System.out.print(x+" "+y);

        chess(n, m, x, y-1);
        chess(n, m, x-1, y);
        chess(n, m, x, y+1);
        chess(n, m, x+1, y);
    }
    
    
    
    
  
    
    
    
    
    
  
    
    
            
    
    

    
    
    
    

   static int findCounts(int arr[], int n)  
    { 
        
        int i = 0; 
        while (i < n)  
        { 
            
            
            if (arr[i] <= 0)  
            { 
                i++; 
                continue; 
            } 
  
            
            
            int elementIndex = arr[i] - 1; 
  
            
            
            
            if (arr[elementIndex] > 0)  
            { 
                arr[i] = arr[elementIndex]; 
  
                
                
                arr[elementIndex] = -1; 
            }  
            else 
            { 
                
                
                arr[elementIndex]--; 
  
                
                
                arr[i] = 0; 
                i++; 
            } 
        } 
        int sum=0;
  
      
        for (int j = 1; j < n; j++) 
           { if( Math.abs(arr[j])>1)
            sum++; }
            return sum;
    } 


   
        
    




    
    
    
    
    
    
    
          
          
    
    
  
    
    
    
    
    
    
    
    
          
    
    
    
    
  
    
    
      
}