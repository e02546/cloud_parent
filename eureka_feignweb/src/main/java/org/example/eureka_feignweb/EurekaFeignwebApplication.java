package org.example.eureka_feignweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@Controller
public class EurekaFeignwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaFeignwebApplication.class, args);
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("index1")
    @ResponseBody
    public List<ServiceInstance> getRegister(){
        return  discoveryClient.getInstances("eureka-client");
    }
}
