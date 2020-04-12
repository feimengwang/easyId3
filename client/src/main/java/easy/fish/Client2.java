package easy.fish;

import easy.fish.impl.LockIdService;
import easy.fish.intf.IdServiceIntf;
import easy.fish.provider.ConfigIdGenerateProvider;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Java猿
 */
public class Client2 {
    public static void main(String[] args) {
        new Client2().startTest();
    }

    private void startTest() {
        final IdServiceIntf idService = new LockIdService(new ConfigIdGenerateProvider());
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        long longId = idService.genId();
                        print(idService, longId);
                    }
                }
            });

        }
        executorService.shutdown();
    }

    private void print(IdServiceIntf idService, long id) {
        System.out.println("生成的Id:" + id);
        System.out.println("生成的Id对象:" + idService.makeId(id));
    }
}
