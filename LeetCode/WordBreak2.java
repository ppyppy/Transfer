//Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
//
//Return all such possible sentences.
//
//For example, given
//s = "catsanddog",
//dict = ["cat", "cats", "and", "sand", "dog"].
//
//A solution is ["cats and dog", "cat sand dog"].

	    ArrayList<String> wordBreak(String s, HashSet<String> dict){
	    	ArrayList<String> list = new ArrayList<String>();
	    	if(s==null)
	    		return list;
	    	int len = s.length();
	    	boolean[] dp = new boolean[len+1];
	    	dp[len] = true;
	    	for(int i=len-1; i>=0; i--)
	    		for(int j=i+1; j<=len; j++){
	    			String sub = s.substring(i, j);
	    			if( dict.contains(sub) && dp[j]==true )
	    				dp[i] = true;
	    		}
	    	wordBreakHelper(s, new StringBuffer(), list, dict, dp, 0);
	    	return list;
	    }

	    void wordBreakHelper(String s, StringBuffer sb, ArrayList<String> list, HashSet<String> dict, boolean[] dp, int index){
	    	if(index==s.length()){
	    		list.add(sb.toString());
	    		return;
	    	}
	    	for(int i=index+1; i<dp.length; i++){
	    		if(dp[i]==true){
	    			String sub = s.substring(index, i);
	    			if(dict.contains(sub)){
	    				sb.append(sub);
	    				if(i!=s.length())
	    					sb.append(" ");
	    				wordBreakHelper(s, sb, list, dict, dp, i);
	    				sb.setLength(sb.length()-sub.length());
	    				if(i!=s.length())
	    					sb.setLength(sb.length()-1); //delete " "
	    			}
	    		}
	    	}
	    }