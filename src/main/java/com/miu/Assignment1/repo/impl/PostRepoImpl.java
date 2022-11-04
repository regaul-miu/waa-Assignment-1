package com.miu.Assignment1.repo.impl;

import com.miu.Assignment1.domain.Post;
import com.miu.Assignment1.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo {
    public static List<Post> posts;
    static {
        posts=new ArrayList<>();
        Post p1=new Post(1,"Java","Spring","Rezaul");
        Post p2=new Post(2,"Java","Spring","Rezaul");
        posts.add(p1);
        posts.add(p2);
    }
    public List<Post> findAll(){
        return posts;
    }

    @Override
    public Post findById(long id) {

        return posts
                .stream()
                .filter(i ->i.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Post p) {
        posts.add(p);
    }

    @Override
    public void deleteById(long id) {
        var post =
                posts
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst().get();
        posts.remove(post);
    }

    @Override
    public void updateById(long id, Post post) {
        var postUpdate = findById(id);
        postUpdate.setTitle(post.getTitle());
        postUpdate.setAuthor(post.getAuthor());
        postUpdate.setContent(post.getContent());
    }
}
