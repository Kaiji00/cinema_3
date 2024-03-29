package com.kata.cinema.base.webapp.facade.movie.impl;

import com.kata.cinema.base.converter.media.MediaBodyMapper;
import com.kata.cinema.base.converter.media.MediaMapper;
import com.kata.cinema.base.models.dto.request.MediaRequestDto;
import com.kata.cinema.base.models.dto.response.MediaBodyResponseDto;
import com.kata.cinema.base.models.entitys.Media;
import com.kata.cinema.base.service.entity.MediaService;
import com.kata.cinema.base.webapp.facade.movie.MediaServiceFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MediaServiceFacadeImpl implements MediaServiceFacade {
    private final MediaService mediaService;
    private final MediaMapper mediaMapper;
    private final MediaBodyMapper mediaBodyMapper;

    @Override
    public MediaBodyResponseDto getMedia(Long id) {
        Media media = mediaService.getMedia(id);
        return mediaBodyMapper.toDto(media);
    }

    @Override
    public void createMedia(MediaRequestDto mediaRequestDto) {
        Media media = mediaMapper.toEntity(mediaRequestDto);
        mediaService.createMedia(media);
    }

    @Override
    public void updateMedia(Long id, MediaRequestDto mediaRequestDto) {
        Media media = mediaMapper.toEntity(mediaRequestDto);
        media.setId(id);
        mediaService.updateMedia(id, media);
    }

    @Override
    public void delete(Long id) {
        mediaService.changeEnableStatus(id);
    }

    @Override
    public void publish(Long id) {
        mediaService.changeStatusWaitVerify(id);
    }
}
