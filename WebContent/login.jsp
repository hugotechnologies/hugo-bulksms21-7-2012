<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html>
	<head>
	<link href="styles.css" rel="stylesheet" type="text/css">
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
	
		<div id='ta'>
		
<h3 align="center" style="font-weight:normal;">Login Here</h3><br>
<font color="red">
<html:errors/>
</font>
	<html:form action="/login">
		
		<table id="tab">
			<tr>
				<td colspan="2" align="center">

					<table id="tbl">

						<tr>
							<td>Username:</td>
							<td><html:text property="username" />
							</td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><html:password property="password" />
							</td>
						</tr>
						<tr>
							<td></td>
							<td align="right"><html:submit value="Login" />
							</td>
						</tr>
						<tr>
							<td></td>
						</tr>

					</table>
			<tr>
				<td align="left"><a href="register.jsp">New User</a></td>
				<td align="right"><a href="forget.jsp">Forgotten password</a></td>
			</tr>


		</table>
	</html:form>
</div>
	</body>
</html>