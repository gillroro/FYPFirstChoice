 $("input[type='text']").blur(function(){
    $(this).hide().after('<span class="dfk">' + $(this).val() + '</span>');  

});
$("#editBut").click(function() {
     $('.textboxes span').hide();
     $('.textboxes input[type=text]').show();
});
