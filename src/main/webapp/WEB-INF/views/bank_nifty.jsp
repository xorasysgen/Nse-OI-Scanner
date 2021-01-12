<!doctype html>
<html>
  <head>
    <title>Bank Nifty</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "order": [[ 1, "desc" ]],
            "pageLength": 25,
            "ajax": "advances_declines_bank_nifty",
            "columns": [
                { "data": "symbol" ,
                  	 render: function ( data, type, row ) {
                         
                         return '<span class="symbol">'+data+'</span>';
                       
                     } 
                	},
                { "data": "weightage" },
                { "data": "weightageOld" },
                { "data": "open" },
                { "data": "high" ,
                   	 render: function ( data, type, row ) {
                         
                         return '<span class="liteGreen">'+data+'</span>';
                       
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
                { "data": "previousClose" },
                { "data": "ptsC" ,
                	render: function ( data, type, row ) {
                        if (data >= 0) {
                          return '<span class="positive">'+data+'</span>';
                        } else {
                          return '<span class="negative">'+data+'</span>';
                        }
                      } 
                	},
                { "data": "per" ,
                    	render: function ( data, type, row ) {
                            if (data >= 0) {
                              return '<span class="positive">'+data+'%</span>';
                            } else {
                              return '<span class="negative">'+data+'%</span>';
                            }
                          } 
                		},
                { "data": "signal" ,
                        	render: function ( data, type, row )  {
                        		if (data =="Strong Buy(OL)") {
                       			 return '<span class="positive">'+data+'</span>';
                       		}
                       		else if (data =="Strong Buy(Higher High)") {
                                 return '<span class="positive">'+data+'</span>';
                               } else if (data =="Buy") {
                               	return '<span class="positive">'+data+'</span>';
                               }
                               else {
                                 return '<span class="negative">'+data+'</span>';
                               }
                             } 
                },
                { "data": "wkhi"  ,
                	render: function ( data, type, row ) {
                		data=data.split(',').join('');//remove comma
                        if (data >= 0) {
                          return '<span class="positive">'+data+'</span>';
                        } else {
                          return '<span class="negative">'+data+'</span>';
                        }
                      }
                },
                { "data": "wklo"  ,
                	render: function ( data, type, row ) {
                		data=data.split(',').join('');//remove comma
                          return '<span class="negative">'+data+'</span>';
                        }
                     
                },
                { "data": "yPC" ,
                	render: function ( data, type, row ) {
                        if (data >= 0) {
                          return '<span class="positive">'+data+'%</span>';
                        } else {
                          return '<span class="negative">'+data+'%</span>';
                        }
                      } 
                	},
                { "data": "mPC" ,
                    	render: function ( data, type, row ) {
                            if (data >= 0) {
                              return '<span class="positive">'+data+'%</span>';
                            } else {
                              return '<span class="negative">'+data+'%</span>';
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
<legend>Bank Nifty Stocks</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Bank Nifty</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 100%">
		<thead>
			<tr>
				 	  <th>Symbol</th>
				 	  <th>Weightage</th>
				 	  <th>WT Old</th>
				 	  <th>Open</th>
					  <th>High</th>
					  <th>Low</th>
  				      <th>Ltp</th>
					  <th>preClose</th>
				 	  <th>Chng</th>
					  <th>%Chng</th>
					  <th>Signal</th>
				 	  <th>52wH</th>
					  <th>52wL</th>
					  <th>%YearChng</th>
					  <th>%MonChng</th>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
	<jsp:include page="footer.jsp" />	
</body>
</html>
