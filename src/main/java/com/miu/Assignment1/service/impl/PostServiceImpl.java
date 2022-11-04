package com.miu.Assignment1.service.impl;

import com.miu.Assignment1.domain.Post;
import com.miu.Assignment1.domain.dto.PostDto;
import com.miu.Assignment1.repo.PostRepo;
import com.miu.Assignment1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;
    public List<Post> findAll(){
        return postRepo.findAll();
    }

    @Override
    public PostDto findById(long id) {
        Post post = postRepo.findById(id);
        PostDto postDto = new PostDto(post.getId(),post.getTitle(),post.getContent(),post.getAuthor());
        return postDto;
    }

    @Override
    public void save(PostDto p) {
        Post post = new Post(p.getId(),p.getTitle(),p.getContent(),p.getAuthor());
        postRepo.save(post);
    }

    @Override
    public void deleteById(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void updateById(long id, PostDto p) {
        Post post = new Post(p.getId(),p.getTitle(),p.getContent(),p.getAuthor());
        postRepo.updateById(id, post);
    }
}
