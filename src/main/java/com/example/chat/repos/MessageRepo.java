package com.example.chat.repos;

import com.example.chat.entity.Message;
import com.example.chat.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface MessageRepo extends CrudRepository<Message,Long>{
    List<Message> findByTag (String tag);
    List<Message> findByAuthor(User author);
    @Override
    List<Message> findAll();
    void deleteById(Integer id);
}
