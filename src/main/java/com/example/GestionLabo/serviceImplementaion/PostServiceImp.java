package com.example.GestionLabo.serviceImplementaion;


import com.example.GestionLabo.exception.CustomNotFoundException;
import com.example.GestionLabo.models.Posts;
import com.example.GestionLabo.repository.PostRepositry;
import com.example.GestionLabo.requestDto.PostRequestDto;
import com.example.GestionLabo.serviceDeclaration.PostServiceDec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImp   implements PostServiceDec {
    private final PostRepositry postRepositry ;

    @Override
    public Posts createPost(PostRequestDto postRequestDto) {
          Posts post = Posts.builder()
                  .title(postRequestDto.getTitle())
                  .date(postRequestDto.getDate())
                  .content(postRequestDto.getContent())
                  .build();
          return this.postRepositry.save(post);
    }

    @Override
    public List<Posts> getAllPosts() {
        return postRepositry.findAll();
    }

    @Override
    public Posts updatePost(String id, Posts post) {
        return null;
    }

    @Override
    public void deletePost(  @PathVariable("id") String id) {
        if (!this.postRepositry.existsById(id)) {
            throw new CustomNotFoundException("product", id);
        }
        this.postRepositry.deleteById(id);

    }
}
