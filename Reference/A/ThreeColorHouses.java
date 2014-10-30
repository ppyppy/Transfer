//There are a row of houses, each house can be painted with three colors red, blue and green. 
//The cost of painting each house with a certain color is different. 
//You have to paint all the houses such that no two adjacent houses have the same color. 
//You have to paint the houses with minimum cost. How would you do it? 

//You maintain three arrays R[1..n], B[1..n], G[1..n].
//
//Where R[i] is the minimum cost of painting houses 1,2,3...,i such that i is colored Red.
//
//Similary B is min cost of painting 1,2,...,i with i being colored Blue, and G is with i being colored Green.
//
//You can compute R[i+1] = (Cost of painting house i+1 Red) + minimum {G[i], B[i]}.
//
//Similarly B[i+1] and G[i+1] can be computed.
//
//Ultimately you take the minimum of R[n], B[n] and G[n].
//
//This is O(n) time and O(n) space.



int minPaintCost(int[] rc, int[] bc, int[] gc){
	if(rc==null || bc==null || gc==null)
		return 0;
	int n = rc.length;
	int[] r = new int[n];
	int[] b = new int[n];
	int[] g = new int[n];
	r[0] = rc[0];
	b[0] = bc[0];
	g[0] = gc[0];
	for(int i=1; i<n; i++){
		r[i] = rc[i] + Math.min(b[i-1], g[i-1]);
		b[i] = bc[i] + Math.min(r[i-1], g[i-1]);
		g[i] = gc[i] + Math.min(r[i-1], b[i-1]);
	}
	return Math.min(Math.min(r[n-1], b[n-1]), g[n-1]);
}