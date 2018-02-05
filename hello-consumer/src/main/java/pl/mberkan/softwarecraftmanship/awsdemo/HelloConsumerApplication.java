package pl.mberkan.softwarecraftmanship.awsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class HelloConsumerApplication {
    public static void main(String[] args) {
        System.out.println("HelloConsumerApplication test!");
        SpringApplication.run(HelloConsumerApplication.class, args);
    }
}

@RestController
class HelloWorldConsumerRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/")
    public String serviceInstancesByApplicationName() {
        return "Output from producer: " + this.discoveryClient.getInstances("hello-producer-client")
                .stream()
                .findFirst()
                .map(serviceInstance -> new RestTemplate().getForObject(serviceInstance.getUri().toString(), String.class))
                .orElse("No producer found");
    }
}


@RestController
class HelloWorldConsumerFeinController {

    @Autowired
    private HelloClient helloClient;

    @RequestMapping("/fein")
    public String serviceInstancesByApplicationName() {
        return helloClient.hello().getHello();
    }
}