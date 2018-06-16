<!doctype html>
<html>
  <head>
    <title>Most Active Securities Values Wise</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "order": [[ 2, "desc" ]],
            "ajax": "most_active_value",
            "columns": [
                { "data": "series" },
                { "data": "symbol",
                  	 render: function ( data, type, row ) {
                         
                         return '<span class="symbol">'+data+'</span>';
                       
                     } 
                },
                { "data": "netPrice" ,
                	render: function ( data, type, row ) {
                        if (data >= 0) {
                          return '<span class="positive">'+data+' %</span>';
                        } else {
                          return '<span class="negative">'+data+' %</span>';
                        }
                      }
                },
                { "data": "ltp" },
                { "data": "previousPrice" },
                { "data": "tradedQuantity" },
                { "data": "turnoverInLakhs" },
                { "data": "lastCorpAnnouncementDate" },
                { "data": "lastCorpAnnouncement" }
                
            ]
        } );
    } );
    </script>
    
    
    
  </head>
  <body>
  <jsp:include page="menu.jsp"/>
  
  
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>Intraday Most Active Securities Values Wise</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Most Active Securities - Values</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 100%">
		<thead>
			<tr>
							<th>Series</th>
							<th>Name</th>
							<th>%Change</th>
							<th>Ltp</th>
							<th>Previous close</th>
							<th>Traded Qty</th>
							<th>Value (in Lakhs)</th>
							<th>Latest Ex Date<th>
						</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
	<jsp:include page="footer.jsp" />	
</body>
</html>