package com.thomson.concurrent.cookbook.ch5.joining;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类说明
 *
 * @author Thomson Tang
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        Date parse = sdf.parse("2018-10-12");
        String date = sdf.format(new Date());
        System.out.println("end." + date);
    }
}
