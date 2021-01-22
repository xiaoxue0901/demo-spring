package com.fall.aop;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xql132@zcsmart.com
 * @date 2021/1/22
 * @time 16:40
 * @description
 */
public class TrackCounter {

    private Map<Integer, Integer> trackCounts = new HashMap<>();

    @Pointcut("execution(* soundsystem.CompactDisc.playTrack(int))  && args(trackNumber)")
    public void trackPlayed(int trackNumber) {
    }


    /**
     * 在播放前, 为磁道计数
     * @param trackNumber
     */
    @Before("trackPlayed{trackNumber}")
    public void countTrack(int trackNumber) {
        int currentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber) {
        return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackNumber) : 0;
    }
}
