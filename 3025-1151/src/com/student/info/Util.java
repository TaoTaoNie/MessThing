package com.student.info;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public static int calculateAge(String birthDay) {
        if (birthDay == null || birthDay.length()<4) {
            return 0;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String cYear = sdf.format(new Date()).substring(0,4);
        String cMouth = sdf.format(new Date()).substring(5,7);
        String cDay = sdf.format(new Date()).substring(8,10);
        String birth_Year = birthDay .substring(0,4);
        String birth_Mouth = birthDay .substring(5,7);
        String birth_Day = birthDay .substring(8,10);
        int age = Integer.parseInt(cYear) - Integer.parseInt(birth_Year);
        if ((Integer.parseInt(cMouth) - Integer.parseInt(birth_Mouth))<0) {
            age=age-1;
        }else if ((Integer.parseInt(cMouth) - Integer.parseInt(birth_Mouth))==0) {
            if ( (Integer.parseInt(cDay) - Integer.parseInt(birth_Day))>0) {
                age=age-1;
            }else {
                age = Integer.parseInt(cYear) - Integer.parseInt(birth_Year);
            }
        }else if ((Integer.parseInt(cMouth) - Integer.parseInt(birth_Mouth))>0) {
            age = Integer.parseInt(cYear) - Integer.parseInt(birth_Year);
        }
        return age;
    }
}
