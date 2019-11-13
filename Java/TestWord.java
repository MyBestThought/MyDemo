package com.yht.example1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class TestWord {
    public static void main(String[] args) throws Exception {
        Reader in = new FileReader("");

        /**
         * 统计一个文本文件中，有多少个字符
         * Reader默认查找的码表是与操作系统一致的码表，我们的操作系统是中文的，所以Reader就会使用GBK码表
         * GBK中一个中文占两个字节，且汉字的两个字节都是1开头。UTF-8中一个中文占三个字节
         * 读取到记事本中的文字--->GBK--->UNICODE
         */

        BufferedReader br = new BufferedReader(in);
        String line = null;

        StringBuilder sb = new StringBuilder("");

        while((line = br.readLine()) != null){
            sb.append(line);
            sb.append(" ");
        }

//        String[] words = sb.toString().split("[^a-zA-z]+");
        String[] words = sb.toString().split("[.!?。]+");

        System.out.println(words.length);
        in.read();
        in.close();

    }
}




