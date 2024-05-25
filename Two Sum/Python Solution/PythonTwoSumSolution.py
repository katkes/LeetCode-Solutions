class Solution(object):
    """
    Approach: The idea is to have a dictionary where the {key, value} pairing is:
                    -- key: the value of the array nums at an index i
                    -- value: the index i
              This is done as to have a map to consult if there exists a compliment of a
              given number in the list. If it does, the index of the number and the
              compliment are returned in a list.

    Time complexity: Theta(n) --> The code is guaranteed to iterate through the list twice,
                     making it O(2n) and Theta(2n), which simplifies to O(n) and Theta(n)
                     and Theta(n) as a result

    Space complexity: Theta(n) --> The dictionary is guaranteed to be filled, making it a base of
                      O(n)/Theta(n), having one variable defined adds a constant of 1 each time,
                      making it O(2n)/Theta(2n), which simplifies to O(n) and Theta(n) and
                      Theta(n) as a result
    """
    def twoSum(self, nums, target):
        # empty dictionary
        dic = {}

        # populate dictionary with entries of
        for i in range(len(nums)):
            dic[nums[i]] = i

        for i in range(len(nums)):
            opp = target - nums[i] # Initialization of the compliment
            if (opp in dic) and dic[opp] != i:
                return [i, dic[opp]]
