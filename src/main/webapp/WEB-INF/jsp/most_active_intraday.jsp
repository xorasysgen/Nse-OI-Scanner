<!doctype html>
<html>
  <head>
    <title>Most Active Underlying</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "ajax": "https://jsr101.herokuapp.com/most_active_intraday/",
            "columns": [
                        { "data": "fo_SYMBOL" },
                    	{ "data": "op" },
                        { "data": "value2" },
                        { "data": "value1" },
                        { "data": "total_VALUE" },
                        { "data": "volume2" },
                        { "data": "volume1" },
                        { "data": "total_VOLUME" },
                        { "data": "openinterest" },
                        { "data": "underlyingvalue" }
            
            ]
        } );
    } );
    </script>
    
    
    
  </head>
  <body>
  <jsp:include page="menu.jsp"/>
  
  
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>F&amp;O Most Active Underlying </legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Most Active Underlying</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 90%">
		<thead>
			<tr>
					  <th>SYMBOL</th>
				 	  <th>Options (Premium)</th>
					  <th>val Options</th>
					  <th>Val Futures</th>
					  <th>Val Total</th>
					  <th>Vol Options</th>
					  <th>Vol Futures</th>
					  <th>Vol Value</th>
					  <th>Open Interest (Contracts</th>
					  <th>Underlying</th>
			</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
</body>
</html>