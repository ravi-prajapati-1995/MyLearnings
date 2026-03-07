'''
seq = [1, 2, 3, 4, 5]
for num in seq:
    print(f' Hello: {num}')
'''

i = 1;
while i < 5:
    print(f"while loop : {i}")
    i = i + 1

ra = range(2, 5)  # range function will generate the number from 0 to 4, 5 is not include
print(list(ra))

for num in ra:
    print(num)

print("------------------------------------------------")
x = [1, 2, 3, 4, 5]
out = []
for num in x:
    out.append(num ** 2)  # It will square every number and store it in out

print(out)


# Above operation can be done python in single line called list comperhansive

def using_list_comp(parm):
    print([a ** 2 for a in parm])  # Give me the a square for the a


using_list_comp(x)


# Here name is having default value ravi if we don't pass it it will take ravi
def my_func(name='ravi'):
    print(f"hello world: {name}")


# my_func('kavya')

def square_num(num):
    """
    This is function with multple lines
    This is documentation string
    :param num:
    :return:
    """
    return num ** 2


print(square_num(3))
seq = [1, 2, 3, 4, 5]
res = map(square_num, seq)
print(list(res))

# In map we can gave function as lambda function i.e
res = map(lambda x: x ** 3, seq)
print(list(res))

# Filter function to filter out the elements
res = filter(lambda x: x % 2 == 0, seq) #Filter out the element which fall under the condition in our case even numbers
print(list(res))

print("------------------------------------------------------")
#tuple unpacking
tup = [(1, 2), (3, 4), ('a', 'b')]
for x, y in tup:
    print(f'{x} and {y}')
