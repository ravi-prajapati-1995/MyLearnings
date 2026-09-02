# Dynamic Programming(DP)
***
Famous quote for the DP:  **Those who cannot remember the past are condemned to repeat it**

### Types Of DP
 - **Memoization:** Top - down approach - **_Solves the problem from the main problem to the base cases_** <br/>
We will store the data in the array of n+1 elements and
   then before calculating the f(n-2) and f(n-1), we will check if we have already calculated f(n) for this, if yes then return
   output otherwise calculate it and store it in dpArray
 - **Tabularization:** Bottom-up approach - **_it solves the problem from the base cases to the main problem_** <br/>
 - In this we will start with the base case i.e in Fibonacci we start with
`dpArray[0] = 0
dp Array[1] = 1`



Q. How we can find out if any given problem is a DP problem: 
    In question you find the below keyword: 
    1. Find the total number of ways
    2. Try all the possible ways--- Recursion will be applied
        a. count
        b. best ways

According to striver if we want to solve any DP problem remember below rules: 
1. Try to represent the problem in terms of index
2. Do all possible stuff on that index and do all the possible  According to the problem statement
3. Sum of all stuff -- if problem says count all ways
    min(of all stuff) -- find min 
    max(of all stuff) -- find max
    

Dynamic Programming:
    
Lets take a recursion example to find the fibonacci series of f(6)

~~~
f(6)
├── f(5)
│   ├── f(4)
│   │   ├── f(3)
│   │   │   ├── f(2)
│   │   │   │   ├── f(1) = 1
│   │   │   │   └── f(0) = 0
│   │   │   └── f(1) = 1
│   │   └── f(2)
│   │       ├── f(1) = 1
│   │       └── f(0) = 0
│   └── f(3)
│       ├── f(2)
│       │   ├── f(1) = 1
│       │   └── f(0) = 0
│       └── f(1) = 1
└── f(4)
    ├── f(3)
    │   ├── f(2)
    │   │   ├── f(1) = 1
    │   │   └── f(0) = 0
    │   └── f(1) = 1
    └── f(2)
        ├── f(1) = 1
        └── f(0) = 0
~~~

So in fibonacci:<br/>
f(6)  = f(5) + f(4)</br>
f(5)  = f(4) + f(3)</br>
f(4) = f(3) + f(2)

So in this process we are computing f(4) 2 times, f(3)-- 3 times and f(2) 4 times, which is inefficient so to solve
this problem we can store the pre-calculated values and use when we need
So we will have an dpArray with n+1 size and in that array for each number we put the value if we have calculated

So in DP we will save the calculated value so that we can use that in near future