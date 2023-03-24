class StreamChecker:
    def __init__(self, words: List[str]):
        self.TrieNode = TrieNode()
        self.stream = []
        for word in words:
            self.TrieNode.insert(word)

    def query(self, letter: str) -> bool:
        self.stream.append(letter)
        return self.TrieNode.search(self.stream[-200:])


class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.ifEnd = False
    
    def insert(self, word: str):
        node = self
        for char in word[::-1]:
            index = ord(char)-ord('a')
            if node.children[index] is None:
                node.children[index] = TrieNode()
            node = node.children[index]
        node.ifEnd = True
    
    def search(self, words: List[str]) -> bool:
        node = self
        for char in words[::-1]:
            index = ord(char)-ord('a')
            if node.children[index] is None:
                return False
            node = node.children[index]
            if node.ifEnd:
                return True
        return False

# Your StreamChecker object will be instantiated and called as such:
# obj = StreamChecker(words)
# param_1 = obj.query(letter)