package com.robustel.pl.app.dictionary.controller;

import com.alibaba.fastjson.JSONObject;
import com.robustel.pl.app.dictionary.entity.DictionaryGroup;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 14:45 2018/3/30
 * Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DictionaryGroupControllerTest {
    @Test
    public void contextLoads() {
    }

    private MockMvc mockMvc; // 模拟MVC对象

    @Autowired
    private WebApplicationContext wac; // 注入WebApplicationContext

//    @Autowired
//    private MockHttpSession session;// 注入模拟的http session
//
//    @Autowired
//    private MockHttpServletRequest request;// 注入模拟的http request\

    @Before // 在测试开始前初始化工作
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testSave() throws Exception {
        DictionaryGroup dictionaryGroup = new DictionaryGroup();
        dictionaryGroup.setDicLevel("1");
        dictionaryGroup.setName("MQTT配置");
        dictionaryGroup.setGpDesc("MQTT分组");
        dictionaryGroup.setAppId("abc");
        dictionaryGroup.setCode("mqtt_group");
        dictionaryGroup.setLgDescCode("lang_mqtt_group");

        MvcResult result = mockMvc.perform(post("/dictionaryGroup").contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(dictionaryGroup)))
                .andExpect(status().isOk())// 模拟向testRest发送get请求
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
                .andReturn();// 返回执行请求的结果

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testPage() throws Exception {
        MvcResult result = mockMvc.perform(get("/dictionaryGroup/list").param("pageNum", "1").param("pageSize", "2"))
                .andExpect(status().isOk())// 模拟向testRest发送get请求
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
                .andReturn();// 返回执行请求的结果

        System.out.println(result.getResponse().getContentAsString());
    }
}
