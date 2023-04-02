class Solution:
    def maskPII(self, s: str) -> str:
        index = s.find('@')
        if index == -1:
            s = "".join(i for i in s if i.isdigit())
            return ["", "+*-", "+**-", "+***-"][len(s) - 10] + "***-***-" + s[-4:]
        return (s[0] + "*" * 5 + s[index - 1:]).lower()
        