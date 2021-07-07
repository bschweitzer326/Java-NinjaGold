<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold Game</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.6.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/gold.css">
<script type="text/javascript" src="js/app.js"></script>
</head>
<body>

	<div class="container">
            
	    <div class="nav">
	           
	            <span>Your Gold:</span><p class="header"><c:out value="${gold}"/></p>
	
	            <a href="/restart" class="btn btn-danger">Restart</a>

	    </div>
	
	    <div class=boxes>
	        
	        <div class="box">
	            <form action="/process_money" method="POST">
	                <h2>Farm</h2>
	                <p>(Earns 10-20 gold)</p>
	                <input type="hidden" name="location" value="farm">
	                <input class="btn btn-dark" type="submit" value="Find Gold" name="farm">
	                
	            </form>
	        </div>
	
	        <div class="box">
	            <form action="/process_money" method="POST">
	                <h2>Cave</h2>
	                <p>(Earns 5-10 gold)</p>
	                <input type="hidden" name="location" value="cave">
	                <input class="btn btn-dark" type="submit" value="Find Gold" name="cave">
	            </form>
	        </div>
	
	        <div class="box">
	            <form action="/process_money" method="POST">
	                <h2>House</h2>
	                <p>(Earns 2-5 gold)</p>
	                <input type="hidden" name="location" value="house">
	                <input class="btn btn-dark" type="submit" value="Find Gold" name="house">
	            </form>
	        </div>
	
	        <div class="box">
	            <form action="/process_money" method="POST">
	                <h2>Casino</h2>
	                <p>(Earns/Takes 0-50 gold)</p>
	                <input type="hidden" name="location" value="casino">
	                <input class="btn btn-dark" type="submit" value="Find Gold" name="casino">
	            </form>
	        </div>
	    </div>
	
	    <h4>Activities:</h4>
	    <div class="last" style="overflow: auto;">
	        
	        <c:forEach items="${results}" var="result">
	        	<p class="act"><c:out value="${result}"/></p>               
	       	</c:forEach>
	    </div>
	</div>

</body>
</html>