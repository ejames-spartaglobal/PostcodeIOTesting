package com.spartaglobal.postcodeiotestingservices.MultiPostCode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spartaglobal.postcodeiotestingservices.MultiPostCode.MPCDTO.MPCDTO;
import com.spartaglobal.postcodeiotestingservices.MultiPostCode.MPCHttpManagement.MPCHttpCallManager;
import com.spartaglobal.postcodeiotestingservices.MultiPostCode.MPCHttpManagement.MPCResponseManager;

public class MPCService {
    private MPCHttpCallManager mpcHttpCallManager;
    private MPCResponseManager mpcResponseManager;
    private ObjectMapper objectMapper;

    public MPCService() {
        this.mpcHttpCallManager=new MPCHttpCallManager();
        this.mpcResponseManager=new MPCResponseManager();
        this.objectMapper=new ObjectMapper();
    }

    public void executeMPCPostRequest(String listOfPostCodesSplitByComma){
        mpcResponseManager.setFullResponse(mpcHttpCallManager.executeMultiplePCPostRequest(listOfPostCodesSplitByComma));
    }

    public MPCDTO getParsedJSONResponse(){
        MPCDTO parsedResponse=null;

        try {
            parsedResponse=objectMapper.readValue(mpcResponseManager.getResponseBody(),MPCDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return parsedResponse;
    }
}
