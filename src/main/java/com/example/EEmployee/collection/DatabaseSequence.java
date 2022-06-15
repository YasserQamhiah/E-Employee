package com.example.EEmployee.collection;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "database_sequences")
@Data
@Builder

public class DatabaseSequence {

    @Id
    private String id;

    private long seq;

}
