package hu.schonherz.training.utils;

import hu.schonherz.training.models.PostsList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by Attila on 2016.07.22..
 */
public class RequestUtils {
    private static final Logger LOG = LoggerFactory.getLogger(RequestUtils.class);

    private RequestUtils(){}

    public static Properties readRequest(HttpServletRequest req) {
        Properties properties = new Properties();

        if (!req.getContentType().equalsIgnoreCase("application/x-www-form-urlencoded")) {
            return properties;
        }

        try (Scanner sc = new Scanner(req.getReader())) {
            System.out.print(req.getReader());
            sc.useDelimiter("=|&");
            while (sc.hasNext()) {
                String key = URLDecoder.decode(sc.next(), "utf-8");
                String value = "";
                if (sc.hasNext()) {
                    value = URLDecoder.decode(sc.next(), "utf-8");
                }
                properties.put(key, value);
            }
        } catch (final IOException e) {
            LOG.error("Error while process request.", e);
        }
        return properties;
    }

    public static PostsList readPostsListsFromContext(final HttpServletRequest req){
        ServletContext context = req.getServletContext();
        if (context.getAttribute("posts") == null) {
            context.setAttribute("posts", new PostsList());
        }
        return (PostsList) context.getAttribute("posts");
    }
}
