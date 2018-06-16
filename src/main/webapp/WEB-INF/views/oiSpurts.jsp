<!doctype html>
<html>
  <head>
    <title>NSE OI Spurts</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "order": [[ 4, "desc" ]],
            "pageLength": 50,
            "ajax": "oi_spurts",
            "columns": [
                 { "data": "symbol",
                   	 render: function ( data, type, row ) {
                         
                         return '<span class="symbol">'+data+'</span>';
                       
                     }
                 },
                 { "data": "latestOI" },
                 { "data": "prevOI" },
                 { "data": "oiChange" ,
                	render: function ( data, type, row ) {
                		data=data.split(',').join('');
                        if (data >= 0) {
                          return '<span class="positive">'+data+'</span>';
                        } else {
                          return '<span class="negative">'+data+'</span>';
                        }
                      }
                 },
                 { "data": "percOIchange",
                	render: function ( data, type, row ) {
                        if (data >= 0) {
                          return '<span class="liteGreen">'+data+'%</span>';
                        } else {
                          return '<span class="negative">'+data+'%</span>';
                        }
                      }
                 },
                 { "data": "volume" },
                 { "data": "valueInLakhs" },
                 { "data": "underlying" }
            ]
        } );
    } );
    </script>
    
    
    
  </head>
  <body>
    <jsp:include page="menu.jsp"/>
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>INTRADAY OI SPURTS - Moves with a sudden burst of speed</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">NSE OI Spurts</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 100%">
		<thead>
			<tr>
                <th>symbol</th>
                <th>latest OI</th>
                <th>Prev OI</th>
                <th>OI Change</th>
                <th>%OIchange</th>
                <th>Volume</th>
                <th>ValueInLakhs</th>
                <th>Last Traded Price</th>
              
			</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
	<jsp:include page="footer.jsp" />	
</body>
</html>