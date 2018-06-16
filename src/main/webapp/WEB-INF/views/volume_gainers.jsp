<!doctype html>
<html>
  <head>
    <title>Intraday 25 Volume Gainers</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "order": [[ 2, "desc" ]],
            "ajax": "volume_gainers",
            "columns": [
                { "data": "sym" },
                { "data": "name",
                  	 render: function ( data, type, row ) {
                         
                         return '<span class="symbol">'+data+'</span>';
                       
                     } 
                },
                { "data": "netpr" ,
                	render: function ( data, type, row ) {
                        if (data >= 0) {
                          return '<span class="positive">'+data+' %</span>';
                        } else {
                          return '<span class="negative">'+data+' %</span>';
                        }
                      }
                },
                { "data": "ltp" },
                { "data": "week1a" },
                { "data": "week2a" },
                { "data": "week1vc" },
                { "data": "week2vc" },
                { "data": "value" }
                
            ]
        } );
    } );
    </script>
    
    
    
  </head>
  <body>
  <jsp:include page="menu.jsp"/>
  
  
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>Intraday Top 25 - Volume Gainers</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Top 25 - Volume Gainers</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 100%">
		<thead>
			<tr>
							<th>Symbol</th>
							<th>Name</th>
							<th>%Change</th>
							<th>ltp</th>
							<th>1 Week Avg Vol</th>
							<th>2 Week Avg Vol</th>
							<th>1 Week Change<br>(No. of times)</th>
							<th>2  Week Change<br>(No. of times)</th>
							<th>Turn Over</th>
						</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
	
<jsp:include page="footer.jsp" />	
	
</body>
</html>