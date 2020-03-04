package com.flagcamp.backend.rest;

import com.flagcamp.backend.entity.Comment;
import com.flagcamp.backend.entity.Resident;
import com.flagcamp.backend.entity.Post;
import com.flagcamp.backend.service.CommentService;
import com.flagcamp.backend.service.PostService;
import com.flagcamp.backend.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AllRestController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public List<Comment> getComments() {
        return commentService.getComments();
    }

    @GetMapping("/comments/{commentId}")
    public Comment getComment(@PathVariable int commentId) {
        Comment theComment = commentService.getComment(commentId);
        if (theComment == null) {
            throw new NotFoundException("Comment id not found - " + commentId);
        }
        return theComment;
    }

    @PostMapping("/comments")
    public Comment addComment(@RequestBody Comment theComment) {
        theComment.setComment_id(0);   //hardcode

        commentService.saveComment(theComment);

        return theComment;
    }

    @PutMapping("/comments")
    public Comment updateComment(@RequestBody Comment theComment) {
        commentService.saveComment(theComment);
        return theComment;
    }

    @DeleteMapping("/comments/{commentId}")
    public String deleteComment(@PathVariable int commentId) {
        Comment tempComment = commentService.getComment(commentId);
        if (tempComment == null) {
            throw new NotFoundException("Comment id not found - " + commentId);
        }
        commentService.deleteComment(commentId);
        return "Deleted Comment id - " + commentId;
    }

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/posts/{postId}")
    public Post getPost(@PathVariable int postId) {
        Post thePost = postService.getPost(postId);
        if (thePost == null) {
            throw new NotFoundException("Post id not found - " + postId);
        }
        return thePost;
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post thePost) {
        thePost.setPost_id(0);   //hardcode

        postService.savePost(thePost);

        return thePost;
    }

    @PutMapping("/posts")
    public Post updatePost(@RequestBody Post thePost) {
        postService.savePost(thePost);
        return thePost;
    }

    @DeleteMapping("/posts/{postId}")
    public String deletePost(@PathVariable int postId) {
        Post tempPost = postService.getPost(postId);
        if (tempPost == null) {
            throw new NotFoundException("Post id not found - " + postId);
        }
        postService.deletePost(postId);
        return "Deleted Comment id - " + postId;
    }

    @Autowired
    private ResidentService residentService;

    @GetMapping("/residents")
    public List<Resident> getResidents() {
        return residentService.getResidents();
    }

    @GetMapping("/residents/{username}")
    public Resident getResident(@PathVariable int username) {
        Resident theResident = residentService.getResident(username);
        if (theResident == null) {
            throw new NotFoundException("Resident id not found - " + username);
        }
        return theResident;
    }

    @PostMapping("/rensidents")
    public Resident addResident(@RequestBody Resident theResident) {
        theResident.setUsername(0);   //hardcode

        residentService.saveResident(theResident);

        return theResident;
    }

    @PutMapping("/residents")
    public Resident updateResident(@RequestBody Resident theResident) {
        residentService.saveResident(theResident);
        return theResident;
    }

    @DeleteMapping("/residents/{username}")
    public String deleteResident(@PathVariable int username) {
        Resident tempResident = residentService.getResident(username);
        if (tempResident == null) {
            throw new NotFoundException("Resident id not found - " + username);
        }
        residentService.deleteResident(username);
        return "Deleted username - " + username;
    }

}
