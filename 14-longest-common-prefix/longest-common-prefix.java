import java.util.*;
class Solution{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strs= new String[n];

        for(int i =0;i<n;i++){
            strs[i] = sc.next();
        }
        System.out.println(longestCommonPrefix(strs));
    }public static String longestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0) return "";

        String firstWord = strs[0];

        for(int i = 0;i<firstWord.length();i++){
            char ch = firstWord.charAt(i);
            for(int j = 1;j<strs.length;j++){
                if(i== strs[j].length()|| strs[j].charAt(i)!=ch){
                    return firstWord.substring(0,i);
                }
            }
        }
        return firstWord;
    }
}