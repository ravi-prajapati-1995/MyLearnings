package com.ravi.learnings.dsa.stack.monotonic_stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/asteroid-collision/description/">Problem Link</a>
 * We are given an array asteroids of integers representing asteroids in a row. The indices of the asteroid in the array
 * represent their relative position in space.
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right,
 * negative meaning left). Each asteroid moves at the same speed.
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
 * If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 *
 * */
public class AsteroidCollision {

    public static void main(String[] args) {
        int arr[] = {10,2,-5};
        System.out.println(Arrays.toString(asteroidCollisionStriverWay(arr)));
    }

    public static int[] asteroidCollisionStriverWay(int[] asteroids) {
        final var list = new LinkedList<Integer>();
        for(int i: asteroids) {
            if(i < 0) {

                // So we will keep removing element from the stack till we are getting smaller number than i
                while (!list.isEmpty() && list.getLast() > 0 && list.getLast() < Math.abs(i)) {
                    list.removeLast();
                }

                
                // So after above loop we will either get the empty list or the top element is not less that the i
                if(!list.isEmpty() && list.getLast() == Math.abs(i) ) {
                    list.removeLast();
                } else if(list.isEmpty() || list.getLast() < 0) {
                    list.add(i);
                }

            } else {
                list.add(i);
            }
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
    /**
     * Do to this we will maintain a stack
     * If we have positive Number then keep adding that in stack
     * Once got negative number we can either
     *  remove top in case it is small
     *  Remove Negative number if that is small
     *  remove both in case they are equal
     * In case stack is empty and got negative directly add that number in the stack as that will move in left direction
     * and there is no astroid for which it will collide
     * */
    public static int[] asteroidCollision(int[] asteroids) {
        final var integers = new ArrayList<Integer>();
        final var st = new Stack<Integer>();

        for(int i: asteroids) {
            if(i < 0) {
                 i = i * -1;
                 boolean isEqual = false;
                while (!st.isEmpty()) {
                    final var peek = st.peek();
                    if (peek > i) {
                        break;
                    } else if (peek < i) { // 3,5,-6,2,-1,4}
                        st.pop();
                    } else {
                        st.pop();
                        isEqual = true;
                        break;
                    }
                }

                if(st.isEmpty() && !isEqual) {
                    integers.add(i*-1);
                }

            } else {
                st.push(i);
            }
        }

        // if there are not element to collide
        int idx = 0;
        while (idx < st.size()) {
            integers.addLast(st.get(idx++));
        }

        return integers.stream().mapToInt(Integer::valueOf).toArray();    
    }
}
