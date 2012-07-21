<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
<head>

<script language="javascript" type="text/javascript">

	function limitText(limitField, limitCount, limitNum) {
		if (limitField.value.length > limitNum) {
			limitField.value = limitField.value.substring(0, limitNum);
		} else {
			limitCount.value = limitNum - limitField.value.length;
		}
	}
	
</script>

<style type="text/css">
#col {
	text-align: right;
	font-family: verdana;
	color: green;
	size: 20px;
}

fieldset {
	width: 350px;
	height: 350px;
	margin-top: 20px;
	margin-left: 100px;
}
</style>
<!-- <input id="Action" type="hidden" value="fagstheydg345" name="Action"> -->
</head>

<body>
	<fieldset>
		<legend style="font-family: verdana;color: green;size: 14px;">Save
			Template</legend>
		<br> <br>
		<html:errors/>
		<form action="./sendsms.do?method=sendsms" method="post">
			<table width="353" height="243">
			<tr>
							<td id="col">Template Name:</td>
							<td><input type="text"" name="templatename" />
							</td>
						</tr>
				<tr>
					<td></td>
				</tr>
				
				<tr>
					<td id="col">SMS Message:</td>
					<td><textarea name="body" rows="5" 
							onKeyDown="limitText(this.form.body,this.form.countdown,160);"
							onKeyUp="limitText(this.form.body,this.form.countdown,160);" style="white-space: nowrap;"></textarea>
					</td>
				</tr>
				<tr>
					<td></td>
					<td id="col"><font size="1">(Maximum characters: 160)</font></td>
				</tr>
				
				<tr>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2"><font size="2"> You have <input
							readonly type="text" name="countdown" size="3" value="160">
							characters left.</font></td>
					</td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					
					<td id="col"><input type="submit" value="save template" />		
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>
