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
  name = "PredicateServlet",
  urlPatterns = {"/predicates"}
)

public class PredicateServlet extends HttpServlet
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
      Predicate newPredicate = gson.fromJson(req.getReader(), Predicate.class);

      String[] variables = newPredicate.variables;
      String[] operators = newPredicate.operators;
      printTruthTable(variables.length, 0, new int[variables.length], operators, res);
    } catch (Exception e) {
      e.printStackTrace();
      pw.println("Error: Unable to process the new review.");
    }
//
//    res.setContentType("text/html");
//    res.setCharacterEncoding("UTF-8");
    pw.close();

  }


  public void printTruthTable(int N, int index, int[] truthVals, String[] clauses, HttpServletResponse res)
    throws ServletException, IOException {
    PrintWriter pw = res.getWriter();

    if (index == N) {
      int i = 0;
      pw.println("<tr>");
      for (i=0; i<N; i++) {
        pw.println("<td>" + truthVals[i] + "</td>");
        if (i == N-1) { // evaluate answer for row
          boolean answer;
          if (truthVals[0] == 0)
            answer = false;
          else
            answer = true;
          for (int y = 0; y < N-1; y++) {
            boolean tmp;
            if (truthVals[y+1] == 0)
              tmp = false;
            else
              tmp = true;
            if (clauses[y].equalsIgnoreCase("and")) {
              answer = answer && tmp;
            } else if (clauses[y].equalsIgnoreCase("or")) {
              answer = answer || tmp;
            } else if (clauses[y].equalsIgnoreCase("xor")) {
              answer = answer ^ tmp;
            }
          }
          if (answer)
            pw.println("<td class='border-left'>1</td>");
          else
            pw.println("<td class='border-left'>0</td>");
        }
      }
      pw.println("</tr>");
    } else {
      int i = 0;
      for (i=0; i<2; i++) {
        truthVals[index] = i;
        printTruthTable(N, index + 1, truthVals, clauses, res);
      }
    }
  }

}
