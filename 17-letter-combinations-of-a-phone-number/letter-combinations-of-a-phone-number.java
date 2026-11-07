class Solution {
    private static final String[] Mapping={
       "",     // 0
    "",     // 1
    "abc",  // 2
    "def",  // 3
    "ghi",  // 4
    "jkl",  // 5
    "mno",  // 6
    "pqrs", // 7
    "tuv",  // 8
    "wxyz"
    };
    public List<String> letterCombinations(String digits) {

        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        helper(digits,0,sb,list,Mapping);
        return list;
    }public static void helper(String digits,int i ,StringBuilder sb,List<String> list,String[]mapping){
        if(sb.length()== digits.length()){
            list.add(sb.toString());
            return;
        }
        char ch = digits.charAt(i);
        int num = ch-'0';
        String letter = mapping[num];
        
        for(int j=0;j<letter.length();j++){
            sb.append(letter.charAt(j));
            helper(digits,i+1,sb,list,Mapping);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}