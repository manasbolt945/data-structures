class Solution {
    public String longestPalindrome(String s) 
    {
        if(s.length()==0)
            return "";
        if(s.length()==1)
            return s;
        int start=0;
        int low;
        int high;
        int maxl=1;
        for(int i=1; i<s.length(); i++)
        {
            low=i-1;
            high=i;
            while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high))
                  {
                      if(maxl<high-low+1)
                      {
                          start=low;
                          maxl=high-low+1;
                      }
                      --low;
                      ++high;
                  }
            low=i-1;
            high=i+1;
            while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high))
            {
                if(maxl<high-low+1)
                {
                    start=low;
                    maxl=high-low+1;
                }
                --low;
                ++high;
            }
    
        }
        return s.substring(start,start+maxl);
    }
}
