package CodingInterview;
public class DeletedCharsPailndromes {
    public static String getDeletedCharactersAndPailndrome(String s){
        String reversed = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i =1; i<=n; i++){
            for(int j= 1; j<=n; j++){
                if(s.charAt(i-1)==reversed.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int longestPalindromeSubstring = dp[n][n];
        int minDeletions = n-longestPalindromeSubstring;
        StringBuilder lps = new StringBuilder();
        int i =n, j = n;
        while(i>0 && j>0){
            if(s.charAt(i-1)==reversed.charAt(j-1)){
                lps.append(s.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
        String palindrome = lps.reverse().toString();
        StringBuilder deletedChars = new StringBuilder();
        int indexOflps = 0;
        for(int k = 0 ; k<s.length(); k++){
            if(indexOflps<palindrome.length() && s.charAt(k)==palindrome.charAt(indexOflps)){
                indexOflps++;
            }
            else{
                deletedChars.append(s.charAt(k));
            }
        }
        return "deleted chars: " + deletedChars.toString() + " palindrome: "+palindrome;
    }

    public static void main(String[] args){
        String input = "utgiekqitzu";
        System.out.println(getDeletedCharactersAndPailndrome(input));
    }
}
