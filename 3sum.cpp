class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        set<vector<int>> resultSet;
        vector<vector<int>> result;
        
        sort(nums.begin(), nums.end());
        
        for (int i=0; i<(signed int)nums.size()-2; i++) {
            
            if (i == 0 || nums[i] > nums[i-1]) {
                int low = i + 1;
                int high = nums.size() - 1;
                
                while (low < high) {
                    int sum = nums[i] + nums[low] + nums[high];
                    if (sum == 0) {
                        vector<int> v = {nums[i], nums[low], nums[high]};
                        resultSet.insert(v);
                        low++;
                        high--;
                    }
                    else if (sum < 0) {
                        low++;
                    }
                    else {
                        high--;
                    }
                }
            }
        }
        
        for (auto v : resultSet)
            result.push_back(v);
        
        return result;
        
    }
};