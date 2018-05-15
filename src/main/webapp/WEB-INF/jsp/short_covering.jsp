<!doctype html>
<html>
  <head>
    <title>Short Covering</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "ajax": "http://jsr101.herokuapp.com/oi_spurts_rise_in_price_slide_in_oi",
            "columns": [
                { "data": "symbol" },
                { "data": "instrument" },
                { "data": "expiry" },
                { "data": "strike" },
                { "data": "optionType" },
                { "data": "ltp" },
                { "data": "prevClose" },
                { "data": "percLtpChange" },
                { "data": "latestOI" },
                { "data": "oiChange" },
                { "data": "volume" },
                { "data": "valueInCrores" },
                { "data": "premValueInCrores" },
                { "data": "underlyValue" },
                { "data": "isFO" }
            ]
        } );
    } );
    </script>
    
    
    
  </head>
  <body>
  <jsp:include page="menu.jsp"/>
  
  
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>Bullish signs according to open interest : Decrease in open interest along with an increase in price mostly indicates short covering, except for weak stocks where traders may decide to book profits/cut losses at higher levels. It may also indicate delivery based buying by institutions which pushes up the price and speculators use it to unwind.</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Short Covering : Slide in OI-Rise in Price -> Decrease in open interest along with an increase in price mostly indicates short covering</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 90%">
		<thead>
			<tr> 
						  <th>symbol</th>
                            <th>instrument</th>
                            <th>expiry</th>
                            <th>strike</th>
                            <th>optionType</th>
                            <th>ltp</th>
                            <th>prevClose</th>
                            <th>percLtpChange</th>
                            <th>latestOI</th>
                            <th>oiChange</th>
                            <th>volume</th>
                            <th>valueInCrores</th>
                                <th>premValueInCrores</th>
                            <th>underlyValue</th>
                            <th>isFO</th>
						</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
</body>
</html>