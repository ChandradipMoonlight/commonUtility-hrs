package com.moonlight.commonutility.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@Service
@Slf4j
public class ReactiveWebclientServiceImpl implements ReactiveWebClientService{

    @Autowired
    private WebClient webClient;

    @Override
    public <T, S> Mono<T> postMono(String url, S body, Class<T> tClass, HttpHeaders headers) {
        log.info("ReactiveWebclientServiceImpl => ");
        return webClient.post()
                .uri(URI.create(url))
                .bodyValue(body)
                .headers(h->h.addAll(headers))
                .retrieve()
                .bodyToMono(tClass);
    }

    @Override
    public <T, S> Mono<ResponseEntity<T>> postMonoEntity(String url, S body, Class<T> tClass, HttpHeaders headers) {
        return webClient
                .post()
                .uri(URI.create(url))
                .bodyValue(body)
                .headers(h->h.addAll(headers))
                .retrieve()
                .toEntity(tClass);

    }

    @Override
    public <T> Flux<T> getFlux(String url, Class<T> tClass, HttpHeaders headers) {
        return webClient.get()
                .uri(URI.create(url))
                .headers(h->h.addAll(headers))
                .retrieve()
                .bodyToFlux(tClass);
    }

    @Override
    public <T> Mono<T> getMono(String url, Class<T> tClass, HttpHeaders headers) {
        return webClient.get()
                .uri(URI.create(url))
                .headers(h->h.addAll(headers))
                .retrieve()
                .bodyToMono(tClass);
    }

    @Override
    public <T> Mono<ResponseEntity<T>> getMonoEntity(String url, Class<T> clazz, HttpHeaders httpHeaders) {
        return webClient.get()
                .uri(URI.create(url))
                .headers(h-> h.addAll(httpHeaders))
                .retrieve()
                .toEntity(clazz);
    }

    @Override
    public <T> Mono<ResponseEntity<Flux<T>>> getFluxEntity(String url, Class<T> clazz, HttpHeaders headers) {
        return webClient.get()
                .uri(URI.create(url))
                .headers(h->h.addAll(headers))
                .retrieve()
                .toEntityFlux(clazz);
    }

    @Override
    public <T, S> Mono<T> putMono(String url, S body, Class<T> clazz, HttpHeaders httpHeaders){
        return webClient.put()
                .uri(URI.create(url))
                .bodyValue(body)
                .headers(h->h.addAll(httpHeaders))
                .retrieve()
                .bodyToMono(clazz);
    }

    @Override
    public <T, S> Mono<ResponseEntity<T>> putMonoEntity(String url, S body, Class<T> tClass, HttpHeaders headers) {
        return webClient.put()
                .uri(URI.create(url))
                .headers(h->h.addAll(headers))
                .bodyValue(body)
                .retrieve()
                .toEntity(tClass);
    }

    @Override
    public <T, S> Flux<T> putFlux(String url, S body, Class<T> clazz, HttpHeaders httpHeaders){
        return webClient.put()
                .uri(URI.create(url))
                .bodyValue(body)
                .headers(h->h.addAll(httpHeaders))
                .retrieve()
                .bodyToFlux(clazz)
                .log();
    }

}
