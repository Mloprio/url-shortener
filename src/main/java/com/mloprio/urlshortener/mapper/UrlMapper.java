package com.mloprio.urlshortener.mapper;

import com.mloprio.urlshortener.dto.UrlShortenerDto;
import com.mloprio.urlshortener.model.UrlShortenerEntity;

public class UrlMapper {

    public static UrlShortenerDto entityToDto (UrlShortenerEntity entity) {
        UrlShortenerDto dto = new UrlShortenerDto();
        dto.setKeyValue(entity.getKeyValue());
        dto.setLongUrl(entity.getLongUrl());
        dto.setShortUrl(entity.getShortUrl());
        return dto;
    }

}
