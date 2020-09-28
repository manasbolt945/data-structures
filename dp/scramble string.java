class Solution {
    HashMap<String, Boolean> hm = new HashMap();
    public boolean isScramble(String s1, String s2) 
    {
        if(s1.length()!=s2.length())return false;
        if(s1.length()==0 || s2.length()==0)return false;
        if(s1.equals(s2)) return true;
        if(s1.length()<=1 || s2.length()<=1) return false;
        String temp = s1+" "+s2;
        if(hm.containsKey(temp))
            return hm.get(temp);
        boolean flag=false;
        int n = s1.length();
        for(int i=1; i<s1.length(); i++)
        {
            if((isScramble(s1.substring(0,i), s2.substring(n-i,n)) && isScramble(s1.substring(i,n),s2.substring(0,n-i))) || (isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i,n),s2.substring(i,n))))
            {
                flag=true;
                break;
            }
                
                
                
        }
        hm.put(temp,flag);
        return flag;
    }
}
