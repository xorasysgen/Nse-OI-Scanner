<!doctype html>
<html>
  <head>
    <title>Security-Var-data</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "ajax": "security_var",
            "columns": [
                        { "data": "symbol" },
                        { "data": "series" },
                        { "data": "securityVars" ,
                			render: function ( data, type, row ) {
                                if (data <= 7.7) {
                                    return '<span class="positive">'+data+' %</span>';
                                  } else if(data >=  7.8 && data <= 12) {
                                    return '<span class="blue">'+data+' %</span>';
                                  }
                                  else{
                                	  return '<span class="negative">'+data+' %</span>';
                                  }
                                }
                        },
                        { "data": "indexVars" },
                        { "data": "varsMargin" },
                        { "data": "extremeLossRate" },
                        { "data": "adhocMargin" },
                        { "data": "applicableMarginRate" },
                        { "data": "safeOrUnsafe" ,
                        	render: function ( data, type, row ) {
                                if (data == 'Safe') {
                                  return '<span class="positive">'+data+'</span>';
                                } else {
                                  return '<span class="negative">'+data+' </span>';
                                }
                              }}
                
            ]
        } );
    } );
    </script>
    
    
    
  </head>
  <body>
  <jsp:include page="menu.jsp"/>
  
  
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>Security VaR</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Securities - VaR - Safty - Rate</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 100%">
		<thead>
			<tr>
							<th>symbol</th>
							<th>series</th>
							<th>securityVaR</th>
							<th>indexVaR</th>
							<th>vaRMargin</th>
							<th>extremeLossRate</th>
							<th>adhocMargin</th>
							<th>applicableMarginRate</th>
							<th>safeOrUnsafe</th>
						</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
	<jsp:include page="footer.jsp" />	
</body>
</html>