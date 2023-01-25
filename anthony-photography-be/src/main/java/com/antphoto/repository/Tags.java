package com.antphoto.repository;

import com.antphoto.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tags extends JpaRepository<Tags, Integer> {
    List<Tag> findAllByCategoryId() throws Exception;
}
