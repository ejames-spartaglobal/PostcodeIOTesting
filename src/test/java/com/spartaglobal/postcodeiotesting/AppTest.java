package com.spartaglobal.postcodeiotesting;

import static org.junit.Assert.assertTrue;

import com.spartaglobal.postcodeiotestingservices.MultiPostCode.MPCHttpManagement.MPCHttpCallManager;
import com.spartaglobal.postcodeiotestingservices.MultiPostCode.MPCJsonGenerator;
import com.spartaglobal.postcodeiotestingservices.MultiPostCode.MPCService;
import com.spartaglobal.postcodeiotestingservices.SinglePostCode.SPCHttpManager.SPCHttpCallManager;
import com.spartaglobal.postcodeiotestingservices.SinglePostCode.SPCHttpManager.SPCHttpResponseManager;
import com.spartaglobal.postcodeiotestingservices.SinglePostCode.SPCService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

private static MPCService mpcService;

    @BeforeClass
    public static void setup(){
        mpcService=new MPCService();
        mpcService.executeMPCPostRequest("n52ur,ts160rn");
    }

    @Test
    public void shouldAnswerWithTrue()
    {
//        System.out.println(mpcService.getParsedJSONResponse().getResult().get(1));

        System.out.println(mpcService.getParsedJSONResponse().getStatus());
    }
}
