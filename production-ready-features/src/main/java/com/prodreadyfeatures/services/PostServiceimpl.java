package com.prodreadyfeatures.services;

import com.prodreadyfeatures.dtos.PostDTO;
import com.prodreadyfeatures.entities.PostEntity;
import com.prodreadyfeatures.exceptions.ResourceNotFoundException;
import com.prodreadyfeatures.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class PostServiceimpl implements PostService{
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<PostDTO> getAllPost() {
        return postRepository.findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity,PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO newInputPostDto) {
        PostEntity postEntity = modelMapper.map(newInputPostDto,PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity),PostDTO.class);
    }

    @Override
    public PostDTO findPostById(Long id) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not found" + id));
        return modelMapper.map(postEntity,PostDTO.class);

    }

    @Override
    public PostDTO updatePostById(PostDTO inputPost,Long id) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not found"));
        inputPost.setId(id);
        modelMapper.map(inputPost,postEntity);
        PostEntity savedPost = postRepository.save(postEntity);
        return modelMapper.map(savedPost,PostDTO.class);

    }
}
