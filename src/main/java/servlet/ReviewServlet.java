package servlet;

import java.io.*;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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

     try {

       // Put request body into the review object
       Review newReview = gson.fromJson(req.getReader(), Review.class);

       // Set created time
       newReview.time = new Date().getTime();

       // Validate
       boolean validated = newReview.validate();

       if (!validated) {
         pw.println("Error: Unable to process the new review. Check that all data sent is valid.");
       } else {
         boolean reviewAdded = addReview(newReview);
         if (!reviewAdded) {
           pw.println("Error: Unable to process the new review. Check that all data sent is valid.");
           return;
         }
         pw.println(gson.toJson(newReview));
       }

     } catch (Exception e) {
        pw.println("Error: Unable to process the new review.");
     }

     res.setContentType("application/json");
     res.setCharacterEncoding("UTF-8");
     pw.close();

  }

  protected boolean addReview  (Review newReview)
    throws ServletException, IOException
  {
    JSONParser jsonParser = new JSONParser();
    try
    {
      FileReader reader = new FileReader(getServletContext().getRealPath("")+"reviews.json");
      Object obj = jsonParser.parse(reader);
      JSONArray reviewList = (JSONArray) obj;
      reader.close();

      JSONObject newReviewObject = (JSONObject) jsonParser.parse(new Gson().toJson(newReview,  Review.class));

      JSONArray updatedReviewList = new JSONArray();
      updatedReviewList.add(newReviewObject);
      updatedReviewList.addAll(reviewList);

      FileWriter writer = new FileWriter(new File(getServletContext().getRealPath("")+"reviews.json"));
      writer.write(updatedReviewList.toString());
      writer.close();

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }
}
