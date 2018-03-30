package com.robustel.pl.app.dictionary.Service;

import com.robustel.pl.app.dictionary.entity.DictionaryGroup;
import com.robustel.pl.app.dictionary.service.DictionaryGroupService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 11:56 2018/3/30
 * Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DictionaryGroupServiceTest {
    @Autowired
    private DictionaryGroupService dictionaryGroupService;

    @Test
    public void testInsert(){
        DictionaryGroup dictionaryGroup = new DictionaryGroup();
        dictionaryGroup.setDicLevel("1");
        dictionaryGroup.setName("MQTT配置");
        dictionaryGroup.setGpDesc("MQTT分组");
        dictionaryGroup.setAppId("abc");
        dictionaryGroup.setCode("mqtt_group");
        dictionaryGroup.setLgDescCode("lang_mqtt_group");
        dictionaryGroup.setCreater("gaolinlou");
        dictionaryGroup.setCreateTime(System.currentTimeMillis());
        dictionaryGroup.setCreateUserId("123456");
        dictionaryGroupService.insert(dictionaryGroup);
    }

    @Test
    public void testSelecOne(){
        DictionaryGroup dictionaryGroup = new DictionaryGroup();
        dictionaryGroup.setName("MQTT配置");
        DictionaryGroup dictionaryGroup1 = dictionaryGroupService.selectOne(dictionaryGroup);
        Assert.assertNotNull(dictionaryGroup1);
    }
}
