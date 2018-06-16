<!doctype html>
<html>
  <head>
    <title>Open Interest Equity Derivatives Scanner</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "pageLength": 50,
            "ajax": "open_interest",
            "columns": [
                { "data": "date" },
                { "data": "name",
                 	 render: function ( data, type, row ) {
                        
                        return '<span class="symbol">'+data+'</span>';
                      
                    }
               } ,
                { "data": "usedLimit" ,
               	render: function ( data, type, row ) {
                      return '<span class="positive">'+data+' %</span>';
                    }
                  },
               
                { "data": "scrip" },
                { "data": "mwpl" },
                { "data": "nse_Open_Interest" },
                { "data": "isin" }
                
            
            ]
        } );
    } );
    </script>
    
    
    
  </head>
  <body>
  <jsp:include page="menu.jsp"/>
  
  
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>Daily Top NSE Open Interest Equity Derivatives</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Top NSE Open Interest</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 100%">
		<thead>
			<tr>
					 <th>Name</th>
				 	 <th>Date</th>
					  <th>Used Limit [ Danger>95% ]</th>
					  <th>Script</th>
					  <th>Market Wide Position Limit</th>
					  <th>Nse Open Interest</th>
					  <th>isin</th>
			</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
	<jsp:include page="footer.jsp" />	
</body>
</html>