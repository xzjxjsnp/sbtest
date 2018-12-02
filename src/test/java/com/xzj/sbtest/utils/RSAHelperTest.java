package com.xzj.sbtest.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RSAHelperTest {

    @Test
    public void initKey() throws Exception {
        Map<String, Object> keyMap = RSAHelper.initKey();

        byte[] publicKey = RSAHelper.getPublicKey(keyMap);
        byte[] privateKey = RSAHelper.getPrivateKey(keyMap);

        System.out.println("公钥：\n" + Base64.encodeBase64String(publicKey));
        System.out.println("私钥：\n" + Base64.encodeBase64String(privateKey));
    }
}