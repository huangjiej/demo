package com.hummingbird.demo.util;
/**
 * 数字转中文
 * @author liudou
 *
 */
public class FundNameUtil {
	public static String numToCh(int num){
        switch (num){
        case 1 :  return "一";
        case 2 : return "二";
        case 3 : return "三";
        case 4 : return "四";
        case 5 : return "五";
        case 6 : return "六";
        case 7 : return "七";
        case 8 : return "八";
        case 9 : return "九";
        default : return "零";
        }
    }
    
    public static String outCh(int num){
        String str1 = numToCh(num%10);
        String answer=null;
        if(num/10<=0){
        	answer= str1;
        }else if(num/10>0){
            String str2 = numToCh((num%100)/10) + "十";
            if(num/100<=0){
                if(num%10==0){
                	answer= str2;
                }else{
                	answer= str2+str1;
                }
            }
        }
        return answer;
    }
}
