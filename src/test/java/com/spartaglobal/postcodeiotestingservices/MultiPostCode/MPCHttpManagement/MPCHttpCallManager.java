package com.spartaglobal.postcodeiotestingservices.MultiPostCode.MPCHttpManagement;

import com.spartaglobal.postcodeiotestingservices.MultiPostCode.MPCJsonGenerator;
import com.spartaglobal.postcodeiotestingservices.SinglePostCode.URLConfig;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.imageio.IIOException;
import java.io.IOException;

public class MPCHttpCallManager {

    MPCJsonGenerator mpcJsonGenerator;


    public MPCHttpCallManager() {
        mpcJsonGenerator=new MPCJsonGenerator();
    }

    public CloseableHttpResponse executeMultiplePCPostRequest(String listOfPostcodesSplitByComma){
        CloseableHttpResponse MPCResponse=null;

        try {
            CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
            HttpPost postMPC=new HttpPost(URLConfig.baseURL+URLConfig.singlePostCodesEndpoint);
            postMPC.setHeader("Content-Type","application/json");
            postMPC.setEntity(mpcJsonGenerator.createMPCJsonQuery(listOfPostcodesSplitByComma));
            MPCResponse=closeableHttpClient.execute(postMPC);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return MPCResponse;
    }
}
