<!doctype html>
<html>
  <head>
    <title>put nifty bank</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "ajax": "https://jsr101.herokuapp.com/derivative/put/put_nifty_bank",
            "columns": [
                { "data": "instrumentType" },
                { "data": "symbol" },
                { "data": "expiryDate" },
                { "data": "optionType" },
                { "data": "strikePrice" },
                { "data": "perChange" },
                { "data": "openInterest" },
                { "data": "lastTradedPrice" },
                { "data": "noOfContractsTraded" },
                { "data": "contractValueRsLakhs" },
                { "data": "contractValuePremRsLakhs" },
                { "data": "timestamp" }
                
            ]
        } );
    } );
    </script>
    
    
    
  </head>
  <body>
  <jsp:include page="menu.jsp"/>
  
  
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>Intraday Top Put Nifty Bank</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Top Gainers</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 90%">
		<thead>
			<tr>
							<th>Instrument</th>
							<th>symbol</th>
							<th>expiryDate</th>
							<th>optionType</th>
							<th>strikePrice</th>
							<th>perChange%</th>
							<th>openInterest %</th>
							<th>lastTradedPrice</th>
							<th>noOfContractsTraded</th>
							<th>contractValueRsLakhs</th>
							<th>contractValuePremRsLakhs</th>
							<th>timestamp</th>
						</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
</body>
</html>