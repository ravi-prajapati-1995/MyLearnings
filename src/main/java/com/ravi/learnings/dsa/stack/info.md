# Monotonic Stack
If we have a window in and array and we need to find the min or max in that perticular window in O(n) time complexity.
In that case we will use monotonic stack.
```
Get max array in the k winow
arr = [4, 0, -1, 3, 5, 3, 6, 8], k = 3 // where K is the window size
window:         Max 
4, 0, -1        4
0, -1, 3        3
-1, 3, 5        5
3, 5, 6         6
5, 6, 8         8

To resolve this we will use two loops first loop runs from 0 to n-k second for each window

if we want to do it in o(n) time complexity we will follow steps: 
1. we need a DS where we can add element at one end and remove from other end, dequeue will use
2. we will add elements in the decreasing order biggest element will be at start and smallest at the end
3. If we get a element while adding is greater than all other element then remove all elements

```