/**

给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

    所有数字（包括 target）都是正整数。
    解集不能包含重复的组合。 

示例 1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]

示例 2:

输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Set<List<Integer>>> map = new HashMap<>();
        Arrays.sort(candidates);
        for(int i=1; i <= target; i++){
            map.put(i, new HashSet<>());
            for(int j=0; j<candidates.length && candidates[j] <= target; j++){
                if(i == candidates[j]){
                    //此时表示相减为0的情况，直接加入set集合
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i); 
                    map.get(i).add(temp);
                }else if(i > candidates[j]){
                    //i-candidates[j]的值就是key
                    int key = i - candidates[j];
                    //使用迭代器进行遍历
                    for(Iterator iterator=map.get(key).iterator(); iterator.hasNext(); ){
                        List list = (List)iterator.next();
                        List temp = new ArrayList<>();
                        temp.addAll(list);
                        temp.add(candidates[j]);
                        //结果去重
                        Collections.sort(temp);
                        map.get(i).add(temp);
                    }
                }
            } 
        }
        result.addAll(map.get(target));
        return result;
    }
}