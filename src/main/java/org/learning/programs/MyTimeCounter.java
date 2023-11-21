package org.learning.programs;

import java.util.concurrent.TimeUnit;

public class MyTimeCounter {
    private long startTime = 0;
    private long lapStartTime;
    final private TimeUnit requestedTimeUnit;

    private MyTimeCounter(TimeUnit timeUnit) {
        this.requestedTimeUnit = timeUnit;
    }

    private void start() {
        startTime = System.currentTimeMillis();
    }

    public void lapStart() {
        lapStartTime = System.currentTimeMillis();
    }

    public long lapEnd() {
        if(lapStartTime == 0)
            throw new RuntimeException("Lap Timer not yet started");
        long currentTime = System.currentTimeMillis();
        long lapTime = currentTime - lapStartTime;
        lapStartTime = 0;
        return requestedTimeUnit.convert(lapTime, TimeUnit.MILLISECONDS);
    }

    public long elapsedTime() {
        if(startTime == 0)
            throw new RuntimeException("Timer not yet started");
        long totalTime = System.currentTimeMillis() - startTime;
        return requestedTimeUnit.convert(totalTime, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) throws Exception {
        MyTimeCounter lapCounter = new MyTimeCounter(TimeUnit.MILLISECONDS);
        lapCounter.start();
        Thread.sleep(1000);
        Thread.sleep(1000);
        Thread.sleep(1000);
        System.out.println(String.format("ElapsedTime=%s", lapCounter.elapsedTime()));
        for (int i = 0; i < 5; i++) {
            lapCounter.lapStart();
            Thread.sleep(1000);
            Thread.sleep(1000);
            System.out.println(String.format("LapTime=%s, ElapsedTime=%s", lapCounter.lapEnd(), lapCounter.elapsedTime()));
        }
        System.out.println(String.format("ElapsedTime=%s", lapCounter.elapsedTime()));
    }
}
