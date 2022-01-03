package org.learning.javapractice.dynamicprogramming;

public class ClimbingStairs {
    static long counter = 0;
    public static void main(String[] args) {
        ClimbingStairs service = new ClimbingStairs();
        int noOfSteps = 50;

        counter = 0;
        long startTime = System.currentTimeMillis();
        long ways = service.helper(0, noOfSteps);
        long endTime = System.currentTimeMillis();
        System.out.println("First Method : No of times recursive function called : " + counter);
        System.out.println(String.format("Time Taken %s - %s = %s", endTime, startTime, (endTime-startTime)));
        System.out.println("No of Steps : " + ways);
        counter = 0;
        int store[] = new int[noOfSteps + 1];
        startTime = System.currentTimeMillis();
        ways = service.helper_d(0, noOfSteps, store);
        endTime = System.currentTimeMillis();
        System.out.println("First Method : No of times recursive function called : " + counter);
        System.out.println(String.format("Time Taken %s - %s = %s", endTime, startTime, (endTime-startTime)));
        System.out.println("No of Steps : " + ways);
    }

    public long helper(long start, long noOfSteps){
        counter++;
        if ( start == noOfSteps)
            return 1;
        if ( start > noOfSteps)
            return 0;
        return helper(start+1, noOfSteps) + helper(start+2, noOfSteps);
    }

    public int helper_d(int start, int noOfSteps, int store[]){
        counter++;
        if ( start == noOfSteps)
            return 1;
        if ( start > noOfSteps)
            return 0;
        if(store[start] > 0 )
            return store[start];
        store[start] = helper_d(start+1, noOfSteps, store) + helper_d(start+2, noOfSteps, store);
        return store[start];
    }

}
