class Solution:
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        res = 0
        resi = dividend
        while dividend > divisor:
            dividend -= divisor
            res += 1
        return res

#print(Solution().divide(7,-3))
class Person():
    def __init__(self, name = 'Random Person'):
        self.name  = name

    def __str__(self):
        return 'A Person'

class Student(Person):
    def __init__(self, name = 'Random Student', student_id = 0):
        self.student_id = student_id

new_student = Student()
try:
    print(new_student.name)
except:
    print("Exception")
print(new_student)
