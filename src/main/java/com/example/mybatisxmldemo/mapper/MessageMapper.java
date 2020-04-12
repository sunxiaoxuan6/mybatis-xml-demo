package com.example.mybatisxmldemo.mapper;

import com.example.mybatisxmldemo.model.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper {
    List<Message> selectAll();

    Message selectById(Integer id);

    int delete(Integer id);

    int update(Message message);

    int updateText(Message message);

    int batchInsert(List<Message> message);

    int insert(Message message);
}
