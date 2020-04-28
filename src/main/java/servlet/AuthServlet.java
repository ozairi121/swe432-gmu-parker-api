package servlet;
// From "Professional Java Server Programming", Patzer et al.,

// Import Servlet Libraries
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

// Import Java Libraries
import java.io.*;
import java.util.Date;

import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@WebServlet(
  name = "AuthServlet",
  urlPatterns = {"/auth"}
)

public class AuthServlet extends HttpServlet
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

  public void doPost (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    HttpSession session = request.getSession();

    JSONObject convertedObject = new Gson().fromJson(request.getReader(), JSONObject.class);

    String username = convertedObject.get("user").toString();
    System.out.print(username);

    PrintWriter out = response.getWriter();
    JSONObject resObj = new JSONObject();

    if (username == null) {
      out.print(false);
      resObj.put("success", true);
      out.println(resObj.toJSONString());
      response.setStatus(400);
    }
    else {
      out.print(true);
      session.setAttribute("user", username);
      resObj.put("success", true);
      out.println(resObj.toJSONString());
    }

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    out.close();
  }

  public void doGet (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    String action = request.getParameter("action");

    if (action != null && action.equals("invalidate"))
    {  // Called from the invalidate button, kill the session.
      // Get session object
      HttpSession session = request.getSession();
      session.invalidate();

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      out.println("<html>");
      out.println("<head>");
      out.println(" <title>Session lifecycle</title>");
      out.println("</head>");
      out.println("");
      out.println("<body>");

      out.println("<p>Your session has been invalidated.</P>");

      // Create a link so the user can create a new session.
      // The link will have a parameter builtin
      String lifeCycleURL = "/session";
      out.println("<a href=\"" + lifeCycleURL + "?action=newSession\">");
      out.println("Create new session</A>");

      out.println("</body>");
      out.println("</html>");
      out.close();
    } //end if
    else
    {  // We were called either directly or through the reload button.
      // Get session object
      HttpSession session = request.getSession();

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      out.println("<html>");
      // no-cache lets the page reload by clicking on the reload link
      out.println("<meta http-equiv=\"Pragma\" content=\"no-cache\">");
      out.println("<head>");
      out.println(" <title>Session lifecycle</title>");
      out.println("</head>");
      out.println("");

      out.println("<body>");
      out.println("<h1><center>Session life cycle</center></h1>");
      out.print  ("<BR>Session status: ");
      if (session.isNew())
      {
        out.println ("New session.");
      }
      else
      {
        out.println ("Old session.");
      }
      // Get the session ID
      out.print  ("<br>Session ID: ");
      out.println(session.getId());
      // Get the created time, convert it to a Date object
      out.print  ("<br>Creation time: ");
      out.println(new Date (session.getCreationTime()));
      // Get the last time it was accessed
      out.print  ("<br>Last accessed time: ");
      out.println(new Date(session.getLastAccessedTime()));
      // Get the max-inactive-interval setting
      out.print  ("<br>Maximum inactive interval (seconds): ");
      out.println(session.getMaxInactiveInterval());

      String lifeCycleURL = "/session";
      out.print  ("<br><br><a href=\"" + lifeCycleURL + "?action=invalidate\">");
      out.println("Invalidate the session</a>");
      out.print  ("<br><a href=\"" + lifeCycleURL + "\">");
      out.println("Reload this page</a>");

      out.println("</body>");
      out.println("</html>");
      out.close();
    } //end else
  } // End doGet
} //End  sessionLifeCycle