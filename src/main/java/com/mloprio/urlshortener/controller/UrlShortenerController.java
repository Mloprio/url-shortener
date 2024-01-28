package com.mloprio.urlshortener.controller;

import com.mloprio.urlshortener.dto.UrlRequestDto;
import com.mloprio.urlshortener.dto.UrlShortenerDto;
import com.mloprio.urlshortener.service.UrlShortenerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.*;

@RestController
@AllArgsConstructor
@Validated
public class UrlShortenerController {

    private UrlShortenerService urlShortenerService;

    @PostMapping(value = "/newUrl")
    public ResponseEntity<UrlShortenerDto> newUrl(@Valid @RequestBody (required = true) UrlRequestDto requestDto) {
        UrlShortenerDto responseDto = urlShortenerService.newUrl(requestDto);
        return new ResponseEntity<UrlShortenerDto>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/{key}")
    public ResponseEntity<Object> redirectToLongUrl (@PathVariable String key) {
        UrlShortenerDto dto = urlShortenerService.getLongUrl(key);

        if (dto != null) {
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(dto.getLongUrl())).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("URL not found");
        }
    }

    @DeleteMapping("/{key}")
    public ResponseEntity<Object> deleteUrl (@PathVariable String key) {
        Integer deletedCount = urlShortenerService.deleteUrl(key);

        if (deletedCount > 0) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no URL for the input key");
        }
    }

}
