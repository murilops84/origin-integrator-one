package br.com.mps.config.feign;

import feign.Client;
import feign.Logger;
import feign.Retryer;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;

public class FeignConfig {

    private OkHttpClient okHttpClient;

    @Bean
    public Client client() {
        if (okHttpClient == null) {
            this.okHttpClient = new OkHttpClient();
        }
        return this.okHttpClient;
    }

    @Bean
    public Retryer retryer() {
        return Retryer.NEVER_RETRY;
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Decoder feignDecoder() {
        return new FeignDecoder();
    }

    @Bean
    public ErrorDecoder feignErrorDecoder() {
        return new FeignErrorDecoder();
    }
}
