package easy.fish.impl.enums;

import easy.fish.impl.IdMetaData;

/**
 * @author Java猿
 */
public enum IdMetaDataEnum {
    DEFAULT_ID_METADATA() {
        @Override
        public IdMetaData getIdMetaData() {
            return new IdMetaData(1, 10, 41, 12);
        }
    };

    public abstract IdMetaData getIdMetaData();
}
