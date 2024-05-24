class Solution(object):
    """
    Idea is to have a dictionary where the {key,value} pairing is 
    """
    def twoSum(self, nums, target):
        # empty dictionary
        dic = {}

        # populate dictionary with entries of
        for i in range(len(nums)):
            dic[nums[i]] = i

        for i in range(len(nums)):
            opp = target - nums[i]
            if (opp in dic) and dic[opp] != i:
                return [i, dic[opp]]