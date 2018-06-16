<!doctype html>
<html>
  <head>
    <title>Most Active Security - Year</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "order": [[ 0, "asc" ]],
            "pageLength": 25,
            "ajax": "most_active_securities_market_capitalisation",
            "columns": [
                        { "data": "rank" },
                		{ "data": "security" ,
                			render: function ( data, type, row ) {
                                
                                return '<span class="symbol">'+data+'</span>';
                              
                            } 
                		},
                        { "data": "totmkt" ,
                			render: function ( data, type, row ) {
                                
                                return '<span class="positive">'+data+'%</span>';
                              
                            } 
                		},
                        { "data": "mktcap" ,
                			render: function ( data, type, row ) {
                                
                                return '<span class="olive">'+data+'</span>';
                              
                            } 
                        },
                        { "data": "totturnover" ,
                			render: function ( data, type, row ) {
                                
                                return '<span class="darkviolet">'+data+'%</span>';
                              
                            } 
                        },
                        { "data": "turnover" },
                        { "data": "fy" }
                
            ]
        } );
    } );
    </script>
    
    
    
  </head>
  <body>
  <jsp:include page="menu.jsp"/>
  
  
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>Most Active Securities During - Year With Market Capitalisation</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Did You Know# Most Active Securities during year.</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 100%">
		<thead>
			<tr>
							<th>Rank</th>
							<th>Security</th>
							<th>%Share in Total Market Cap</th>
							<th>Market Capitalisation</th>
							<th>%Share in Total Turnover</th>
							<th>Turnover</th>
							<th>Financial Year</th>
						</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
	<jsp:include page="footer.jsp" />	
</body>
</html>