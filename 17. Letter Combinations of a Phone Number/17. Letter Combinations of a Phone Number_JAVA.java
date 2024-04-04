class Solution {
    private static final String[][] KEYPAD = {
            { "a", "b", "c" }, { "d", "e", "f" }, { "g", "h", "i" }, { "j", "k", "l" },
            { "m", "n", "o" }, { "p", "q", "r", "s" }, { "t", "u", "v" }, { "w", "x", "y", "z" }
    };

    public List<String> letterCombinations(String digits) {
       List<String> list = new ArrayList<>();
       if(digits.isEmpty()){
            return list;
       }

       list.add("");

       for(char digit : digits.toCharArray()){
        List<String> temp = new ArrayList<>();
        int num = Character.getNumericValue(digit) - 2;
        for(String combo : list){
            for(String letter : KEYPAD[num]){
                temp.add(combo + letter);
            }
        }
        list = temp;
       }
       return list;
    }
}