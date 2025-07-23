package com.example.AlgoCampEcom.config;

import com.example.AlgoCampEcom.gateway.api.FakeStoreCategoryAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetroFitConfig {

    @Value("${FAKE_STORE_BASE_URL}")
    private String fakeStoreBaseUrl;

    @Bean
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl(fakeStoreBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    // creates a bean of type FakeStoreCategoryAPI
    @Bean
    public FakeStoreCategoryAPI fakeStoreCategoryAPI(Retrofit retrofit) {
        return retrofit.create(FakeStoreCategoryAPI.class);
    }
}
