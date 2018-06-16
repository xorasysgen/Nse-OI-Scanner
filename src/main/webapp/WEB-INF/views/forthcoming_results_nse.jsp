<!doctype html>
<html>
  <head>
    <title>Results Calendar | Company Results Calendar</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "order": [],
            "pageLength": 50,
            "ajax": "forthcoming_results",
            "columns": [
                		{ "data": "symbol" ,
                			render: function ( data, type, row ) {
                                
                                return '<span class="symbol">'+data+'</span>';
                              
                            } 
                		},
                        { "data": "company" },
                        { "data": "purpose" ,
                			render: function ( data, type, row ) {
                                
                                return '<span class="positive">'+data+'</span>';
                              
                            } 
                        },
                        { "data": "boardMeetingDate" ,
                			render: function ( data, type, row ) {
                                
                                return '<span class="symbol">'+data+'</span>';
                              
                            } 
                        }
                        
                
            ]
        } );
    } );
    </script>
    
    
    
  </head>
  <body>
  <jsp:include page="menu.jsp"/>
  
  
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>Results Calendar</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Results Calendar - Forthcoming Results</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 100%">
		<thead>
			<tr>
							<th>Symbol</th>
							<th>Company</th>
							<th>Purpose</th>
							<th>Board Meeting Date</th>
						</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
	<jsp:include page="footer.jsp" />	
</body>
</html>