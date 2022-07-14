package com.ricoliang.coindesk_api.convert;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

public class JavaScriptMessageConverter extends AbstractJackson2HttpMessageConverter {


    protected JavaScriptMessageConverter(ObjectMapper objectMapper) {
        super(objectMapper);
    }

    protected JavaScriptMessageConverter(ObjectMapper objectMapper, MediaType supportedMediaType) {
        super(objectMapper, supportedMediaType);
    }

    protected JavaScriptMessageConverter(ObjectMapper objectMapper, MediaType... supportedMediaTypes) {
        super(objectMapper, supportedMediaTypes);
    }

    public JavaScriptMessageConverter() {
        super(Jackson2ObjectMapperBuilder.json().build(),new MediaType("application","javascript"));
    }
}
