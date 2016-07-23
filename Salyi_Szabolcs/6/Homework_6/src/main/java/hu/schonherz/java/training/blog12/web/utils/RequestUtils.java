package hu.schonherz.java.training.blog12.web.utils;


import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.servlet.http.HttpServletRequest;


/**
 * Created by Home on 2016. 07. 18..
 */

/**
 * Methods for HTTP request.
 */
public class RequestUtils {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(RequestUtils.class);

    /**
     *  The method gets an HTTPServletRequest and reads the key value pairs from its body
     *
     * @param req Instance of HTTPServletRequest
     *
     * @return instance of Java Properties, entries from request body
     */
    public static Map<String, String> parseFromBody(final HttpServletRequest req){

        Map<String, String> formData = new HashMap<>();

        try (Scanner sc = new Scanner(req.getReader())){

            sc.useDelimiter("=|&");

            while(sc.hasNext()){
                String key = URLDecoder.decode(sc.next(), "UTF-8");
                String value = URLDecoder.decode(sc.next(), "UTF-8");
                formData.put( key , value );
            }
        } catch (final IOException e) {
            LOG.warn("Error while parsing request body!");
        }
        return formData;
    }

    private RequestUtils() {
    }
}
