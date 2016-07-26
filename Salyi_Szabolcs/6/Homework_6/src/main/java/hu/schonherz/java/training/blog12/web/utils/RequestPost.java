package hu.schonherz.java.training.blog12.web.utils;

/**
 * Created by Home on 2016. 07. 25..
 */
public class RequestPost {

    public static int getPostNumber(StringBuffer stringBuffer){

        return Integer.parseInt(stringBuffer.substring(stringBuffer.length()-1));

    }
}
