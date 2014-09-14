
boolean TopologicalSort(Graph G){
	if(G==null)
		return;
	FindInDegree(G, indegree);
	Stack<Integer> s;
	for(int i=0; i<G.num; i++)
		if(indegree[i]==0)
			s.push(i);
	int count = 0;
	while(!s.isEmpty()){
		int index = s.pop();
		visit(G.vertices[i]);
		count++;
		for(Vertice v=G.vertices[index]; v!=null; v=v.nextVertice){
			int k = v.get();
			if(!(--indegree[k]))
				s.push(k);
		}
	}
	if(count<G.num)
		return false;
	return true;
}