$(document).ready(function(){
$('#completed').hide();
$('#uncompleted').hide();

	$('#yeschecked').click(function() {
	    $("#completed").toggle(this.checked);
	});
	$('#nochecked').click(function() {
	    $("#uncompleted").toggle(this.checked);
	});
	
});