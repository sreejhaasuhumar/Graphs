package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathExistsInGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=3,start=0,end=2;
		int[][] edges= {{0,1},{1,2},{2,0}};
		boolean ans=validPath(n, edges, start, end);
		System.out.println(ans);
	}

		
	    static boolean found;
	    public static boolean validPath(int n, int[][] edges, int start, int end) {
	        found = false;
	        
	        if(start == end)
	            return  true;

	        Map<Integer,List<Integer>> graph = new HashMap();
	        boolean[] visited = new boolean[n];
	        
	        for(int i = 0 ; i < n ; i++){
	            graph.put(i, new ArrayList());
	        }
	         //construct graph, add bidirectional vertex
	        for(int[] edge : edges){
	           graph.get(edge[0]).add(edge[1]);
	           graph.get(edge[1]).add(edge[0]);
	        }
			//start dfs from start point
	        dfs(graph,visited,start,end);
	       
	        return found;
	    }
	    
	    private static void dfs(Map<Integer,List<Integer>> graph,boolean[] visited, int start, int end){
	        if(visited[start] || found)
	            return;
	        
	        visited[start] = true;
	        //when we found and neighbour which is equal to end point inside the recursion, voooleeey! break and return the true
	        for(int nei : graph.get(start)){
	            if(nei == end){
	                found = true;
	                break;
	            }
	            if(!visited[nei])
	                dfs(graph, visited, nei, end); //otherwise deep dig again!
	        }
	    }
	
}
