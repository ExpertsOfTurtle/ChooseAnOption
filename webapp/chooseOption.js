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

function queryGroup() {
	var param = {
		"requestType" : "forChoose"
	}
	$.ajax({
		type : "POST",
		url : "wf/main/choose/queryGroup",
		data : JSON.stringify(param),
		contentType : "application/json; charset=utf-8",
		dataType : "text",
		success : function(result) {
			console.log(result);
			qq = result;
			$("#groupNameList").html(result);
		},
		error : function() {
			console.log("error");
		}
	});
}

function chooseOption(groupid) {
	var param = {
		"requestType" : "",
		"date":"",
		"groupid": groupid
	}
	$.ajax({
		type : "POST",
		url : "wf/main/choose/chooseOption",
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
}
