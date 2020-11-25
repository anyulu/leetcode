class Solution:
    def countAndSay(self, n: int) -> str:
        res = '1'
        for i in range(n-1):
            new_char = res[0]
            temp_res = ''
            count = 0
            for char in res:
                if new_char == char: count += 1
                else:
                    temp_res += (str(count) + new_char)
                    new_char = char
                    count = 1
            res = temp_res + str(count) + char
        return res
