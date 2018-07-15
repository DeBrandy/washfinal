 	//服务类型
  	$("type").ready(function(){
  		var resp = {"data":[{"typeCode":"1","typeName":"保养"},{"typeCode":"2","typeName":"常规洗"},{"typeCode":"3","typeName":"单烫"},{"typeCode":"4","typeName":"附加服务"},{"typeCode":"5","typeName":"干洗"},{"typeCode":"6","typeName":"其他"},{"typeCode":"7","typeName":"清洗"},{"typeCode":"8","typeName":"染色"},{"typeCode":"9","typeName":"上光"},{"typeCode":"10","typeName":"水洗"},{"typeCode":"11","typeName":"修拉链"}],"success":true};
  		if(!!resp.success && !!resp.data){
  			typeList = resp.data;
  			var htmlStr ;
	        var htmlData ;
	        for (var i in resp.data) {
	            htmlStr += "<li onclick='onTypeClick(" + resp.data[i].typeCode + ",&quot;" + resp.data[i].typeName + "&quot;)'><a>" + resp.data[i].typeName + "</a></li>";
	            htmlData += "<option value="+ resp.data[i].typeName + ">";
	        }
	        $("#type .dropdown-menu").html(htmlStr);
	        $("#typeInput").html(htmlData);
  		}
  	});
  	var onTypeClick = function(typeCode,typeName){
	    if(typeCode){
	        curtypeCode = typeCode;
	        $("#type .sel_input").val(typeName);
	        typeIsLegal = true;
	    }
	};
	var onTypeChange = function(){
	    var val = $("#type .sel_input").val();
	    var list = typeList;
	    var sel = undefined;
	    for(var i=0;i<list.length;i++){
	        if(val == list[i].typeName){
	            sel = list[i];
	            break;
	        }
	    }
	    if(sel){
	        curtypeCode = sel.typeCode;
	        $("#type .sel_input").val(sel.typeName);
	        typeIsLegal = true;
	    }
	    else{
	        typeIsLegal = false;
	    }
	};
	var onTypeFocus = function(){
	    if($('#type .open').length>0){
	        $('#type .dropdown-toggle').dropdown('toggle');
	    }
	    var val = $('type .sel_input').val();
	    if(val.length == 0){
	        $('#typeInput > *').remove();
	    }
	};
	var onTypeKey = function(){
	    if($('#type .open').length>0){
	        $('#type .dropdown-toggle').dropdown('toggle');
	    }
	    var list = typeList;
	    var htmlData = '';
	    for (var i in list) {
	        htmlData += "<option value="+ list[i].typeName + ">";
	    }
	    $("#typeInput").html(htmlData);
	};
  	//服务项目
  	$("clo").ready(function(){
  		var resp = {"data":[{"cloCode":"1","cloName":"棉衬衣"},{"cloCode":"2","cloName":"羊绒外套"},{"cloCode":"3","cloName":"长羽绒服"},{"cloCode":"4","cloName":"小棉上衣"}],"success":true};
  		if(!!resp.success && !!resp.data){
  			cloList = resp.data;
  			var htmlStr ;
	        var htmlData ;
	        for (var i in resp.data) {
	            htmlStr += "<li onclick='onCloClick(" + resp.data[i].cloCode + ",&quot;" + resp.data[i].cloName + "&quot;)'><a>" + resp.data[i].cloName + "</a></li>";
	            htmlData += "<option value="+ resp.data[i].cloName + ">";
	        }
	        $("#clo .dropdown-menu").html(htmlStr);
	        $("#cloInput").html(htmlData);
  		}
  	});
  	var onCloClick = function(cloCode,cloName){
	    if(cloCode){
	        curcloCode = cloCode;
	        $("#clo .sel_input").val(cloName);
	        cloIsLegal = true;
	    }
	};
	var onCloChange = function(){
	    var val = $("#clo .sel_input").val();
	    var list = cloList;
	    var sel = undefined;
	    for(var i=0;i<list.length;i++){
	        if(val == list[i].cloName){
	            sel = list[i];
	            break;
	        }
	    }
	    if(sel){
	        curcloCode = sel.cloCode;
	        $("#clo .sel_input").val(sel.cloName);
	        cloIsLegal = true;
	    }
	    else{
	        cloIsLegal = false;
	    }
	};
	var onCloFocus = function(){
	    if($('#clo .open').length>0){
	        $('#clo .dropdown-toggle').dropdown('toggle');
	    }
	    var val = $('clo .sel_input').val();
	    if(val.length == 0){
	        $('#cloInput > *').remove();
	    }
	};
	var onCloKey = function(){
	    if($('#clo .open').length>0){
	        $('#clo .dropdown-toggle').dropdown('toggle');
	    }
	    var list = cloList;
	    var htmlData = '';
	    for (var i in list) {
	        htmlData += "<option value="+ list[i].cloName + ">";
	    }
	    $("#cloInput").html(htmlData);
	};
	//材质
  	$("mat").ready(function(){
  		var resp = {"data":[{"matCode":"1","matName":"fff"},{"matCode":"1","matName":"fff"}],"success":true};
  		if(!!resp.success && !!resp.data){
  			matList = resp.data;
  			var htmlStr ;
	        var htmlData ;
	        for (var i in resp.data) {
	            htmlStr += "<li onclick='onMatClick(" + resp.data[i].matCode + ",&quot;" + resp.data[i].matName + "&quot;)'><a>" + resp.data[i].matName + "</a></li>";
	            htmlData += "<option value="+ resp.data[i].matName + ">";
	        }
	        $("#mat .dropdown-menu").html(htmlStr);
	        $("#matInput").html(htmlData);
  		}
  	});
  	var onMatClick = function(matCode,matName){
	    if(matCode){
	        curmatCode = matCode;
	        $("#mat .sel_input").val(matName);
	        matIsLegal = true;
	    }
	};
	var onMatChange = function(){
	    var val = $("#mat .sel_input").val();
	    var list = matList;
	    var sel = undefined;
	    for(var i=0;i<list.length;i++){
	        if(val == list[i].matName){
	            sel = list[i];
	            break;
	        }
	    }
	    if(sel){
	        curmatCode = sel.matCode;
	        $("#mat .sel_input").val(sel.matName);
	        matIsLegal = true;
	    }
	    else{
	        matIsLegal = false;
	    }
	};
	var onMatFocus = function(){
	    if($('#mat .open').length>0){
	        $('#mat .dropdown-toggle').dropdown('toggle');
	    }
	    var val = $('mat .sel_input').val();
	    if(val.length == 0){
	        $('#matInput > *').remove();
	    }
	};
	var onMatKey = function(){
	    if($('#mat .open').length>0){
	        $('#mat .dropdown-toggle').dropdown('toggle');
	    }
	    var list = matList;
	    var htmlData = '';
	    for (var i in list) {
	        htmlData += "<option value="+ list[i].matName + ">";
	    }
	    $("#matInput").html(htmlData);
	};
	//颜色
  	$("color").ready(function(){
  		var resp = {"data":[{"colorCode":"1","colorName":"fff"},{"colorCode":"1","colorName":"fff"}],"success":true};
  		if(!!resp.success && !!resp.data){
  			matList = resp.data;
  			var htmlStr ;
	        var htmlData ;
	        for (var i in resp.data) {
	            htmlStr += "<li onclick='onColorClick(" + resp.data[i].colorCode + ",&quot;" + resp.data[i].colorName + "&quot;)'><a>" + resp.data[i].colorName + "</a></li>";
	            htmlData += "<option value="+ resp.data[i].colorName + ">";
	        }
	        $("#color .dropdown-menu").html(htmlStr);
	        $("#colorInput").html(htmlData);
  		}
  	});
  	var onColorClick = function(colorCode,colorName){
	    if(colorCode){
	        curcolorCode = colorCode;
	        $("#color .sel_input").val(colorName);
	        colorIsLegal = true;
	    }
	};
	var onColorChange = function(){
	    var val = $("#color .sel_input").val();
	    var list = colorList;
	    var sel = undefined;
	    for(var i=0;i<list.length;i++){
	        if(val == list[i].colorName){
	            sel = list[i];
	            break;
	        }
	    }
	    if(sel){
	        curcolorCode = sel.colorCode;
	        $("#color .sel_input").val(sel.matName);
	        colorIsLegal = true;
	    }
	    else{
	        colorIsLegal = false;
	    }
	};
	var onColorFocus = function(){
	    if($('#color .open').length>0){
	        $('#color .dropdown-toggle').dropdown('toggle');
	    }
	    var val = $('color .sel_input').val();
	    if(val.length == 0){
	        $('#colorInput > *').remove();
	    }
	};
	var onColorKey = function(){
	    if($('#color .open').length>0){
	        $('#color .dropdown-toggle').dropdown('toggle');
	    }
	    var list = colorList;
	    var htmlData = '';
	    for (var i in list) {
	        htmlData += "<option value="+ list[i].colorName + ">";
	    }
	    $("#colorInput").html(htmlData);
	};
  	//品牌
  	$("brand").ready(function(){
  		var resp = {"data":[{"brandCode":"1","brandName":"fff"},{"brandCode":"1","brandName":"fff"}],"success":true};
  		if(!!resp.success && !!resp.data){
  			matList = resp.data;
  			var htmlStr ;
	        var htmlData ;
	        for (var i in resp.data) {
	            htmlStr += "<li onclick='onBrandClick(" + resp.data[i].brandCode + ",&quot;" + resp.data[i].brandName + "&quot;)'><a>" + resp.data[i].brandName + "</a></li>";
	            htmlData += "<option value="+ resp.data[i].brandName + ">";
	        }
	        $("#brand .dropdown-menu").html(htmlStr);
	        $("#brandInput").html(htmlData);
  		}
  	});
  	var onBrandClick = function(brandCode,brandName){
	    if(brandCode){
	        curbrandCode = brandCode;
	        $("#brand .sel_input").val(brandName);
	        brandIsLegal = true;
	    }
	};
	var onBrandChange = function(){
	    var val = $("#brand .sel_input").val();
	    var list = brandList;
	    var sel = undefined;
	    for(var i=0;i<list.length;i++){
	        if(val == list[i].brandName){
	            sel = list[i];
	            break;
	        }
	    }
	    if(sel){
	        curbrandCode = sel.brandCode;
	        $("#brand .sel_input").val(sel.brandName);
	        brandIsLegal = true;
	    }
	    else{
	        brandIsLegal = false;
	    }
	};
	var onBrandFocus = function(){
	    if($('#brand .open').length>0){
	        $('#brand .dropdown-toggle').dropdown('toggle');
	    }
	    var val = $('brand .sel_input').val();
	    if(val.length == 0){
	        $('#brandInput > *').remove();
	    }
	};
	var onBrandKey = function(){
	    if($('#brand .open').length>0){
	        $('#brand .dropdown-toggle').dropdown('toggle');
	    }
	    var list = brandList;
	    var htmlData = '';
	    for (var i in list) {
	        htmlData += "<option value="+ list[i].brandName + ">";
	    }
	    $("#brandInput").html(htmlData);
	};
	//瑕疵
  	$("flaw").ready(function(){
  		var resp = {"data":[{"flawCode":"1","flawName":"fff"},{"flawCode":"1","flawName":"fff"}],"success":true};
  		if(!!resp.success && !!resp.data){
  			matList = resp.data;
  			var htmlStr ;
	        var htmlData ;
	        for (var i in resp.data) {
	            htmlStr += "<li onclick='onFlawClick(" + resp.data[i].flawCode + ",&quot;" + resp.data[i].flawName + "&quot;)'><a>" + resp.data[i].flawName + "</a></li>";
	            htmlData += "<option value="+ resp.data[i].flawName + ">";
	        }
	        $("#flaw .dropdown-menu").html(htmlStr);
	        $("#flawInput").html(htmlData);
  		}
  	});
  	var onFlawClick = function(flawCode,flawName){
	    if(flawCode){
	        curflawCode = flawCode;
	        $("#flaw .sel_input").val(flawName);
	        flawIsLegal = true;
	    }
	};
	var onFlawChange = function(){
	    var val = $("#flaw .sel_input").val();
	    var list = flawList;
	    var sel = undefined;
	    for(var i=0;i<list.length;i++){
	        if(val == list[i].flawName){
	            sel = list[i];
	            break;
	        }
	    }
	    if(sel){
	        curflawCode = sel.flawCode;
	        $("#flaw .sel_input").val(sel.flawName);
	        flawIsLegal = true;
	    }
	    else{
	        flawIsLegal = false;
	    }
	};
	var onFlawFocus = function(){
	    if($('#flaw .open').length>0){
	        $('#flaw .dropdown-toggle').dropdown('toggle');
	    }
	    var val = $('flaw .sel_input').val();
	    if(val.length == 0){
	        $('#flawInput > *').remove();
	    }
	};
	var onFlawKey = function(){
	    if($('#flaw .open').length>0){
	        $('#flaw .dropdown-toggle').dropdown('toggle');
	    }
	    var list = flawList;
	    var htmlData = '';
	    for (var i in list) {
	        htmlData += "<option value="+ list[i].flawName + ">";
	    }
	    $("#flawInput").html(htmlData);
	};
	//附件
  	$("add").ready(function(){
  		var resp = {"data":[{"addCode":"1","addName":"fff"},{"addCode":"1","addName":"fff"}],"success":true};
  		if(!!resp.success && !!resp.data){
  			addList = resp.data;
  			var htmlStr ;
	        var htmlData ;
	        for (var i in resp.data) {
	            htmlStr += "<li onclick='onAddClick(" + resp.data[i].addCode + ",&quot;" + resp.data[i].addName + "&quot;)'><a>" + resp.data[i].addName + "</a></li>";
	            htmlData += "<option value="+ resp.data[i].addName + ">";
	        }
	        $("#add .dropdown-menu").html(htmlStr);
	        $("#addInput").html(htmlData);
  		}
  	});
  	var onAddClick = function(addCode,addName){
	    if(addCode){
	        curaddCode = addCode;
	        $("#add .sel_input").val(addName);
	        addIsLegal = true;
	    }
	};
	var onAddChange = function(){
	    var val = $("#add .sel_input").val();
	    var list = addList;
	    var sel = undefined;
	    for(var i=0;i<list.length;i++){
	        if(val == list[i].addName){
	            sel = list[i];
	            break;
	        }
	    }
	    if(sel){
	        curaddCode = sel.addCode;
	        $("#add .sel_input").val(sel.addName);
	        addIsLegal = true;
	    }
	    else{
	        addIsLegal = false;
	    }
	};
	var onAddFocus = function(){
	    if($('#add .open').length>0){
	        $('#add .dropdown-toggle').dropdown('toggle');
	    }
	    var val = $('add .sel_input').val();
	    if(val.length == 0){
	        $('#addInput > *').remove();
	    }
	};
	var onAddKey = function(){
	    if($('#add .open').length>0){
	        $('#add .dropdown-toggle').dropdown('toggle');
	    }
	    var list = addList;
	    var htmlData = '';
	    for (var i in list) {
	        htmlData += "<option value="+ list[i].addName + ">";
	    }
	    $("#addInput").html(htmlData);
	};
	
	