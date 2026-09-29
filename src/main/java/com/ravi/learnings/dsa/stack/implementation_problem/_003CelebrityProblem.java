package com.ravi.learnings.dsa.stack.implementation_problem;

import java.util.Arrays;

/**
 * A celebrity is a person who is known by everyone else at the party but does not know anyone in return.
 * Given a square matrix M of size N x N where M[i][j] is 1 if person i knows person j, and 0 otherwise,
 * determine if there is a celebrity at the party. Return the index of the celebrity or -1 if no such person exists.
 * Note that M[i][i] is always 0.
 * <p>
 * Input: M = [ [0, 1, 1, 0], [0, 0, 0, 0], [1, 1, 0, 0], [0, 1, 1, 0] ]
 * Output: 1
 * Explanation: Person 1 does not know anyone and is known by persons 0, 2, and 3. Therefore, person 1 is the celebrity.
 *
 */
public class _003CelebrityProblem {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 1, 0}
        };


//        celebrity(arr);
        celebrityOptimal(arr);
    }

    /**
    * 1. We created two arrays 1 is for a person knows how manay people in party(personKnows)
     * 2. 2nd a person known by how many people at party(personKnownBy)
     * 3. We created a loop for each row and fill the rows in personKnows and personKnownBy
     * 4. Then after calculating we run a loop on personKnows, check if current person knows anyone, if he don't know
     *    anyone
     * 5. Then check if he knows by all the remaining persons
    * */
    public static int celebrity(int[][] M) {
        final var length = M.length;
        final var personKnows = new int[length];
        final var personKnownBy = new int[length];
        for (int i = 0; i < length; i++) {
            fillKnowns(i, M[i], personKnows, personKnownBy);
        }

        System.out.println(Arrays.toString(personKnownBy));
        System.out.println(Arrays.toString(personKnows));
        for(int i = 0; i< personKnows.length; i++) {
            if(personKnows[i] == 0 && personKnownBy[i] == length - 1) {
                return i;
            }
        }

        return -1;
    }

    private static void fillKnowns(
            final int currIdx,
            final int[] ints,
            final int[] personKnows,
            final int[] personKnownBy
    ) {
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 1) {
                personKnows[currIdx]++;
                personKnownBy[i]++;
            }
        }
    }

    /**
     * 1. We will use the two pointer approach first point to the first row and 2nd point to last row
     * 2. Check if arr[top][bottom] top knows bottom, if yes then top can't be celebrity, increase top by 1
     * 3. if not then check arr[bottom][top], mean bottom knows the top, if yes then bottom can't be celebrity decrease bottom
     * 3. If both don't knows each other then no one can't be the celebrity, to be celebrity atleast one should knows other
     *     then do top++ and bottom--
     * 4. after doing this, check if we moved after bottom, if yes then return -1
     * 5. If we found some celebrity candidate, then we need to check he should know no one, and everyone else should know
     *     him
     *  6. If this condition satisfy then return the top
     * @param M
     * @return
     */
    public static int celebrityOptimal(int[][] M) {
        final var length = M.length;
        int top = 0;
        int bottom = length - 1;


        while (top < bottom) {

            if(M[top][bottom] == 1) {
                top++;
            } else if(M[bottom][top] == 1) {
                bottom--;
            } else { // if they don't know each other, they both can't be celebrity
                top ++;
                bottom--;
            }

        }

        if(top > bottom) {
            return -1;
        }

        for(int i = 0; i< length; i++) {
            if(top == i) {
                continue;
            }
            if(M[top][i] == 0 && M[i][top] == 1) {

            } else {
                return -1;
            }
        }
        System.out.println(top +"\t" + bottom);
        return top;
    }
}
