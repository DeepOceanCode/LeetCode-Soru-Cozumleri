class Solution {
    fun maxScore(s: String): Int {
        var maxScore = 0
        var totalOnes = s.count { it == '1' }
        var zeros = 0
        for (i in 0 until s.length - 1) {
            if (s[i] == '0') {
                zeros++
            } else {
                totalOnes--
            }
            val currentScore = zeros + totalOnes
            maxScore = maxOf(maxScore, currentScore)
        }
        return maxScore
    }
}
