package com.example.mybatisxmldemo.mapper;

import com.example.mybatisxmldemo.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MessageMapperTest {
    @Autowired
    private MessageMapper messageMapper;

    @Test
    @Order(1)
    public void testInsert(){
//        1、模拟数据
        Message msg=Message.builder().msgText("桃花").msgSummary("春天").build();
        int num=messageMapper.insert(msg);
        log.info("插入的数据数：{}",num);
    }

    @Order(2)
    @Test
    public void testSelectAll(){
        List<Message> msgs=messageMapper.selectAll();
        if(msgs==null){
            log.error("msg为null");
        }
        msgs.forEach(msg -> log.info("查询到的记录:{}",msg));
    }

    @Order(3)
    @Test
    public void testSelectById(){
        Message message=messageMapper.selectById(8);
        log.info("id为8的数据：{}",message);
    }

    @Order(4)
    @Test
    public void testDelete(){
        int num = messageMapper.delete(11);
        log.info("删除的数据:{}",num);
    }

    @Order(5)
    @Test
    public void testUpdate(){
        Message message=Message.builder().msgId(1).msgText("computer").msgSummary("学校").build();
        int num=messageMapper.update(message);
        log.info("更新的数据条数:{}",num);
    }

    @Order(6)
    @Test
    public void testUpdateText(){
        Message message=Message.builder().msgId(2).msgText("computer").msgSummary("").build();
        int num=messageMapper.update(message);
        log.info("更新Text的数据条数:{}",num);
    }

    @Order(7)
    @Test
    public void testBatchInsert(){
        List<Message> messages=new ArrayList<>(Arrays.asList(
                Message.builder().msgText("apple").msgSummary("水果").build(),
                Message.builder().msgText("origin").msgSummary("水果").build()
        ));
        int num=messageMapper.batchInsert(messages);
        log.info("插入的数据条数:{}",num);
    }
}
