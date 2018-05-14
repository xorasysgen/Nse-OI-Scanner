<!doctype html>
<html>
  <head>
    <title>My AngularJS App</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<!-- begin js files -->    
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.1/js/dataTables.responsive.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.1/js/responsive.bootstrap.min.js"></script>
<!-- end js files -->

<!-- begin css files -->
 <link rel="stylesheet"   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css">
 <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.2.1/css/responsive.bootstrap.min.css">
 <!-- end css files -->
 
 
   
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