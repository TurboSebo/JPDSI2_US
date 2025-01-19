package com.s3bastiank.cybercentrum.service;

import com.s3bastiank.cybercentrum.entity.Comments;
import com.s3bastiank.cybercentrum.repository.CommentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private CommentsRepository commentsRepository;

    public CommentService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }
    public List<Comments> getCommentsByPostId(int postId) {
        return commentsRepository.findAllByPostIdAndDeletedFalseOrderByCreationDate(postId);
    }
}
