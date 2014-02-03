function Edit(){
    var par = $(this).parent().parent(); //tr
    var tdFirstName = par.children("td:nth-child(1)");
    var tdSurname = par.children("td:nth-child(2)");
    var tdUsername = par.children("td:nth-child(3)");
    var tdPassword = par.children("td:nth-child(4)");
	var tdAddress = par.children("td:nth-child(5)");
	var tdSalary = par.children("td:nth-child(6)");
	var tdUserType = par.children("td:nth-child(7)");
	var tdManager = par.children("td:nth-child(8)");
 
    tdFirstName.html("<input type='text' id='txtFirstName' value='"+tdFirstName.html()+"'/>");
    tdSurname.html("<input type='text' id='txtSurname' value='"+tdSurname.html()+"'/>");
    tdUsername.html("<input type='text' id='txtUsername' value='"+tdUsername.html()+"'/>");
	tdPassword.html("<input type='text' id='txtPassword' value='"+tdPassword.html()+"'/>");
	tdAddress.html("<input type='text' id='txtAddress' value='"+tdAddress.html()+"'/>");
	tdSalary.html("<input type='text' id='txtSalary' value='"+tdSalary.html()+"'/>");
	tdUserType.html("<input type='text' id='txtUserType' value='"+tdUserType.html()+"'/>");
	tdManager.html("<input type='text' id='txtManager' value='"+tdManager.html()+"'/>");
    tdButtons.html("<img src='images/disk.png' class='btnSave'/>");
 
    $(".btnSave").bind("click", Save);
    $(".btnEdit").bind("click", Edit);
    $(".btnDelete").bind("click", Delete);
};

$(function () {
    $("td").dblclick(function () {
        var OriginalContent = $(this).text();
          
        $(this).addClass("cellEditing");
        $(this).html("<input type='text' value='" + OriginalContent + "' />");
        $(this).children().first().focus();
  
        $(this).children().first().keypress(function (e) {
            if (e.which == 13) {
                var newContent = $(this).val();
                $(this).parent().text(newContent);
                $(this).parent().removeClass("cellEditing");
            }
        });
          
    $(this).children().first().blur(function(){
        $(this).parent().text(OriginalContent);
        $(this).parent().removeClass("cellEditing");
    });
    });
});


