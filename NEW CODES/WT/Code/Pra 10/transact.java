import java.io.IOException; 
import java.io.PrintWriter; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
public class transact extends httpServlet { 
protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{ 
response.setContentType("text/html;charset=UTF-8"); 
try 
{ 
PrintWriter out = response.getWriter()}; 
String selectdType=request.getParameter("transact"); 
int amount=Integer.ParseInt(request.getParameter(t1)); 
if(selectdType.equals("deposite")) 
{ 
bankTransact.deposite(amount); 
} 
if(selectdType.equals("withdraw")) 
{ 
int amt=bankTransact.withdraw(amount); 
out.println(amount="successfully withdraw. Your Balance is: Rs"+ amt) 
} 
} 
} 
private BankTransactLocal lookupBankTransactLocal() 
{ 
try 
{ 
Context c= New initialContext(); 
return(BankTransactLocal)c.Lookup("java.global/Bank/Bank-ejb/BankTransact!Bankexamp.Bank/Bank-
            ejb/BankTransactLocal") 
} 
catch (NamingException ne) 
{ 
Logger.getLogger(getClass().getName().log(Level.SEVERE,"exception caught",ne)) 
throw new RuntimeException(ne); 
} 
}
