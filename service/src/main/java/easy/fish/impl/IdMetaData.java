package easy.fish.impl;

/**
 * @author Java猿
 */
public class IdMetaData {
    private int version;
    private int machine;
    private int time;
    private int sequence;

    public IdMetaData(int version, int machine, int time, int sequence) {
        this.version = version;
        this.machine = machine;
        this.time = time;
        this.sequence = sequence;
    }


    public int getMachine() {
        return machine;
    }

    public void setMachine(int machine) {
        this.machine = machine;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getMachineShift() {
        return sequence;
    }

    public int getTimeShift() {
        return sequence + machine;
    }

    public int getVersionShift() {
        return sequence + machine + time;
    }

    public long getSequenceMask() {
        return -1L ^ -1L << sequence;
    }


    public long getMachineMask() {
        return -1L ^ -1L << machine;
    }

    public long getTimeMask() {
        return -1L ^ -1L << time;
    }

    public long getVersionMask() {
        return -1L ^ -1L << version;
    }

}
