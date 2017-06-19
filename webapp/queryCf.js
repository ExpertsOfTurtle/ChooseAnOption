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
}


function updCfStatus(problemid) {
	var param = {
		"requestType" : "updStatus",
		"status" : "1",
		"problemNo" : problemid
	}
	$.ajax({
		type : "POST",
		url : "wf/main/choose/updateCf",
		data : JSON.stringify(param),
		contentType : "application/json; charset=utf-8",
		dataType : "text",
		success : function(result) {
			console.log(result);
			$("#groupMsgBox .alert-success .content").html("更新成功");
			$("#groupMsgBox .alert-success").show();
			$("#groupMsgBox .alert-danger").hide();
			$("#finish").hide();
		},
		error : function() {
			console.log("error");
			$("#groupMsgBox .alert-danger .content").html("更新失败：未知原因");
			$("#groupMsgBox .alert-success").hide();
			$("#groupMsgBox .alert-danger").show();
		}
	});
}

function addCfProblem() {
	var respondent=$("#filterUser2").val();
	var type=$("#problemNoType").val();
	var num=$("#problemNum").val();
	var deadline=$("#deadlineT").val()
	if(deadline.length==0){
		deadline="-1";
	}
	if(num.length==0){
		num=1;
	}
	var param = {
		"requestType" : "addPunishProNo",
		"respondent" : respondent,
		"type" : type,
		"num" : num,
		"deadline" : deadline 
	}
	$.ajax({
		type : "POST",
		url : "wf/main/choose/updateCf",
		data : JSON.stringify(param),
		contentType : "application/json; charset=utf-8",
		dataType : "text",
		success : function(result) {
			console.log(result);
			$("#groupMsgBox .alert-success .content").html("更新成功");
			$("#groupMsgBox .alert-success").show();
			$("#groupMsgBox .alert-danger").hide();
			$("#finish").hide();
		},
		error : function() {
			console.log("error");
			$("#groupMsgBox .alert-danger .content").html("更新失败：未知原因");
			$("#groupMsgBox .alert-success").hide();
			$("#groupMsgBox .alert-danger").show();
		}
	});
}



