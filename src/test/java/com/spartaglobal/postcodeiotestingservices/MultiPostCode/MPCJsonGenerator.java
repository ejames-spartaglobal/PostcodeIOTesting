package com.spartaglobal.postcodeiotestingservices.MultiPostCode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.apache.http.entity.StringEntity;

public class MPCJsonGenerator {

    //{"postcodes":["n52ur","ts160rn"]}
    private ObjectMapper objectMapper = new ObjectMapper();

    public StringEntity createMPCJsonQuery(String listOfPostcodesSplitByComma){
        ArrayNode postcodeArrayNode=objectMapper.createArrayNode();
        String MPCBaseNode="{\"postcodes\":";
        String MPCClosingJsonBracket="}";
        String[]postcodeArray=listOfPostcodesSplitByComma.split(",");
        for (String postcode:postcodeArray){
            postcodeArrayNode.add(postcode.replaceAll("\\s",""));
        }
        System.out.println(MPCBaseNode+postcodeArrayNode+MPCClosingJsonBracket);
        return new StringEntity(MPCBaseNode+postcodeArrayNode+MPCClosingJsonBracket,"UTF-8");
    }

}
