//Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
//
//Only one letter can be changed at a time
//Each intermediate word must exist in the dictionary
//For example,
//
//Given:
//start = "hit"
//end = "cog"
//dict = ["hot","dot","dog","lot","log"]
//Return
//  [
//    ["hit","hot","dot","dog","cog"],
//    ["hit","hot","lot","log","cog"]
//  ]
//Note:
//All words have the same length.
//All words contain only lowercase alphabetic characters.

public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		if(start==null || end==null || start.length()!=end.length()){
			return null;
		}
		List<List<String>> lists = new ArrayList<List<String>>();
		Queue<String> Q = new LinkedList<String>();
		HashMap<String, ArrayList<String>> backMap = new HashMap<String, ArrayList<String>>();
		backMap.put(end, new ArrayList<String>());  
		backMap.put(start, new ArrayList<String>());
        for (String s : dict) {  
        	backMap.put(s, new ArrayList<String>());  
        }
		ArrayList<String> currentlevel = new ArrayList<String>();
		Q.add(start);
		while(!Q.isEmpty()){
	        currentlevel.clear();  
	        while(!Q.isEmpty()) { 
	            String top = Q.poll();
	            if (dict.contains(top)) 
	            	dict.remove(top);  
	            currentlevel.add(top);
	        }
	      for(String w : currentlevel){
			for(String v : getOneEditedWords(w, dict)){
				if(v.equals(end)){
					backMap.get(v).add(w);
				}else if(dict.contains(v)){
					backMap.get(v).add(w);
				}
				if(!Q.contains(v))
					Q.add(v);
			}
	      }
		  if(Q.contains(end))
				break;
		}
		ArrayList<String> tmparray = new ArrayList<String>();
		tmparray.add(end);
		buildpath(start, end, backMap, tmparray, lists);
		return lists;
	}
    
    public void buildpath(String start, String end,  
            HashMap<String, ArrayList<String>> map, ArrayList<String> tmparray,  
            List<List<String>> res) {  
        ArrayList<String> pre = map.get(end);
        if(pre==null)
        	return;
        if (end.equals(start)) {
            ArrayList<String> tmparray2 = new ArrayList<String>(tmparray);
            Collections.reverse(tmparray2);
            res.add(tmparray2);  
            return;  
        }
        for (String s: pre) { 
            tmparray.add(s);
            buildpath(start, s, map, tmparray, res);
            tmparray.remove(tmparray.size() - 1);
        }
    }
	
    public ArrayList<String> getOneEditedWords(String searchWord, Set<String> dict){
        ArrayList<String> rets = new ArrayList<String>();
        for(int ii=0; ii<searchWord.length(); ii++){
            for(char ch='a'; ch<='z'; ch++){
                if(searchWord.charAt(ii)!=ch){
                    char[] ss = searchWord.toCharArray();
                    ss[ii] = ch;
                    String word = new String(ss);
                    if(dict.contains(word))
                    	rets.add(word);
                }
            }
        }
        return rets;
    }
}