package com.s3bastiank.cybercentrum;

import com.s3bastiank.cybercentrum.entity.Post;
import com.s3bastiank.cybercentrum.repository.CommentsRepository;
import com.s3bastiank.cybercentrum.repository.PostRepository;
import com.s3bastiank.cybercentrum.service.PostService;
import com.s3bastiank.cybercentrum.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    private PostService postService;
    private CommentService commentService;
    private PostRepository postRepository;

    public PostController(PostRepository postRepository, CommentService commentService) {
        this.postRepository = postRepository;
        this.postService = new PostService(postRepository);
        this.commentService = commentService;
    }
    @GetMapping
    public String listPosts(Model model) {
        List<Post> posts = postService.getAllPosts();

        // Skracanie treści postów, jeśli są za długie
        for (Post post : posts) {
            if (post.getContent() != null) {
                // Jeśli treść jest dłuższa niż 100 znaków, skracamy ją
                if (post.getContent().length() > 100) {
                    post.setContent(post.getContent().substring(0, 100) + "...");
                }
            } else {
                // Jeżeli brak treści, ustawiamy "Brak treści"
                post.setContent("Brak treści");
            }
        }

        model.addAttribute("posts", posts);
        return "postList";
    }




    @GetMapping("/{id}")
        public String viewPost(@PathVariable Integer id, Model model) {
        Post post = postService.getPostById(id);

        model.addAttribute("post", post);
        model.addAttribute("comments", commentService.getCommentsByPostId(id));
        return "postView";

    }
}
