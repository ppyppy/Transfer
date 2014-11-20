//
//
//题目以前见过，就是给一些不重叠的interval，然后设计一个数据结构来存储，实现 插入interval和 find一个value 两个函数，
//前者碰到重叠就return false，后者碰到所在的interval返回。
//
//
//这个我记得就是用BST做的。
//
//有一个bug，就是插入的时候给空指针 n = new Node(c),这么做了，被指出了，还是基
//础不扎实啊，可能以前都是链表或者用递归做的，就从来没发现这个问题。应该说明下
//还可以用递归做的。
//
//中间讨论了一下维护min和max变量是否必要，我说主要是在val超出范围的时候直接判断，他说那其实interval中间也有空当。
//我就说那就只有两端的时候，会比较有用，而且我这个办法维护min和max每次都要做一次，应该有更好的。对average case是没有用的。
//
//最后问了下time cost，就是O(lgn)和o(n)，分别对应average和worst，他说怎么保证balanced，就说就可以了，我说可以用红黑树或者AVL，
//或者先找中位数插入（后来一想应该是先排序）
//
//用sorted array行不行，与BST比较优缺点（前者没overhead，但是无法动态插入和删除）。似乎他还挺满意。
//
//让我问问题之后就欢快的结束了。
//
//
//
//[192, 320) [384, 512) [512, 640) [1024, 1152) // 128
//
//// Fixed size, non-overlap
//
class Interval {
  /* feel free to add or modify */
public:
  int start;
  int end;
};

class Store{
 /* feel free to add or modify */
public:
 bool insert(const Interval *c);
 const Interval * find(int val);
};

class Node{

public:
	const Interval intv;
	Node *left;
	Node *right;
    
	Node(const Interval *c):intv(c->start,c->end){
    	left = right = NULL;
	}
    
}
    
class Store{

public:
	Node *root;
	int minv;
	int maxv;
    
	Store(){
    	root = NULL;
    	minv = numeric_limit<int>::max();
    	maxv = numeric_limit<int>::min();
	}
    
	bool insert(const Interval *c){
    	if(!root){
        	root = new Node(c);
        	minv = c->start;
        	maxv = c->end -1;
        	return true;
    	}
   	 
    	int start = c->start;
    	int end = c->end;
   	 
    	Node *n = root;
    	Node *parent = NULL;
   	 
    	while(n!= NULL){
       	 
        	parent = n;
       	 
        	if( start >= n->intv->end)
            	n = n->right;
        	else if( end <= n->intv->start )
            	n = n->left;
        	else
            	return false;
    	}
   	 
	//一开始这里没用parent，直接写n = new Node(c)，被指出错误了，其实就是空指针没法去新建一个东西，还是基础不扎实就出现这种错误。应该不用parent的，不过他说没问题。

    	if( start >= parent->intv->end)
        	parent->right = new Node(c);
    	else if( end <= parent->intv->start )
        	parent->left = new Node(c);
   	 
    	maxv = max(n->end -1,maxv);
    	minv = min(n->start,minv);
    	 
    	return true;
	}
    
	Interval  find(int val){
   	 
    	if( val < minv || val > maxv)
        	return Interval(-1,-1);
   	 
    	Node *n = root;
   	 
    	while( n!= NULL){
        	if( val >= n->start && val < n->end)
            	return n->intv;
        	else if ( val < n->start )
            	n = n->left;
        	else if( val >= n->end )
            	n = n->right;
    	}
   	 
    	return Interval(-1,-1); // maybe not necessary;
   	 
 	}
}
    
    
    