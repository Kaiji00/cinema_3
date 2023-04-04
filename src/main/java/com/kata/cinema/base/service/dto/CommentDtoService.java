package com.kata.cinema.base.service.dto;

import com.kata.cinema.base.models.dto.response.UserCommentResponseDto;
import com.kata.cinema.base.models.dto.response.UserNameResponseDto;

import java.util.List;

public interface CommentDtoService {

    List<UserCommentResponseDto> listDto(Long mediaId);
    UserCommentResponseDto getUserCommentById(Long mediaId);
    List<UserNameResponseDto> getUserDtoByCommentIds();

}
