package com.s3bastiank.cybercentrum;

import com.s3bastiank.cybercentrum.entity.Post;
import com.s3bastiank.cybercentrum.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostRestController {
    private final PostService postService;

    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/search")
    public List<Post> searchPosts(@RequestParam String query) {
        return postService.searchPostsByTitle(query);
    }
}