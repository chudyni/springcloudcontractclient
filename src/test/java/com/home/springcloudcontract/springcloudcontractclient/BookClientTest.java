package com.home.springcloudcontract.springcloudcontractclient;

import com.home.springcloudcontract.springcloudcontractclient.controller.BookClient;
import com.home.springcloudcontract.springcloudcontractclient.model.Book;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by marcin.bracisiewicz
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(
        ids = "com.home.springcloudcontract:spring-cloud-contract-producer:+:stubs:9090",
        stubsMode = StubRunnerProperties.StubsMode.LOCAL
)
public class BookClientTest {

    @Autowired
    private BookClient bookClient;

    @Test
    public void getBookByIsbnCompliesToContract() {
        final Book book = this.bookClient.getBook("123");
        Assertions.assertThat(book.getIsbn()).isEqualToIgnoringCase("123");
    }

    @Test
    public void createBookCompliesToContract() {
        final Book book = this.bookClient.getBook("123");
        final Book createdBook = this.bookClient.createBook(book);
        Assertions.assertThat(createdBook.getIsbn()).isEqualToIgnoringCase("123");
    }
}
