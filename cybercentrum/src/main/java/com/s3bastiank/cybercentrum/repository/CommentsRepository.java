package com.s3bastiank.cybercentrum.repository;


import com.s3bastiank.cybercentrum.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface CommentsRepository extends JpaRepository<Comments, Integer> {
    List<Comments> findAllByPostIdAndDeletedFalseOrderByCreationDate(Integer postId);
}
