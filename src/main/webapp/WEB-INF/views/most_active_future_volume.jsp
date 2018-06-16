<!doctype html>
<html>
  <head>
    <title>Most Active Futures Volume Wise</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "order": [[ 3, "desc" ]],
            "ajax": "future_stocks_spike_volume",
            "columns": [
                { "data": "instrumentType" },
                { "data": "expiryDate" },
                { "data": "symbol",
                  	 render: function ( data, type, row ) {
                         
                         return '<span class="symbol">'+data+'</span>';
                       
                     } 
                },
                { "data": "perChange" ,
                	render: function ( data, type, row ) {
                        if (data >= 0) {
                          return '<span class="positive">'+data+' %</span>';
                        } else {
                          return '<span class="negative">'+data+' %</span>';
                        }
                      }
                },
                { "data": "lastTradedPrice",
                  	 render: function ( data, type, row ) {
                         
                         return '<span class="liteGreen">'+data+'</span>';
                       
                     } 
                },
                { "data": "valueOfUnderlying" ,
                  	 render: function ( data, type, row ) {
                         
                         return '<span class="darkGreen">'+data+'</span>';
                       
                     }
                },
                { "data": "noOfContractsTraded" },
                { "data": "openInterest" },
                { "data": "contractValueRsLakhs" },
                
            ]
        } );
    } );
    </script>
    
    
    
  </head>
  <body>
  <jsp:include page="menu.jsp"/>
  
  
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>Intraday Most Active Futures Volume Wise</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Most Active Future - Volume</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 100%">
		<thead>
			<tr>
				 <th>instrumentType</th>
	              <th>ExpiryDate</th>
	              <th>Symbol</th>
	              <th>%Change</th>
	              <th>Future Price</th>
	              <th>Cash Price</th>
	              <th>Cont Traded Qty</th>
	              <th>openInterest</th>
	              <th>contractValueRsLakhs<th>
			</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
	<jsp:include page="footer.jsp" />	
</body>
</html>