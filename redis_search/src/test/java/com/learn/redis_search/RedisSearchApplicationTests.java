package com.learn.redis_search;

import io.redisearch.Document;
import io.redisearch.Query;
import io.redisearch.Schema;
import io.redisearch.SearchResult;
import io.redisearch.client.Client;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class RedisSearchApplicationTests {

    Client client = new Client("any-search", "192.168.249.132", 6666);

    @Test
    void contextLoads() {

        Schema schema = new Schema().addTextField("title", 5.0).addTextField("body", 5.0).addNumericField("star");
        client.dropIndex();
        client.createIndex(schema, Client.IndexOptions.defaultOptions());

        Map<String, Object> doc1 = this.createDoc("any video1", "video1", 20000);
        Map<String, Object> doc4 = this.createDoc("any video2", "video2", 100);
        Map<String, Object> doc2 = this.createDoc("any chat", "chat", 500);
        Map<String, Object> doc3 = this.createDoc("any security", "security", 10000);

        client.addDocument("doc1", doc1);
        client.addDocument("doc2", doc2);
        client.addDocument("doc3", doc3);
        client.addDocument("doc4", doc4);
    }

    @Test
    void test(){
        Query query = new Query("any").addFilter(new Query.NumericFilter("star", 0, 1000)).setWithScores().limit(0, 10);
        SearchResult result = client.search(query);
        this.printResult(result);
    }

    @Test
    void testQueryString(){
        Query other = new Query("se").limitFields("body").limit(0,10);
        SearchResult search = client.search(other);
        this.printResult(search);

    }

    private Map<String, Object> createDoc(String title, String body, Integer price) {
        HashMap<String, Object> fields = new HashMap<>();
        fields.put("title", title);
        fields.put("body", body);
        fields.put("star", price);
        return fields;
    }

    private void printResult(SearchResult result) {
        List<Document> docs = result.docs;
        docs.forEach(System.out::println);
    }


    @Test
    void test1(){
    }

}
