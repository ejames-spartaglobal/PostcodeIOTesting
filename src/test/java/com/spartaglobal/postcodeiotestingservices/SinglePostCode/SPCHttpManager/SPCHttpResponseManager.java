package com.spartaglobal.postcodeiotestingservices.SinglePostCode.SPCHttpManager;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class SPCHttpResponseManager {

    private CloseableHttpResponse spcResponse;

    public void setFullResponse(CloseableHttpResponse closeableHttpResponse){
        spcResponse = closeableHttpResponse;
    }

    public String getResponseBody(){
        String responseBody = null;
        try {
            responseBody = EntityUtils.toString(spcResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseBody;
    }
}
