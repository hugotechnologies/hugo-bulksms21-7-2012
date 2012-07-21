<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
<head>

<title>Register here</title>
<link rel="stylesheet" type="text/css" href="styles.css">
<script type="text/javascript">
// -->

	function loadXMLDoc() {
		var xmlhttp;
		var k = document.getElementById("email").value;
		var urls = "CheckUser?email=" + k;

		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState==4 && xmlhttp.status==200) {
				//document.getElementById("err").style.color="red";
				document.getElementById("err").innerHTML = xmlhttp.responseText;

			}
		};
		xmlhttp.open("GET", urls, true);
		xmlhttp.send();
	}
</script>
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
    width: 250px;
    height: 200px;
            }
            h3{
	font-family:Verdana;
	color: DodgerBlue;
	font-size: 14px;
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
<body onload="ClearForm()">
<div id='ta'>
	<font color="red">
<html:errors/>

</font>
<p>${message}</p>
	<form name="myform" action="./newuser.do" method="get">
		<table id="tab">
			<tr>
				<td colspan="2">

					<table id="tbl">


						<tr>
							<td>Username:</td>
							<td><input type="text" name="uname">
							</td>
						</tr>
						<tr>
							<td>Email:</td>
							<td><input type="email" name="email" id="email"
								required="required" onchange="loadXMLDoc()"></td>
						</tr>
						<tr>
							<td></td>
							<td><span id="err"></span></td>
						</tr>

						<tr>
							<td>Address:</td>
							<td><input type="text" name="address" />
							</td>
						</tr>

						<tr>
							<td>Phone:</td>
							<td><input type="text" name="phone" />
							</td>
						</tr>

						<tr>
							<td></td>
							<td align="right"><input type="reset" value="Reset" /><input
								type="submit" value="Register" /></td>
						</tr>
						<tr>
							<td></td>
						</tr>

					</table>
		</table>
	</form>
	</div>
</body>
</html>