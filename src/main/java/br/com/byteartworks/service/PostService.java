package br.com.byteartworks.service;

import br.com.byteartworks.dto.PostDTO;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface PostService {

    @GetExchange("/posts")
    List<PostDTO> getAllPosts();
}
