<!doctype html>
<html>
  <head>
    <title>Bearish</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "order": [[ 7, "asc" ]],
            "ajax": "oi_spurts_slide_in_price_rise_in_oi",
            "columns": [
                { "data": "symbol" },
                { "data": "instrument" },
                { "data": "expiry"  ,
                  	 render: function ( data, type, row ) {
                         
                         return '<span class="symbol">'+data+'</span>';
                       
                     }
                },
                { "data": "strike"  ,
                  	 render: function ( data, type, row ) {
                         
                         return '<span class="symbol">'+data+'</span>';
                       
                     }
                },
                { "data": "optionType" },
                { "data": "ltp" },
                { "data": "prevClose" },
                { "data": "percLtpChange",
                	render: function ( data, type, row ) {
                        if (data >= 0) {
                          return '<span class="positive">'+data+' %</span>';
                        } else {
                          return '<span class="negative">'+data+' %</span>';
                        }
                      }
                	},
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
<legend>Bearish signs according to open interest : An increase in open interest along with a decrease in price mostly indicates short positions being built up, except for very strong stocks where some traders may buy the stock on declines.</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Bearish : Rise in Open Interest Slide In Price -> An increase in open interest along with a decrease in price</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 100%">
		<thead>
			<tr> 
						  <th>symbol</th>
                            <th>instrument</th>
                            <th>expiry</th>
                            <th>strike</th>
                            <th>OPType</th>
                            <th>ltp</th>
                            <th>prevClose</th>
                            <th>%PerLtpChange</th>
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
	<jsp:include page="footer.jsp" />	
</body>
</html>