package com.example.demo.security;

import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


@Service
public class SecureDataTreatment {

    private static final String ALGORITHM = "";
    private static final int  IV_LENGTH = 12;
    private static final int TAG_LENGTH = 128;

    /*
    private final SecretKey key;
    private final SecureRandom random = new SecureRandom();

    public String encrypt (String message) throws NoSuchPaddingException, NoSuchAlgorithmException {
        byte[] iv = new byte[IV_LENGTH];
        random.nextBytes(iv);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        Cipher.init(Cipher.ENCRYPT_MODE, key, new GCMParameterSpec(TAG_LENGTH, iv));
        byte[] cipherText = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));





    }
    */
}
