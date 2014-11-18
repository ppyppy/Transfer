//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//Note:
//Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
//The solution set must not contain duplicate triplets.
//    For example, given array S = {-1 0 1 2 -1 -4},
//
//    A solution set is:
//    (-1, 0, 1)
//    (-1, -1, 2)

//When only get one solution, use the hashmap solution
	public boolean threeSum(int[] num) {
    	if(num==null || num.length<3)
    		return false;
    	for(int i=0; i<num.length-2; i++){
    		int a = num[i];
    		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    		for(int j=i+1; j<num.length; j++){
    			int b = num[j];
    			if(!map.containsKey(b)){
    				map.put(-b-a, j);
    			}else{
    				return true;
    			}
    		}
    	}
    	return false;
    }
	
	public class Solution {
		  public List<List<Integer>> threeSum(int[] num) {
		        // Start typing your Java solution below
		        // DO NOT write main() function
		        List<List<Integer>> res = new ArrayList<List<Integer>>();
		        if(num.length<3) 
		            return res;
		        
		        Arrays.sort(num);
		        for(int i=0;i<num.length-2;i++){
		            if(i==0 || num[i]>num[i-1]){ //avoid duplicate solutions   
		                int j=i+1, k=num.length-1;
		                while(j<k){ 
		                    if(num[j]+num[k]==-num[i]){
		                        ArrayList<Integer> temp = new ArrayList<Integer>();
		                        temp.add(num[i]);
		                        temp.add(num[j]);
		                        temp.add(num[k]);
		                        res.add(temp);
		                        k--;
		                        j++;
		                        while(k>j && num[k]==num[k+1]) k--;//avoid duplicate solutions 

		                        while(j<k && num[j]==num[j-1]) j++;//avoid duplicate solutions 

		                    }else if(num[j]+num[k]>-num[i]){
		                        k--;
		                    }else{
		                        j++;
		                    }
		                }
		            }
		        }
		        return res;
		    }
		}