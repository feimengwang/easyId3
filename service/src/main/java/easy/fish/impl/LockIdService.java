package easy.fish.impl;

import easy.fish.provider.IdGenerateProvider;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Java猿
 */
public class LockIdService extends IdService {
    Lock lock = new ReentrantLock();

    public LockIdService(IdGenerateProvider idGenerateProvider) {
        super(idGenerateProvider);
    }

    public LockIdService() {
    }

    @Override
    public long genId() {
        long id;
        try {
            lock.tryLock();
            id = super.genId();
        } finally {
            lock.unlock();
        }

        return id;
    }
}
