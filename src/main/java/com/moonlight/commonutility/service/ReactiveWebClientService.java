package com.moonlight.commonutility.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ReactiveWebClientService {

    <T, S> Mono<T> postMono(String url, S body, Class<T> tClass, HttpHeaders headers);

    <T, S> Mono<ResponseEntity<T>> postMonoEntity(String url, S body, Class<T> tClass, HttpHeaders headers);

    <T> Mono<ResponseEntity<T>> getMonoEntity(String url, Class<T> clasz, HttpHeaders httpHeaders);

    <T> Mono<T> getMono(String url, Class<T> tClass, HttpHeaders headers);

    <T, S> Mono<T> putMono(String url, S body, Class<T> tClass, HttpHeaders httpHeaders);

    <T, S> Mono<ResponseEntity<T>> putMonoEntity(String url, S body, Class<T> tClass, HttpHeaders headers);

    <T> Flux<T> getFlux(String url, Class<T> tClass, HttpHeaders headers);


    <T> Mono<ResponseEntity<Flux<T>>> getFluxEntity(String url, Class<T> clazz, HttpHeaders headers);

    <T, S> Flux<T> putFlux(String url, S body, Class<T> tClass, HttpHeaders httpHeaders);
}
