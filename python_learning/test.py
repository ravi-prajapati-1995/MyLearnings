i = 1 / 2.5
print(i)

j = 2 ** 4  # 2 raise to power 4
print(f"2 raise to power 4 is: {j}")

k = 2 + 3 * 5 + 5
print(k)

print("my name is {name} and my age is: {age}, and my name: {name}".format(name='Ravi', age=30))
print("My daughter's name is {} and my age is: {}".format('Kavya', 2))

s = 'hello'
print(s[0])

t = "Kavya Devi"
# K  a  v  y  a     D  e  v  i
# 0  1  2  3  4  5  6  7  8  9

print(t[0:])  # Here [0:] tells that grab everything start from the zero so it print whole name
print(t[4:])  # Here [4:] tells that grab everything start from index 4 so it print [space] Devi

print(t[:4])  # In string slicing last index is not included here :4 so it will pring Kavy

'''
string[start : end : step]
start → index to begin (inclusive)
end → index to stop (exclusive)
step → jump size (direction + speed)
'''

print(t[0::2])  # Meaning print all the string by skipping one char it will print kvadv

print('------------------------Python List------------------------------------')

list = [1, 2, 3, 4, 'a']
print(list)
list.append("b")

print(list[0:3])  # Works same as string slicing

list[0] = "updated"  # Update index 0

print(list)

nest = [1, 2, 3, ['a', 'b', 'c']]  # Nested list
print(nest[3][0])

print('------------------------Python Dict------------------------------------')

d1 = {'key1': 'value1', 'key2': 'value2', 'key3': 123, 'k4': [1, 2, 3]}
print(d1)
print(d1['key3'])

d2 = {'key1': {'k1': 'v1', 'k2': [1, 3, 4], 'k3': 'hello world'}}
print(d2)

# tuple and list has only one difference we can't change value in tuple as we can list

l1 = [1, 2, 3]
t1 = (1, 2, 3)
print(l1)
print(t1)
# l1[0] = 'new' # we can't call t1[0] = 'new it will gave error'
print(l1)

print('------------------------Python Sets------------------------------------')
s1 = {1, 2, 3, 4, 4}  # will store only unique elements and we can't update the elements like tuple
print(s1)
s1.add(5)
print(s1)

print('------------------------Python Logical operators------------------------------------')
print(1 == 1)
print('hi' == 'bye')
print('hi' != 'bye')

print(1 < 2 or 3 > 4)
print(1 < 2 and 3 > 4)


print('------------------------Python Conditional statements------------------------------------')
if 1 < 2:
    print("1 is less than 2")

if 1 == 2:
    print("one is equals to 2")
elif  3 == 3:
    print("yess i did it")
else:
    print("not equal")