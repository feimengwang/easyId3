package easy.fish.config;

import easy.fish.impl.LockIdService;
import easy.fish.intf.IdServiceIntf;
import easy.fish.provider.ConfigIdGenerateProvider;
import easy.fish.provider.IdGenerateProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Java猿
 */
@Configuration
public class EasyIdConfiguration {

    @Bean
    public IdGenerateProvider idGenerateProvider() {
        return new ConfigIdGenerateProvider();
    }

    @Bean
    public IdServiceIntf idService(IdGenerateProvider idGenerateProvider) {
        return new LockIdService(idGenerateProvider);
    }
}
