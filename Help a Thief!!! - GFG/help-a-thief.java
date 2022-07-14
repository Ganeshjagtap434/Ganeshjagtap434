// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int T = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            int[] B = new int[N];
            
            for(int i=0; i<N; i++)
            {
                A[i] = Integer.parseInt(S1[i]);
                B[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxCoins(A,B,T,N));
        }
    }
}// } Driver Code Ends


class Solution {
    public static class pair{
        int coins, plate;
        pair(int c, int p){
            coins = c;
            plate = p;
        }
    }
    
    static int maxCoins(int[] A, int[] B, int T, int N) {
        // code here
        int Result = 0;
        if(T == 0) return Result;
        PriorityQueue<pair> PQ = new PriorityQueue<pair>(N, (p, q) -> q.coins - p.coins);
        
        for(int i = 0; i < N; i++){
            pair p = new pair(B[i], A[i]);
            PQ.add(p);
        }
        
        while(T > 0 && !PQ.isEmpty()){
            pair p = PQ.poll();
            int coins = p.coins, plate = p.plate;
            // System.out.println(coins+" "+plate);
            Result += (coins*Math.min(T, plate));
            T -= plate;
        }
        
        return Result;
    }
}