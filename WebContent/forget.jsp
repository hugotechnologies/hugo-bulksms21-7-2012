<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html:html>
	<head>
		<link rel="stylesheet" type="text/css" href="styles.css">
		<style><!--
		@CHARSET "ISO-8859-1";
div
{
height:200;
width:100;
position: absolute;
top:50%;
left: 50%;
margin-top: -100px;
margin-left: -130px;
}

 #ta {
    text-align: center;
    border: 1px solid #000000;
    width: 350px;
    height: 150px;
            }
	a{
font-family:Verdana;
font-size:11px;
color: Blue;
text-decoration: none;
}
a:HOVER{
text-decoration:underline;
}
		--></style>
	</head>
	<body>
	<div id='ta'>
			
		<h3> Enter your email</h3>
		<p>${message}</p>
		<font color="red">
 <html:errors/>
</font>
		<html:form action="/sendmail.do" method="post">
			<table class="new">
				<tr>
					<td colspan="2">

						<table id="tbl">

							<tr>
								<td>
									E-Mail:
								</td>
								<td>
									<html:text property="email" />
								</td>
								<td align="right">
									 <html:submit>Submit</html:submit>
								</td>
							</tr>

						</table>
			</table>
			<br>
			<br>
			<h4 style="margin-left: 100px;">
				<span id="err"></span>
			</h4>
		</html:form>
</div>
	</body>
</html:html>