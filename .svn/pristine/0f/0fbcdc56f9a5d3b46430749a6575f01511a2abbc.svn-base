/*
		FileReader共有4种读取方法：
		1.readAsArrayBuffer(file)：将文件读取为ArrayBuffer。
		2.readAsBinaryString(file)：将文件读取为二进制字符串
		3.readAsDataURL(file)：将文件读取为Data URL
		4.readAsText(file, [encoding])：将文件读取为文本，encoding缺省值为'UTF-8'
		 */
		var wb;//读取完成的数据
		var rABS = false; //是否将文件读取为二进制字符串

		function importf(obj) {//导入
			if (!obj.files) {
				return;
			}
			var f = obj.files[0];
			var reader = new FileReader();
			reader.onload = function(e) {
				var data = e.target.result;
				if (rABS) {
					wb = XLSX.read(btoa(fixdata(data)), {//手动转化
						type : 'base64'
					});
				} else {
					wb = XLSX.read(data, {
						type : 'binary'
					});
				}
				//获取sheet表名
				var snames = wb.SheetNames;
				for ( var i = 0; i < snames.length; i++) {
					$("#sel").append(
							'<option value="'+i+'">' + snames[i] + '</option>');
				}
				let excelData = [];
				var seltext;
				$("#btnOk").click(//预览按钮点击
						function() {
							seltext = $('#sel option:selected').text();
							//                  		alert(seltext);
							//wb.SheetNames[0]是获取Sheets中第一个Sheet的名字
							//wb.Sheets[Sheet名]获取第一个Sheet的数据
							excelData = JSON.stringify(XLSX.utils
									.sheet_to_json(wb.Sheets[seltext]));

							dataShow(excelData, seltext);
						});
				//点击提交按钮，将数据传送给后台
				 $("#btnSubmit").click(function(){
					leadGetData (excelData,seltext);
				});

			};
			if (rABS) {
				reader.readAsArrayBuffer(f);
			} else {
				reader.readAsBinaryString(f);
			}
		}
		//导入所获得的数据
		function leadGetData(jdata,sname) {
			$.ajax({
				type : "post",
				url : "http://192.168.106.1/8080/web/extract/setProfitData.do",
				dataType : "json",
				//data:leadData,
				data : json_array(jdata,sname),
				async : true,
				error : function(result) {
					console.log(result);
				},
				success : function(result) {
					alert("导入成功！");
				}
			});
		}
		function json_array(data, selname) {
			var jsonData = eval(data);
			let num;
			var arr = [];
			for ( var i = 0, j = 0; j, i < jsonData.length; i++) {
				if (jsonData[i][selname] != null) {
					if ((jsonData[i][selname]).replace(/\s/ig, '') == "项目") {//去除所有空格，然后进行判断
						arr[j] = {};
						arr[j]['company' + 0] = jsonData[i]["__EMPTY"];
						for ( var k = 1; k < 30; k++) {
							arr[j]['company' + [ k ]] = jsonData[i]["__EMPTY_"
									+ [ k ]];
						}
						j = 1;
						num = i;
					}
				}
				if (i > num) {
					arr[j] = {}; //js中二维数组必须进行重复的声明，否则会undefind  
					arr[j]['project'] = jsonData[i][selname];
					arr[j]['data' + 0] = jsonData[i]["__EMPTY"];
					for ( var k = 1; k < 30; k++) {
						arr[j]['data' + [ k ]] = jsonData[i]["__EMPTY_" + [ k ]];
					}
					j++;
				}
			}
			let jsond1 = [], jsond2 = [], jsond3 = [];
			$.each(arr, function(index, value) {
				let a = 0;
				while (arr[index]['company' + [ a ]] != undefined) {
					jsond1.push(arr[index]['company' + [ a ]]);
					a++;
				}
				jsond2.push(arr[index]['project']);
				jsond3[index] = [];
				while (arr[index]['data' + [ a ]] != undefined) {
					jsond3[index].push(arr[index]['data' + [ a ]]);
					a++;
				}
			});
			let jsonD = [];
			for ( var k = 0; k < jsond1.length; k++) {
				for ( var i = 1; i < jsond2.length; i++) {
					for ( var j = 0; j < jsond3[i].length; i++) {
						jsonD.push({
							"company" : jsond1[k],
							"project" : jsond2[i],
							"data" : jsond3[i][j]
						});
					}
				}
			}
			let fileJsonData = JSON.stringify(jsonD);
			/* console.log(JSON.stringify(jsonD));
			console.log(jsond1);
			console.log(jsond2);
			console.log(jsond3); */
			return fileJsonData;
		}

		function dataShow(persons, selname) {
			var allRow = [],
			//allCol=[],
			tableName = selname, objData = eval(persons);
			var num2;
			//console.log(objData);
			for ( var m = 0, n = 1; n < objData.length; m++, n++) {
				if (objData[n][tableName] != null) {
					if ((objData[n][tableName]).replace(/\s/ig, '') == "项目") {//去除所有空格，然后进行判断
						//              			allCol[m]=[];
						//              			allCol[m].push(objData[n][tableName]);
						//              			allCol[m].push(objData[n]["__EMPTY"]);
						//              			for(var k=1;k<30;k++){
						////								arr[j]['company'+[k]]=jsonData[i]["__EMPTY_"+[k]];  
						//			                	allCol[m].push(objData[n]["__EMPTY_"+[k]]);
						//              			}
						num2 = n;
					}
				}
				if (n >= num2) {
					allRow[m] = [];
					allRow[m].push(objData[n][tableName]);
					allRow[m].push(objData[n]["__EMPTY"]);
					for ( var k = 1; k < 30; k++) {
						allRow[m].push(objData[n]["__EMPTY_" + [ k ]]);
					}
				}
			}
			//              console.log(allCol); 
			//              console.log(allRow);
			$('#my').jexcel({
				data : allRow,
				//				    colHeaders:allCol,
				csvHeaders : true,
				/* tableOverflow : true, */
				colWidths : colW(),
			});
			function colW() {
				let col = [];
				for ( var m = 0; m < allRow.length; m++) {
					col.push(80);
				}
				return col;
			}
		}

		/* $("#btnSubmit").click(function() {
			leadGetData();
		}); */
		function fixdata(data) { //文件流转BinaryString
			var o = "", l = 0, w = 10240;
			for (; l < data.byteLength / w; ++l)
				o += String.fromCharCode.apply(null, new Uint8Array(data.slice(
						l * w, l * w + w)));
			o += String.fromCharCode.apply(null, new Uint8Array(data.slice(l
					* w)));
			return o;
		}