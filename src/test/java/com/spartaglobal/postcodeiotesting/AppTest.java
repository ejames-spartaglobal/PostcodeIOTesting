package com.spartaglobal.postcodeiotesting;

import static org.junit.Assert.assertTrue;

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

    private static SPCService spcService;

    @BeforeClass
    public static void setup(){
        spcService = new SPCService();
        spcService.executeSPCCall("n52ur");
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        Assert.assertEquals(200,spcService.getParsedJsonResponse().getStatus());
        Assert
    }
}
