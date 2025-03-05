package com.prodreadyfeatures.services;

import com.prodreadyfeatures.dtos.PostDTO;

import java.util.List;

public interface PostService {

    public List<PostDTO> getAllPost();
    public PostDTO createNewPost(PostDTO newInputPostDto);
    public PostDTO findPostById(Long id);
}
