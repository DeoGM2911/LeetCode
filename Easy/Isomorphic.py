class Solution(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        #* This problem is similar to Word Pattern (easy) problem.
        s_t_map = {}
        seen = {}
        for i in range(len(s)):
            if s[i] in s_t_map:
                if t[i] != s_t_map[s[i]]:
                    return False
            else:
                if t[i] in seen:
                    return False
                s_t_map[s[i]] = t[i]
                seen[t[i]] = None
        return True