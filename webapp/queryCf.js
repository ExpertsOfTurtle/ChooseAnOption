function getValuesFromInputs(inputs) {
	var arr = new Array();
	for (var i = 0; i < inputs.length; i++) {
		arr.push(inputs[i].value);
	}
	return arr;
}
function getIntegersFromInputs(inputs) {
	var arr = new Array();
	for (var i = 0; i < inputs.length; i++) {
		arr.push(parseInt(inputs[i].value));
	}
	return arr;
}


function queryCfResult() {
	var name=$("#filterUser").val();
	var sdate=$("#dateFrom").val();
	var edate=$("#dateTo").val();
	var type=$("input[name='Type']:checked").val();
	var status=$("input[name='Status']:checked").val()

	var param = {
		"requestType" : "",
		"sdate":sdate,
		"edate":edate,
		"type": type,
		"status": status,
		"name": name
	}
	$.ajax({
		type : "POST",
		url : "wf/main/choose/queryCfResult",
		data : JSON.stringify(param),
		contentType : "application/json; charset=utf-8",
		dataType : "text",
		success : function(result) {
			console.log(result);
			qq = result;
			$("#resultList").html(result);
		},
		error : function() {
			console.log("error");
		}
	});
	
	function updCfStatus(problemid){
		
	}
}
