package com.xingray.collection;

/**
 * Description : 范围
 *
 * @author : leixing
 * <p>
 * @date : 2018/6/23
 * Email       : leixing@baidu.com
 * Version     : 0.0.1
 */
public class Range {
    private int from;
    private int to;

    public Range(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "\"Range\": {"
                + "\"from\": \"" + from
                + ", \"to\": \"" + to
                + '}';
    }
}
