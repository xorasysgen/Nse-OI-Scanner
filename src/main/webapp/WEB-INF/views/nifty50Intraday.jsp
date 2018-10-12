<!doctype html>
<html>
  <head>
    <title>F&amp;O Stocks</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "order": [[ 1, "asc" ]],
            "pageLength": 50,
            "ajax": "suggestions/nifty/ohl_strategy",
            "columns": [
                { "data": "symbol" ,
               	 render: function ( data, type, row ) {
                     
                     return '<span class="symbol">'+data+'</span>';
                   
                 }
                },
                { "data": "open" },
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
                { "data": "previousClose" },
                { "data": "ltP" , 
	               	 render: function ( data, type, row ) {
	                     return '<span class="navy">'+data+'</span>';
	                 } 
                },
                { "data": "buySell",
                	render: function ( data, type, row ) {
                		if (data =="Strong Buy(OL)") {
               			 return '<span class="positive">'+data+'</span>';
               			}
                		else if (data =="Strong Buy(Higher High)") {
                          return '<span class="positive">'+data+'</span>';
                        } else if (data =="Buy") {
                        	return '<span class="positive">'+data+'</span>';
                        }
                        else {
                          return '<span class="negative">'+data+'</span>';
                        }
                      } 
                },
                { "data": "sellPercentage" ,
                	render: function ( data, type, row ) {
                		data=data.toString().substring(0,5);
                        if (data >= 0) {
                          return '<span class="positive">'+data+'%</span>';
                        } else {
                          return '<span class="negative">'+data+'%</span>';
                        }
                      } 
                },
                { "data": "buyPercentage" ,
                	render: function ( data, type, row ) {
                		data=data.toString().substring(0,5);
                        if (data >= 0) {
                          return '<span class="positive">'+data+'%</span>';
                        } else {
                          return '<span class="negative">'+data+'%</span>';
                        }
                      } 
                },
                { "data": "per",
                	render: function ( data, type, row ) {
                        if (data >= 0) {
                          return '<span class="positive">'+data+' %</span>';
                        } else {
                          return '<span class="negative">'+data+' %</span>';
                        }
                      }
                },
                { "data": "wkhi" ,
                   	 render: function ( data, type, row ) {
                         
                         return '<span class="liteGreen">'+data+'</span>';
                       
                     }},
                { "data": "wklo",
                       	 render: function ( data, type, row ) {
                             
                             return '<span class="negative">'+data+'</span>';
                           
                         }}
            ]
        } );
    } );
    </script>
    
    
  </head>
  <body>
  <jsp:include page="menu.jsp"/>
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>Nifty 50 Equity Stock Watcher</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Nifty 50 Intraday</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 100%">
		<thead>
			<tr>
				 	  <th>Script Name</th>
				 	  <th>Open</th>
					  <th>High</th>
					  <th>Low</th>
					  <th>Prev Close</th>
					  <th>LTP</th>
					  <th>Signal</th>
					  <th>Lower%</th>
					  <th>Higher%</th>
					  <th>Per%</th>
					  <th>52w H</th>
					  <th>52w L</th>
					 
			</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
	<jsp:include page="footer.jsp" />	
</body>
</html>