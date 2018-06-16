<!doctype html>
<html>
  <head>
    <title>Top Gainers</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "order": [[ 6, "desc" ]],
            "ajax": "top_gainer",
            "columns": [
                { "data": "symbol" ,
               	 render: function ( data, type, row ) {
                     
                     return '<span class="symbol">'+data+'</span>';
                   
                 }
                },
                { "data": "openPrice" },
                { "data": "highPrice" },
                { "data": "lowPrice" },
                { "data": "ltp" },
                { "data": "previousPrice" },
                { "data": "netPrice" ,
                	render: function ( data, type, row ) {
                        if (data >= 0) {
                          return '<span class="positive">'+data+' %</span>';
                        } else {
                          return '<span class="negative">'+data+' %</span>';
                        }
                      }},
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
<legend>Intraday Top Ten Gainers</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Top Gainers</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 100%">
		<thead>
			<tr>
				<th>symbol</th>
				<th>openPrice</th>
				<th>highPrice</th>
				<th>lowPrice</th>
				<th>ltp</th>
				<th>previousPrice</th>
				<th>netPrice %</th>
				<th>tradedQuantity</th>
				<th>turnoverInLakhs</th>
				<th>lastCorpAnnouncementhate</th>
				<th>lastCorpAnnouncement</th>
			</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
	<jsp:include page="footer.jsp" />	
</body>
</html>