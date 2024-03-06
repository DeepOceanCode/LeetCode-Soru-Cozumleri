class Solution {
    public int maxScore(String s) {
        int theBiggest = 0;
        int totalOnes = 0;
        int len = s.length();

        for(int i = 0; i<len; i++){
           if(s.charAt(i) == '1'){
               totalOnes++;
           }
        }

        int tmpOnes = totalOnes;
        int zeros = 0;

        for(int j = 0; j<len-1; j++){
            if(s.charAt(j) == '0'){
                zeros++;
            }else{
                tmpOnes--;
            }
            if(zeros+tmpOnes > theBiggest){
                theBiggest = zeros+tmpOnes;
            }
        }
        return theBiggest;
    }
}

class Solution {
    public int maxScore(String s) {
        int theBiggest = 0;
        int totalOnes = 0;
        int len = s.length();
        char [] characters = s.toCharArray();
        for(int i = 0; i<len; i++){
           if(characters[i] == '1'){
               totalOnes++;
           }
        }

        int tmpOnes = totalOnes;
        int zeros = 0;

        for(int j = 0; j<len-1; j++){
            if(characters[j] == '0'){
                zeros++;
            }else{
                tmpOnes--;
            }
            if(zeros+tmpOnes > theBiggest){
                theBiggest = zeros+tmpOnes;
            }
        }
        return theBiggest;
    }
}