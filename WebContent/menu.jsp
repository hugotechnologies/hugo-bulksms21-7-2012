<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript">
$(document).ready(function () {
            $('#showhidetarget').hide();

            $('a#showhidetrigger').click(function () {
                $('#showhidetarget').toggle(400);
        });
 $("#changepassword").click(function()
{ 
 $("#managecontactsview").hide(1000);
 $("#managecontactsupload").hide(1000);
 $("#managecontactsdelete").hide(1000);
 $("#groupcontactsview").hide(1000);
 $("#groupcontactsupload").hide(1000);
 $("#groupcontactsdelete").hide(1000);
   });
  $("#groupcontacts").click(function(){
    $("#groupcontactsview").show(1000);
 $("#groupcontactsupload").show(1000);
 $("#groupcontactsdelete").show(1000);
    $("#managecontactsview").hide(1000);
 $("#managecontactsupload").hide(1000);
 $("#managecontactsdelete").hide(1000);
  });
$("#managecontacts").click(function(){
    $("#groupcontactsview").hide(1000);
 $("#groupcontactsupload").hide(1000);
 $("#groupcontactsdelete").hide(1000);
    $("#managecontactsview").show(1000);
 $("#managecontactsupload").show(1000);
 $("#managecontactsdelete").show(1000);
     
  });
});
</script>
</head>
<script language="javascript">
function composebulksms(form)
{

	form.action="./Link.do?method=composebulksms";
	form.submit();
}
function changepassword(form)
{
form.method.value="changepassword";
	form.action="./Link.do?method=changepassword";
	form.submit();
}
function groupcontacts(form)
{

form.method.value="groupcontacts";
	form.action="./Link.do?method=groupcontacts";
	form.submit();
}
function groupcontactsupload(form)
{
form.method.value="groupcontacts";
	form.action="./Link.do?method=groupcontactsupload";
	form.submit();
}
function groupcontactsview(form)
{
	form.action="./showData.do";
	form.submit();
}
function groupcontactsdelete(form)
{
	form.action="./deleteData.do";
	form.submit();
}
/*function managecontacts(form)
{
	form.action="./deleteData.do";
	form.action="./Link.do?method=managecontacts";
	form.submit();
}*/
function managecontactsupload(form)
{
	form.action="./Link.do?method=managecontactsupload";
	form.submit();
}
function managecontactsview(form)
{
	form.action="./managecontactsview.do";
	form.submit();
}
function managecontactsdelete(form)
{
	form.action="./managecontactsdelete.do";
	form.submit();
}



</script>
<body>
<form  method="post">
<input type="submit"  value="Change Password" onclick=changepassword(this.form)>
<br>
<input type="submit"   value="Group Contacts" onclick=groupcontacts(this.form)>
<br>
<a href="./Link.do?method=managecontactsupload" >Upload Group Contacts</a>
	
<br>


<a  href="./showData.do">View Group Contacts</a>
<br>
<a  href="./deleteData.do">Delete Group Contacts</a>
<br>
<input type="button" value="Contacts" onclick=groupcontacts(this.form)>
<br>
<a  href="./Link.do?method=groupcontactsupload" >Upload Contacts</a>
<!-- <a href="./Link.do?method=managecontactsupload" >Upload Conts</a> -->
<br>
<a href="./managecontactsview.do" >View Contacts</a>
<br>
<a href="./managecontactsdelete.do" >Delete Contacts</a>
<br>
<input type="button" value="Message Template" onclick=groupcontacts(this.form)>
<br>
<a href="./Link.do?method=sendsmsview">Sms</a>
<br>
<a href="./Link.do?method=sendemail">Email</a>
<br>
<a href="./Link.do?method=voiceupload">VoiceCall</a>
<br>
<input type="button" value="Compose BulkSms" onclick=composebulksms(this.form)>
<br>


<!--<div>
<a  id="groupcontactsupload" type="hidden">Upload Contacts</a>
</div>
<div >
<a id="groupcontactsview" type="hidden">View Contacts</a>
</div>
<div>
<a id="groupcontactsdelete" type="hidden">Delete Contacts</a>
</div>
<button id="managecontacts">Manage Contacts</button><br>
<div>
<a id="managecontactsupload" type="hidden">Upload Contacts</a>
</div>
<div>
<a id="managecontactsview" type="hidden">View Contacts</a>
</div>
<div>
<a id="managecontactsdelete" type="hidden">Delete Contacts</a>
</div>
-->

</form>
</body>
</html>
