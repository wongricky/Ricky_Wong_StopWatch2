<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>StopWatch</title>
</head>
	<body>
		<table width="100%">
			<tr>
				<form action="Start" method="Post">
					<td><button type="submit" name="start" value="start">Start</button></td>
				</form> 
				<form action="Stop" method="Post">
					<td><button type="submit" name="stop">Stop</button></td>
				</form>
				<form action="Reset" method="Post">
					<td><button type="submit" name="reset" value="reset">Reset</button></td>
				</form>
			</tr>
		
		</table>
		<br/><br/><br/><br/>
		<table width="100%">
			<tr>
				<td>Start: <%= session.getAttribute("start") %></td>
				<td>Current Time: <%= session.getAttribute("current") %></td>
				<td>Running Time: <%= session.getAttribute("runTime") %> seconds</td>
			</tr>
		</table>
	</body>
</html>