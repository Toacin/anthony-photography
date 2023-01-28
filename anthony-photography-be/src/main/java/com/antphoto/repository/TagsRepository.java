package com.antphoto.repository;

import com.antphoto.model.Tag;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TagsRepository extends JpaRepository<Tag, Integer> {
    List<Tag> findAllByCategoryId(Integer categoryId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO photo_tag (photo_id, tag_id) values (:photoId, :tagId)", nativeQuery = true)
    void addTagsToPhoto(@Param("photoId") Integer photoId, @Param("tagId") Integer tagId);
}
