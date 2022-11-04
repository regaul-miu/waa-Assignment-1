package com.miu.Assignment1.controller;

import com.miu.Assignment1.domain.Post;
import com.miu.Assignment1.domain.dto.PostDto;
import com.miu.Assignment1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts/")
public class PostController {
    @Autowired
    private PostService postService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Post> getAllPost(){
        return postService.findAll();
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("{id}")
    public PostDto getById(@PathVariable("id") long id){
        return postService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody PostDto p){
        postService.save(p);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") long id){
        postService.deleteById(id);
    }

    @PutMapping("{id}")
    public void updateById(@PathVariable("id") long id, @RequestBody PostDto p){
        postService.updateById(id,p);
    }

}
