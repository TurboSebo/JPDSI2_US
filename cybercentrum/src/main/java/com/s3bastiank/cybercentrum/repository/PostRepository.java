package com.s3bastiank.cybercentrum.repository;

import com.s3bastiank.cybercentrum.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAllByDeletedFalseOrderByCreationDateDesc();
}
