package com.shanjiancaofu.userclient.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class UserRibbonhystrixCommand extends HystrixCommand<List> {


    private final String providerServiceName;
    private final RestTemplate restTemplate;

    public UserRibbonhystrixCommand(String providerServiceName, RestTemplate restTemplate) {
        super(HystrixCommandGroupKey.Factory.asKey("User-ribbon-Client"), 100);
        this.restTemplate = restTemplate;
        this.providerServiceName = providerServiceName;
    }

    @Override
    protected List run() throws Exception {
        return restTemplate.getForObject("http://" + providerServiceName + "/user/list", List.class);
    }
}
