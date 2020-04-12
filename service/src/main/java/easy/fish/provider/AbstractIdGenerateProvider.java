package easy.fish.provider;

import easy.fish.converter.IdConverter;
import easy.fish.impl.IdMetaData;
import easy.fish.impl.enums.IdMetaDataEnum;
import easy.fish.timer.Timer;
import easy.fish.vo.Id;


/**
 * @author Java猿
 */
public abstract class AbstractIdGenerateProvider implements IdGenerateProvider {
    private Timer timer = new Timer();
    private long lastTime = -1L;
    private long sequence = -1L;
    IdConverter idConverter = new IdConverter();

    IdMetaData idMetaData = IdMetaDataEnum.DEFAULT_ID_METADATA.getIdMetaData();
    private long version =0L;

    @Override
    public long genId() {
        Id id = new Id();
        id.setVersion(version);
        id.setMachineId(getMachineId());
        id = generate(id);
        long ret = idConverter.convertTime(id, idMetaData);
        return ret;
    }

    @Override
    public Id convertId(long time) {
        return idConverter.convertId(time,idMetaData);
    }

    @Override
    public long convertTime(Id id) {
        return idConverter.convertTime(id, idMetaData);
    }

    private Id generate(Id id) {
        long time = timer.genTime();
        timer.validTime(time, lastTime);
        if (time == lastTime) {
            sequence++;
            sequence &= idMetaData.getSequenceMask();
            if (sequence == 0) {
                time = timer.nextTime(time);
            }
        } else {
            sequence = 0L;
            lastTime = time;
        }
        id.setTime(time);
        id.setSequence(sequence);
        return id;
    }

    /**
     * 获取机器Id
     *
     * @return
     */
    protected abstract long getMachineId();

    public IdMetaData getIdMetaData() {
        return idMetaData;
    }

    public void setIdMetaData(IdMetaData idMetaData) {
        this.idMetaData = idMetaData;
    }

    public IdConverter getIdConverter() {
        return idConverter;
    }

    public void setIdConverter(IdConverter idConverter) {
        this.idConverter = idConverter;
    }
}
