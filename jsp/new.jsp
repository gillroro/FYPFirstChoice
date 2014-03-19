<html> 
<head> 
<title>Multiple Text area Validation</title> 
<script> 
function addInputBox() { 

var ni = document.getElementById('myDiv'); 

var numi = document.myForm.inputboxlength; 

var num = parseInt(numi.value) +1; 
//alert(num); 
numi.value = num; 

var newdiv = document.createElement('div'); 

var divIdName = 'my'+num+'Div'; 

newdiv.setAttribute('id',divIdName); 

newdiv.innerHTML = "<input type=\"text\" name=\"txtArea"+num +"\" /> <input type=\"button\" onclick=\"removeInputBox(\'"+divIdName+"\')\" value='Remove'/>"+divIdName; 

ni.appendChild(newdiv); 

} 

function removeInputBox(divNum) { 

//alert(); 
var d = document.getElementById('myDiv'); 
var numi = document.myForm.inputboxlength; 
//alert("current value inputboxlength="+numi.value); 
var num = parseInt(numi.value) -1; 

numi.value = num; 
var olddiv = document.getElementById(divNum); 
d.removeChild(olddiv); 
//alert("after removing value inputboxlength="+num); 

} 


function reset() 
{ 
var numi = document.myForm.inputboxlength; 
numi.value=0; 
//alert("current value inputboxlength="+numi.value); 
} 

</script> 
</head> 
<body onload="reset()"> 

<form name="myForm" action="result.jsp" > 
<p><input type='button' onclick='addInputBox()' value='Add'/></p> 
<input type="hidden" name="inputboxlength" value="0" /> 
<div id="myDiv"> </div> 

<input type="submit" value="ShowValue" > 
</form> 

</body> 
</html> 