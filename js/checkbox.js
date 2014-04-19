function Ischecked(current){
    if( $(current).is(":checked")){
        var name = current.name;
        var id = current.id;
        var substr = id.split('-');
        var num = substr[1];
        if(num==1){
        num = 2;
        }else{
         num = 1;   
        }
        $("#"+name+"-"+num).attr("disabled","disabled");

     }
} 