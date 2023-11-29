class Solution {
    
    List<List<Integer>> answer = new ArrayList<>();
    int length;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        length = candidates.length;
        combination(candidates, target, new LinkedList<>(), 0);
        
        return answer;
    }
    
    private void combination(int[] candidates, int target, LinkedList<Integer> comb, int idx){
        if(target < 0) return;
        
        if(target == 0){
            answer.add(new ArrayList<>(comb));
            return;
        }
        
        if(idx >= length) return;
        
        comb.add(candidates[idx]);
        combination(candidates, target - candidates[idx], comb, idx);
        
        comb.pollLast();
        combination(candidates, target, comb, idx + 1);
    }
}