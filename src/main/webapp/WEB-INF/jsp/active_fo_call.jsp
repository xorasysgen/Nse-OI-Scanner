<!doctype html>
<html>
  <head>
    <title>Most Active Calls</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "ajax": "https://jsr101.herokuapp.com/derivative/call/call_stocks",
            "columns": [
                      	{ "data": "instrumentType" },
                        { "data": "symbol" },
						{ "data": "expiryDate" },
                        { "data": "optionType" },
                        { "data": "strikePrice" },
                        { "data": "noOfContractsTraded" },
                        { "data": "contractValueRsLakhs" },
                        { "data": "contractValuePremRsLakhs" },
                        { "data": "lastTradedPrice" },
                        { "data": "impliedValue" },
					    { "data": "openInterest" },
						{ "data": "valueOfUnderlying" },
            	        { "data": "timestamp" },
						{ "data": "perChange" }
            
            ]
        } );
    } );
    </script>
    
    
    
  </head>
  <body>
  <jsp:include page="menu.jsp"/>
  
  
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>F&amp;O Most Active Calls </legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Most Active Calls(F&amp;O)</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 90%">
		<thead>
			<tr>
					 	<th>instrumentType</th>
                        <th>symbol</th>
						<th>expiryDate</th>
                        <th>optionType</th>
                        <th>strikePrice</th>
                        <th>noOfContractsTraded</th>
                        <th>contractValueRsLakhs</th>
                        <th>contractValuePremRsLakhs</th>
                        <th>lastTradedPrice</th>
                        <th>impliedValue</th>
					    <th>openInterest</th>
						<th>valueOfUnderlying</th>
            	        <th>timestamp</th>
						<th>perChange</th>
			</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
</body>
</html>