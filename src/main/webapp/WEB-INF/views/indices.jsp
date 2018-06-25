<!doctype html>
<html>
  <head>
    <title>All Indices</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "ajax": "indices",
            "pageLength": 100,
            "order": [],
            "columns": [
                { "data": "name" ,
               	 render: function ( data, type, row ) {
                     
                     return '<span class="symbol">'+data+'</span>';
                   
                 }
                },
                { "data": "lastPrice" },
                { "data": "change" ,
                	render: function ( data, type, row ) {
                        if (data >= 0) {
                          return '<span class="positive">'+data+'</span>';
                        } else {
                          return '<span class="negative">'+data+'</span>';
                        }
                      }
                },
                { "data": "pChange" ,
                	render: function ( data, type, row ) {
                        if (data >= 0) {
                          return '<span class="positive">'+data+'</span>';
                        } else {
                          return '<span class="negative">'+data+'</span>';
                        }
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
<legend>All Indices</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Indices Live Feed</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 100%">
		<thead>
			<tr>
				 	  <th>Name</th>
				 	  <th>lastPrice</th>
					  <th>Value change</th>
					  <th>% Change</th>
			</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
	<jsp:include page="footer.jsp" />	
</body>
</html>