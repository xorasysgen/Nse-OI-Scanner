<!doctype html>
<html>
  <head>
    <title>NIFTY 50 Top 10 Holdings</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "order": [[ 1, "desc" ]],
            "ajax": "nifty_top_10_weightage_holdings",
            "columns": [
                { "data": "symbol" ,
               	 render: function ( data, type, row ) {
                     
                     return '<span class="symbol">'+data+'</span>';
                   
                 }
                },
                { "data": "weightage", 
	               	 render: function ( data, type, row ) {
	                     return '<span class="navy">'+data+'%</span>';
	                 } 
				},
                { "data": "open" },
                { "data": "high" , 
                  	 render: function ( data, type, row ) {
                         return '<span class="darkGreen">'+data+'</span>';
                     } 
                },
                { "data": "low" , 
                	 render: function ( data, type, row ) {
                         return '<span class="negative">'+data+'</span>';
                     } 
                },
                { "data": "ltP" , 
	               	 render: function ( data, type, row ) {
	                     return '<span class="navy">'+data+'</span>';
	                 } 
                },
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
                          return '<span class="positive">'+data+'%</span>';
                        } else {
                          return '<span class="negative">'+data+'%</span>';
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
                          return '<span class="positive">'+data+'%</span>';
                        } else {
                          return '<span class="negative">'+data+'%</span>';
                        }
                      }
                },
                { "data": "wkhicm_adj",
                  	render: function ( data, type, row ) {
                        if (data >= 0) {
                          return '<span class="positive">'+data+'</span>';
                        } else {
                          return '<span class="negative">'+data+'</span>';
                        }
                      }
                },
                { "data": "wklocm_adj" ,
                  	render: function ( data, type, row ) {
                        if (data >= 0) {
                          return '<span class="positive">'+data+'</span>';
                        } else {
                          return '<span class="negative">'+data+'</span>';
                        }
                      }
                },
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
<legend>NIFTY50 Top 10 Weightage% Holdings Equity Stock Watch</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">NIFTY 50 Heroes Holdings</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 100%">
		<thead>
			<tr>
				 	  <th>Script Name</th>
				 	  <th>WT</th>
				 	  <th>Open</th>
					  <th>High</th>
					  <th>Low</th>
					  <th>LTP</th>
					  <th>Chng</th>
					  <th>%Chng</th>
					  <th>Vol(Lac)</th>
					  <th>Turn<br>Over(Crs)</th>
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