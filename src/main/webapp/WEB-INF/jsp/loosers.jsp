<!doctype html>
<html>
  <head>
    <title>Losers</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp" />
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "ajax": "https://jsr101.herokuapp.com/top_looser/",
            "columns": [
                { "data": "symbol" },
                { "data": "openPrice" },
                { "data": "highPrice" },
                { "data": "lowPrice" },
                { "data": "ltp" },
                { "data": "previousPrice" },
                { "data": "netPrice" },
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
<legend>Intraday Top Ten Loosers</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Top Loosers</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 90%">
		<thead>
			<tr>
				<th>symbol</th>
				<th>openPrice</th>
				<th>highPrice</th>
				<th>lowPrice</th>
				<th>ltp</th>
				<th>previousPrice</th>
				<th>netPrice</th>
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

</body>
</html>