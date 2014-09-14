
///////////////////////////////
//start                 ///////
/////   ///////////////////////
//////                    /////
////////////  /////////////////
/////                    //////
////////////  /////////////////
///////////                ////
//////////////////////     ////
//////////////////////    end//
///////////////////////////////

//Maze Path

boolean MazePath(Position start, Position end){
	Stack s;
	Position curPos = start;
	step=0;  //caculate how many stepes need;
	do{
		if(isCanPass(curPos)){ //if can pass the position
			footPrint(curPos); //make tag to the position already passed
			s.push(curPos);
			if(curPos==end)  //hit end
				return true;
			curPos = nextPos(curPos, 1); //step east
		}else{
			if(!s.isEmpty()){
				Position p = s.pop();
				while(p.direction==4&&!s.isEmpty()){
					markPrint(p);
					p = s.pop();
				}
				if(p.direction<4){
					p.direction++;
					s.push(p);
					curPos(nextPos(p, p,direction));
				}
			}
		}
	}while(!s.isEmpty())
	return false;
}