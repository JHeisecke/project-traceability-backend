package com.github.pol.una.traceability.web.response;

import java.util.Locale;

public class HeartBeatResponseDTO extends BaseResponseDTO {


    public HeartBeatResponseDTO() {
        super();
    }

    public HeartBeatResponseDTO(HeartBeatBuilder builder) {
        super(builder);
    }

    public static HeartBeatBuilder builder() {
        return new HeartBeatBuilder();
    }

    public static class HeartBeatBuilder extends Builder<HeartBeatBuilder> {

        protected HeartBeatBuilder() {
            super(HeartBeatBuilder.class);
        }

        public HeartBeatResponseDTO build() {
            return new HeartBeatResponseDTO(this);
        }
    }
}
