package easy.fish.vo;

import java.io.Serializable;

/**
 * @author Java猿
 */
public class Id implements Serializable {
    private static final long serialVersionUID = 6870261236218491181L;

    /**
     * 版本号，未使用，最高位的符号位0
     */
    private long version;
    /**
     * 时间戳，从2019/01/01计算
     */
    private long time;
    /**
     * 10位机器码
     */
    private long machineId;
    /**
     * 序列号
     */
    private long sequence;

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getMachineId() {
        return machineId;
    }

    public void setMachineId(long machineId) {
        this.machineId = machineId;
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "Id{" +
                "version=" + version +
                ", time=" + time +
                ", machineId=" + machineId +
                ", sequence=" + sequence +
                '}';
    }
}
