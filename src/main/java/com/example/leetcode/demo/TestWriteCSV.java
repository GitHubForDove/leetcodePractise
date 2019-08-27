package com.example.leetcode.demo;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Copyright (c) 2019 maoyan.com
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-07-18
 * @descript xx
 */
public class TestWriteCSV {

    public static void main(String[] args) {
        /*ConcurrentHashMap<String, String> data = new ConcurrentHashMap<String,String>();
        data.put("a","1");
        data.put("b","2");
        data.put("c","3");*/
        /*List<String[]> datas = Collections.synchronizedList(new ArrayList<String[]>());
        datas.add(new String[]{"a","1"});
        datas.add(new String[]{"b","2"});
        datas.add(new String[]{"c","3"});
        datas.add(new String[]{"d","4"});
        String path = "/tmp/";
        storeDataToCSV(datas, path);*/
        String path = "/tmp/20190720.csv";

        try {
            DataInputStream in = new DataInputStream(new FileInputStream(new File(path)));
            CSVReader csvReader = new CSVReader(new InputStreamReader(in, "UTF-8"));
            //List<String[]> datas = csvReader.readAll();
            //System.out.println(datas.size());
            String[] strs;
            while ((strs = csvReader.readNext()) != null) {
                System.out.println(strs[0]);
                System.out.println(strs[1]);
                System.out.println(Arrays.toString(strs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    // 存储文件
    private static void storeDataToCSV(List<String[]> contentArrayList, String path) {
        //文件名
        String fileName = path + new SimpleDateFormat("yyyyMMdd").format(new Date())+".csv";

        //判断文件是否存在，如果存在，先删除
        File file = new File(fileName);

        //if (file.exists())
        //    file.delete();

        try(CSVWriter writer = new CSVWriter(new FileWriter(file,true))) {
            writer.writeAll(contentArrayList,false);
        } catch (IOException e) {
            System.out.println("storeDateToCSV error."  +  e);
        }
    }

    private static void storeDateToCSV(ConcurrentHashMap<String,String> data, String path) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path),"utf-8"));
            for(Map.Entry<String, String> entry : data.entrySet()){
                out.write(entry.getKey() + "," + entry.getValue());
                out.newLine();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 关闭资源文件
            try {
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
