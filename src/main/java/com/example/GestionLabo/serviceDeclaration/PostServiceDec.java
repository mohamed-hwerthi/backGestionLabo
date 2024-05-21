package com.example.GestionLabo.serviceDeclaration;

import com.example.GestionLabo.models.Posts;
import com.example.GestionLabo.requestDto.PostRequestDto;

import java.util.List;

public interface PostServiceDec {
    Posts createPost(PostRequestDto post);
    List<Posts> getAllPosts();
    Posts updatePost(String id, Posts post);
    void deletePost(String id);
}
