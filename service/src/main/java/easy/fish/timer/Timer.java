package easy.fish.timer;

import easy.fish.exception.TimeException;


/**
 * @author Java猿
 */
public class Timer {
    /**
     * 2019-01-01截止的毫秒数
     */
    private long epoch = 1546272000000L;

    /**
     * 获取毫秒
     * @return
     */
    public long genTime() {
        return System.currentTimeMillis() - epoch;
    }

    /**
     * 校验现在时间和上次时间
     * @param time
     * @param lastTime
     */
    public void validTime(long time, long lastTime) {
        if (time < lastTime) {
            throw new TimeException("当前时间小于上次时间");
        }
    }

    /**
     * 获取下一个毫秒
     * @param lastTime
     * @return
     */
    public long nextTime(long lastTime) {
        long currentTime = genTime();
        while (true) {
            if (currentTime > lastTime) {
                return currentTime;
            }
            currentTime = genTime();
        }
    }
}
