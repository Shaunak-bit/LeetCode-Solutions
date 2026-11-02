class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> list = new ArrayList<>();
        backtrack(0,new ArrayList<>(),nums,list);
        return list;
    }public static void backtrack(int start ,ArrayList<Integer> cur,int []nums,List<List<Integer>>list){
        list.add(new ArrayList<>(cur));

        for(int i = start;i<nums.length;i++){
        cur.add(nums[i]);
        backtrack(i+1,cur,nums,list);
        cur.remove(cur.size()-1);
        }
        
    }
}