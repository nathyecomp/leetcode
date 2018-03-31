/*
need to improve it! ()
*/

class Solution {
    int[] timeVisited;
    public int networkDelayTime(int[][] times, int N, int K) {
            if (times.length==0) return -1;
            int[][] nodes = new int[N+1][N+1];
            timeVisited = new int[N+1];
	        for(int i = 1; i<=N; i++){
                timeVisited[i] = -2;
                for(int i2 = 1; i2<=N; i2++){
   	                nodes[i][i2] = -1;
                }
            }
	        
	        for(int i = 0; i<times.length; i++){
	            int node1 = times[i][0];
	            int node2 = times[i][1];
                // //Marcando os nós existentes
                timeVisited[node1] = -1;
                timeVisited[node2] = -1;
	            int t = times[i][2];
	            nodes[node1][node2] = t;
                nodes[node1][node1] = 0;
                nodes[node2][node2] = 0;
            }
            if(timeVisited[K]==-2) return -1;
        
            timeVisited[K] = 0;
            //source first
            calcTime(K, N, nodes);
            int highestTime = Integer.MIN_VALUE;
            for(int i = 1; i<=N; i++){
                    //Algum nó existente nao foi acessado
	                if(timeVisited[i] <= -1) return -1;
	                if(timeVisited[i]>highestTime){
	                    highestTime = timeVisited[i];
                    }
            }
	return highestTime;
}
    
public void calcTime(int source, int N, int[][] nodes){
           if(timeVisited[source]<=-1) return;
           for(int i = 1; i<=N; i++){
               //Se existe conexao entre os nós...
		        if(i!=source && nodes[source][i]>-1){
	                int time = nodes[source][i];
	                //Se o que esta lá for maior do que eu tenho pra oferecer...
	                if(timeVisited[i] ==-1 || (timeVisited[i]>timeVisited[source]+time)){
		                timeVisited[i] = timeVisited[source]+time;
		                calcTime(i,N,nodes);
                    }
                }
            }
            return;
}

}