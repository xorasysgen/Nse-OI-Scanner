<!doctype html>
<html>
  <head>
    <title>Live World Market Future Indices Watch</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "order": [],
            "pageLength": 10,
            "ajax": "world_market_indices",
            "columns": [
                { "data": "index" ,
                	render: function ( data, type, row ) {
                          return '<span class="symbol">'+data+'</span>';
                        }
                },
                { "data": "month",
                  	 render: function ( data, type, row ) {
                         return '<span class="dark">'+data+'</span>';
                       
                     } 
                },
                { "data": "ltp" ,
                	render: function ( data, type, row ) {
                          return '<span class="navy">'+data+'</span>';
                      }
                },
                { "data": "chg" ,
                  	render: function ( data, type, row ) {
                        if (data >= 0) {
                          return '<span class="positive">'+data+'</span>';
                        } else {
                          return '<span class="negative">'+data+'</span>';
                        }
                      }
                },
                { "data": "chgPer" ,
                  	render: function ( data, type, row ) {
                  		data=data.toString().substring(0,5);
                        if (data >= 0) {
                          return '<span class="positive">'+data+'%</span>';
                        } else {
                          return '<span class="negative">'+data+'%</span>';
                        }
                      }
                },
                { "data": "low" , 
	               	 render: function ( data, type, row ) {
	                     return '<span class="liteGreen">'+data+'</span>';
	                 } 
        	    },
                { "data": "high" ,
                  	 render: function ( data, type, row ) {
                         return '<span class="negative">'+data+'</span>';
                  	 }      
                 },
                { "data": "time" , 
               	 render: function ( data, type, row ) {
                     return '<span class="navy">'+data+'</span>';
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
<legend>Live World Market future Indices Watch</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Explore World market future indices</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 100%">
		<thead>
			<tr>
				 <th>Index</th>
	              <th>Month</th>
	              <th>LTP</th>
	              <th>chg</th>
	              <th>PerChange</th>
	              <th>Low</th>
	              <th>High</th>
	              <th>Time</th>
	              
			</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
	<jsp:include page="footer.jsp" />	
</body>
</html>