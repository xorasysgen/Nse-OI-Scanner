<!doctype html>
<html>
  <head>
    <title>Nifty Put Call Ratio</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "order": [],
            "pageLength": 10,
            "ajax": "option_chain_reader_all",
            "columns": [
                { "data": "month",
                  	 render: function ( data, type, row ) {
                         return '<span class="symbol">'+data+'</span>';
                     } 
                },
                { "data": "calls" ,
                	render: function ( data, type, row ) {
                          return '<span class="positive">'+data+'</span>';
                        }
                },
                { "data": "callsVolume", 
               	 	render: function ( data, type, row ) {
                     return '<span class="darksalmon">'+data+'</span>';
                	 } 
                },
                { "data": "puts" ,
                	render: function ( data, type, row ) {
                        return '<span class="positive">'+data+'</span>';
                      }
              },
                { "data": "putsVolume" , 
                	 render: function ( data, type, row ) {
                         return '<span class="darksalmon">'+data+'</span>';
                     } 
                },
                { "data": "pcrVolume" },
                { "data": "pcrOI" , 
                	render: function ( data, type, row ) {
              		if (data >= 1) {
                        return '<span class="liteGreen">'+data+'</span>';
                 		}
                 		else{
                 			return '<span class="orange">'+data+'</span>';
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
<legend>Positional Wise Nifty Put Call Ratio</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Nifty Put Call Ratio (PCR)</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 100%">
		<thead>
			<tr>
				 <th>month</th>
	              <th>calls</th>
	              <th>callsVolume</th>
	              <th>puts</th>
	              <th>putsVolume</th>
	              <th>pcrVolume</th>
	              <th>pcrOI</th>
	              
			</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
	<jsp:include page="footer.jsp" />	
</body>
</html>