//Robot sitting on the left upper conner of an m*n grid, only move right and down.

///////////////////////////////
//start                 ///////
/////   ///////////////////////
//////                    /////
////////////  /////////////////
/////                    //////
////////////  /////////////////
///		                   ////
//////  //////////////     ////
///	       ///////////    end//
///////////////////////////////

//1. how many possible paths for the robot?
From (m-1)+(n-1) steps, find n-1 steps to move right: (m+n-2)!/((n-1)!*(m-1)!)

//2. print all possible paths
ArrayList<Point> path = new ArrayList<Point>();
void getAllPaths(int x, int y){
	Point p = new Point(x, y);
	path.add(p); //update path
	if(x==0&&y==0){
		for(Point obj : path)
			System.out.print(obj.x + "-" + obj.y + ", ");
		System.out.println();
	}
	if(x>=1 && isFree(x-1,y))
		getAllPaths(x-1, y);
	if(y>=1 && isFree(x, y-1))
		getAllPaths(x, y-1);
	path.remove(p);//update path
}