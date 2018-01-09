package io.github.shibadog.ragdoll.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

import io.github.shibadog.ragdoll.exception.ApplicationException;

@Service
public class Util {

    public static String generateHash(long index, String previousHash, long generateTime, String data) throws ApplicationException {
        return generateHash(puls(index, previousHash, generateTime, data), "SHA-256");
    }

    public static String generateHash(String data, String algorithm) throws ApplicationException {
        String hash = null;
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(data.getBytes());
            byte[] cipher_byte = md.digest();
            StringBuilder sb = new StringBuilder(2 * cipher_byte.length);
            for(byte b: cipher_byte) {
                    sb.append(String.format("%02x", b&0xff) );
            }
            hash = sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            throw new ApplicationException("ブロックのハッシュ生成に失敗しました。", ex);
        }

        return hash;
    }

    public static String puls(long index, String previousHash, long generateTime, String data) {
        return String.format("%d%s%d%s", index, previousHash, generateTime, data);
    }
}