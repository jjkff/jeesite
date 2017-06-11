package com.thinkgem.jeesite.sierac.unitTest;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import com.thinkgem.jeesite.common.utils.AddressUtils;

/**
 * 
 * Description: <br/>
 * date: 2017年4月12日 下午4:08:10 <br/>
 * 
 * @author jkf
 * @version
 */

public class AddressUtilsTest {

    @Test
    public void testAddressUtilsTest() {
        AddressUtils addressUtils = new AddressUtils();
        String ip = "222.59.135.134";
        String address = "";
        try {
            address = addressUtils.getAddresses("ip=" + ip, "utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(address);
    }
}
