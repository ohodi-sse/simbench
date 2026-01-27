public class Main{

    public static void main(String[] args){
        

        Scanner sc=new Scanner(System.in);

        int X=sc.nextInt();
        int N=sc.nextInt();

        int[] p=new int[N+10];

        int[] up=new int[200];
        int[] dw=new int[200];

        Arrays.fill(up, 0);
        Arrays.fill(dw, 0);

        int i=0;
        dw[0]=1;

        for(i=0;i<N;i++){
            p[i]=sc.nextInt();
            int sa=p[i]-X;

            if(sa>=0){
                up[sa]=1;
                
            }else{
                sa=sa*(-1);
                dw[sa]=1;
                
            }
            
        }

        int hit=0;

        for(i=0;i<100;i++){
            if(dw[i]==0){
                hit=-i;
                
                break;
            }else if(up[i]==0){
                hit=i;
                
                break;
            }else if(i==X){
                
                break;
            }
        }

        int ans=X+hit;

        
            System.out.println(ans);
        

        
    }
}