package com.xzj.sbtest.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RsaHelperTest {

    @Test
    public void initKey() throws Exception {
        Map<String, Object> keyMap = RsaHelper.initKey();

        byte[] publicKey = RsaHelper.getPublicKey(keyMap);
        byte[] privateKey = RsaHelper.getPrivateKey(keyMap);

        System.out.println("公钥：\n" + Base64.encodeBase64String(publicKey));
        System.out.println("私钥：\n" + Base64.encodeBase64String(privateKey));
    }
}