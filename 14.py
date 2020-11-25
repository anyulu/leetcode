class Solution:
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        l = len(strs)
        if l == 0:
            return ''
        elif l == 1:
            return strs[0]

        std = strs[0]
        if_null = 1
        cut = 1
        if_end = 0
        while cut <= len(std)+1:
            for s in strs:
                if s[:cut] != std[:cut]:
                    if_end = 1
            if if_end == 1:
                return std[:cut-1]
            else:
                cut += 1
        return std[:cut-1]