package easy.fish.converter;


import easy.fish.impl.IdMetaData;
import easy.fish.vo.Id;

/**
 * @author junbo
 */
public class IdConverter {
    /**
     * 把Id转成long型数字
     * @param id
     * @param idMetaData
     * @return
     */
    public long convertTime(Id id, IdMetaData idMetaData) {
        long time = 0L;
        time |= id.getSequence();
        time |= id.getMachineId() << idMetaData.getMachineShift();
        time |= id.getTime() << idMetaData.getTimeShift();
        time |= id.getVersion() << idMetaData.getVersionShift();
        return time;
    }

    /**
     * 通过long型数字转成ID对象
     * @param time
     * @param idMetaData
     * @return
     */
    public Id convertId(long time, IdMetaData idMetaData){
        Id id = new Id();
        id.setSequence(time & idMetaData.getSequenceMask());
        id.setMachineId((time>>>idMetaData.getMachineShift()) & idMetaData.getMachineMask());
        id.setTime((time>>>idMetaData.getTimeShift()) & idMetaData.getTimeMask());
        id.setVersion((time>>>idMetaData.getVersionShift()) & idMetaData.getVersionMask());
        return id;
    }

}
