package com.shanjiancaofu.userserver;

import com.shanjiancaofu.userserver.controller.OrderController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserServerApplication.class)
public class FlowOrderControllerTest {
    @Autowired
    WebApplicationContext context;
    //虚拟MVC请求，获取得到处理结果
    MockMvc mockMvc;

    @Before
    public void initMokcMvc() {
        //mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        mockMvc = MockMvcBuilders.standaloneSetup(OrderController.class).build();
    }

    // 集成 spring mvc 测试
    @Test
    public void getOrderInfo() throws Exception {
        Map<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("hello", 1);
        objectObjectHashMap.put("world", 1);
        Object responseMsg = MovTestUtil.conteollerCallPost("/pushOrderForDirect", objectObjectHashMap, Object.class, mockMvc);
        System.out.println(responseMsg.toString());
    }


}