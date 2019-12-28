import java.io.*;
import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
import java.net.*;
import java.util.*;



public class search extends HttpServlet{
	//Connection object
	Connection theConnection;

	//Change StringdbURL according to your database url.

	//private  String dbURL = "jdbc:mysql://127.0.0.1:3306/roseindia_net?user=root&password=";

	private  String dbURL = "jdbc:mysql://10.0.0.1/javadevelopers?user=abc&password=abc";



	//private String servletURL="/servlet";    
	private String servletURL="http://www.webappcabaret.com/javadevelopers";    


	//private String image="/images/open.gif";
	private String image="http://www.roseindia.net/images/open.gif";

    public void init() throws ServletException{
	makeConnection();	
    }
    
    public void makeConnection(){
            //System.out.println("Opening db connection");
				try
				{
				     Class.forName("org.gjt.mm.mysql.Driver").newInstance();
					theConnection = DriverManager.getConnection(dbURL);
				}
				catch (Exception e)
				{
				//	System.out.println(e.getMessage());
				}
           // System.out.println("Connected to the database");
	
    }
    public void destory(){
	try{
	theConnection.close();
	}catch(Exception e){}
    }

    public void service (HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException
      {
	  //Get the session object
	  HttpSession session = req.getSession(true);
	  res.setContentType("text/html");
	  PrintWriter out = res.getWriter();

	 writeHead(out);
	
	String strSection = req.getParameter("section");
	String strCategory = req.getParameter("category");
	String strUnder = req.getParameter("under");
	String strLink = req.getParameter("link");
	String straddnew = req.getParameter("addnew");
	String striunder = req.getParameter("iunder");
	String strilink = req.getParameter("ilink");
	String strserno = req.getParameter("serno");
	String modifylink= req.getParameter("modifylink");
	String validate= req.getParameter("validate");
	String updatemodified = req.getParameter("updatemodified");
	String placelinks = req.getParameter("placelinks");
	String item= req.getParameter("item");





	if ( item!= null)
		searchitems(out,item);


	else if ( placelinks != null)
		placelinks(out);

	else if (updatemodified!= null)
		updateModified(out,req);

	else if (validate!= null)
		validateLogin(out,req);

	else if (modifylink!= null)
		displayLoginForm(out);
	else if (strserno != null)
		displayFinalResult(out,strserno);
	else if (straddnew != null && striunder != null && strilink!=null)
		updatenewEntry(out,straddnew,striunder,strilink,req);
	else if (strSection != null)
		displayCategories(out,strSection);
	else if (strCategory!= null)
		displayListings(out,strCategory);			
	else if (strUnder!= null)
		addListings(out,strUnder,strLink);			
	else

	 displaySections(out);

	 writeBottom(out);
	 out.close();
	}


	public void searchitems(PrintWriter pr,String item){

		Statement theStatement;
		ResultSet theResult;
            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\"><font color=\"#000080\" size=\"5\">Search results:</font></td>");
            pr.println("</tr>");
            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\">");
                pr.println("<div align=\"center\">");
                  pr.println("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"91%\" bgcolor=\"#FFFFFF\" bordercolor=\"#C6FFFF\">");

	
		String sql;
		sql="select serno,caption,descp from listings where caption like '%" + item + "%' or descp like '%" + item + "%'";

