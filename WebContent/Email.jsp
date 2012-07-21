<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
<head>
<style type="text/css">
#col {
	text-align: right;
	font-family: verdana;
	color: green;
	size: 20px;
}

fieldset {
	width: 400px;
	height: 400px;
	margin-top: 20px;
	margin-left: 100px;
}
</style>
<!-- <input id="Action" type="hidden" value="fagstheydg345" name="Action"> -->
</head>

<body>
	<fieldset>
		<legend style="font-family: verdana;color: green;size: 14px;">send
			Email</legend>
		<br> <br>
		<html:errors/>
		<form action="./sendemail.do"  method="post">
			<table>
				<tr>
					<td id="col">Template Name:</td>
					<td><input type="text" name="description" size="46" /></td>				
				</tr>
				<tr>
					<td id="col">Mail Header:</td>
					<td><input type="text" name="header" size="46"/></td>

				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td id="col">Mail Body:</td>
					<td><textarea name="body" rows="10" cols="50"></textarea>
					</td>
				</tr>
				
				<tr>
					<td id="col">Mail Footer:</td>
					<td><input type="text" name="footer" size="46">
					</td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td id="col"><input type="submit" value="send email" />
					</td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				
			</table>

		</form>
	</fieldset>
</body>
</html>
