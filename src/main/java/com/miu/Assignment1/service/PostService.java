package com.miu.Assignment1.service;

import com.miu.Assignment1.domain.Post;
import com.miu.Assignment1.domain.dto.PostDto;

import java.util.List;

public interface PostService {
    List<Post> findAll();

    public PostDto findById(long id);

    public void save(PostDto p);

    public void deleteById(long id);

    void updateById(long id, PostDto p);
}
