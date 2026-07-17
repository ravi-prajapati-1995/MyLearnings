import numpy as np

arr = np.arange(0, 10)
print(arr)
print(arr[0:4]) # Print element from index 0 to 4 , 0 is inclusive and 4 is exclusive
print(arr[4:]) # element from 4th tll the last element
print(arr[:4]) # from 0 to 4th index exclusive

slice_arr = arr[1:4] # this will not copy the array just keep the reference of array
print(slice_arr)
slice_arr[:] = 100 # when we update all the elements here it will reflect in the original array
print(arr)

arr = np.arange(0, 10)
copy_arr = arr[0:4].copy()  # it will create a copy of array
print(copy_arr)
copy_arr[:] = 111
print(copy_arr)
print(arr)

print("===================================================")
randint = np.arange(5, 50, 5)
print(randint)
arr_2d = randint.reshape(3, 3)
print(arr_2d)
print(arr_2d[1][1]) # To get the 1st row and 1st col
print(arr_2d[1, 1]) # we can use comma
print(arr_2d[1:,1:]) # this will return from 1st row to last row and from 1 colum to last column

print("======================= Condition based selection ==========================")
rang = np.arange(1, 10)
bool_arr = rang > 5 # it will create the boolean array
print(bool_arr)
print(rang[bool_arr]) # will return all the element where value is true
print(arr[arr > 5]) # sortcut to filter the element in one go, all the element greater than 5
print(arr[arr < 3]) # all the element less than three


