package com.mloprio.urlshortener.repository.mapper;

import com.mloprio.urlshortener.dto.UrlRequestDto;
import com.mloprio.urlshortener.dto.UrlShortenerDto;
import com.mloprio.urlshortener.model.UrlShortenerEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UrlShortenerMapper {

    UrlShortenerEntity getUrlInfo (@Param("requestDto") UrlRequestDto requestDto);

    Integer getKeyCount (@Param("key") String key);

    void insertUrlInfo(@Param("dto")UrlShortenerDto dtoToSave);

    UrlShortenerEntity getLongUrl (@Param("key") String key);

    Integer deleteUrl (@Param("key") String key);

}
