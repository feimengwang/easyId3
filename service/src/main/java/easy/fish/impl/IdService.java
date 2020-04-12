package easy.fish.impl;

import easy.fish.intf.IdServiceIntf;
import easy.fish.provider.IdGenerateProvider;
import easy.fish.vo.Id;

/**
 * @author Java猿
 */
public abstract class IdService implements IdServiceIntf {
    IdGenerateProvider idGenerateProvider;

    public IdService(IdGenerateProvider idGenerateProvider) {
        this.idGenerateProvider = idGenerateProvider;
    }

    public IdService() {

    }

    @Override
    public long genId() {
        return idGenerateProvider.genId();
    }

    @Override
    public Id makeId(long time) {
        return idGenerateProvider.convertId(time);
    }

    @Override
    @Deprecated
    public long makeId(Id id) {
        return idGenerateProvider.convertTime(id);
    }


    public IdGenerateProvider getIdGenerateProvider() {
        return idGenerateProvider;
    }

    public void setIdGenerateProvider(IdGenerateProvider idGenerateProvider) {
        this.idGenerateProvider = idGenerateProvider;
    }
}
