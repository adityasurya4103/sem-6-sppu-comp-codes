<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body style="margin-left: 40%; margin-top: 10%">
        <h1>Login Form</h1>
        <s:form action="login_action">
            <s:textfield name="name" label="Enter your Name: "/>
            <s:textfield name="mobileno" label="Enter your Mobile No: "/>
            <s:textfield name="email" label="Enter your Email: "/>
            <s:submit value="Login" align="center"/>                
        </s:form>
    </body>
</html>
