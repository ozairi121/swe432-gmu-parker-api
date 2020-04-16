package servlet;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.internal.$Gson$Types;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@WebServlet(
        name = "ReviewServlet",
        urlPatterns = {"/reviews"}
    )

public class ReviewServlet extends HttpServlet
{
  @Override
  protected void doOptions  (HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    res.setHeader("Access-Control-Allow-Origin", "*");
    res.setHeader("Access-Control-Allow-Methods", "GET, POST");
    res.setHeader("Access-Control-Allow-Headers", "Content-Type");
    res.setHeader("Access-Control-Max-Age", "86400"); // probably optional
    res.setStatus(HttpServletResponse.SC_OK);
  } //end of doOptions()

    @Override
   protected void doGet  (HttpServletRequest req, HttpServletResponse res)
          throws ServletException, IOException
   {
     res.setHeader("Access-Control-Allow-Origin", "*");
     res.setHeader("Access-Control-Allow-Methods", "GET, POST");
     res.setHeader("Access-Control-Allow-Headers", "Content-Type");
     res.setHeader("Access-Control-Max-Age", "86400"); // probably optional
     res.setStatus(HttpServletResponse.SC_OK);

     PrintWriter pw = res.getWriter();
     JSONParser jsonParser = new JSONParser();
     try
     {
       System.out.println( getServletContext().getRealPath(""));
       FileReader reader = new FileReader(getServletContext().getRealPath("")+"reviews.json");
       Object obj = jsonParser.parse(reader);
       JSONArray reviewList = (JSONArray) obj;


       res.setContentType("application/json");
       res.setCharacterEncoding("UTF-8");
       pw.println(reviewList.toJSONString());
       pw.close();

     } catch (Exception e) {
       e.printStackTrace();
     }
   }

   @Override
   protected void doPost  (HttpServletRequest req, HttpServletResponse res)
          throws ServletException, IOException
   {
     res.setHeader("Access-Control-Allow-Origin", "*");
     res.setHeader("Access-Control-Allow-Methods", "GET, POST");
     res.setHeader("Access-Control-Allow-Headers", "Content-Type");
     res.setHeader("Access-Control-Max-Age", "86400"); // probably optional
     res.setStatus(HttpServletResponse.SC_OK);

     PrintWriter pw = res.getWriter();
     Gson gson = new Gson();

     // Put request body into the review object
     Review newReview = gson.fromJson(req.getReader(), Review.class);

     // Set created time
     newReview.date = new Date().getTime();

     // Validate
     boolean validated = newReview.validate();

     if (!validated) {
       pw.println("Error: Unable to process the new review. Check that all data sent is valid.");
     } else {
       pw.println(gson.toJson(newReview));
     }

     res.setContentType("application/json");
     res.setCharacterEncoding("UTF-8");
     pw.close();

  }
}
