package com.shanjiancaofu.userserver;

import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 模拟请求工具类
 */
public class MovTestUtil {


    private final static Gson gson = new Gson();

    /**
     * movController  调用
     * @param url 调用地址
     * @param obj 请求Body
     * @param t   返回的content类型类
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T conteollerCallPost(String url, Object obj, Class<T> t, MockMvc mockMvc) throws Exception {
        // MvcResult mvcResult =

/*        List<Object> list = new ArrayList<>();
        Optional<Object> first = list.stream().findFirst();
        first.ifPresent(x -> System.out.println(x));

        Object o = first.orElse("1231");

        // 存在返回, 不存在 则返回1.
        first.orElseGet(() -> {
            return 1;
        });*/
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post(url)
                .content(gson.toJson(obj))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String contentAsString = response.getContentAsString();
        System.out.println("contentAsString: " + contentAsString);
        return gson.fromJson(contentAsString, t);
    }

    public static <T> T conteollerCallGet(String url, Class<T> t, MockMvc mockMvc) throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get(url)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String contentAsString = response.getContentAsString();
        System.out.println("contentAsString: " + contentAsString);
        return gson.fromJson(contentAsString, t);
    }
}
