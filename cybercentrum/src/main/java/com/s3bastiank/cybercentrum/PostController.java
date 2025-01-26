package com.s3bastiank.cybercentrum;

import com.s3bastiank.cybercentrum.entity.Comments;
import com.s3bastiank.cybercentrum.entity.Post;
import com.s3bastiank.cybercentrum.entity.User;
import com.s3bastiank.cybercentrum.repository.PostRepository;
import com.s3bastiank.cybercentrum.service.PostService;
import com.s3bastiank.cybercentrum.service.CommentsService;
import com.s3bastiank.cybercentrum.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    private PostService postService;
    private CommentsService commentsService;
    private PostRepository postRepository;
    private UserService userService;

    public PostController(PostRepository postRepository, CommentsService commentsService, PostService postService, UserService userService) {
        this.postRepository = postRepository;
        this.postService =  postService;
        this.commentsService = commentsService;
        this.userService = userService;
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

        if (post == null) {
            throw new RuntimeException("Nie znaleziono");
        }
//        if (post.isDeleted()) {
//            throw new AccessDeniedException("Nie możesz wyświetlić");
//        }

        // Pobieranie komentarzy związanych z postem
        List<Comments> comments = commentsService.getCommentsByPostId(id);

        // Pobieranie informacji o zalogowanym użytkowniku
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userService.getUserByUsername(username);
        String currentRole = currentUser.getRoleName();

        model.addAttribute("post", post);
        model.addAttribute("comments", comments);

        System.out.println("Zalogowany użytkownik: " + username);
        System.out.println("Autor posta: " + post.getAuthor().getUsername());
        model.addAttribute("username", username);
        model.addAttribute("post", post);
        model.addAttribute("currentRole", currentRole);
        return "postView";

    }
    @GetMapping("/create")
    public String showCreatePostForm(Model model, Post post) {
        model.addAttribute("post", new Post());
        return "createPost";
    }
    @PostMapping
    public String createPost(@ModelAttribute("post") Post post) {
        //pobieram nazwe użytkownika
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        //wyszukujemy go w bazie
        User currentUser = userService.getUserByUsername(username);
        if ("GUEST".equals(currentUser.getRoleName())||"UNKNOWN".equals(currentUser.getRoleName())) {
            return "redirect:/error-403";
        }
        post.setAuthor(currentUser);
        post.setCreationDate(LocalDateTime.now());
        post.setDeleted(false);

        postService.savePost(post);
        return "redirect:/posts";
    }


    @PostMapping("/{id}/delete")
    public String deletePost(@PathVariable Integer id) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userService.getUserByUsername(username);

        Post post = postService.getPostById(id);

        if (("ADMIN".equals(currentUser.getRoleName())) ||
                ("MODERATOR".equals(currentUser.getRoleName())) ||
                (post.getAuthor().equals(currentUser))) {
            postService.deletePostById(id, currentUser);
            return "redirect:/posts";

        }
        else{
            return "error-403";
        }
    }

    //komentarze
    @PostMapping("/{id}/comments/add")
    public String addComment(@PathVariable Integer id, @RequestParam String content) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userService.getUserByUsername(username);

        Post post = postService.getPostById(id);

        Comments comment = new Comments();
        comment.setContent(content);
        comment.setCreationDate(LocalDateTime.now());
        comment.setDeleted(false);
        comment.setPost(post);
        comment.setAuthor(currentUser);

        commentsService.saveComment(comment);
        return "redirect:/posts/" + id;
    }

    @PostMapping("/comments/{id}/delete")
    public String deleteComment(@PathVariable Integer id) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userService.getUserByUsername(username);

        Comments comment = commentsService.getCommentById(id);

        if (("ADMIN".equals(currentUser.getRoleName())) ||
                ("MODERATOR".equals(currentUser.getRoleName())) ||
                (comment.getAuthor().equals(currentUser))) {
            comment.setDeleted(true);
            comment.setWhoDeleted(currentUser);
            comment.setDeleteDateTime(LocalDateTime.now());
            commentsService.saveComment(comment);
        }
        return "redirect:/posts/" + comment.getPost().getId();
    }


}
