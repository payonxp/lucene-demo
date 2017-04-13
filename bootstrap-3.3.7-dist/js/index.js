$(document).ready(function(){


// 清屏
  $("#clean").click(function(){
    
    $("#result").text(" ");
  });

// 索引点击完成

$("#suoyin").click(function(){
    

    $.post("localhost:8888/demo/index",
  		{
    		
    		path:$("#suoyintext").val()
  		},
  		function(data,status){
  			$("#result").text(data["result"]);
    		
  	});
});

$("#chaxun").click(function(){
    

    $.post("localhost:8888/demo/query",
  		{
    		
    		path:$("#chaxuntext").val()
  		},
  		function(data,status){
  			$("#result").text(data["result"]);
    		
  	});
});


});