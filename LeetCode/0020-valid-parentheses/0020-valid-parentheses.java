class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for (char c : s.toCharArray()){
            //If the current character is an opening bracket, push it
            if(c == '(' ||  c== '{' || c == '['){
                st.push(c);
            } else {
                // If the stack is empty, it's false
                if(st.isEmpty()){
                    return false;
                }
                
                // If the current character closing bracket matches the top
                if((c == ')' && st.peek() != '(') || 
                   (c == '}' && st.peek() != '{') ||
                   (c == ']' && st.peek() != '[')) {
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }
}