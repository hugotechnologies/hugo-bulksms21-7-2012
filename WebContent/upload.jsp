<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<% response.addHeader("Refresh","20"); %>
<html>

<head>
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
    width: 350px;
    height: 150px;
            }
</style>
</head>
<body >
<div id='ta' >
<h3 >Upload Here</h3><br>
<font color="red">
 <html:errors/>
</font>
	<html:form action="/firstupload.do" enctype="multipart/form-data">
		<table>
					<tr><td>
							
           File Name
               <html:file property="filelocation"/> 
                 </td>  </tr> 
                      <tr>
               <td align="center" colspan="2">
                 <html:submit>Upload File</html:submit>
                 </td>
                 </tr>
                 </table>
</html:form>
</div>
</body>
</html>