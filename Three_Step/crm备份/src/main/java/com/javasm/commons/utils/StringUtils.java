package com.javasm.commons.utils;

import java.util.concurrent.ThreadLocalRandom;

 class StringUtils {

    public static String randomValiCode() {
        int minNumber = 111111;
        int maxNumber = 666666;

        ThreadLocalRandom random = ThreadLocalRandom.current();
        int num = random.nextInt(minNumber, maxNumber);

        return Integer.toString(num);

    }

    public static void main(String[] args) {
        System.out.println(randomValiCode());
    }
}
