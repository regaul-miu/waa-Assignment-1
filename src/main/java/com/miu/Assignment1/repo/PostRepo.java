package com.miu.Assignment1.repo;

import com.miu.Assignment1.domain.Post;

import java.util.List;

public interface PostRepo {
    public List<Post> findAll();

    Post findById(long id);

    void save(Post p);

    void deleteById(long id);

    void updateById(long id, Post post);
}
