package com.shanjiancaofu.elstaticsearchdemo.repository;

import com.shanjiancaofu.elstaticsearchdemo.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

    List<Book> findByBookNameLike(String name);
}
