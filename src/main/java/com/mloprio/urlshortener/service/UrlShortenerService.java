package com.mloprio.urlshortener.service;

import com.mloprio.urlshortener.dto.UrlRequestDto;
import com.mloprio.urlshortener.dto.UrlShortenerDto;

public interface UrlShortenerService {

    UrlShortenerDto newUrl (UrlRequestDto requestDto);

    UrlShortenerDto getLongUrl (String key);

    Integer deleteUrl (String key);

}
