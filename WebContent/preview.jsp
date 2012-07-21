<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<html>
	<head>
	<link href="styles.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="jquery.js"></script>
		<script type="text/javascript">
		function composebulksms(form)
		{
			form.action="./Link.do?method=composemessagetype";
			form.submit();
		}
		function proceed(form)
		{
			form.action="./Link.do?method=proceed";
			form.submit();
		}
		</script>
        <style>
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
    width: 250px;
    height: 200px;
            }
            h3{
	font-family:Verdana;
	color: DodgerBlue;
	font-size: 14px;
	}
	#td
	{
	col:red;
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
        </style>
      	
	</head>
	<body>
	<form method="post">
	
		<div id='ta'>
		
<h3 align="center" style="font-weight:normal;">preview message</h3><br>
<font color="red">
</font>
	
		
		<table id="tab">
			<tr>
				<td colspan="2" align="center">

					<table id="tbl">
					<tr>
							<td><%
        out.println("<b>" + request.getAttribute("header") + "</b>");
%></td>
<tr><td>${message}</td></tr>
					<tr><td><%
                  out.println("<b>" + request.getAttribute("footer") + "</b>");%></td></tr>						
					</table>
			<tr>
			<td></td>
			<td align="left"><input type="button" value="Previous" onclick=composebulksms(this.form)></td>
				<td align="right"><input type="button" value="Proceed" onclick=proceed(this.form)></td>
			</tr>
		</table>
	
</div>
</form>
	</body>
