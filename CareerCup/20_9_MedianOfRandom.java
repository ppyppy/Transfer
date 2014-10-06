	void addRandmon(int val){
	    if(maxHeap.size()==minHeap.size()){
	        if(val>minHeap.peek()){
	        	maxHeap.add(minHeap.pop());
	        	minHeap.add(val);
	        }else{
	        	maxHeap.add(val);
	        }
	    }else{
	        if(val<maxHeap.peek()){
	        	minHeap.add(maxHeap.pop());
	        	maxHeap.add(val);
	        }else{
	        	minHeap.add(val);
	        }
	    }
	}