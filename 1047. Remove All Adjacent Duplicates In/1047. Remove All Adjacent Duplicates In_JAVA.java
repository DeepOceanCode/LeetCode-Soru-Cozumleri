
class Node{
    char character;
    int count;

    Node(char character, int count){
        this.character = character;
        this.count = count;
    }
}
class Solution {
    public String removeDuplicates(String s) {
        Stack<Node> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(!stack.empty() && stack.peek().character == c){
                if(++stack.peek().count % 2 == 0){
                    stack.pop();
                }
            }else{
                stack.push(new Node(c, 1));
            }
        }

        StringBuilder builder = new StringBuilder();
        while(!stack.empty()){
            Node node = stack.pop();
            for(int i = 0; i<node.count; i++){
                builder.append(node.character);
            }
        }
        return builder.reverse().toString();
    }
}