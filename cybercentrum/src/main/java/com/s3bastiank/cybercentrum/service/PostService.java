package com.s3bastiank.cybercentrum.service;

import com.s3bastiank.cybercentrum.entity.Post;
import com.s3bastiank.cybercentrum.entity.User;
import com.s3bastiank.cybercentrum.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
private PostRepository postRepository;

public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
}
public List<Post> findAllByDeletedFalse() {
    return postRepository.findAll();
}
    public List<Post> getAllPosts() {
        return postRepository.findAllByDeletedFalseOrderByCreationDateDesc();
    }

public Post getPostById(int PostId) {
    return postRepository.findById(PostId)
            .orElseThrow(() -> new RuntimeException("Post not found"));
}
    public void savePost(Post post) {
        if (post.getTitle() == null || post.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Tytuł nie może być pusty");
        }
        if (post.getContent() == null || post.getContent().isEmpty()) {
            throw new IllegalArgumentException("Treść nie może być pusta");
        }

        postRepository.save(post);
    }
    public void deletePostById(int PostId, User deletedBy) {
        Post post = getPostById(PostId);
        post.setDeleted(true);
        post.setWhoDeleted(deletedBy);
        post.setPostDeleteDate(LocalDateTime.now());
        postRepository.save(post);
    }

    public List<Post> searchPostsByTitle(String query) {
        return postRepository.findByTitleContainingIgnoreCase(query);
    }

}
