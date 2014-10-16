// You have a stack of n boxes, with widths w., heights l\ and depths dr The boxes
//cannot be rotated and can only be stacked on top of one another if each box in the
//stack is strictly larger than the box above it in width, height, and depth. Implement
//a method to build the tallest stack possible, where the heigh t of a stack is the sum of
//the heights of each box.

ArrayList<Box> createStackDP(Box[] boxes, Box bottom, HashMap<Box, ArrayList<Box>> hashmap){
	if( bottom!=null && hashmap.contains(bottom))
		return hashmap.get(bottom);
	int max_height = 0;
	ArrayList<Box> max_list = null;
	for(int i=0; i<boxes.length; i++){
		if( canbeBottom([boxes[i]], bottom) ){ //boxes[i] can be bottom of bottom
			ArrayList<Box> new_list = createStackDP(boxes, boxes[i], hashmap);
			int height = getHeight(new_list);
			if(height>max_height){
				max_height = height;
				max_list = new_list;
			}
		}
	}
	if(max_list==null)
		max_list = new ArrayList<Box>();
	if(bottom!=null)
		max_list.add(bottom);
	hashmap.put(bottom, max_list);
	return (ArrayList<Box>) max_list.clone();
}

//call function: createStackDP(boxes, null, new Map<Box, List<Box>>());