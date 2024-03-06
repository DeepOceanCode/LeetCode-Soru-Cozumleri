class Solution(object):
    def maxScore(self, s):
        theBiggest = 0
        totalOnes = s.count('1')
        zeros = 0
        for j in range(0, len(s)-1):
            if s[j] == '0':
                zeros += 1
            else:
                totalOnes -= 1
            result = totalOnes+zeros
            if result > theBiggest:
                theBiggest = result
        return theBiggest
        