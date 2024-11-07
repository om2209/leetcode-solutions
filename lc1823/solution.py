class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        persons = [(i+1) for i in range(n)]
        index = 0
        k -= 1
        while len(persons) != 1:
            index = (index + k) % len(persons)
            persons.pop(index)
        
        return persons[0]