data class Node(val character: Char, var count: Int = 1)

class Solution {
    fun removeDuplicates(s: String, k: Int): String {
        val stack = Stack<Node>()
        for(c in s.toCharArray()){
            if(!stack.empty() && stack.peek().character == c){
                if(++stack.peek().count == k){
                    stack.pop();
                }
            }else {
                stack.push(Node(c, 1))
            }
        }
        val builder = StringBuilder()
        while(!stack.empty()){
            val node = stack.pop()
            for(j in 0 until node.count){
                builder.append(node.character)
            }
        }
        return builder.reverse().toString()
    }
}
