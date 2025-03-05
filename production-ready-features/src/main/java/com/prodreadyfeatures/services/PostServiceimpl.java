package com.prodreadyfeatures.services;

import com.prodreadyfeatures.dtos.PostDTO;
import com.prodreadyfeatures.entities.PostEntity;
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
}
