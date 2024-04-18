<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Student Registration Form</title>
	<style>
		/* CSS styles for the form go here */
		/* Styles for the form */
form {
  max-width: 500px;
  margin: 0 auto;
  font-family: Arial, sans-serif;
  padding: 20px;
  background-color: #f5f5f5;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0,0,0,0.2);
}

h1 {
  text-align: center;
}

label {
  display: block;
  margin-bottom: 10px;
}

input[type="text"], input[type="number"], input[type="submit"] {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  margin-bottom: 20px;
  box-sizing: border-box;
}

input[type="submit"] {
  background-color: #e6b225;
  color: black;
  border: none;
  cursor: pointer;
  font-size: 16px;
  margin-top: 20px;
}

input[type="submit"]:hover {
  background-color: #fcba03 ;
}
		
	</style>
</head>
<body>
	<h1>Student Registration Form</h1>
	<form action="studentinsert.jsp" method="post">
		<label for="student_id">Student ID:</label>
		<input type="number" id="student_id" name="student_id" required><br>
		
		<label for="student_name">Student Name:</label>
		<input type="text" id="student_name" name="student_name" required><br>
		
		<label for="class">Class:</label>
		<input type="text" id="class_Name" name="class_Name" required><br>
		
		<label for="division">Division:</label>
		<input type="text" id="division" name="division" required><br>
		
		<label for="city">City:</label>
		<input type="text" id="city" name="city" required><br>
		
		<input type="submit" value="Submit">
	</form>
</body>
</html>
