package hu.schoherz.training.webshop.servlets;

import hu.schoherz.training.webshop.pojo.BlogPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2016.07.22..
 */
public class Index extends HttpServlet{
    private List<BlogPost> blogs = new ArrayList<BlogPost>();

    private static int postId=0;

    private static final String POST_AUTHOR = "name";
    private static final String POST_TITLE = "title";
    private static final String POST_CONTENT = "textarea";
    private static final String POST_POSTS = "posts";
    private static final String COMMENTER_INPUT_NAME = "name";
    private static final String ENCODING = "utf-8";
    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding(ENCODING);
        res.setCharacterEncoding(ENCODING);
        postId++;
        BlogPost blog = new BlogPost(Integer.toString(postId), req.getParameter(POST_AUTHOR),req.getParameter(POST_TITLE),req.getParameter(POST_CONTENT));
        blogs.add(blog);

        req.getSession().setAttribute(POST_POSTS, this.blogs);
        res.sendRedirect("Index");
    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {

        String title = "Available Blogs";
        res.setContentType("text/html; charset=utf-8");
        String lnk="";
        PrintWriter out = res.getWriter();

        try {
            out.println("<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">");
            out.println("<html>");
            out.println("<head><title>" + title + "</title></head>");
            out.println("<body bgcolor=\"#f0f0f0\">");
            out.println("<h1 align=\"center\">" + title + "</h1>");
            if (!blogs.isEmpty()) {
                out.println("<table>");
                for (BlogPost blog : blogs) {
                    lnk = blog.getAuthor() + " " + blog.getTitle() + " " + blog.getDateOfPosting();
                    out.println("<td><a href='ViewBlogPost?key1=" + blog.getId() + "'>" + lnk +"</td></tr>");
                }
                out.println("</table>");
                out.println("<form action='BlogPostServlet' method='Post'>");
                out.println("<button type='submit'>Add new post</button>");
                out.println("</form>");
                out.println("</body></html>");
            } else {
                out.println("<div>There is no blogpost yet</div>");
                out.println("<form action='BlogPostServlet' method='Post'>");
                out.println("<button type='submit'>Create BlogPost</button>");
                out.println("</form>");
            }
        }	finally {
            out.close();
        }
    }
}
