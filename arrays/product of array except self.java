class Solution {
    public int[] productExceptSelf(int[] nums)
    {
        if (nums.length <= 0)
            return nums;

        int[] prod = new int[nums.length];
        Arrays.fill(prod,1);

        int tmp = 1;
        for (int i = 0 ; i < prod.length; i++){
            prod[i] = tmp;
            tmp = tmp * nums[i];
        }

        tmp = 1;
        for (int i = nums.length-1 ; i >= 0; i--){
            prod[i] *= tmp;
            tmp = tmp * nums[i];
        }

        return prod;
    }
}