		try{
		if(theConnection == null) makeConnection();

		theStatement=theConnection.createStatement();
	      theResult=theStatement.executeQuery(sql); 
		
		int i;
		i=0;

	//	i=theResult.getFetchSize();


            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\">");
                pr.println("<b>");
                pr.println("This Page Will Show You The Final Hit.</font>");
                pr.println("</b>");
              pr.println("</td>");


            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\">");
                pr.println("<div align=\"center\">");
                  pr.println("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"91%\" bgcolor=\"#FFFFFF\" bordercolor=\"#C6FFFF\" height=\"1\">");

		while(theResult.next()) //Fetch all the records
		{
			i++;
                    pr.println("<tr>");
                      pr.println("<td width=\"5%\" valign=\"top\" height=\"1\" bgcolor=\"#FFFFCC\">" + String.valueOf(i) + "</td>");
                      pr.println("<td width=\"95%\" valign=\"top\" height=\"1\" bgcolor=\"#FFFFCC\"><a href=\"" + servletURL + "/search?serno=" + theResult.getString(1) + "\"><font color=\"#CC3300\" size=\"3\">" + theResult.getString(2) + "</font></a></td>");
                    pr.println("</tr>");
                    pr.println("<tr>");
                      pr.println("<td width=\"5%\" valign=\"top\" height=\"1\" bgcolor=\"#FFFFF0\"><font color=\"#CC3300\" size=\"4\">&nbsp;</font></td>");
                      pr.println("<td width=\"95%\" valign=\"top\" height=\"1\" bgcolor=\"#FFFFF0\"><font color=\"#000080\" size=\"2\">" + theResult.getString(3) + "</font></td>");
                    pr.println("</tr>");
		}
                


      /*              pr.println("<tr>");
                      pr.println("<td colspan=2 bgcolor=\"#FFFFF0\"><font color=\"#CC3300\" size=\"4\"><a href=\"" + servletURL + "/search?under=" + strCategory + "\">Add Link</a></font></td>");
                    pr.println("</tr>");
*/
				  pr.println("</table>");
                pr.println("</div>");
              pr.println("</td>");
            pr.println("</tr>");


            theResult.close();//Close the result set
            theStatement.close();//Close statement
		}catch (Exception e){
			pr.println(e.getMessage());
		}


	
	}

	public void placelinks(PrintWriter out){

            out.println("<tr>");
              out.println("<td width=\"100%\" align=\"center\">");
                out.println("<div align=\"center\">");
                  out.println("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"88%\" bgcolor=\"#FFFFFF\" bordercolor=\"#C6FFFF\" height=\"1\">");
                    out.println("<tr>");
                      out.println("<td width=\"100%\" valign=\"top\" height=\"2\" bgcolor=\"#FFFFCC\">");
                        
                        out.println("<h2>Please be more specific!</h2>");
                        out.println("<p>Please find a more specific sub-category for your entry and resubmit your request there.&nbsp;");
                        out.println("<p>Return to <a href=\"" + servletURL + "/search\">Java Search</a></p>");
                        out.println("<p>&nbsp;&nbsp;");
                      out.println("</td>");
                    out.println("</tr>");
                  out.println("</table>");
                out.println("</div>");
              out.println("</td>");
            out.println("</tr>");


	}


	public void updateModified(PrintWriter out,HttpServletRequest req){
	
	  //Get the session object
	  HttpSession session = req.getSession(true);
        String username = (String) session.getValue ("user");

	//out.println(username);

	String address = req.getParameter("address");
		if(address==null) address="";
			else address = change(address);
	String city= req.getParameter("city");
		if(city==null) city="";
			else city = change(city);
	String state= req.getParameter("state");
		if(state==null) state="";
			else state= change(state);
	String zip= req.getParameter("zip");
		if(zip==null) zip="";
			else zip= change(zip);
	String country= req.getParameter("country");
		if(country==null) country="";
			else country= change(country);
	String phone= req.getParameter("phone");
		if(phone==null) phone="";
			else phone= change(phone);
	String email= req.getParameter("email");
	String url= req.getParameter("url");
	String caption= req.getParameter("caption");
		if(caption==null) caption="";
			else caption= change(caption);
	String description= req.getParameter("description");
		if(description==null) description="";
			else description= change(description);
	String mail= req.getParameter("mail");

	String sql;
	sql="update listings set street='" + address + "', city='" + city + "', state='" + state + "', zip='" + zip + "', country='" + country + "', telephone='" + phone + "', email='" + email + "', url='" + url + "', caption='" + caption + "', descp='" + description + "', mailing_list='" + mail + "' where login='" + username + "'";

	try{
	Statement theStatement;
	theStatement=theConnection.createStatement();
	theStatement.executeUpdate(sql);
	theStatement.close();
            out.println("<tr>");
              out.println("<td width=\"100%\" align=\"center\"><font color=\"#FF0000\" size=\"5\">Database successfully updated.</font></td>");
            out.println("</tr>");
            out.println("<tr>");

	}catch(Exception e){}

	
	}
	

	public void validateLogin(PrintWriter pr,HttpServletRequest req){
	String login= req.getParameter("login");
	String password = req.getParameter("password");


	int serno;
	serno=0;

	String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16;
	s1="";
	s2="";
	s3="";
	s4="";
	s5="";
	s6="";
	s7="";
	s8="";
	s9="";
	s10="";
	s11="";
	s12="";
	s13="";
	s14="";
	s15="";
	s16="";

	try{

	Statement theStatement;
	ResultSet theResultset;


	theStatement=theConnection.createStatement();
	theResultset=theStatement.executeQuery("select * from listings where login='" + login + "' and password='" + password + "'");
		while(theResultset.next()){
		serno++;
		//create a session for user
		HttpSession session = req.getSession(true);
	      session.putValue ("user", login);
		s1=theResultset.getString(1);
		s2=theResultset.getString(2);
		s3=theResultset.getString(3);
		s4=theResultset.getString(4);
		s5=theResultset.getString(5);
		s6=theResultset.getString(6);
		s7=theResultset.getString(7);
		s8=theResultset.getString(8);
		s9=theResultset.getString(9);
		s10=theResultset.getString(10);
		s11=theResultset.getString(11);
		s12=theResultset.getString(12);
		s13=theResultset.getString(13);
		s14=theResultset.getString(14);
		s15=theResultset.getString(15);
		}	
	theResultset.close();
	theStatement.close();

if(serno==0){
            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\">");
                pr.println("<div align=\"center\">");
                  pr.println("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"83%\" bgcolor=\"#FFFFFF\" bordercolor=\"#C6FFFF\" height=\"1\">");
                    pr.println("<tr>");
                      pr.println("<td width=\"100%\" valign=\"top\" height=\"2\" bgcolor=\"#FFFFCC\">");
                        pr.println("<form method=\"POST\" action=\"" + servletURL + "/search\">");
                          pr.println("<input type=hidden name=validate value=1>");
                          pr.println("<p><br>");
                          pr.println("<font color=\"#800000\">&nbsp; <font size=\"4\">Invalid user ID or Password! Try again!</font></font><br>");
                          pr.println("&nbsp;&nbsp; <font color=\"#FF0000\">Login:&nbsp;</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                          pr.println("<input type=\"text\" name=\"login\" size=\"20\"><br>");
                          pr.println("&nbsp;&nbsp; <font color=\"#FF0000\">Password:&nbsp;</font>");
                          pr.println("<input type=\"password\" name=\"password\" size=\"20\"></p>");
                          pr.println("<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                          pr.println("<input type=\"submit\" value=\"Submit\" name=\"B1\"></p>");
                        pr.println("</form>");
                      pr.println("</td>");
                    pr.println("</tr>");
                  pr.println("</table>");
                pr.println("</div>");
              pr.println("</td>");
            pr.println("</tr>");


return;
}


            pr.println("<script language=javascript>");

pr.println("function validate1(){");

		pr.println("if(window.document.f2.address.value.length==0){");
			pr.println("alert (\"Re enter your address.\");");
			pr.println("window.document.f2.address.focus();");
			pr.println("return false;");
			pr.println("}");


		pr.println("if(window.document.f2.city.value.length==0){");
			pr.println("alert (\"Re enter your city.\");");
			pr.println("window.document.f2.city.focus();");
			pr.println("return false;");
			pr.println("}");

		pr.println("if(window.document.f2.state.value.length==0){");
			pr.println("alert (\"Re enter your state.\");");
			pr.println("window.document.f2.state.focus();");
			pr.println("return false;");
			pr.println("}");

		pr.println("if(window.document.f2.country.value.length==0){");
			pr.println("alert (\"Re enter your country.\");");
			pr.println("window.document.f2.country.focus();");
			pr.println("return false;");
                        pr.println("}");

		pr.println("if(window.document.f2.email.value.length==0){");
			pr.println("alert (\"Re enter your email.\");");
			pr.println("window.document.f2.email.focus();");
			pr.println("return false;");
			pr.println("}");
			
			
			
pr.println("//  FOR EMAIL ");

	pr.println("if(window.document.f2.email.value.length)");
	pr.println("{  	var Ename = document.f2.email.value = document.f2.email.value.toLowerCase();");
		pr.println("var sLength =  Ename.length;");
	
		pr.println("//Validate the login name");
		pr.println("if (isWhitespace(Ename))");
			pr.println("{");
			pr.println("alert (\"You can't leave this field blank\")");
     	  pr.println("window.document.f2.email.focus();");
			pr.println("return false;");
			pr.println("}");
		pr.println("else if ( !isCharsInBag( Ename, \"abcdefghijklmnopqrstuvwxyz0123456789.-_@\" ))");
		pr.println("{");
		pr.println("alert( \"Email ID may only contain the following characters:\\nabcdefghijklmnopqrstuvwxyz0123456789.-_@\" );");
		pr.println("window.document.f2.email.focus();");
		pr.println("return false;");
	    pr.println("}");
		pr.println("else if ( !isCharsInBag( Ename.charAt(Ename.length - 1), \"abcdefghijklmnopqrstuvwxyz0123456789\") )");
	    pr.println("{");
		  pr.println("alert( \"Email ID must end in an alphanumeric character.\");");
		  pr.println("window.document.f2.email.focus();");
		pr.println("return false;");
            pr.println("}");
		pr.println("else if ( !isCharsInBag( Ename.charAt(0), \"abcdefghijklmnopqrstuvwxyz0123456789\") )");
		pr.println("{");
		pr.println("alert( \"Email ID must start with an alphanumeric character.\");");
		pr.println("window.document.f2.email.focus();");
		pr.println("return false;");
	    pr.println("}");
    
		pr.println("else if ( Ename.length < 3 )");
	    pr.println("{");
		  pr.println("alert( \"Email ID must be 3 or more characters.\" );");
		  pr.println("window.document.f2.email.focus();");
		pr.println("return false;");
		pr.println("}");
	    pr.println("// look for @");
	    pr.println("else if (Ename.indexOf(\"@\") == -1)");
           pr.println("{");
             pr.println("alert(\"Your Email ID must contain @ sign\") ");
             		  pr.println("window.document.f2.email.focus();");

        pr.println("return false;");
            pr.println("}");
       pr.println("// look for .");
		pr.println("else if (Ename.indexOf(\".\") == -1)");
		    pr.println("{");
             pr.println("alert(\"Your Email ID must contain . sign\")");
             		  pr.println("window.document.f2.email.focus();");

             pr.println("return false;");
            pr.println("}");
      pr.println("// return true;");
	pr.println("}");
			
			
			pr.println("////EMAIL");
			
			
			

		pr.println("if(window.document.f2.url.value.length==0 || window.document.f2.url.value==\"http://\"){");
			pr.println("alert (\"Re enter your web url.\");");
			pr.println("window.document.f2.url.focus();");
			pr.println("return false;");
			pr.println("}");


		pr.println("if(window.document.f2.caption.value.length==0){");
			pr.println("alert (\"Re enter caption of your page.\");");
			pr.println("window.document.f2.caption.focus();");
			pr.println("return false;");
			pr.println("}");

		pr.println("if(window.document.f2.description.value.length==0){");
			pr.println("alert (\"Re enter description.\");");
			pr.println("window.document.f2.description.focus();");
			pr.println("return false;");
			pr.println("}");

	pr.println("return true;");
	pr.println("}");


pr.println("</script>");


            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\"><font color=\"#000080\" size=\"5\">Modify Your Link</font></td>");
            pr.println("</tr>");
            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\">");


  pr.println("<table border=\"0\" width=\"95%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#FFFFDB\">");
  pr.println("<form name=\"f2\" method=\"post\" action=\"" + servletURL + "/search\" onsubmit=\"return validate1();\">");

  pr.println("<input type=\"hidden\" name=\"updatemodified\" value=Y>");
  


    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\">&nbsp;&nbsp;&nbsp;</td>");
      pr.println("<td width=\"89%\">&nbsp;&nbsp;&nbsp;</td>");
    pr.println("</tr>");

    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>Address<font color=\"#FF0000\">*</font></b></td>");
      pr.println("<td width=\"89%\"><textarea rows=\"4\" name=\"address\" cols=\"22\" maxlength=200>" + s4 + "</textarea></td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>City<font color=\"#FF0000\">*</font></b></td>");
      pr.println("<td width=\"89%\"><input type=\"text\" name=\"city\" size=\"20\" maxlength=30 value=\"" + s5 + "\" ></td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>State<font color=\"#FF0000\">*</font></b></td>");
      pr.println("<td width=\"89%\"><input type=\"text\" name=\"state\" size=\"20\" maxlength=30 value=\"" + s6 + "\"></td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>Zip</b></td>");
      pr.println("<td width=\"89%\"><input type=\"text\" name=\"zip\" size=\"20\" maxlength=10 value=\"" + s7 + "\"></td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>Country<font color=\"#FF0000\">*</font></b></td>");
      pr.println("<td width=\"89%\"><input type=\"text\" name=\"country\" size=\"20\" maxlength=30 value=\"" + s8 + "\"></td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>Phone</b></td>");
      pr.println("<td width=\"89%\"><input type=\"text\" name=\"phone\" size=\"20\" maxlength=30 value=\"" + s9 + "\"></td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>E-mail<font color=\"#FF0000\">*</font></b></td>");
      pr.println("<td width=\"89%\"><input type=\"text\" name=\"email\" size=\"20\" maxlength=50 value=\"" + s10 + "\"></td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>URL<font color=\"#FF0000\">*</font></b></td>");
      pr.println("<td width=\"89%\"><input type=\"text\" name=\"url\" size=\"20\" value=\"" + s11 + "\" maxlength=100 > </td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>Caption<font color=\"#FF0000\">*</font></b></td>");
      pr.println("<td width=\"89%\"><input type=\"text\" name=\"caption\" size=\"20\" maxlength=100 value=\"" + s13 + "\"> </td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>Description<font color=\"#FF0000\">*</font></b></td>");
      pr.println("<td width=\"89%\"><input type=\"text\" name=\"description\" size=\"35\" maxlength=\"200\" value=\"" + s14 + "\"> </td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>Add me to mailing list</b></td>");
      pr.println("<td width=\"89%\"><input type=\"checkbox\" name=\"mail\" value=\"Y\" checked> </td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\">&nbsp;&nbsp;</td>");
      pr.println("<td width=\"89%\">&nbsp;&nbsp; </td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"133%\" colspan=\"3\" align=\"center\"><input type=\"submit\" value=\"Submit\" name=\"B1\">&nbsp;");
        pr.println("<input type=\"reset\" value=\"Reset\" name=\"B2\"></td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\">&nbsp;</td>");
      pr.println("<td width=\"89%\">&nbsp;&nbsp;&nbsp; </td>");
    pr.println("</tr>");
  pr.println("</table>");




}catch(Exception e){}



	}

	public void displayLoginForm(PrintWriter out){

            out.println("<tr>");
              out.println("<td width=\"100%\" align=\"center\">");
                out.println("<div align=\"center\">");
                  out.println("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"83%\" bgcolor=\"#FFFFFF\" bordercolor=\"#C6FFFF\" height=\"1\">");
                    out.println("<tr>");
                      out.println("<td width=\"100%\" valign=\"top\" height=\"2\" bgcolor=\"#FFFFCC\">");
                        out.println("<form method=\"POST\" action=\"" + servletURL + "/search\">");
                          out.println("<input type=hidden name=validate value=1>");
                          out.println("<p><br>");
                          out.println("<font color=\"#800000\">&nbsp; <font size=\"4\">Please login to modify your listings.</font></font><br>");
                          out.println("&nbsp;&nbsp; <font color=\"#FF0000\">Login:&nbsp;</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                          out.println("<input type=\"text\" name=\"login\" size=\"20\"><br>");
                          out.println("&nbsp;&nbsp; <font color=\"#FF0000\">Password:&nbsp;</font>");
                          out.println("<input type=\"password\" name=\"password\" size=\"20\"></p>");
                          out.println("<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                          out.println("<input type=\"submit\" value=\"Submit\" name=\"B1\"></p>");
                        out.println("</form>");
                      out.println("</td>");
                    out.println("</tr>");
                  out.println("</table>");
                out.println("</div>");
              out.println("</td>");
            out.println("</tr>");


	}

	public void updatenewEntry(PrintWriter out,String straddnew,String striunder,String strilink,HttpServletRequest req){

	int serno;
	serno=1;

	try{

	String strregid = req.getParameter("regid");
		if(strregid==null) strregid="";
			else strregid = change(strregid);



	Statement theStatement;
	ResultSet theResultset;


	theStatement=theConnection.createStatement();
	theResultset=theStatement.executeQuery("select * from listings where login='" + strregid + "'");
		while(theResultset.next()){

            out.println("<tr>");
              out.println("<td width=\"100%\" align=\"center\"><font color=\"#FF0000\" size=\"5\">Registration ID already exists! Please hit your browsers back button and select another Registration ID.</font></td>");
            out.println("</tr>");
            out.println("<tr>");
		return;			

		}	
	theResultset.close();
	theStatement.close();



	theStatement=theConnection.createStatement();
	theResultset=theStatement.executeQuery("select max(serno) from listings");
		while(theResultset.next()){
			serno=theResultset.getInt(1)+1;
		}	
	theResultset.close();
	theStatement.close();

	String password = req.getParameter("pass1");
		if(password==null) password="";
			else password = change(password);

	String address = req.getParameter("address");
		if(address==null) address="";
			else address = change(address);

	String city= req.getParameter("city");
		if(city==null) city="";
			else city = change(city);


	String state= req.getParameter("state");
		if(state==null) state="";
			else state= change(state);


	String zip= req.getParameter("zip");
		if(zip==null) zip="";
			else zip= change(zip);

	String country= req.getParameter("country");
		if(country==null) country="";
			else country= change(country);

	String phone= req.getParameter("phone");
		if(phone==null) phone="";
			else phone= change(phone);

	String email= req.getParameter("email");
	String url= req.getParameter("url");
	String category= req.getParameter("iunder");
	String caption= req.getParameter("caption");
		if(caption==null) caption="";
			else caption= change(caption);
	String description= req.getParameter("description");
		if(description==null) description="";
			else description= change(description);
	String mail= req.getParameter("mail");


	String sql="insert into listings values('" + String.valueOf(serno) + "','" + strregid + "','" + password + "','" + address + "','" + city + "','" + state + "','" + zip + "','" + country + "','" + phone + "','"  + email + "','" + url + "','" + category + "','" + caption + "','" + description + "','" + mail + "',now())";

	theStatement=theConnection.createStatement();
	theStatement.executeUpdate(sql);
	theStatement.close();

            out.println("<tr>");
              out.println("<td width=\"100%\" align=\"center\"><font color=\"#000080\" size=\"5\">Thank you for adding your link.</font></td>");
            out.println("</tr>");
            out.println("<tr>");


	}
	catch(Exception e){
            out.println("<tr>");
              out.println("<td width=\"100%\" align=\"center\"><font color=\"#FF0000\" size=\"5\">" + e.getMessage() + "</font></td>");
            out.println("</tr>");
            out.println("<tr>");


	}

	

		//out.println("Adding new Entry");



	}


 public String change(String  str){

	 String st;
	 st="";

    StringTokenizer t=new StringTokenizer(str,"'");
    if(str==null)
	{
		st="";
	}
	else
	{
	 int i =t.countTokens();
	 while(t.hasMoreTokens()){
		if(st.compareTo("")==0)
		st=t.nextToken();
		else
			st=st + "\\'" + t.nextToken();

	 }
	}
  return st;
 }


	//Displays the form, which allows to add new entry.
	
	public void addListings(PrintWriter pr,String strUnder,String strLink){

            pr.println("<script language=javascript>");

pr.println("function validate1(){");
		pr.println("if(window.document.f2.regid.value.length==0){");
			pr.println("alert (\"Please enter a login.\");");
			pr.println("window.document.f2.regid.focus();");
			pr.println("return false;");
			pr.println("}");

		pr.println("if(window.document.f2.pass1.value.length==0){");
			pr.println("alert (\"Please enter your password.\");");
			pr.println("window.document.f2.pass1.focus();");
			pr.println("return false;");
			pr.println("}");

		pr.println("if(window.document.f2.pass2.value.length==0){");
			pr.println("alert (\"Re enter your password.\");");
			pr.println("window.document.f2.pass2.focus();");
			pr.println("return false;");
			pr.println("}");


		pr.println("if(window.document.f2.pass2.value != window.document.f2.pass1.value){");
			pr.println("alert (\"Password does not match. Re-enter password!\");");
			pr.println("window.document.f2.pass1.focus();");
			pr.println("return false;");
			pr.println("}");

		pr.println("if(window.document.f2.address.value.length==0){");
			pr.println("alert (\"Re enter your address.\");");
			pr.println("window.document.f2.address.focus();");
			pr.println("return false;");
			pr.println("}");


		pr.println("if(window.document.f2.city.value.length==0){");
			pr.println("alert (\"Re enter your city.\");");
			pr.println("window.document.f2.city.focus();");
			pr.println("return false;");
			pr.println("}");

		pr.println("if(window.document.f2.state.value.length==0){");
			pr.println("alert (\"Re enter your state.\");");
			pr.println("window.document.f2.state.focus();");
			pr.println("return false;");
			pr.println("}");

		pr.println("if(window.document.f2.country.value.length==0){");
			pr.println("alert (\"Re enter your country.\");");
			pr.println("window.document.f2.country.focus();");
			pr.println("return false;");
                        pr.println("}");

		pr.println("if(window.document.f2.email.value.length==0){");
			pr.println("alert (\"Re enter your email.\");");
			pr.println("window.document.f2.email.focus();");
			pr.println("return false;");
			pr.println("}");
			
			
			
pr.println("//  FOR EMAIL ");

	pr.println("if(window.document.f2.email.value.length)");
	pr.println("{  	var Ename = document.f2.email.value = document.f2.email.value.toLowerCase();");
		pr.println("var sLength =  Ename.length;");
	
		pr.println("//Validate the login name");
		pr.println("if (isWhitespace(Ename))");
			pr.println("{");
			pr.println("alert (\"You can't leave this field blank\")");
     	  pr.println("window.document.f2.email.focus();");
			pr.println("return false;");
			pr.println("}");
		pr.println("else if ( !isCharsInBag( Ename, \"abcdefghijklmnopqrstuvwxyz0123456789.-_@\" ))");
		pr.println("{");
		pr.println("alert( \"Email ID may only contain the following characters:\\nabcdefghijklmnopqrstuvwxyz0123456789.-_@\" );");
		pr.println("window.document.f2.email.focus();");
		pr.println("return false;");
	    pr.println("}");
		pr.println("else if ( !isCharsInBag( Ename.charAt(Ename.length - 1), \"abcdefghijklmnopqrstuvwxyz0123456789\") )");
	    pr.println("{");
		  pr.println("alert( \"Email ID must end in an alphanumeric character.\");");
		  pr.println("window.document.f2.email.focus();");
		pr.println("return false;");
            pr.println("}");
		pr.println("else if ( !isCharsInBag( Ename.charAt(0), \"abcdefghijklmnopqrstuvwxyz0123456789\") )");
		pr.println("{");
		pr.println("alert( \"Email ID must start with an alphanumeric character.\");");
		pr.println("window.document.f2.email.focus();");
		pr.println("return false;");
	    pr.println("}");
    
		pr.println("else if ( Ename.length < 3 )");
	    pr.println("{");
		  pr.println("alert( \"Email ID must be 3 or more characters.\" );");
		  pr.println("window.document.f2.email.focus();");
		pr.println("return false;");
		pr.println("}");
	    pr.println("// look for @");
	    pr.println("else if (Ename.indexOf(\"@\") == -1)");
           pr.println("{");
             pr.println("alert(\"Your Email ID must contain @ sign\") ");
             		  pr.println("window.document.f2.email.focus();");

        pr.println("return false;");
            pr.println("}");
       pr.println("// look for .");
		pr.println("else if (Ename.indexOf(\".\") == -1)");
		    pr.println("{");
             pr.println("alert(\"Your Email ID must contain . sign\")");
             		  pr.println("window.document.f2.email.focus();");

             pr.println("return false;");
            pr.println("}");
      pr.println("// return true;");
	pr.println("}");
			
			
			pr.println("////EMAIL");
			
			
			

		pr.println("if(window.document.f2.url.value.length==0 || window.document.f2.url.value==\"http://\"){");
			pr.println("alert (\"Re enter your web url.\");");
			pr.println("window.document.f2.url.focus();");
			pr.println("return false;");
			pr.println("}");


		pr.println("if(window.document.f2.caption.value.length==0){");
			pr.println("alert (\"Re enter caption of your page.\");");
			pr.println("window.document.f2.caption.focus();");
			pr.println("return false;");
			pr.println("}");

		pr.println("if(window.document.f2.description.value.length==0){");
			pr.println("alert (\"Re enter description.\");");
			pr.println("window.document.f2.description.focus();");
			pr.println("return false;");
			pr.println("}");

	pr.println("return true;");
	pr.println("}");


pr.println("</script>");


            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\"><font color=\"#000080\" size=\"5\">Place Your Link</font></td>");
            pr.println("</tr>");
            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\">");


  pr.println("<table border=\"0\" width=\"95%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#FFFFDB\">");
  pr.println("<form name=\"f2\" method=\"post\" action=\"" + servletURL + "/search\" onsubmit=\"return validate1();\">");

  pr.println("<input type=\"hidden\" name=\"addnew\" value=Y>");
  pr.println("<input type=\"hidden\" name=\"iunder\" value=" + strUnder + ">");
  pr.println("<input type=\"hidden\" name=\"ilink\" value=" + strLink + ">");



    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\">&nbsp;&nbsp;&nbsp;</td>");
      pr.println("<td width=\"89%\">&nbsp;&nbsp;&nbsp;</td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>Select Registration ID<font color=\"#FF0000\">*</font></b></td>");
      pr.println("<td width=\"89%\"><input type=\"text\" name=\"regid\" size=\"20\" maxlength=15></td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>Enter Password<font color=\"#FF0000\">*</font></b></td>");
      pr.println("<td width=\"89%\"><input type=\"password\" name=\"pass1\" size=\"20\" maxlength=15></td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>Re -Enter Password<font color=\"#FF0000\">*</font></b></td>");
      pr.println("<td width=\"89%\"><input type=\"password\" name=\"pass2\" size=\"20\" maxlength=15></td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>Address<font color=\"#FF0000\">*</font></b></td>");
      pr.println("<td width=\"89%\"><textarea rows=\"4\" name=\"address\" cols=\"22\" maxlength=200></textarea></td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>City<font color=\"#FF0000\">*</font></b></td>");
      pr.println("<td width=\"89%\"><input type=\"text\" name=\"city\" size=\"20\" maxlength=30></td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>State<font color=\"#FF0000\">*</font></b></td>");
      pr.println("<td width=\"89%\"><input type=\"text\" name=\"state\" size=\"20\" maxlength=30></td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>Zip</b></td>");
      pr.println("<td width=\"89%\"><input type=\"text\" name=\"zip\" size=\"20\" maxlength=10></td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>Country<font color=\"#FF0000\">*</font></b></td>");
      pr.println("<td width=\"89%\"><input type=\"text\" name=\"country\" size=\"20\" maxlength=30></td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>Phone</b></td>");
      pr.println("<td width=\"89%\"><input type=\"text\" name=\"phone\" size=\"20\" maxlength=30></td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>E-mail<font color=\"#FF0000\">*</font></b></td>");
      pr.println("<td width=\"89%\"><input type=\"text\" name=\"email\" size=\"20\" maxlength=50></td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>URL<font color=\"#FF0000\">*</font></b></td>");
      pr.println("<td width=\"89%\"><input type=\"text\" name=\"url\" size=\"20\" value=\"http://\" maxlength=100> </td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>Caption<font color=\"#FF0000\">*</font></b></td>");
      pr.println("<td width=\"89%\"><input type=\"text\" name=\"caption\" size=\"20\" maxlength=100> </td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>Description<font color=\"#FF0000\">*</font></b></td>");
      pr.println("<td width=\"89%\"><input type=\"text\" name=\"description\" size=\"35\" maxlength=\"200\"> </td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\"><b>Add me to mailing list</b></td>");
      pr.println("<td width=\"89%\"><input type=\"checkbox\" name=\"mail\" value=\"Y\" checked> </td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\">&nbsp;&nbsp;</td>");
      pr.println("<td width=\"89%\">&nbsp;&nbsp; </td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"133%\" colspan=\"3\" align=\"center\"><input type=\"submit\" value=\"Submit\" name=\"B1\">&nbsp;");
        pr.println("<input type=\"reset\" value=\"Reset\" name=\"B2\"></td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"5%\">&nbsp;</td>");
      pr.println("<td width=\"39%\">&nbsp;</td>");
      pr.println("<td width=\"89%\">&nbsp;&nbsp;&nbsp; </td>");
    pr.println("</tr>");
  pr.println("</table>");




	}//end of addListings



	public void displayFinalResult(PrintWriter pr,String strserno){

		Statement theStatement;
		ResultSet theResult;
            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\"><font color=\"#000080\" size=\"5\">Search results:</font></td>");
            pr.println("</tr>");

	
		String sql;
		sql="select * from listings where serno=" + strserno;

		try{
		if(theConnection == null) makeConnection();

		theStatement=theConnection.createStatement();
	      theResult=theStatement.executeQuery(sql); 
		
	
            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\">");
                pr.println("<b>");
                pr.println("This Page Will Show You The Final Hit.</font>");
                pr.println("</b>");
              pr.println("</td>");
		  pr.println("</tr>");

		while(theResult.next()) //Fetch all the records
		{
              pr.println("<td width=\"100%\" align=\"center\">");
                pr.println("<div align=\"center\">");
                  pr.println("<table border=\"2\" cellpadding=\"0\" cellspacing=\"1\" width=\"91%\" bgcolor=\"#FFFFFF\" bordercolor=\"#C6FFFF\" height=\"1\">");
                    pr.println("<tr>");
                      pr.println("<td width=\"100%\" valign=\"top\" height=\"1\" bgcolor=\"#000066\" align=\"center\"><font size=\"4\" color=\"#FFFFFF\">" + theResult.getString(13) + "</font></td>");
                    pr.println("</tr>");
                    pr.println("<tr>");
                      pr.println("<td width=\"100%\" valign=\"top\" height=\"1\" bgcolor=\"#FFFFF0\"><b><font color=\"#000080\">Description:<br>");
                        pr.println("</font></b>&quot;" + theResult.getString(14) + "&quot;<br>");
                        pr.println("&nbsp;&nbsp;<br>");
                        pr.println("<font color=\"#000080\"><b>Contact</b></font><font color=\"#000080\"><b>");
                        pr.println("Address:<br>");
                        pr.println("</b></font><font face=\"Arial\" size=\"2\">" + theResult.getString(4) + "<br>");
                        pr.println(theResult.getString(5) + "<br>");
                        pr.println(theResult.getString(6) + "<br>");
                        pr.println(theResult.getString(7) + "<br>");
                        pr.println(theResult.getString(8) + "<br>");
                        pr.println("&nbsp;<br>");
                        pr.println("<font color=\"#008000\">Tel:&nbsp;</font> " + theResult.getString(9) + "<br>");
				
							String em;
							em=theResult.getString(10);
		
                        pr.println("<font color=\"#008000\">Email:</font> <a href=\"mailto:" + em + "\">" + em + "<br>");
                        pr.println("</a><font color=\"#008000\">Web: </font><a href=\"" + theResult.getString(11) + "\">Visit at our web site.</a>&nbsp;<br>");
                        pr.println("&nbsp;&nbsp;&nbsp;</font></td>");
                    pr.println("</tr>");
                  pr.println("</table>");
                pr.println("</div>");
              pr.println("</td>");
           pr.println("</tr>");
		}
            

            theResult.close();//Close the result set
            theStatement.close();//Close statement
		}catch (Exception e){
			pr.println(e.getMessage());
		}
	


	}

	//displays add links 
	public void displayListings(PrintWriter pr,String strCategory){


		Statement theStatement;
		ResultSet theResult;
            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\"><font color=\"#000080\" size=\"5\">Search results:</font></td>");
            pr.println("</tr>");
            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\">");
                pr.println("<div align=\"center\">");
                  pr.println("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"91%\" bgcolor=\"#FFFFFF\" bordercolor=\"#C6FFFF\">");

	
		String sql;
		sql="select serno,caption,descp from listings where category=" + strCategory;

		try{
		if(theConnection == null) makeConnection();

		theStatement=theConnection.createStatement();
	      theResult=theStatement.executeQuery(sql); 
		
		int i;
		i=0;

	//	i=theResult.getFetchSize();


            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\">");
                pr.println("<b>");
                pr.println("This Page Will Show You The Final Hit.</font>");
                pr.println("</b>");
              pr.println("</td>");


            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\">");
                pr.println("<div align=\"center\">");
                  pr.println("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"91%\" bgcolor=\"#FFFFFF\" bordercolor=\"#C6FFFF\" height=\"1\">");

		while(theResult.next()) //Fetch all the records
		{
			i++;
                    pr.println("<tr>");
                      pr.println("<td width=\"5%\" valign=\"top\" height=\"1\" bgcolor=\"#FFFFCC\">" + String.valueOf(i) + "</td>");
                      pr.println("<td width=\"95%\" valign=\"top\" height=\"1\" bgcolor=\"#FFFFCC\"><a href=\"" + servletURL + "/search?serno=" + theResult.getString(1) + "\"><font color=\"#CC3300\" size=\"3\">" + theResult.getString(2) + "</font></a></td>");
                    pr.println("</tr>");
                    pr.println("<tr>");
                      pr.println("<td width=\"5%\" valign=\"top\" height=\"1\" bgcolor=\"#FFFFF0\"><font color=\"#CC3300\" size=\"4\">&nbsp;</font></td>");
                      pr.println("<td width=\"95%\" valign=\"top\" height=\"1\" bgcolor=\"#FFFFF0\"><font color=\"#000080\" size=\"2\">" + theResult.getString(3) + "</font></td>");
                    pr.println("</tr>");
		}
                


                    pr.println("<tr>");
                      pr.println("<td colspan=2 bgcolor=\"#FFFFF0\"><font color=\"#CC3300\" size=\"4\"><a href=\"" + servletURL + "/search?under=" + strCategory + "\">Add Link</a></font></td>");
                    pr.println("</tr>");

				  pr.println("</table>");
                pr.println("</div>");
              pr.println("</td>");
            pr.println("</tr>");


            theResult.close();//Close the result set
            theStatement.close();//Close statement
		}catch (Exception e){
			pr.println(e.getMessage());
		}
	


	}//end of displayListings


	public void displayCategories(PrintWriter pr,String strSection){

		Statement theStatement;
		ResultSet theResult;
	


            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\"><font color=\"#000080\" size=\"5\">Categories</font></td>");
            pr.println("</tr>");
            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\">");
                pr.println("<div align=\"center\">");
                  pr.println("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"91%\" bgcolor=\"#FFFFFF\" bordercolor=\"#C6FFFF\">");

	
		String sql;
		sql="select serno,description from categories where section_code=" + strSection;

		try{
		if(theConnection == null) makeConnection();

		theStatement=theConnection.createStatement();
	      theResult=theStatement.executeQuery(sql); 
		while(theResult.next()) //Fetch all the records
		{

                    pr.println("<tr>");
                      pr.println("<td width=\"7%\" valign=\"top\" height=\"1\"><font face=\"arial\" size=\"3\"><b><small><img border=\"0\" src=\"" + image + "\" width=\"24\" height=\"24\"></small></b></font></td>");
                      pr.println("<td width=\"42%\" valign=\"top\" height=\"1\"><font face=\"arial\" size=\"3\"><a href=\""  + servletURL + "/search?category=" + String.valueOf(theResult.getInt(1)) + "\">" + theResult.getString(2)+ "</a></font></td>");

				if(theResult.next()){


                      pr.println("<td width=\"7%\" valign=\"top\" height=\"1\"><font face=\"arial\" size=\"3\"><b><small><img border=\"0\" src=\""+ image +"\" width=\"24\" height=\"24\"></small></b></font></td>");
                      pr.println("<td width=\"44%\" valign=\"top\" height=\"1\"><font face=\"arial\" size=\"3\"><a href=\""  + servletURL + "/search?category=" + theResult.getString(1) + "\">" + theResult.getString(2)+ "</a></font></td>");
			}else{
                      pr.println("<td width=\"7%\" valign=\"top\" height=\"1\">&nbsp;</td>");
                      pr.println("<td width=\"44%\" valign=\"top\" height=\"1\">&nbsp;</td>");

			}

                    pr.println("</tr>");
			
		}
            theResult.close();//Close the result set
            theStatement.close();//Close statement
		}catch (Exception e){
			pr.println(e.getMessage());
		}
	
	}

	public void displaySections(PrintWriter pr){

		Statement theStatement;
		ResultSet theResult;
	
            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\"><font color=\"#000080\" size=\"5\">Sections</font></td>");
            pr.println("</tr>");
            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\">");
                pr.println("<div align=\"center\">");
                  pr.println("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"91%\" bgcolor=\"#FFFFFF\" bordercolor=\"#C6FFFF\">");
	
		String sql;
		sql="select * from section";
		try{
		if(theConnection == null) makeConnection();

		theStatement=theConnection.createStatement();
	      theResult=theStatement.executeQuery(sql); 
		while(theResult.next()) //Fetch all the records
		{
                    pr.println("<tr>");
                      pr.println("<td width=\"50%\" valign=\"top\"><small><font face=\"arial\" size=\"3\"><a href=\"" + servletURL + "/search?section=" + theResult.getString(1) + "\"><b>" + theResult.getString(2) + "</b></a></font></small><font face=\"arial\" size=\"2\"><br>");
                        pr.println(theResult.getString(3) + "</font></td>");
				if(theResult.next()){
                      		pr.println("<td width=\"50%\" valign=\"top\"><small><font face=\"arial\" size=\"3\"><a href=\"" + servletURL + "/search?section=" + theResult.getString(1) + "\"><b>" + theResult.getString(2) + "</b></a></font></small><font face=\"arial\" size=\"2\"><br>");
                        	pr.println(theResult.getString(3) + "</font></td>");
				}
				else pr.println("<td width=\"50%\" valign=\"top\">&nbsp;</td>");
                    pr.println("</tr>");
			
		}
            theResult.close();//Close the result set
            theStatement.close();//Close statement
		}catch (Exception e){
			pr.println(e.getMessage());
		}
	}

	public void writeHead(PrintWriter pr){


pr.println("<html>");

pr.println("<head>");
pr.println("<title>Welcome to Java Developers paradise!</title>");
pr.println("<meta content=\"Welcome to Java Developers paradise! We are totally devoted to Java server side , servlets, JSP, JDBC, EJB, XML,MySql\"name=\"description\">");
pr.println("<meta content=\"JAVA, JSP, Servlets, Servlet, Search Engine, Directory, Jserv, Apache, JDBC, EJB, programming, developer, news, intranet, internet, Web, http, cgi alternatives, jdbc servlets, links, help\"name=\"keywords\">");

pr.println("<script language=javascript>");


pr.println("var whitespace=\"/t/n/r\"");
	
pr.println("function isEmpty(s)");
	pr.println("{  return ");
	pr.println("((s == null) || (s.length == 0))");
	pr.println("}");
	
	pr.println("function isWhitespace (s)");
	pr.println("{  var i;");
 	pr.println("  // Is s empty?");
 	  pr.println("if (isEmpty(s)) ");
 	  pr.println("return true;");

 	   pr.println("// Search through string's characters one by one");
 	   pr.println("// until we find a non-whitespace character.");
 	  pr.println(" // When we do, return false; if we don't, return true.");
 	   pr.println("for (i = 0; i < s.length; i++)");
 	   pr.println("{   ");
 	       pr.println("// Check that current character isn't whitespace.");
 	       pr.println("var c = s.charAt(i);");
	
 	       pr.println("if (whitespace.indexOf(c) == -1)");
 	       pr.println("return false;");
 	   pr.println("}");
	
 	   pr.println("// All characters are whitespace.");
	   pr.println(" return true;");
	pr.println("}");

  pr.println("function isCharsInBag (s, bag)");
  pr.println("{  ");
    pr.println("var i;");
    pr.println("// Search through string's characters one by one.");
    pr.println("// If character is in bag, append to returnString.");

    pr.println("for (i = 0; i < s.length; i++)");
    pr.println("{   ");
        pr.println("// Check that current character isn't whitespace.");
        pr.println("var c = s.charAt(i);");
        pr.println("if (bag.indexOf(c) == -1) return false;");
    pr.println("}");
    pr.println("return true;");
  pr.println("}");
  



pr.println("function validate(){");

pr.println("if(window.document.f1.name.value.length==0){");
	pr.println("alert(\"Please enter your name\");");
	pr.println("window.document.f1.name.focus();");
	pr.println("return false;");
	pr.println("}");
pr.println("if(window.document.f1.email.value.length==0){");
	pr.println("alert(\"Please enter your email\");");
	pr.println("window.document.f1.email.focus();");
	pr.println("return false;");
	pr.println("}");
	
pr.println("//  FOR EMAIL ");

	pr.println("if(window.document.f1.email.value.length)");
	pr.println("{  	var Ename = document.f1.email.value = document.f1.email.value.toLowerCase();");
		pr.println("var sLength =  Ename.length;");
	
		pr.println("//Validate the login name");
		pr.println("if (isWhitespace(Ename))");
			pr.println("{");
			pr.println("alert (\"You can't leave this field blank\")");
     	  pr.println("window.document.f1.email.focus();");
			pr.println("return false;");
			pr.println("}");
		pr.println("else if ( !isCharsInBag( Ename, \"abcdefghijklmnopqrstuvwxyz0123456789.-_@\" ))");
		pr.println("{");
		pr.println("alert( \"Email ID may only contain the following characters:\\nabcdefghijklmnopqrstuvwxyz0123456789.-_@\" );");
		pr.println("window.document.f1.email.focus();");
		pr.println("return false;");
	    pr.println("}");
		pr.println("else if ( !isCharsInBag( Ename.charAt(Ename.length - 1), \"abcdefghijklmnopqrstuvwxyz0123456789\") )");
	    pr.println("{");
		  pr.println("alert( \"Email ID must end in an alphanumeric character.\");");
		  pr.println("window.document.f1.email.focus();");
		pr.println("return false;");
	    pr.println("}");
		pr.println("else if ( !isCharsInBag( Ename.charAt(0), \"abcdefghijklmnopqrstuvwxyz0123456789\") )");
		pr.println("{");
		pr.println("alert( \"Email ID must start with an alphanumeric character.\");");
		pr.println("window.document.f1.email.focus();");
		pr.println("return false;");
	    pr.println("}");
    
		pr.println("else if ( Ename.length < 3 )");
	    pr.println("{");
		  pr.println("alert( \"Email ID must be 3 or more characters.\" );");
		  pr.println("window.document.f1.email.focus();");
		pr.println("return false;");
		pr.println("}");
	    pr.println("// look for @");
	    pr.println("else if (Ename.indexOf(\"@\") == -1)");
           pr.println("{");
             pr.println("alert(\"Your Email ID must contain @ sign\") ");
             		 pr.println(" window.document.f1.email.focus();");

        pr.println("return false;");
            pr.println("}");
       pr.println("// look for .");
		pr.println("else if (Ename.indexOf(\".\") == -1)");
		    pr.println("{");
             pr.println("alert(\"Your Email ID must contain . sign\")");
             		  pr.println("window.document.f1.email.focus();");

             pr.println("return false;");
            pr.println("}");
      pr.println("// return true;");
	pr.println("}");
	
	pr.println("return true;");
pr.println("}");

pr.println("</script>");

pr.println("</head>");

pr.println("<body bgcolor=\"#c6ffff\">");


pr.println("<div align=\"center\">");
  pr.println("<center>");
  pr.println("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"99%\">");
    pr.println("<tr>");
      pr.println("<td width=\"100%\" colspan=\"2\" bgcolor=\"#FFCCFF\"><a href=http://www.roseindia.net><img border=\"0\" src=\"http://www.roseindia.net/images/paradise.gif\" width=\"420\" height=\"60\" alt=\"Welcome to Java Developers Paradise\"></a>");
		
      pr.println("</td>");
    pr.println("</tr>");
    pr.println("<tr>");
      pr.println("<td width=\"23%\" valign=\"top\">");
        pr.println("<div align=\"center\">");
          pr.println("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"99%\" bordercolor=\"#FFFF00\">");
            pr.println("<tr>");
              pr.println("<td width=\"100%\" bgcolor=\"#FFFFFF\">");
                pr.println("<p align=\"center\"><font color=\"#000080\" size=\"3\">Features</font></td>");
            pr.println("</tr>");
            pr.println("<tr>");
              pr.println("<td width=\"100%\">");
                pr.println("<p align=\"center\"><font color=\"#FF0000\" face=\"Times New Roman\" size=\"4\">Have tutorials?</font><font size=\"1\"><br>                </font><a href=\"http://www.roseindia.net/subscription/addsite.htm\"><font size=\"2\">Add your tutorial to our Java Resource and get tons of hits.</font></a><font size=\"2\"><br>We offer <b>free hosting</b> for your tutorials. and exposure for thousands of readers. drop a mail</font><font face=\"MS Sans serif\" size=\"-2\"><a href=\"mailto:deepak@roseindia.net\"><font color=\"maroon\"><br>deepak@roseindia.net<br></font></a>&nbsp;&nbsp;&nbsp;");
                pr.println(" </font></td>");
            pr.println("</tr>");
            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\" bgcolor=\"#FFFFFF\">");
                pr.println("<font color=\"#000080\" size=\"3\">Search Options</font></td>");
            pr.println("</tr>");
            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\">");
                pr.println("<form method=\"POST\" action=\"" + servletURL + "/search\">");
                  
                  pr.println("<p><input type=\"text\" name=\"item\" size=\"20\"><br>");
                  pr.println("<input type=\"submit\" value=\"Search\" name=\"B1\"></p>");
                pr.println("</form>");
              pr.println("</td>");
            pr.println("</tr>");
            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\" bgcolor=\"#FFFFFF\">");
                pr.println("<p align=\"center\"><font color=\"#000080\" size=\"3\">Link Options</font></td>");
            pr.println("</tr>");
            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\">");
                pr.println("<font color=\"#000080\" size=\"2\"><a href=\"" + servletURL + "/search?placelinks=y\">Place Links</a></font></td>");
            pr.println("</tr>");
            pr.println("<tr>");
              pr.println("<td width=\"100%\" align=\"center\">");
                pr.println("<font color=\"#000080\" size=\"2\"><a href=\"" + servletURL + "/search?modifylink=y\">Modify Links</a></font></td>");
            pr.println("</tr>");

            pr.println("<tr>");
              pr.println("<td width=\"100%\" bgcolor=\"#FFCCFF\" align=\"center\">");
                pr.println("<p align=\"center\"><a href=\"http://www.roseindia.net/jsp/jsp.htm\" style=\"color: #800000\"><font face=\"Times New Roman\" color=\"#800000\" size=\"2\">Java Server Pages</font></a>");
              pr.println("</td>");
            pr.println("</tr>");
            pr.println("<tr>");
              pr.println("<td width=\"100%\" bgcolor=\"#FFCCFF\" align=\"center\">");
                pr.println("<p align=\"center\"><a style=\"color: #800000\" href=\"http://www.roseindia.net/rmi/rmi.htm\"><font face=\"Times New Roman\" color=\"#800000\" size=\"2\">RMI</font></a>");
                pr.println("</p>");
              pr.println("</td>");
            pr.println("</tr>");
            pr.println("<tr>");
              pr.println("<td width=\"100%\" bgcolor=\"#FFCCFF\" align=\"center\">");
        
              pr.println("<p align=\"center\"><a style=\"color: #800000\" href=\"http://www.roseindia.net/javabeans/javabeans.htm\"><font face=\"Times New Roman\" color=\"#800000\" size=\"2\">Java Beans</font></a>");
        
              pr.println("</td>");
            pr.println("</tr>");
            pr.println("<tr>");
              pr.println("<td width=\"100%\" bgcolor=\"#FFCCFF\" align=\"center\">");
                pr.println("<p align=\"center\"><a style=\"color: #800000\" href=\"http://www.roseindia.net/jdbc/jdbc.htm\"><font face=\"Times New Roman\" color=\"#800000\" size=\"2\">JDBC</font></a>");
                pr.println("</p>");
              pr.println("</td>");
            pr.println("</tr>");
            pr.println("<tr>");
              pr.println("<td width=\"100%\" bgcolor=\"#FFCCFF\" align=\"center\">");
                pr.println("<p align=\"center\"><a style=\"color: #800000\" href=\"http://www.roseindia.net/mysql/mysql.htm\"><font face=\"Times New Roman\" color=\"#800000\" size=\"2\">MySQL</font></a>");
                pr.println("</p>");
              pr.println("</td>");
            pr.println("</tr>");
            pr.println("<tr>");
              pr.println("<td width=\"100%\" bgcolor=\"#FFCCFF\" align=\"center\">");
                pr.println("<p align=\"center\"><a style=\"color: #800000\" href=\"http://www.roseindia.net/servlets/servlets.htm\"><font face=\"Times New Roman\" color=\"#800000\" size=\"2\">Java Servlets</font></a>");
              pr.println("</td>");
            pr.println("</tr>");
            pr.println("<tr>");
              pr.println("<td width=\"100%\" bgcolor=\"#FFCCFF\" align=\"center\">");
                pr.println("<p align=\"center\"><a style=\"color: #800000\" href=\"" + servletURL + "/search\"><font face=\"Times New Roman\" color=\"#800000\" size=\"2\">Home</font></a></td>");
            pr.println("</tr>");
            pr.println("<tr>");
              pr.println("<td width=\"100%\">");
              
               pr.println("<form name=\"f1\" method=\"post\" action=\"http://www.roseindia.net/subscription/subscribe.php3\" onsubmit=\"return validate()\">");
            pr.println("<P align=center><font color=\"#FF0000\" size=\"3\">Join Now For Free</font><FONT size=4 color=\"#000080\"></FONT><font color=\"#800000\"> <font size=\"2\"> Weekly newsletter about latest in java.&nbsp;<br>");
            pr.println("Your Name</font> <input type=\"text\" name=\"name\" size=\"20\"><br>");
            pr.println("<font size=\"2\">Your E-mail&nbsp;<br></font></font><INPUT id=text2 size=13 name=email><br><INPUT align=absMiddle alt=Join border=0 name=I2 src=\"http://www.roseindia.net/images/blue_submit.gif\" type=image value=Join width=\"94\" height=\"26\" ></P>");           
        pr.println("</form>");
              
              pr.println("</td>");
            pr.println("</tr>");
          pr.println("</table>");
        pr.println("</div>");
      pr.println("</td>");
      pr.println("<td width=\"77%\" valign=\"top\">");
        pr.println("<div align=\"center\">");
          pr.println("<center>");
          pr.println("<table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">");
            pr.println("<tr>");
              pr.println("<td width=\"100%\" bgcolor=\"#FFFFFF\"><font size=\"3\"><a href=\"http://www.roseindia.net/sourcecode/searchengine\">Download</a> the source code of java search engine.</font></td>");
            pr.println("</tr>");
            pr.println("<tr>");
              pr.println("<td width=\"100%\">&nbsp;&nbsp;&nbsp;</td>");
            pr.println("</tr>");


	}



public void writeBottom(PrintWriter pr){

                  pr.println("</table>");
                pr.println("</div>");
              pr.println("</td>");
            pr.println("</tr>");
          pr.println("</table>");
          pr.println("</center>");
        pr.println("</div>");
      pr.println("</td>");
    pr.println("</tr>");
  pr.println("</table>");
  pr.println("</center>");
pr.println("</div>");
pr.println("<p align=\"center\">&nbsp;<font color=\"#800000\">Copyright 2000, by Java Developers Paradise.<br>All rights reserved.<br>");
    pr.println("</font> ");

pr.println("</p>");
pr.println("<p>&nbsp;</p>");
pr.println("</body>");
pr.println("</html>");
}




}
