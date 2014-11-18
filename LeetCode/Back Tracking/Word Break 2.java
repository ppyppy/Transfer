//Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
//
//Return all such possible sentences.
//
//For example, given
//s = "catsanddog",
//dict = ["cat", "cats", "and", "sand", "dog"].
//
//A solution is ["cats and dog", "cat sand dog"].

public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> list = new ArrayList<String>();
        if(s==null || s.length()==0)
            return list;
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[len] = true;
        for(int i=len-1; i>=0; i--){
            for(int j=i+1; j<dp.length; j++){
                if(dp[j]==true){
                    String sub = s.substring(i, j);
                    if(dict.contains(sub)){
                        dp[i] = true;
                    }
                }
            }
        }
        helper(s, 0, list, new StringBuffer(), dp, dict);
        return list;
    }
    
    void helper(String s, int index, List<String> list, StringBuffer sb, boolean[] dp, Set<String> dict){
        if(index==s.length()){
            list.add(sb.toString());
            return;
        }
        for(int i=index+1; i<dp.length; i++){
            if(dp[i]==true){
                String sub = s.substring(index, i);
                if(dict.contains(sub)){
                    sb.append(sub);
                    if(i!=dp.length-1)
                        sb.append(" ");
                    helper(s, index+sub.length(), list, sb, dp, dict);
                    sb.setLength(sb.length()-sub.length());
                    if(i!=dp.length-1)
                        sb.setLength(sb.length()-1);
                }
            }
        }
    }
}