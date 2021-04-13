package A1.Recursion;

public class GroupSumClump {

    public boolean groupSumClump(int start, int[] nums, int target) {
        if(start >= nums.length)
            return target == 0;

        int i = start;
        int sum = 0;

        while(i < nums.length && nums[start] == nums[i]) {
            sum += nums[i];
            i++;
        }

        if(groupSumClump(i, nums, target - sum))
            return true;

        if(groupSumClump(i, nums, target))
            return true;

        return false;
    }
    public static void main(String[] args){
        GroupSumClump obj = new GroupSumClump();
        System.out.println(obj.groupSumClump(0, new int[]{2, 4, 8}, 12));
        System.out.println(obj.groupSumClump(0, new int[]{1, 2, 4, 8, 1}, 14));
        System.out.println(obj.groupSumClump(0, new int[]{2, 4, 4, 8}, 14));
    }
}
