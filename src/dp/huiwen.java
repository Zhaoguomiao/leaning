package dp;

public class huiwen {
    /**
     * 这是一个 二维的  dp数组，其含义是 从  i 到 j 的中间的这一段距离 钟大哥字串是否为 回文
     * 是一个巨大的 空间换时间 的方法，将所有 字串都囊括再进
     */
    public static String longest(String string){
        if(string==null|| string.isEmpty()){
            return "";
        }
        int n=string.length();
        boolean[][] dp=new boolean[n][n];
        int maxLen=1;
        int start=0;
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        for(int i=0;i<n-1;i++){
            if(string.charAt(i)==string.charAt(i+1)){
                dp[i][i+1]=true;
                start=i;
                maxLen=2;
            }
        }
        //接下来检查的都是 长度大于 3的子字符串
        for(int len=3;len<=n;len++){
            for(int i=0;i<n-len;i++){
                int j=i+len-1;
                if(string.charAt(i)==string.charAt(j)&&dp[i+1][j-1]){
                    dp[i][j]=true;
                    if(len>maxLen){
                        start=i;
                        maxLen=len;
                    }
                }
            }
        }
        return string.substring(start,start+maxLen);//返回 字串
    }
}
