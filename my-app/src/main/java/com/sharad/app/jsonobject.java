package com.sharad.app;

import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

// import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.Operator;

public class jsonobject {

    public static void main(String[] args) {

        String sample1 = "{\"took\": 16,\"errors\": false,\"items\": [{\"index\": {\"_seq_no\": 109,\"_type\": \"summarytransaction\",\"_version\": 27,\"_shards\": {\"total\": 2,\"successful\": 2,\"failed\": 0},\"_id\": \"1\",\"_index\": \"cs_transaction_index\",\"result\": \"updated\",\"_primary_term\": 1,\"status\": 200}}]}";
        JSONObject jsample1 = new JSONObject(sample1);
        System.out.println(jsample1.get("took"));
        System.out.println(jsample1.getJSONArray("items").getJSONObject(0));

        // Response datastreamservResponse = Response
        //         .status(200)
        //         .type(MediaType.APPLICATION_JSON)
        //         .entity(sample1)
        //         .build();

        // System.out.println(datastreamservResponse.toString());


        // StringBuilder

        String actionMetaData = String.format("{ \"index\" : { \"_index\" : \"%s\", \"_id\" : \"%s\" } }%n", "index", "_id");

        List<String> bulkData = new ArrayList<>(); // a list of your documents in JSON strings
        bulkData.add("one");
        bulkData.add("two");
        bulkData.add("three");
        StringBuilder bulkRequestBody = new StringBuilder();
        for (String bulkItem : bulkData) {
            bulkRequestBody.append(actionMetaData);
            bulkRequestBody.append(bulkItem);
            bulkRequestBody.append("\n");
        }
        System.out.println(bulkRequestBody.toString());

        // JSONObject

        JSONObject obj = new JSONObject(sample1);
        obj.put("name", "mkyong.com");
        obj.put("age", 100);

        JSONObject obj1 = new JSONObject();
        obj1.put("name", "com");
        obj1.put("age", 10);

        JSONArray list = new JSONArray();
        list.put(obj1);

        obj.put("messages", list);

        System.out.println(obj);


        // Query builder
        MatchAllQueryBuilder maqb = QueryBuilders
                .matchAllQuery();

        Map <String, Float> fields = new HashMap<>();
        fields.put("fields1", 8.0f);
        MultiMatchQueryBuilder mmqb = QueryBuilders.multiMatchQuery("-1200 Amount", "transactionType","counterPartyName","netAmount.amount")
        .field("field1")
        .fields(fields)
        .operator(Operator.AND);

        String searchQuery = "{ \"query\" : %s }\n";
        System.out.println("qb======" + String.format(searchQuery, maqb.toString()));
        System.out.println("mmqb======" + String.format(searchQuery, mmqb.toString()));
    }

}