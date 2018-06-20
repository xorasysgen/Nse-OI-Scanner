<!doctype html>
<html>
  <head>
    <title>Live Indices Watch</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "order": [],
            "pageLength": 50,
            "ajax": "all_nifty_indices",
            "columns": [
                { "data": "indexName" ,
                	render: function ( data, type, row ) {
                          return '<span class="symbol">'+data+'</span>';
                        }
                },
                { "data": "previousClose",
                  	 render: function ( data, type, row ) {
                         return '<span class="dark">'+data+'</span>';
                       
                     } 
                },
                { "data": "open" ,
                	render: function ( data, type, row ) {
                          return '<span class="darkGreen">'+data+'</span>';
                      }
                },
                { "data": "high" ,
                  	 render: function ( data, type, row ) {
                         return '<span class="liteGreen">'+data+'</span>';
                  	 }      
                 },
                { "data": "low" , 
	               	 render: function ( data, type, row ) {
	                     return '<span class="negative">'+data+'</span>';
	                 } 
        	    },
                { "data": "last" , 
                	 render: function ( data, type, row ) {
                         return '<span class="orange">'+data+'</span>';
                     } 
                },
                { "data": "percChange" , 
                  	 render: function ( data, type, row ) {
                         return '<span class="navy">'+data+'%</span>';
                     } 
                },
                { "data": "yearHigh" , 
               	 render: function ( data, type, row ) {
                     return '<span class="liteGreen">'+data+'</span>';
                 } 
                },
                { "data": "yearLow" , 
                 	 render: function ( data, type, row ) {
                        return '<span class="negative">'+data+'</span>';
                    } 
                }
                
            ]
        } );
    } );
    </script>
    
    
    
  </head>
  <body>
  <jsp:include page="menu.jsp"/>
  
  
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>Explore Nifty Indices# The NIFTY 50 is a well diversified 50 stock index and it represent important sectors of the economy.</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Explore all Nifty Indices</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 100%">
		<thead>
			<tr>
				 <th>Index Name</th>
	              <th>Previous Close</th>
	              <th>Open</th>
	              <th>High</th>
	              <th>Low</th>
	              <th>Last</th>
	              <th>PerChange</th>
	              <th>Year High</th>
	              <th>Year Low</th>
	              
			</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
	<jsp:include page="footer.jsp" />	
</body>
</html>