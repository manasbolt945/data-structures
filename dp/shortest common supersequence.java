class Solution {
    public String shortestCommonSupersequence(String str1, String str2) 
    {
        int m = str1.length();
        int n = str2.length();
        int t[][] = new int[m+1][n+1];
        for(int i=1; i<=m; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    t[i][j] = 1+t[i-1][j-1];
                else
                    t[i][j]= Math.max(t[i-1][j],t[i][j-1]);
            }
        }
        String str="";
        int i=m,j=n;
        while(i>0 && j>0)
        {
            if(str1.charAt(i-1)==str2.charAt(j-1))
            {
                str+=str1.charAt(i-1);
                i--;
                j--;
            }
            else
            {
                if(t[i][j-1]>t[i-1][j])
                {
                    str+=str2.charAt(j-1);
                    j--;
                    
                }
                else
                {
                    str+=str1.charAt(i-1);
                    i--;
                }
            }
        }
        while(i>0)
        {
            str+=str1.charAt(i-1);
            i--;
        }
        while(j>0)
        {
            str+=str2.charAt(j-1);
            j--;
        }
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();
       
    }
}
