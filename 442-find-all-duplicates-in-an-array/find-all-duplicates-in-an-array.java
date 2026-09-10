class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0;i<nums.length;i++){
            int num = nums[i];

            if(map.containsKey(num)){
                list.add(num);
            }else{
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }
        return list;
    }
}