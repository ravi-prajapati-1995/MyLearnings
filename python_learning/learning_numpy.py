# Numpy is Linear algebra Library for python
import numpy as np

arr = [1, 2, 3, 4] # Normal array
print(arr)

np_arr = np.array(arr)
print(np_arr)

arr_2d = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
print(arr_2d)
print("--------------- 2D Numpy ----------------")
np_2d_arr = np.array(arr_2d)
print(np_2d_arr)

#-----------------------
print(np.arange(0, 10, 2)) # Creating a array for given range first argument is from, to, step
# To generate 1D array in numpy we can use zeros function
print(np.zeros(5))

# To generate 2D matrix we can pass tuple to the zeros function
print(np.zeros((4, 4)))

print(np.ones((2, 3)))

# To get the evenly spaced numbers between any two numbers
print(np.linspace(0, 3, 10)) # It means I want 10, numbers from 0 to 3, evenly spaced
print(np.linspace(1, 10, 10)) # It means I want 10, numbers from 1 to 10, evenly spaced both inclusive

print("-------------------------------")

print(np.eye(5)) # To create a identity matrix with the given rows and column and diagonal element will be 1

print("---------------Creating matrix with random number ---------------- \n")
print(np.random.rand(5)) # Create matrix of random numbers with provided length
print(np.random.rand(5, 6)) # Create matrix of random numbers with provided length

print("--------------------- randn ------------------")
print(np.random.randn(5)) # value can be random between all positive and negative number, can pass row, col to get 2d matrix
print(np.random.randint(-293, 345, 10)) # random int values with low, high, size

arr = np.arange(25) # will create 1D array from 0 to 24
print(arr)
arr = np.random.randint(0, 100, 10)
print(arr)
# print(arr.reshape(5, 5)) #convert 1D array to 2D, but keep in mind 2D must fill the array
print(f"{arr.max()} \t {arr.min()}")
print(f"{arr.argmax()} \t {arr.argmin()}")