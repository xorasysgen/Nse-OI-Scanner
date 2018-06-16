<!doctype html>
<html>
  <head>
    <title>Most Active Underlying</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "order": [[ 5, "desc" ]],
            "pageLength": 50,
            "ajax": "most_active_intraday",
            "columns": [
                        { "data": "fo_SYMBOL" ,
                       	 render: function ( data, type, row ) {
                             
                             return '<span class="symbol">'+data+'</span>';
                           
                         }
                        	
                        },
                    	{ "data": "op"  ,
					  	 render: function ( data, type, row ) {
					         
					         return '<span class="yellow">'+data+'</span>';
					       
					     }
                        },
                        { "data": "underlyingvalue"  ,
					  	 render: function ( data, type, row ) {
					         
					         return '<span class="positive">'+data+'</span>';
					       
					     }
                    	},
                        { "data": "value2" },
                        { "data": "value1" },
                        { "data": "total_VALUE" },
                        { "data": "volume2" },
                        { "data": "volume1" },
                        { "data": "total_VOLUME" },
                        { "data": "openinterest" }
            
            ]
        } );
    } );
    </script>
    
    
    
  </head>
  <body>
  <jsp:include page="menu.jsp"/>
  
  
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>F&amp;O Most Active Underlying </legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Most Active Underlying</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 100%">
		<thead>
			<tr>
					  <th>SYMBOL</th>
				 	  <th>Options(Premium)</th>
					  <th>LTP(Price)</th>
					  <th>Val Options</th>
					  <th>Val Futures</th>
					  <th>Val Total</th>
					  <th>Vol Options</th>
					  <th>Vol Futures</th>
					  <th>Vol Total</th>
					  <th>Open Interest(Contracts)</th>
			</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
	<jsp:include page="footer.jsp" />	
</body>
</html>