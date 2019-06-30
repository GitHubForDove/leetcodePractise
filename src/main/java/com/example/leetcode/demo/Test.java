package com.example.leetcode.demo;


import org.springframework.util.StringUtils;
import org.thymeleaf.expression.Lists;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-06-13
 * @descript xx
 */
public class Test {


    public static void main(String[] args) {


        /*Date date = new Date();
        System.out.println(date);
        long dateTime = date.getTime();
        System.out.println("long dateTime : -->" + dateTime);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = new Date(dateTime );

        System.out.println(date1);

        String dateStr = formatter.format(dateTime);
        System.out.println(dateStr);*/

        /*List<String> reminders = new ArrayList<>();
        reminders.add("liying84");
        String remindersStr2 = reminders.toString();
        String remindersStr3 = String.join(",",reminders);
        remindersStr2.replace("[","");
        remindersStr2.replace("]","");
        System.out.println(remindersStr2);
        System.out.println(remindersStr3);


        reminders.add("zhanghao66");
        reminders.add("zhangsan77");
        String remindersStr = String.join(",",reminders);
        System.out.println(remindersStr);
        String reason = null;
        System.out.println(reason);*/

        Map<String,String> params = new HashMap<String,String>();

        List<String> keys = new ArrayList<>();
        for (Map.Entry<String,String> entry : params.entrySet()) {
            keys.add(entry.getKey());
        }

        for (String key : keys) {

        }

        //List<String> keys = Lists.newArrayList(params.keySet());


        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY,14);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginDate = new Date();
        Date endDate = calendar.getTime();

        System.out.println(beginDate);
        System.out.println(sdf.format(beginDate));

        System.out.println(endDate);
        System.out.println(sdf.format(endDate));
    }
}
