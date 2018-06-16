<!doctype html>
<html>
  <head>
    <title>Most Active Puts</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "order": [[ 6, "asc" ]],
            "ajax": "derivative/put/put_stocks",
            "columns": [
                      	{ "data": "instrumentType",
                       	 render: function ( data, type, row ) {
                             return '<span class="symbol">'+data+'</span>';
                         }
                      	},
                        { "data": "symbol" },
						{ "data": "expiryDate" },
                        { "data": "optionType" },
                        { "data": "strikePrice" ,
                          	 render: function ( data, type, row ) {
                                 return '<span class="orange">'+data+'</span>';
                             }
                        },
                        { "data": "lastTradedPrice" ,
                          	 render: function ( data, type, row ) {
                                 return '<span class="cyan">'+data+'</span>';
                             }
                        },
						{ "data": "perChange" ,
                          	render: function ( data, type, row ) {
                                if (data >= 0) {
                                  return '<span class="positive">'+data+'%</span>';
                                } else {
                                  return '<span class="negative">'+data+'%</span>';
                                }
                              }
                        },
					    { "data": "openInterest" },
						{ "data": "valueOfUnderlying" ,
                       	 render: function ( data, type, row ) {
                             return '<span class="dark">'+data+'</span>';
                         }
					    },
                        { "data": "noOfContractsTraded" },
                        { "data": "contractValueRsLakhs" },
                        { "data": "contractValuePremRsLakhs" },
            	        { "data": "timestamp" },
                        { "data": "impliedValue" }
            
            ]
        } );
    } );
    </script>
    
    
    
  </head>
  <body>
  <jsp:include page="menu.jsp"/>
  
  
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>F&amp;O Most Active Puts </legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Most Active Puts(F&amp;O)</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 100%">
		<thead>
			<tr>
					 	<th>InstrumentType</th>
                        <th>Symbol</th>
						<th>ExpiryDate</th>
                        <th>OPType</th>
                        <th>StrikePrice</th>
                        <th>LTP</th>
						<th>%PerChange</th>
					    <th>OpenInterest</th>
						<th>Stock Price</th>
                        <th>NoOfContractsTraded</th>
                        <th>ContractValueRsLakhs</th>
                        <th>ContractValuePremRsLakhs</th>
            	        <th>Timestamp</th>
                        <th>ImpliedValue</th>
			</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
	<jsp:include page="footer.jsp" />	
</body>
</html>