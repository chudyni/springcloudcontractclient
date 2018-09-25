package com.home.springcloudcontract.springcloudcontractclient.controller;

import com.home.springcloudcontract.springcloudcontractclient.model.Book;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by marcin.bracisiewicz
 */
@FeignClient("bookservice")
public interface BookClient {

    @RequestMapping(
            method = RequestMethod.GET, path = "/api/books/{isbn}",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    Book getBook(@PathVariable("isbn") String isbn);

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/api/books",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    Book createBook(@RequestBody Book book);
}
