package com.shanjiancaofu.elstaticsearchdemo;

import com.shanjiancaofu.elstaticsearchdemo.bean.Article;
import com.shanjiancaofu.elstaticsearchdemo.bean.Book;
import com.shanjiancaofu.elstaticsearchdemo.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElstaticsearchDemoApplicationTests {


    @Autowired
    private JestClient jestClient;


    @Autowired
    BookRepository bookRepository;

    /**
     * 测试 使用jest client 操作elasticsearch
     */
    @Test
    public void contextLoads() {
        Article article = new Article();
        article.setId(1);
        article.setAuthor("xiaoming");
        article.setContent("hello world");
        article.setTitle(" 你说的东西不行哟");
        Index build = new Index.Builder(article).index("hello").type("news").build();
        try {
            DocumentResult execute = jestClient.execute(build);
            System.out.println(execute);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void search() throws IOException {
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"你说的东西不行哟\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search build = new Search.Builder(json).addIndex("hello").addType("news").build();
        SearchResult execute = jestClient.execute(build);
        System.out.println(execute.getJsonString());

    }


    @Test
    public void saveBook() {
        Book book = new Book();
        book.setId(1);
        book.setAuthor("xiaoming");
        book.setBookName("西游记");
        bookRepository.index(book);
    }

    @Test
    public void queryBook() {
        List<Book> bok = bookRepository.findByBookNameLike("西游记");
        bok.forEach(x -> System.out.println(x));

    }

}
