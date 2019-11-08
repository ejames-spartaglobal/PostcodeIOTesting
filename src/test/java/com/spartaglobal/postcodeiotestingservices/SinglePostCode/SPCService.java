package com.spartaglobal.postcodeiotestingservices.SinglePostCode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spartaglobal.postcodeiotestingservices.SinglePostCode.SPCDTO.SPCDTO;
import com.spartaglobal.postcodeiotestingservices.SinglePostCode.SPCHttpManager.SPCHttpCallManager;
import com.spartaglobal.postcodeiotestingservices.SinglePostCode.SPCHttpManager.SPCHttpResponseManager;

public class SPCService {

    private SPCHttpCallManager spcHttpCallManager;
    private SPCHttpResponseManager spcHttpResponseManager;
    private ObjectMapper objectMapper;


    public SPCService() {
        spcHttpCallManager = new SPCHttpCallManager();
        spcHttpResponseManager =new SPCHttpResponseManager();
        objectMapper = new ObjectMapper();
    }

    public void executeSPCCall(String postcode){
        spcHttpResponseManager.setFullResponse(spcHttpCallManager.executeSPCGetRequest(postcode));
    }

    public SPCDTO getParsedJsonResponse(){
        SPCDTO parsedResponse =null;
            try {
                parsedResponse = objectMapper.readValue(spcHttpResponseManager.getResponseBody(),SPCDTO.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return parsedResponse;

    }
}
