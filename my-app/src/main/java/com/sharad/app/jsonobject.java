package com.sharad.app;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.core.Response;

public class jsonobject {

    public static void main(String[] args) {


        String sample1 = "{\"took\": 16,\"errors\": false,\"items\": [{\"index\": {\"_seq_no\": 109,\"_type\": \"summarytransaction\",\"_version\": 27,\"_shards\": {\"total\": 2,\"successful\": 2,\"failed\": 0},\"_id\": \"1\",\"_index\": \"cs_transaction_index\",\"result\": \"updated\",\"_primary_term\": 1,\"status\": 200}}]}";

        Response datastreamservResponse = Response
                .status(200)
                .type(MediaType.APPLICATION_JSON)
                .entity(sample1)
                .build();

        JSONObject obj = new JSONObject(sample1);
        // obj.put("name", "mkyong.com");
        // obj.put("age", 100);

        // JSONObject obj1 = new JSONObject();
        // obj1.put("name", "com");
        // obj1.put("age", 10);

        // JSONArray list = new JSONArray();
        // list.put(obj1);

        // obj.put("messages", list);


        System.out.print(obj);

    }

}