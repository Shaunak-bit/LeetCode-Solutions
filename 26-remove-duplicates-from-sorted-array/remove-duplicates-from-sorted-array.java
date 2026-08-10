class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet <Integer> set = new HashSet<>();
        ArrayList <Integer>list = new ArrayList<>();

        for(int i = 0;i<nums.length;i++){
            int num = nums[i];
            if(!set.contains(num)){
                set.add(num);
                list.add(num);
            }
        }

        for(int i = 0;i<list.size();i++){
            nums[i] = list.get(i);
        }
        return list.size() ;
    }
}