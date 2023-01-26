package com.antphoto.repository;

import com.antphoto.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer> {
    @Query(value = "SELECT * FROM user_photos JOIN photo WHERE user_id = :idd", nativeQuery = true)
    List<Photo> getPhotosByUserId(@Param("idd") Integer idd);

}
