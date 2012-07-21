<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html>
	<head>
	<style type="text/css">

  


        </style>
	
		<script type="text/javascript" src="jquery.js"></script>
		<script type="text/javascript">
		function composebulksms(form)
		{
			  var e=$("#groupcontacts option:selected").text();
	            var val="\'"+e+"\'";
	           alert(val);
			form.action="./Link.do?method=composemessagetype&key="+val;
			form.submit();
		}
		
	function RBtnCk(info)
	{
		//var N = info.name;
		
		var YN = getCheckedRadio();
		//var YN =info.Q1yn.valueOf().value;
		//var YN = info.Q1yn.value; // alert(N+' : '+YN);
		//var YN = document.getElementsByName('Q1yn')[0].selectedIndex.value;
		var show = 'none';
		if (YN == 'Yes') 
		{   
			$("#divId").show();
			info.action="./composegroupnames.do?method=groupnamesdisplay";
			info.submit(); 
			
			show = 'block';
		}
		else if (YN == 'No')
		{
			$("#divId").hide();
			/* info.action="./composegroupnames.do?method=groupnames";
			info.submit(); */
		}
		document.getElementById(N + 'Text').style.display = show;
		document.getElementById("msgtype").SetEditable(false);
		disable_dropdown();
	}
	 function getCheckedRadio() {
	      var radioButtons = document.getElementsByName("Q1yn");
	      for (var x = 0; x < radioButtons.length; x ++) {
	    	 if (radioButtons[x].checked) {
	          return radioButtons[x].value;
	        }
	      }
	    }
	function next() {
		document.getElementById("msgtype").SetEditable(true);
	}
	
</script>
		<link href="styles.css" rel="stylesheet" type="text/css">
	</head>
	<body>
	<div id='ta'>
		<form  method="post">
			<table id="tab">
				<tr>
				<td colspan="2" align="center">
				<table id="tbl">
				 
				<tr>
				<td>
						<input name="Q1yn" type="radio" value="No"   onclick="RBtnCk(this.form)">
						Contacts:
					</td>
				</tr>
				<tr>
					<td>
					
						<input name="Q1yn" type="radio"   value="Yes"  onclick="RBtnCk(this.form)">
						Group Contacts:
					</td>
					<td>
		<div id="divId">
		
          <select name="hugo" id="groupcontacts">
          <c:forEach items="${groupnames}" var="groupnames">
	       <option >${groupnames}</option>
	        </c:forEach>
          </select>
          
         </div>
		</td>
				</tr>

				
			</table>
			<tr>
			
				<td align="right"><input type="button" value="Next" onclick=composebulksms(this.form)></td>
			</tr>

</table>

		</form>
		</div>
	</body>
</html>
<!--<p><button id="btn1">Trigger focus event for input field</button></p>
<p><button id="btn2">Trigger blur event for input field</button></p>
-->