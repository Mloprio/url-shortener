package com.mloprio.urlshortener.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlShortenerDto {
    String keyValue;
    String longUrl;
    String shortUrl;
}
