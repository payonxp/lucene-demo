$(document).ready(function(){


// 清屏
  $("#clean").click(function(){

    $("#result").text(" ");
  });

// 索引点击完成

$("#suoyin").click(function(){

    var data = {
        path:$("#suoyintext").val()
    };
    $.ajax({
        type: "POST",
        url: '/demo/index',
        headers: {
            'Content-Type': 'application/json'
        },
        dataType: 'json',
        async: false,
        data: JSON.stringify(data),
        success: function (data) {
            console.log(data);
            for (var str in data.results) {
                var p = document.createElement('p');
                p.innerHTML = data.results[str];
                document.getElementById("result").appendChild(p);
            }

        }
    })
});

$("#chaxun").click(function(){

	var data = {
        keyword:$("#chaxuntext").val()
    };
    $.ajax({
        type: "POST",
        url: '/demo/query',
        headers: {
        	'Content-Type': 'application/json'
		},
        dataType: 'json',
        async: false,
        data: JSON.stringify(data),
        success: function (data) {
			console.log(data);
			for (var str in data.results) {
				var p = document.createElement('p');
				p.innerHTML = data.results[str];
                document.getElementById("result").appendChild(p);
			}

        }
    })
});


});
