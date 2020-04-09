package servlet;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "EchoServlet",
        urlPatterns = {"/echo"}
    )

public class EchoServlet extends HttpServlet
{
  @Override
   protected void doPost  (HttpServletRequest req, HttpServletResponse res)
          throws ServletException, IOException
   {
    res.setHeader("Access-Control-Allow-Origin", "*");
    res.setHeader("Access-Control-Allow-Methods", "GET, POST");
    res.setHeader("Access-Control-Allow-Headers", "Content-Type");
    res.setHeader("Access-Control-Max-Age", "86400"); // probably optional

     PrintWriter pw = res.getWriter();

     String para;
     Enumeration paraNames = req.getParameterNames();

     StringBuilder responseStr = new StringBuilder("");

     while (paraNames.hasMoreElements())
     {  // For each parameter name.
       para = (String)paraNames.nextElement();
       if (!para.equalsIgnoreCase("submit"))
       {
         responseStr.append("  <tr>");
         responseStr.append("    <td style=\"width: 20%\" width=\"20%\"><b>" + para + "</b></td>");

         String[] values = req.getParameterValues(para);

         if (values != null && !values[0].equals(""))
           responseStr.append("    <td>" + values[0] + "</td></tr>");
         else
           responseStr.append("    <td>&nbsp;</td></tr>");

         for (int i = 1; i < values.length; i++)
         {
           if (!values[i].equals(""))
           {
             responseStr.append("  <tr>");
             responseStr.append("    <td style=\"width: 20%\" width=\"20%\">&nbsp;</td>");
             responseStr.append("    <td>" + values[i] + "</td></tr>");
           }
         }
       }
     }
     responseStr.append("</table>");

     req.setAttribute("params", responseStr); // Will be available as ${params} in JSP

     pw.println(responseStr);
     pw.close();
  } //end of doPost()

  @Override
   protected void doOptions  (HttpServletRequest req, HttpServletResponse res)
          throws ServletException, IOException
   {
    res.setHeader("Access-Control-Allow-Origin", "*");
    res.setHeader("Access-Control-Allow-Methods", "GET, POST");
    res.setHeader("Access-Control-Allow-Headers", "Content-Type");
    res.setHeader("Access-Control-Max-Age", "86400"); // probably optional
    res.setStatus(HttpServletResponse.SC_OK)
  } //end of doOptions()
}
