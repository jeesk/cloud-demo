package com.shanjiancaofu.elstaticsearchdemo.bean;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Data
@Document(indexName = "books", type = "book")
public class Book implements Serializable {
    Integer id;

    String bookName;
    String author;

}
