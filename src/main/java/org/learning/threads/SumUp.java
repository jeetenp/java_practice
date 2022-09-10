package org.learning.threads;

public class SumUp {

    long startRange;
    long endRange;
    long counter = 0;
    static long MAX_VALUE = Integer.MAX_VALUE;

    public SumUp(long startRange, long endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }

    public void add(){
        for (long i = startRange; i <= endRange; i++) {
            counter += i;
        }
    }

    public static void oneThread(){
        long start = System.currentTimeMillis();
        SumUp s = new SumUp(1, Integer.MAX_VALUE);
        s.add();
        long end = System.currentTimeMillis();
        System.out.println("One Thread 1-"+Integer.MAX_VALUE+" : Sum - " + s.counter + " : Time - " + (end-start) + "milliseconds");
    }

    public static void twoThread() throws InterruptedException {
        long start = System.currentTimeMillis();
        SumUp s1 = new SumUp(1, MAX_VALUE / 2);
        SumUp s2 = new SumUp((1 + MAX_VALUE/2), MAX_VALUE);

        Thread t1 = new Thread(()->{ s1.add(); });
        Thread t2 = new Thread(()->{ s2.add(); });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        long counter = s1.counter + s2.counter;
        long end = System.currentTimeMillis();
        System.out.println("1-" + MAX_VALUE / 2 + " : Sum - " + s1.counter);
        System.out.println((1 + MAX_VALUE/2) + "-" + MAX_VALUE + " : Sum - " + s2.counter);
        System.out.println("Two Thread : Sum - " + counter + " : Time - " + (end-start) + "milliseconds");
    }

    public static long getThread(long sRange, long eRange) throws InterruptedException {
        SumUp s = new SumUp(sRange, eRange);
        Thread t = new Thread(()->{ s.add(); });
        t.start();
        t.join();
        return s.counter;
    }

    public static void nThread(int threads) throws InterruptedException {
        long start = System.currentTimeMillis();
        long sRange = 0;
        long eRange = 0;
        long split_range = Integer.MAX_VALUE / threads;
        long fCount = 0;
        for (int i = 0; i < threads; i++) {
            sRange = eRange + 1;
            eRange = sRange + split_range;
            if(eRange > Integer.MAX_VALUE) {
                eRange = Integer.MAX_VALUE;
            }
            long count = getThread(sRange, eRange);
            fCount = fCount + count;
            System.out.println(sRange + "-" + eRange + " : Sum - " + count);
        }
        long end = System.currentTimeMillis();
        System.out.println(threads + " Threads : Sum - " + fCount + " : Time - " + (end-start) + "milliseconds");
    }

    public static void main(String[] args) throws InterruptedException {
        oneThread();
        twoThread();
        nThread(1);
        nThread(2);
        nThread(3);
        nThread(4);
        nThread(5);
        nThread(6);
    }
}
