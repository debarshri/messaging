package org.hsrinara.demo;

import org.HdrHistogram.Histogram;

public class HistogramMain {
    public static void main(String[] args) {
        final Histogram histogram = new Histogram(1);
        histogram.recordValue(10);
        histogram.recordValue(1);
        histogram.recordValue(1);
        histogram.recordValue(1000);
        histogram.recordValue(1024);
        System.out.println("histogram.getTotalCount() = " + histogram.getTotalCount());
        System.out.println("histogram.getMaxValue() = " + histogram.getMaxValue());
        System.out.println("histogram.getMinValue() = " + histogram.getMinValue());
        System.out.println("histogram.getMean() = " + histogram.getMean());
        System.out.println("histogram.getLowestDiscernibleValue() = " + histogram.getLowestDiscernibleValue());
        System.out.println("histogram.getStartTimeStamp() = " + histogram.getStartTimeStamp());
        System.out.println("histogram.getEndTimeStamp() = " + histogram.getEndTimeStamp());
        System.out.println("histogram.getStdDeviation() = " + histogram.getStdDeviation());
        System.out.println("histogram.getValueAtPercentile() = " + histogram.getValueAtPercentile(99.99));
    }
}
