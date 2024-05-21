package com.example.GestionLabo.controllers;


import com.example.GestionLabo.models.Posts;
import com.example.GestionLabo.requestDto.PostRequestDto;
import com.example.GestionLabo.serviceImplementaion.PostServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")

public class PostController {
    private static final Logger log = LoggerFactory.getLogger(PostController.class);
    private final PostServiceImp postServiceImp ;

    public PostController(PostServiceImp postServiceImp) {
        this.postServiceImp = postServiceImp;
    }

    @PostMapping("")
    public Posts createPost(  @RequestBody PostRequestDto postRequestDto) {

        log.info(""+postRequestDto);

        return postServiceImp.createPost(postRequestDto);
    }

    @GetMapping("")
    public List<Posts> getAllPosts() {
        return postServiceImp.getAllPosts();
    }
    public Posts updatePost(String id, Posts post) {
        return postServiceImp.updatePost(id, post);
    }
    @DeleteMapping("{id}")
    public void deletePost(  @PathVariable("id") String id) {
        postServiceImp.deletePost(id);
    }
}
