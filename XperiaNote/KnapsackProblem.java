//0 1 knapSack problem

//Recursive
int F(int n, int v){
	if(v > c[n]) //the capacity now is v, c[n] is the currenty item
		A[n][v] = F(n-1, v-c[n]) + w[n]; //get c[n]
	B[n][v] = F(n-1, v); //not get the n item
	return A[n][v]>B[n][v] ? A[n][v] : B[n][v];
}

//non Recursive, iterative
//Input:
//Values (stored in array v)
//Weights (stored in array w)
//Number of distinct items (n)
//Knapsack capacity (W)
for j from 0 to W do
	m[0, j] := 0
end for 
for i from 1 to n do
	for j from 0 to W do
		if w[i] <= j then
			m[i, j] := max(m[i-1, j], m[i-1, j-w[i]] + v[i])
		else
			m[i, j] := m[i-1, j]
	    end if
	end for
end for