<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Details</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
    <center>
        <display:table name="sessionScope.ManageForm.list" requestURI="/managecontactsview.do" pagesize="30" >
            <display:column property="groupcontactid" title="Groupcontact Id" sortable="true"   />
            <display:column property="recipientname" title="Recipient Name" sortable="true"  />
            <display:column property="recipientemail" title="Recipient Email" sortable="true"   />
            <display:column property="recipientphone" title="Recipient Phone" sortable="true"   />
        </display:table>
        </center>
    </body>
</html>
