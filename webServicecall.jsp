<!DOCTYPE html>
<html>
<head>
<title>Ajax call Example</title>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <script src="${pageContext.request.contextPath}/json-viewer/jsoneditor.js"></script>
    <link href="${pageContext.request.contextPath}/json-viewer/jsoneditor.css" type="text/css" rel="stylesheet" />
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style type="text/css">
    body {
      font: 10.5pt arial;
      color: #337ab7;
      line-height: 150%;
      width:700px;
    }

    code {
      background-color: #337ab7;
    }

    #jsoneditor {
      width: 1000px;
      height: 500px;
    }
  </style>


<script type="text/javascript">
$(document).ready(function(){
	
});
$(document).ready(function(){
	
	$("#serviceCall").click(function(){
		var standard = $('select#standard option:selected').val();
		var lang = $('select#lang option:selected').val();
		$("#jsoneditor").empty();
		console.log(standard);
		console.log(lang);
		$.ajax({
			type:'GET',
			url: 'http://10.25.120.94:8080/languages/' + standard + '/' + lang,
			dataType: 'json',
			crossDomain: true,
			async:false,
			success:function(result){
			var outputInJson=JSON.stringify(result);
			 var container = document.getElementById('jsoneditor');
			  var options = {
			    mode: 'tree',
			    modes: ['code', 'form', 'text', 'tree', 'view'], // allowed modes
			    onError: function (err) {
			      alert(err.toString());
			    },
			    onModeChange: function (newMode, oldMode) {
			      console.log('Mode switched from', oldMode, 'to', newMode);
			    }
			  };

			 
			  var editor = new JSONEditor(container, options, result);
				$('#display').html(result);	
				result.Languages.forEach(function(name){
				    console.log(name)
				}); 
				
			},
			error:function(result){
				$('#display').html(result);	
			},
			statusCode: {
				   403: function(result) { 
					console.log("error");
					$('#display').html(result);	
				   },
				   200: function(data) {
					console.log("success")
				   }
				   //other codes. read the docs for more details
				}
		});
	});
	
	$("#name").click(function(){
		var name=$("#textId").val();
		$.ajax({
			type:'GET',
			url:'${pageContext.request.contextPath}/getname/'+name,
			success:function(result){
				$('#display1').html(result);
				
			},
			error:function(result){
				$('#display1').html(result);
			}
		});
	});
	
});

$(document).ready(function(){
	
	$('#jsonId').click(function(){
		var name1=$("#nameId").val();
		$.ajax({
			type:'GET',
			url:'${pageContext.request.contextPath}/json/'+name1,
			success:function(result){
				console.log(result);
				/* var data=jQuery.parseJSON(result);
					console.log("data " + data.id);
					console.log("data " + data.nameOfEmployee);
					var result = "Id=" + data.id + "<br>"+  "Name=" + data.nameOfEmployee; */
						   $.each(result, function (index, value) {
						      console.log(index + '=' + value.nameOfEmployee);
						   });
				$('#display2').html(result);
			},
			error:function(){
				console.log(result);
				$('#display2').html(result);
			}
			
		});
	});
	
});



</script>

</head>

<body>
	<div class="container">
		<h3>Webservice Client Testing</h3>
		<div class="panel panel-primary">
			<div class="panel-heading">Request</div>
			<div class="panel-body">
				<form action="" class="form-group">
					<select id="standard">
						<option value="rgi2001">RGI 2001</option>
						<option value="rgi2011">RGI 2011</option>
						<option value="MDDS">MDDS</option>
					</select>
					 <select id="lang">
						<option value="1">Assamese</option>
						<option value="2">Bengali</option>
						<option value="3">Bodo</option>
						<option value="4">Dogri</option>
						<option value="5">Gujarati</option>
						<option value="6">Hindi</option>
						<option value="7">Kannada</option>
						<option value="8">Kashmiri</option>
						<option value="9">Konkani</option>
						<option value="10">Maithili</option>
						<option value="11">Malayalam</option>
						<option value="12">Manipuri</option>
						<option value="13">Marathi</option>
						<option value="14">Nepali</option>
						<option value="15">Oriya</option>
						<option value="16">Punjabi</option>
						<option value="17">Sanskrit</option>
						<option value="18">Santali</option>
						<option value="19">Sindhi</option>
						<option value="20">Tamil</option>
						<option value="21">Telugu</option>
						<option value="22">Urdu</option>
						<option value="23">Other language (English)</option>


					</select> <input type="button" id="serviceCall" class="btn" value="Get JSON" />
				</form>
		</div>

	</div>
	
		<div class="panel panel-success">
			<div class="panel-heading">Response</div>
			<div class="panel-body">
			 <span id="jsoneditor"></span>
			</div>
		</div>
		
		
	</div>

	
</body>
</html>
