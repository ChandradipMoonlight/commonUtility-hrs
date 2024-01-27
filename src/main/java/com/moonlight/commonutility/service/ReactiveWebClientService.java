package com.moonlight.commonutility.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ReactiveWebClientService {

    <T, S> Mono<T> postMono(String url, S body, Class<T> tClass, HttpHeaders headers);

    <T> Flux<T> getFlux(String url, Class<T> tClass, HttpHeaders headers);
    <T> Mono<T> getMono(String url, Class<T> tClass, HttpHeaders headers);

    <T> Mono<ResponseEntity<T>> getMonoEntity(String url, Class<T> clasz, HttpHeaders httpHeaders);

    <T> Mono<ResponseEntity<Flux<T>>> getFluxEntity(String url, Class<T> clazz, HttpHeaders headers);
    <T, S> Mono<S> putMono(String url, T body, Class<S> clasz, HttpHeaders httpHeaders);

    <T, S> Flux<S> putFlux(String url, T body, Class<S> clasz, HttpHeaders httpHeaders);
}
