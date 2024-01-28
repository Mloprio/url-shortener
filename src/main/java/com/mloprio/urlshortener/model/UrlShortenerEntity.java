package com.mloprio.urlshortener.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlShortenerEntity {
    Integer urlId;
    String keyValue;
    String longUrl;
    String shortUrl;
}
