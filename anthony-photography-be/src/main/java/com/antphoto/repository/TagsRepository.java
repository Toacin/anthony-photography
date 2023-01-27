package com.antphoto.repository;

import com.antphoto.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagsRepository extends JpaRepository<Tag, Integer> {
    List<Tag> findAllByCategoryId(Integer categoryId) throws Exception;
}
