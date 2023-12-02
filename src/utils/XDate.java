/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author sang
 */
public class XDate {
    static SimpleDateFormat formater = new SimpleDateFormat();
    public static Date toDate(String date,String pattern){
        if (pattern.isEmpty()) {
            pattern="dd-MM-yyyy";
        }
        try {
            formater.applyPattern(pattern);
            return formater.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException();
        }
    }
    // chuyển đổi string sang date
    //date là string cần chuyển
    //pattern là định dạng thời gian
    //return date kết quả

    public static String toString(Date date,String pattern){
        if (pattern.isEmpty()) {
            pattern="dd-MM-yyyy";
        }
        formater.applyPattern(pattern);
        return formater.format(date);
    }
    public static Date now(){
        return new Date();
    }
     // chuyển đổi string sang date
    //date thời gian hiện có
    //days số ngày cần bổ sung vào date
    //return Date kết quả
    public static Date addDays(Date date,Long days){
        date.setTime(date.getTime()+days*24*60*60*1000);
        return date;
    }
    public static boolean checkDataDay (Date date) {
        Date ngayBatDau = new Date(2022 - 1900, 0, 1);
        if (date.after(XDate.now()) || ngayBatDau.after(date)) {
            DialogHelper.alert(null, "Thời gian vượt ngoài khoảng thời gian hoạt động");
            return false;
        }
        return true;
    }
    
    public static boolean checkDataYear (int year) {
        if (year > XDate.now().getYear() || year < 2022) {
            DialogHelper.alert(null, "Thời gian vượt ngoài khoảng thời gian hoạt động");
            return false;
        }
        return true;
    }
}
