package com.antphoto.repository;

import com.antphoto.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmail(String email) throws Exception;

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user_photos(user_id, photo_id) VALUES(:userId, :photoId) ", nativeQuery = true)
    void addPhotoToUser(@Param("userId") Integer userId, @Param("photoId") Integer photoId);
}
