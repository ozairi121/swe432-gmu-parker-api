package servlet;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Enumeration;

// Import Servlet Libraries
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(
  name = "TestServlet",
  urlPatterns = {"/test"}
)

public class TestServlet extends HttpServlet {
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
}
