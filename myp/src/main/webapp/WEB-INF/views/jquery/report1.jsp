<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>

<%
	ArrayList reprot1List = (ArrayList) request.getAttribute("reprot1List");
	//HashMap userMap    = (HashMap)   request.getAttribute("userMap");
%>


<%
							HashMap report1 = new HashMap();
						
						    if (reprot1List != null) {
								for (int i = 0; i < reprot1List.size(); i++) {
									report1 = (HashMap) reprot1List.get(i);
						%>
						<li><%=report1.get("TEST")%></li>
						<%
								}
					    	}
						%>
						
						


						<!DOCTYPE html>
						<html>
						<head>
						<style type="text/css">
						</style>  
						<script>
							function test() {
								alert("hi");
							}
						</script>
						</head>
							<body>
								<form name="frm">
								<input name="btnSave"  type="BUTTON" value="클릭" onClick="test()">
								<input name="test1" id="test1" type="input" value="aa">
								</form>
							</body>
						</html>
						
						