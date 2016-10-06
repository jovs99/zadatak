<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
	body {
		margin:0px;
	}

	table, td, th {
    border: 1px solid #ddd;
    text-align: left;
	}
	th {
		background-color: lightgray;
	}
	table {
	    border-collapse: collapse;
	    width: 70%;
	}
	
	th, td {
	    padding: 15px;
	}
	
	a {
		color: black;text-transform: uppercase;
	}
	
	input.searchInput {
		font-size: 20px;
	    padding: 6px;
	    margin-left: -5px;
	}
	
</style>
<title>Welcome</title>
</head>
<body>
	<div style="background-color: gainsboro; height:50px; width:100%">
		<form action="logout" method="post">
			<p style="text-align:right;-webkit-margin-before: 0em; padding: 15px;">Welcome <b>${loggedInUser}</b>!&nbsp;&nbsp;
			<input type="submit" value="Logout">
			</p>
		</form>
	</div>
	
	 <div align="center">
            <h1>Generated Sequences</h1>
            <div style="width: 70%;margin-bottom: 10px;">
	            <div style="float:right">
		            <form action="searchSequence" method="post" onsubmit="return checkLength();">
			            <input type="text" id="inputSearch" name="searchValue" placeholder="Search" style="padding: 6px;font-size: 20px; width: 125px;"/>
			            <input class="searchInput" type="submit" value="Find" />
		            </form>
	            </div>
	            <div style="float:left; text-align: right;">
	            	<h3><a style="padding: 10px;border: 1px solid;background-color: gainsboro;text-decoration: none;" href="newSequence">New Sequence</a></h3>
       			</div>
            </div>
            <table style="clear:both;" id="mytable" class="tablesorter">
            <thead>
                <th>No</th>
                <th>Submitted By</th>
                <th>Purpose</th>
                <th>Date</th>
               </thead>
               <tbody>
                <c:forEach var="sequence" items="${listSequences}" varStatus="status">
                <tr>                    
                    <td><c:out value="${sequence.id}" /></td>
                    <td><c:out value="${sequence.submittedBy}" /></td>
                    <td><c:out value="${sequence.purpose}" /></td>
                    <td><c:out value="${sequence.date}" /></td>                             
                </tr>
                </c:forEach>   
                </tbody>           
            </table>
            <!--  pager -->
            <div style="width: 70%;margin-bottom: 10px;">
	            <div id="pager" class="pager" style="float:right; text-align: right; position: initial !important;">
				  <form>
<%-- 				    <img src="<c:url value="first.png" />" class="first" style="display:none;"/> --%>
				    <img src="<c:url value="/resources/images/prev.png" />" class="prev"/>
				    <span class="pagedisplay"></span>
				    <img src="<c:url value="/resources/images/next.png"/>" class="next"/>
<!-- 				    <img src="last.png" class="last" style="display:none;"/> -->
				    <select class="pagesize" style="display:none;">
				      <option value="5">5</option>
				      <option value="all">All Rows</option>
				    </select>
				  </form>
				</div>
			</div>
         </div>
</body>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-latest.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.tablesorter.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.tablesorter.pager.js" />"></script>
<script> 	
	$(document).ready(function() { 
		$("table").tablesorter()
		.tablesorterPager({container: $("#pager"), size: 5}); 
	});
	
	function checkLength(){
		var input = document.getElementById("inputSearch").value;
		var n = input.length;
		if(n < 3){
			return false;
		}
	}
</script>

</html>
