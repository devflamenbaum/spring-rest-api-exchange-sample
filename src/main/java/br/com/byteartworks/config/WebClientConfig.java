package br.com.byteartworks.config;

import br.com.byteartworks.service.PostService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {

    private static final String JSON_HOLDER_URL = "https://jsonplaceholder.typicode.com/";

    @Bean
    public PostService HttpServiceProxyFactory(){
        WebClient webClient = WebClient.builder().baseUrl(JSON_HOLDER_URL).build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient))
                .build();

        return factory.createClient(PostService.class);
    }
}
