class Solution:
    def longestValidParentheses(self, s: str) -> int:
        maximum = 0
        open = 0
        close = 0
        for i in range(0, len(s)):
            if s[i] == "(":
                open += 1
            else:
                close += 1
            if open == close:
                maximum = max(maximum, 2 * close)
            elif close > open:
                open = 0
                close = 0
        open = 0
        close = 0
        for j in range(len(s) - 1, 0, -1):
            if s[j] == "(":
                open += 1
            else:
                close += 1
            if open == close:
                maximum = max(maximum, 2 * close)
            elif open > close:
                open = 0
                close = 0
        return maximum