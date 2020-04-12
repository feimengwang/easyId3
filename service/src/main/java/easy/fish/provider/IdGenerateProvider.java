package easy.fish.provider;

import easy.fish.vo.Id;

/**
 * @author Java
 */
public interface IdGenerateProvider {
    /**
     * @return
     */
    public long genId();

    /**
     * @param time
     * @return
     */
    Id convertId(long time);

    /**
     * @param id
     * @return
     */
    long convertTime(Id id);

}
