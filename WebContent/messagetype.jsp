<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
    <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="jquery.js"></script>
		<script type="text/javascript">
		
		function messagetype(form)
		{
			
			form.action="./composegroupnames.do?method=displaytemplates";
			form.submit();
		}
function value(form)
{
	var e=$("#messagetemplate option:selected").text();
	}
		function hello(form)
		{
			/* /* var x=document.getElementsByName("messagetype");
			alert(x); */
			/*var messagetype=$(document.getElementsByName("messagetype"));
			var xxx="\'"+messagetype.item()+"\'";
				//$("messagetype option:selected").value();
			alert(xxx.length); */
			
			form.action="./composegroupnames.do?method=displaytemplates";
			form.submit();
		}
		function composebulksms(form)
		{

			form.action="./Link.do?method=composebulksms";
			form.submit();
		}
		function preview(form)
		{

            
            var e=$("#messagetemplate option:selected").text();
            var val="\'"+e+"\'";
           
            
			form.action="./Link.do?method=preview&key="+val;
			
			form.submit();
		}
		</script>
		<link href="styles.css" rel="stylesheet" type="text/css">
	
</head>
<body>
<html:form action="/composegroupnames.do"  method="post">
<c:set var="types" value="${types}"></c:set>
<table id="tab">
			<tr>
				<td colspan="2" align="center">

					<table id="tbl">
						<tr>
						<td>Message Type:</td>
						<td>
						  <html:select property="messagetype"  onchange="hello(this.form)">
                                      <c:forEach items="${types}" var="types">
                    <html:option value="${types}">${types}${duptype}</html:option>
                    <%--  <html:option value="${duptypes}">${duptypes}</html:option> --%>
                                    </c:forEach>
                   
						
						</html:select>  
						
						
						<%--  <select name="messagetype" onchange="hello(this.form)">
						<option >
								SELECT
							</option >
							<option value="sms">
								SMS
							</option >
							<option value="email">
								EMAIL
							</option>
							<option value="voice">
								VOICE
							</option>
							<option value="voice">
								${messagetype}
							</option> --%>

						</select>  
						</td>
						</tr>
						<tr>
							

						<td>Messege TemplateName:</td>
						<td><select id="messagetemplate" name="templatename">
						<c:forEach items="${templatenames}" var="templatenames">
							<option value="templatename" >
								${templatenames}
							</option>
							</c:forEach>

						</select></td>
						<tr>
							<td></td>
							
						</tr>
						<tr>
							<td></td>
						</tr>

					</table>
			<tr>
				<td align="left"><input type="button" value="Previous" onclick=composebulksms(this.form)></td>
				<td align="right"><input type="button" value="next" onclick=preview(this.form)></td>
			</tr>

</td></tr>
		</table>
		</html:form>
</body>
</html:html>