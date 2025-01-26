package com.s3bastiank.cybercentrum.service;

import com.s3bastiank.cybercentrum.entity.Comments;
import com.s3bastiank.cybercentrum.repository.CommentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {
    private CommentsRepository commentsRepository;

    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }
    public List<Comments> getCommentsByPostId(int postId) {
        return commentsRepository.findAllByPostIdAndDeletedFalseOrderByCreationDate(postId);
    }
    public void saveComment(Comments comment) {
        commentsRepository.save(comment);
    }
    public Comments getCommentById(Integer id) {
        return commentsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Komentarz o podanym ID nie istnieje: " + id));
    }
}
