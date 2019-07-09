package com.shanjiancaofu.userserver.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

//    @Autowired
//    private RabbitTemplate rabbitTemplate;

    // 使用点对点的方式 direct, 会匹配 routekey 绑定的quene
    // fanout:指定将消息发给指定exchanger. 该exchanger将消息分发给绑定在其上的所有的queue。
    // topic 正则式匹配所有的  routekey.
    // Exchange 可以绑定routekey，也可以绑定quene
   /* @GetMapping("/pushOrderForDirect")
    public Object pushOrderForDirect(String name, Long id) {
        Order order = new Order();
        order.setId(id);
        order.setName(name);
        rabbitTemplate.convertAndSend("exchange.direct", "helloworld", order);
        return order;
    }

    @GetMapping("/pushOrderForFanout")
    public Object pushOrderForFanout(String name, Long id) {
        Order order = new Order();
        order.setId(id);
        order.setName(name); // 不用制定key ，会发送到exchange 绑定的所有的quene
        rabbitTemplate.convertAndSend("exchange.fanout", "", order);
        return order;
    }


    @GetMapping("/getOrder")
    public int getOrder() {
        Object helloworld = rabbitTemplate.receiveAndConvert("helloworld");
        System.out.println(helloworld);
        return 1;
    }*/

}
