//Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
//
//For example,
//Given:
//s1 = "aabcc",
//s2 = "dbbca",
//
//When s3 = "aadbbcbcac", return true.
//When s3 = "aadbbbaccc", return false.

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3==null && (s1!=null || s2!=null) )
            return false;
        if( s3.length()!=(s1.length()+s2.length()) )
            return false;
        return isInterleave(s1.toCharArray(), 0, s2.toCharArray(), 0, s3.toCharArray(), 0); 
    }
    private boolean isInterleave(char[] chs1, int i1, char[] chs2, int i2, char[] chs3, int i3) {
        if(i1==chs1.length && i2==chs2.length && i3==chs3.length)
            return true;
        if(i1<chs1.length && i2<chs2.length && i3<chs3.length && chs1[i1]==chs3[i3] && chs2[i2]==chs3[i3]){
            return isInterleave(chs1, i1+1, chs2, i2, chs3, i3+1) || isInterleave(chs1, i1, chs2, i2+1, chs3, i3+1);
        }else if(i1<chs1.length && i3<chs3.length && chs1[i1]==chs3[i3]){
            return isInterleave(chs1, i1+1, chs2, i2, chs3, i3+1);
        }else if(i2<chs2.length && i3<chs3.length && chs2[i2]==chs3[i3]){
            return isInterleave(chs1, i1, chs2, i2+1, chs3, i3+1);    
        }else{
            return false;
        }
    }
}

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3==null && (s1!=null || s2!=null) )
            return false;
        if( s3.length()!=(s1.length()+s2.length()) )
            return false;
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        boolean m[][] = new boolean[len1+1][len2+1];
        m[0][0] = true;
        for(int i=1; i<=s1.length(); i++){
            m[i][0] = m[i-1][0] && (s1.charAt(i-1)==s3.charAt(i-1));
        }
        for(int j=1; j<=s2.length(); j++){
            m[0][j] = m[0][j-1] && (s2.charAt(j-1)==s3.charAt(j-1));
        }
        for(int i=1; i<=s1.length(); i++)
            for(int j=1; j<=s2.length(); j++){
                m[i][j] = (m[i-1][j]&&(s1.charAt(i-1)==s3.charAt(i+j-1))) || (m[i][j-1]&&(s2.charAt(j-1)==s3.charAt(i+j-1)));
            }
        return m[len1][len2];
    }
}