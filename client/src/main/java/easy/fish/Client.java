package easy.fish;

import easy.fish.impl.LockIdService;
import easy.fish.intf.IdServiceIntf;
import easy.fish.provider.ConfigIdGenerateProvider;
import easy.fish.vo.Id;

/**
 * @author Java猿
 */
public class Client {
    public static void main(String[] args) {
        IdServiceIntf idService = new LockIdService(new ConfigIdGenerateProvider());

        long longId = idService.genId();
        System.out.println("生成的Id:"+longId);
        Id id = idService.makeId(longId);
        System.out.println("生成的Id对象:"+id);
        System.out.println("从Id对象反解成id:"+idService.makeId(id));
    }
}

