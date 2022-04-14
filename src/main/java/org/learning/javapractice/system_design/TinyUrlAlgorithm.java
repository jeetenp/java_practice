package org.learning.javapractice.system_design;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TinyUrlAlgorithm {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] input = "https://www.educative.io/courses/grokking-the-system-design-interview".getBytes("UTF-8");//args[0].getBytes("UTF-16");//"https://www.educative.io/courses/grokking-the-system-design-interview".getBytes("UTF-8");
        byte[] md5hash = messageDigest.digest(input);
        Base64.Encoder encoder = Base64.getEncoder();
        String encodeToString = encoder.encodeToString(md5hash);
        int shortKeyType =  3;//Integer.parseInt(args[1]);
        String tinyUrlKey = shortKeyType ==1 ? encodeToString.substring(0,6) : shortKeyType == 2 ? encodeToString.substring(0,8) : randomlySelect8Chars(encodeToString);
        System.out.println("ShortKey --> " + tinyUrlKey);

    }

    //Fisher yates algorithm
    private static String randomlySelect8Chars(String encodeToString) {
        Random random = ThreadLocalRandom.current();
        char[] encodedChars =  encodeToString.toCharArray();
        assert encodedChars.length == 21;
        for(int i=20; i >=0; i--) {
            int randomIndex =  random.nextInt(i+1);
            swap(encodedChars,randomIndex,i);
        }

        return new String(encodedChars,0,8);
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
