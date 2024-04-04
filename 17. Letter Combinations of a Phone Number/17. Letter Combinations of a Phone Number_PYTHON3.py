class Solution:
    KEYPAD = [
    ["a", "b", "c"], ["d", "e", "f"], ["g", "h", "i"], ["j", "k", "l"],
    ["m", "n", "o"], ["p", "q", "r", "s"], ["t", "u", "v"], ["w", "x", "y", "z"]
    ]
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []
        
        result = [""]

        for digit in digits:
            temp = []
            num = int(digit) - 2
            for combo in result :
                for letter in self.KEYPAD[num]:
                    temp.append(combo+letter)
            result = temp
        return result
