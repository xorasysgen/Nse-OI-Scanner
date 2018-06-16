<!doctype html>
<html>
  <head>
    <title>Security-wise-deliverable-positions-data</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "order": [[ 12, "desc" ]],
            "ajax": "security_wise_deliverable_positions_data",
            "columns": [
                        { "data": "date" },
                		{ "data": "symbol" ,
                			render: function ( data, type, row ) {
                                
                                return '<span class="symbol">'+data+'</span>';
                              
                            } 
                		},
                        { "data": "delivQnty" ,
                			render: function ( data, type, row ) {
	                            if (data >= 1000000) {
	                                return '<span class="positive">'+data+' </span>';
	                              } else if(data < 1000000 && data > 50000) {
	                                return '<span class="blue">'+data+' </span>';
	                              }
	                              else{
	                            	  return '<span class="negative">'+data+' </span>';
	                              }
                            } 
                		},
                        { "data": "delivPer" ,
                        	render: function ( data, type, row ) {
                                if (data >= 40) {
                                  return '<span class="positive">'+data+' %</span>';
                                } else {
                                  return '<span class="negative">'+data+' %</span>';
                                }
                              }},
                        { "data": "preClose" },
                        { "data": "openPrice" },
                        { "data": "highPrice" },
                        { "data": "lowPrice" },
                        { "data": "lastPrice" },
                        { "data": "closePrice" },
                        { "data": "avgPrice" },
                        { "data": "totalTradedQnty" },
                        { "data": "turnOvrLac" },
         				{ "data": "noOfTrades" },
                        { "data": "series" }
                  
                
            ]
        } );
    } );
    </script>
    
    
    
  </head>
  <body>
  <jsp:include page="menu.jsp"/>
  
  
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>Security Wise Deliverable Positions Data - Bhav Copy</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Did You Know# The higher the Percent of Deliverable Quantity to Traded Quantity the better - it indicates that most buyers are expecting the price of the share to go up.</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 100%">
		<thead>
			<tr>
							<th>Date</th>
							<th>Name</th>
							<th>delivQnty</th>
							<th>delivPer%</th>
							<th>Prevclose</th>
							<th>openPrice</th>
							<th>highPrice</th>
							<th>lowPrice</th>
							<th>lastPrice</th>
							<th>closePrice</th>
							<th>avgPrice</th>
							<th>totalTradedQnty</th>
							<th>turnOvrLac</th>
							<th>noOfTrades</th>
							<th>series</th>
						</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
	<jsp:include page="footer.jsp" />	
</body>
</html>