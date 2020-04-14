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
  name = "IndexServlet",
  urlPatterns = {"/"}
)

public class IndexServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
    req.getRequestDispatcher("/index.jsp").forward(req, res);
  }

  @Override
  protected void doPost  (HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {

    String para;
    Enumeration paraNames = req.getParameterNames();

    StringBuilder responseStr = new StringBuilder("");

    responseStr.append("<table class=\"center mt-5\"cellSpacing=1 cellPadding=1 width=\"75%\" border=1 bgColor=lavender>");
    responseStr.append("");
    responseStr.append("  <tr bgcolor=\"#FFFFFF\">");
    responseStr.append("   <th align=\"center\"><b>Parameter</b></td>");
    responseStr.append("   <th align=\"center\"><b>Value</b></td>");
    responseStr.append("  </tr>");

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

    req.getRequestDispatcher("/review.jsp").forward(req, res);
  } //end of doPost()
}
