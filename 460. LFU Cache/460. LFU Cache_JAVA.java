class Node{
    char character;
    int count = 0;

    Node(char character, int count){
        this.character = character;
        this.count = count;
    }
}
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Node> stack = new Stack<Node>();
        for(var c : s.toCharArray()){
            if(!stack.empty() && stack.peek().character == c){
                if(++stack.peek().count == k){
                    stack.pop();
                }
            }else {
                stack.push(new Node(c, 1));
            }
        }

        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()){
            Node node = stack.pop();
            char character = node.character;
            int count = node.count;

            for(int i = 0; i<count; i++)
                builder.append(character);
        }
        return builder.reverse().toString();
    }
}