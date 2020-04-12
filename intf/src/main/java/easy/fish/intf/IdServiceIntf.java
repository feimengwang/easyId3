package easy.fish.intf;


import easy.fish.vo.Id;

/**
 * @author Java猿
 */
public interface IdServiceIntf {
     /**
      * 生产ID
      * @return
      */
     long genId();

     /**
      * 通过time反解为ID
      * @param time
      * @return
      */
     Id makeId(long time);

     /**
      * 通过Id对象生成id，用于测试，不建议使用
      * @param id
      * @return
      */
     @Deprecated
     long makeId(Id id);
}
