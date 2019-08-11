<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Stopped Time</title>
</head>
<body>
	<table width="100%">
		<tr>
			<td><h1>Start: <%= session.getAttribute("start") %></h1></td>
			<td><h1>Stopped Time: <%= session.getAttribute("stop") %></h1></td>
			<td><h1>Lapsed Time: <%= session.getAttribute("runTime") %> seconds</h1></td>
		</tr>
	</table>
	<br/><br/><br/>
	<table width="100%">
		<tr>
			<form action="Reset" method="Post">
				<td><button type="submit" name="restart" value="restart">Restart</button></td>
			</form>
		</tr>
	</table>
</body>
</html>