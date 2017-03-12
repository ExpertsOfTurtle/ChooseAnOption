function insertGroup() {
	var param = {
		"requestType" : "0",
		"groupName" : $("input[name=groupName]").val()
	}
	$.ajax({
		type : "POST",
		url : "wf/main/choose/createGroup",
		data : JSON.stringify(param),
		contentType : "application/json; charset=utf-8",
		dataType : "text",
		success : function(result) {
			console.log(result);
			$("#groupMsgBox .alert-success .content").html("成功创建");
			$("#groupMsgBox .alert-success").show();
			$("#groupMsgBox .alert-danger").hide();
			queryGroup();
		},
		error : function() {
			console.log("error");
			$("#groupMsgBox .alert-danger .content").html("创建失败：未知原因");
			$("#groupMsgBox .alert-success").hide();
			$("#groupMsgBox .alert-danger").show();
		}
	});
}
function insertRow() {
	var html = $("#emptyOptionRow tbody").html();
	$("#optionBody").append(html);
}
function submit() {
	var groupId = parseInt($("#groupId").val());
	var optionnameList = new Array();
	var optionnameOrgList = new Array();
	var probabilityList = new Array();
	var probabilityOrgList = new Array();
	var optionidList = new Array();
	optionnameList = getValuesFromInputs($("#optionBody input[name=optionname]"));
	optionnameOrgList = getValuesFromInputs($("#optionBody input[name=probabilityorginal]"));
	probabilityList = getIntegersFromInputs($("#optionBody input[name=probability]"));
	probabilityOrgList = getIntegersFromInputs($("#optionBody input[name=probabilityorginal]"));
	optionidList = getIntegersFromInputs($("#optionBody input[name=optionid]"));
	if (optionnameList.length != optionnameOrgList.length
			|| probabilityList.length != probabilityOrgList.length) {
		$("#groupMsgBox .alert-danger .content").html("你好奇怪吖");
		$("#groupMsgBox .alert-success").hide();
		$("#groupMsgBox .alert-danger").show();
		return;
	}
	updateOptions(optionidList, optionnameList, probabilityList);

	optionnameList = getValuesFromInputs($("#optionBody input[name=optionnameNew]"));
	probabilityList = getIntegersFromInputs($("#optionBody input[name=probabilityNew]"));

	if (optionnameList.length != 0) {
		insertOptions(groupId);
	}
}

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
function insertOptions(groupId) {
	var optionnameList = getValuesFromInputs($("#optionBody input[name=optionnameNew]"));
	var probabilityList = getValuesFromInputs($("#optionBody input[name=probabilityNew]"));
	var nameList = new Array();
	var propList = new Array();
	for (var i = 0; i < optionnameList.length; i++) {
		if (optionnameList[i] != null && optionnameList[i].length > 0
				&& probabilityList[i] != null && probabilityList[i].length > 0) {
			nameList.push(optionnameList[i]);
			propList.push(parseInt(probabilityList[i]));
		}
	}
	if (nameList.length == 0 || nameList.length != propList.length) {
		return;
	}

	var param = {
		"requestType" : "0",
		"groupId" : groupId,
		"options" : nameList,
		"probabilitys" : propList
	}
	$.ajax({
		type : "POST",
		url : "wf/main/choose/createOption",
		data : JSON.stringify(param),
		contentType : "application/json; charset=utf-8",
		dataType : "text",
		success : function(result) {
			console.log(result);
			$("#groupMsgBox .alert-success .content").html("插入选项成功");
			$("#groupMsgBox .alert-success").show();
			$("#groupMsgBox .alert-danger").hide();
		},
		error : function() {
			console.log("error");
			$("#groupMsgBox .alert-danger .content").html("未知原因");
			$("#groupMsgBox .alert-success").hide();
			$("#groupMsgBox .alert-danger").show();
		}
	});
}
function updateOptions(idList, nameList, propList) {
	var param = {
		"requestType" : "0",
		"optionIdList" : idList,
		"optionNameList" : nameList,
		"probabilityList" : propList
	}
	$.ajax({
		type : "POST",
		url : "wf/main/choose/updateOption",
		data : JSON.stringify(param),
		contentType : "application/json; charset=utf-8",
		dataType : "text",
		success : function(result) {
			console.log(result);
			$("#groupMsgBox .alert-success .content").html("成功更新");
			$("#groupMsgBox .alert-success").show();
			$("#groupMsgBox .alert-danger").hide();
		},
		error : function() {
			console.log("error");
			$("#groupMsgBox .alert-danger .content").html("更新失败：未知原因");
			$("#groupMsgBox .alert-success").hide();
			$("#groupMsgBox .alert-danger").show();
		}
	});
}
function queryGroup() {
	var param = {
		"requestType" : "0",
		"groupName" : "",
		"groupId" : "-1"
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
			$("#groupList").html(result);
//			$("#choose").html(result);
		},
		error : function() {
			console.log("error");
		}
	});
}
function queryOption(id) {
	var param = {
		"requestType" : "0",
		"groupName" : "",
		"groupId" : id
	}
	$.ajax({
		type : "POST",
		url : "wf/main/choose/queryOption",
		data : JSON.stringify(param),
		contentType : "application/json; charset=utf-8",
		dataType : "text",
		success : function(result) {
			console.log(result);
			qq = result;
			$("#optionDetail").html(result);
		},
		error : function() {
			console.log("error");
		}
	});
}
function deleteGroup(id, obj) {
	var param = {
		"requestType" : "0",
		"groupName" : "",
		"groupId" : id
	}
	$.ajax({
		type : "POST",
		url : "wf/main/choose/deleteGroup",
		data : JSON.stringify(param),
		contentType : "application/json; charset=utf-8",
		dataType : "text",
		success : function(result) {
			console.log(result);
			queryGroup();
		},
		error : function() {
			console.log("error");
		}
	});
}
function deleteOption(id, obj) {
	if (id == null || id == "") {
		$(obj).closest("tr").remove();
		return;
	}
	var param = {
		"requestType" : "0",
		"optionIdList" : [id]
	}
	$.ajax({
		type : "POST",
		url : "wf/main/choose/deleteOption",
		data : JSON.stringify(param),
		contentType : "application/json; charset=utf-8",
		dataType : "text",
		success : function(result) {
			console.log(result);
			$(obj).closest("tr").remove();
		},
		error : function() {
			console.log("error");
		}
	});
}