boolean IsRotation(String s1, String s2){
	if(s1==null || s2==null)
		return false;
	int len = s1.length();
	if(len==s2.length() && len>0){
		String str = s1+s1;
		return str.contains(s2);
	}
	return false;
}