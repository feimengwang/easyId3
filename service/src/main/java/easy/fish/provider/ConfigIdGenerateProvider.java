package easy.fish.provider;

import easy.fish.utils.PropertiesUtil;

/**
 * @author Java猿
 */
public class ConfigIdGenerateProvider extends AbstractIdGenerateProvider {
    private String machineKey = "easyid.machineid";
    @Override
    protected long getMachineId() {
        String machineId = System.getProperty(machineKey);
        if(null == machineId ||"".equals(machineId)){
            machineId = PropertiesUtil.readString(machineKey);
        }
        return Long.parseLong(machineId);
    }
}
