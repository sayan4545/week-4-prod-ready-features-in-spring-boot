package com.prodreadyfeatures.controllers;

import com.prodreadyfeatures.dtos.PostDTO;
import com.prodreadyfeatures.services.PostService;
import com.prodreadyfeatures.services.PostServiceimpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/getAll")
    public List<PostDTO> getAllPost(){
        return postService.getAllPost();
    }

    @PostMapping
    public PostDTO createNewPost(@RequestBody PostDTO inputPost){
        return postService.createNewPost(inputPost);
    }

    @GetMapping("/findById/{id}")
    public PostDTO findPostById(@PathVariable Long id){
        return postService.findPostById(id);
    }

}
