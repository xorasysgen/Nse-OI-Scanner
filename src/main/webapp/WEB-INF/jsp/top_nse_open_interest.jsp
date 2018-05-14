<!doctype html>
<html>
  <head>
    <title>My AngularJS App</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "ajax": "https://jsr101.herokuapp.com/open_interest/",
            "columns": [
                { "data": "date" },
                { "data": "usedLimit" },
                { "data": "scrip" },
                { "data": "mwpl" },
                { "data": "nse_Open_Interest" },
                { "data": "isin" },
                { "data": "name" } 
            
            ]
        } );
    } );
    </script>
    
    
    
  </head>
  <body>
  <jsp:include page="menu.jsp"/>
  
  
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>Daily Top NSE Open Interest Equity Derivatives</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Top NSE Open Interest</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 90%">
		<thead>
			<tr>
				 	 <th>Date</th>
					  <th>Used Limit % [ 95% goes in Ban ]</th>
					  <th>Script</th>
					  <th>Market Wide Position Limit</th>
					  <th>Nse Open Interest</th>
					  <th>isin</th>
					  <th>name</th>
			</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
</body>
</html>