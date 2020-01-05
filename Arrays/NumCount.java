/**
给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。

如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。

*/
class NumCount {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            }else{
                map.put(arr[i], 1);
            }
        }
        List<Integer> list = new ArrayList<>();

        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            if(list.contains(e.getValue())){
                return false;
            }else{
                list.add(e.getValue());
            }
        }
        return true;
    }
}