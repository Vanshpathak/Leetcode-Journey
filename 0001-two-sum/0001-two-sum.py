class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        # Hash map to store the value and its corresponding index
        seen = {}
        
        for index, num in enumerate(nums):
            complement = target - num
            
            # Check if the required complement is already in our map
            if complement in seen:
                return [seen[complement], index]
            
            # Otherwise, add the current number and index to the map
            seen[num] = index