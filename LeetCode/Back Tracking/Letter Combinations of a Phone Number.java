//Given a digit string, return all possible letter combinations that the number could represent.
//
//A mapping of digit to letters (just like on the telephone buttons) is given below.
//
//
//
//Input:Digit string "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        if(digits==null || digits.length()==0){
            ret.add("");
            return ret;
        }
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuffer sb = new StringBuffer();
        letterCombinations(digits.toCharArray(), 0, letters, sb, ret);
        return ret;
    }
    
    private void letterCombinations(char[] chs, int index, String[] letters, StringBuffer sb, List<String> list){
        if(index==chs.length){
            list.add(sb.toString());
            return;
        }
        int n = chs[index]-'2';
        if(n<0 || n>7)
            letterCombinations(chs, index+1, letters, sb, list);
        for(int i=0; i<letters[n].length(); i++){
            sb.append(letters[n].charAt(i));
            letterCombinations(chs, index+1, letters, sb, list);
            sb.setLength(sb.length()-1);
        }
    }
}