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
        name = "MyServlet",
        urlPatterns = {"/result"}
    )

public class HelloServlet extends HttpServlet
{
  @Override
   protected void doPost  (HttpServletRequest req, HttpServletResponse res)
          throws ServletException, IOException
   {

     String para;
     Enumeration paraNames = req.getParameterNames();

     StringBuilder responseStr = new StringBuilder("");

     responseStr.append("<table cellSpacing=1 cellPadding=1 width=\"75%\" border=1 bgColor=lavender>");
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


     req.setAttribute("params", responseStr); // Will be available as ${products} in JSP
     req.getRequestDispatcher("/result.jsp").forward(req, res);
//        res.setContentType ("text/html");
//        PrintWriter out = res.getWriter ();
//
//        out.println ("<HTML>");
//        out.println ("<HEAD>");
//        out.println ("<TITLE>A simple servlet program</TITLE>");
//        out.println ("</HEAD>");
//
//        out.println ("<BODY>");
//        out.println ("<CENTER>");
//
//        out.println (" <B>Hello!</B><BR> <!--  English -->");
//        out.println (" <B>Alo!</B><BR> <!--  Portuguese -->");
//        out.println (" <B>Anyong haseyo!</B><BR> <!--  Korean -->");
//        out.println (" <B>Apa Kabar!</B><BR> <!--  Indonesian -->");
//        out.println (" <B>Ave!</B><BR> <!--  Latin -->");
//        out.println (" <B>Bon jour!</B><BR> <!--  French -->");
//        out.println (" <B>Ciao!</B><BR> <!--  Italian -->");
//        out.println (" <B>Hajur!</B><BR> <!--  Nepali (India) -->");
//        out.println (" <B>Hallo!</B><BR> <!--  German -->");
//        out.println (" <B>Hej!</B><BR> <!--  Swedish -->");
//        out.println (" <B>Hei!</B><BR> <!--  Norwegian -->");
//        out.println (" <B>Hola!</B><BR> <!--  Spanish -->");
//        out.println (" <B>Kaise ho!</B><BR> <!--  Hindi (depending on who you believe) -->");
//        out.println (" <B>Kem Chho, Kem Che!</B><BR> <!--  Gujurati (India) -->");
//        out.println (" <B>Ki Khobor!</B><BR> <!--  Bengali -->");
//        out.println (" <B>Marhaba!</B><BR> <!--  Arabic -->");
//        out.println (" <B>Moin Moin!</B><BR> <!--  German, Hamburg -->");
//        out.println (" <B>Moni!</B><BR> <!--  Chichewa -->");
//        out.println (" <B>Namaskaram!</B><BR> <!--  Telugu (India) -->");
//        out.println (" <B>Namskar!</B><BR> <!--  Hindi -->");
//        // Why do I keep getting different words in Hindi?
//        // out.println (" <B>Namaste!</B><BR> <!--  Hindi -->");
//        // out.println (" <B>Namastar!</B><BR> <!--  Hindi -->");
//        out.println (" <B>Konnichiwa!</B><BR> <!--  Japanese -->");
//        out.println (" <B>Manh gioi!</B><BR> <!--  Vietnamese -->");
//        out.println (" <B>Marhabai!</B><BR> <!--  Arab -->");
//        out.println (" <B>Ni hao!</B><BR> <!--  Chinese -->");
//        out.println (" <B>Shalom!</B><BR> <!--  Hebrew -->");
//        out.println (" <B>Sallam!</B><BR> <!--  Persian -->");
//        out.println (" <B>Sat-Sri-Akal!</B><BR> <!--  Punjabi (India) -->");
//        out.println (" <B>Strasvedte!</B><BR> <!--  Russian -->");
//        out.println (" <B>Yah-shimu-siz!</B><BR> <!--  Uighur -->");
//        out.println (" <B>Zhao  Shen!</B><BR> <!-- Cantonese -->");
//
//        out.println ("<P>");
//        out.println ("For a longer listing of \"hellos\" to the world, go see");
//        out.println ("<A HREF=\"http://www.ipl.org/youth/hello/\">http://www.ipl.org/youth/hello/</A>");
//
//        out.println ("</CENTER>");
//        out.println ("</BODY>");
//
//        out.println ("</HTML>");
//        out.flush();
//
//        out.close ();
    }


//  public void doPost(HttpServletRequest req, HttpServletResponse response)
//    throws ServletException, IOException
//  {
//    // first, set the "content type" header of the response
//    response.setContentType ("text/html");
//    //Get the response's PrintWriter to return text to the client.
//    PrintWriter toClient = response.getWriter ();
//
//    String para;
//    Enumeration paraNames = req.getParameterNames();
//
//    toClient.println("<html>");
//    toClient.println("<head>");
//    toClient.println("  <title>Generic form handler</title>");
//    toClient.println("</head>");
//
//    toClient.println("<body bgcolor=\"#EEEEEE\">");
//    toClient.println("");
//    toClient.println("<center><h2>Generic form handler</h2></center>");
//    toClient.println("<p>");
//    toClient.println("The following table lists all parameter names and");
//    toClient.println("their values that were submitted from your form.");
//    toClient.println("</p>");
//    toClient.println("");
//    toClient.println("<p>");
//    toClient.println("<table cellSpacing=1 cellPadding=1 width=\"75%\" border=1 bgColor=lavender>");
//    toClient.println("");
//    toClient.println("  <tr bgcolor=\"#FFFFFF\">");
//    toClient.println("   <th align=\"center\"><b>Parameter</b></td>");
//    toClient.println("   <th align=\"center\"><b>Value</b></td>");
//    toClient.println("  </tr>");
//
//    while (paraNames.hasMoreElements())
//    {  // For each parameter name.
//      para = (String)paraNames.nextElement();
//      if (!para.equalsIgnoreCase("submit"))
//      {
//        toClient.println("  <tr>");
//        toClient.println("    <td style=\"width: 20%\" width=\"20%\"><b>" + para + "</b></td>");
//
//        String[] values = req.getParameterValues(para);
//
//        if (values != null && !values[0].equals(""))
//          toClient.println("    <td>" + values[0] + "</td></tr>");
//        else
//          toClient.println("    <td>&nbsp;</td></tr>");
//
//        for (int i = 1; i < values.length; i++)
//        {
//          if (!values[i].equals(""))
//          {
//            toClient.println("  <tr>");
//            toClient.println("    <td style=\"width: 20%\" width=\"20%\">&nbsp;</td>");
//            toClient.println("    <td>" + values[i] + "</td></tr>");
//          }
//        }
//      }
//    }
//    toClient.println("</table>");
//    toClient.println("");
//    toClient.println("</body>");
//    toClient.println("</html>");
//
//    toClient.println("");
//
//    // Close the writer; the response is done.
//    toClient.close();
//  } //end of doPost()
}
