<!doctype html>
<html>
  <head>
    <title>F&amp;O Stocks</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "order": [[ 6, "desc" ]],
            "ajax": "fo_stocks",
            "columns": [
                { "data": "symbol" ,
               	 render: function ( data, type, row ) {
                     
                     return '<span class="symbol">'+data+'</span>';
                   
                 }
                },
                { "data": "open" },
                { "data": "high" },
                { "data": "low" },
                { "data": "ltP" },
                { "data": "ptsC" ,
                	render: function ( data, type, row ) {
                        if (data >= 0) {
                          return '<span class="positive">'+data+'</span>';
                        } else {
                          return '<span class="negative">'+data+'</span>';
                        }
                      }
                },
                { "data": "per",
                	render: function ( data, type, row ) {
                        if (data >= 0) {
                          return '<span class="positive">'+data+' %</span>';
                        } else {
                          return '<span class="negative">'+data+' %</span>';
                        }
                      }
                },
                { "data": "trdVol" },
                { "data": "ntP" },
                { "data": "wkhi" ,
                   	 render: function ( data, type, row ) {
                         
                         return '<span class="liteGreen">'+data+'</span>';
                       
                     }},
                { "data": "wklo",
                       	 render: function ( data, type, row ) {
                             
                             return '<span class="negative">'+data+'</span>';
                           
                         }},
                { "data": "mPC" ,
                	render: function ( data, type, row ) {
                        if (data >= 0) {
                          return '<span class="positive">'+data+' %</span>';
                        } else {
                          return '<span class="negative">'+data+' %</span>';
                        }
                      } 
                },
                { "data": "yPC",
                  	render: function ( data, type, row ) {
                        if (data >= 0) {
                          return '<span class="positive">'+data+' %</span>';
                        } else {
                          return '<span class="negative">'+data+' %</span>';
                        }
                      }
                },
                { "data": "wkhicm_adj" },
                { "data": "wklocm_adj" },
               	{ "data": "xDt" },
                { "data": "cAct" }
            
            ]
        } );
    } );
    </script>
    
    
    
  </head>
  <body>
  <jsp:include page="menu.jsp"/>
  
  
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>F&O Equity Stock Watch Derivatives</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Top Future and Options Stocks</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 100%">
		<thead>
			<tr>
				 	  <th>Script Name</th>
				 	  <th>Open</th>
					  <th>High</th>
					  <th>Low</th>
					  <th>LTP</th>
					  <th>Chng</th>
					  <th>%Chng</th>
					  <th>Volume(Lac)</th>
					  <th>Turn Over(Crs)</th>
					  <th>52w H</th>
					  <th>52w L</th>
					  <th>30 d %Chng</th>
					  <th>365 d %Chng</th>
					  <th>52w H_adj </th> 
					  <th>52w L_adj</th>
					  <th>DIVIDEND Date</th>
					  <th>DIVIDEND </th>
			</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
	<jsp:include page="footer.jsp" />	
</body>
</html>
