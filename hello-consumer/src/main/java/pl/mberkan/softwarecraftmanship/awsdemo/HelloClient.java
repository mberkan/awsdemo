package pl.mberkan.softwarecraftmanship.awsdemo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "hello-producer-client", fallback = HelloClient.HelloClientFallBack.class)
public interface HelloClient {
    @GetMapping("/")
    Hello hello();

    @Component
    class HelloClientFallBack implements HelloClient {
        @Override
        public Hello hello() {
            return new Hello("Error: not working!");
        }
    }
}
