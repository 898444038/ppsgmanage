package com.ming.ppsg.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IndexController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 获取所有服务
     */
    @RequestMapping("/services")
    public Object services() {
        return discoveryClient.getInstances("ppsg-server");
    }

    /**
     * 从所有服务中选择一个服务（默认轮询）
     */
    @RequestMapping("/discover")
    public Object discover() {
        return loadBalancerClient.choose("ppsg-server").getUri().toString();
    }

    /**
     * 均衡负载
     * @return
     */
    @RequestMapping("/call")
    public String call() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("ppsg-server");
        System.out.println("服务地址：" + serviceInstance.getUri());
        System.out.println("服务名称：" + serviceInstance.getServiceId());

        String callServiceResult = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/hello", String.class);
        System.out.println(callServiceResult);
        return callServiceResult;
    }

    @RequestMapping("/ribbon/call")
    public String call2() {
        // 调用服务, service-producer为注册的服务名称，LoadBalancerInterceptor会拦截调用并根据服务名找到对应的服务
        String callServiceResult = restTemplate.getForObject("http://ppsg-server/hello", String.class);
        System.out.println(callServiceResult);
        return callServiceResult;
    }
}
