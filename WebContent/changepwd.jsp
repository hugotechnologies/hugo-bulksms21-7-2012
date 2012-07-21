<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
   <html:html>
     <head>
<title>Change Password</title>
<link rel="stylesheet" type="text/css" href="styles.css">
<style>
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
    width: 320px;
    height: 200px;
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
<center>
	<h3>Change Password</h3>
	<font color="red">
<html:errors/>
</font>
		<html:form action="/changepwd">
			<table id="tab">
				<tr>
					<td colspan="2">
<p>${message}</p>
						<table id="tbl">
						
							
							
							<tr>
								<td>Old Password: </td>
								<td><html:password property="oldpwd"/>
								</td>
							</tr>
							<tr>
								<td>New Password: </td>
								<td><html:password property="newpwd"/>
								</td>
							</tr>
							<tr>
								<td>Retype: </td>
								<td><html:password property="retype"/>
								</td>
							</tr>
							<tr>
								<td></td>
								<td align="right"><html:reset value="Reset"/><html:submit value="Change" /></td>
							</tr>
							<tr>
							
								<td></td>
							</tr>

						</table>
			</table>
		</html:form>
		</center>
		</div>
	</body>
</html:html>