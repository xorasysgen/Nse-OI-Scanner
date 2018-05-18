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
            "ajax": "https://jsr101.herokuapp.com/advances_declines_bank_nifty",
            "columns": [
                { "data": "symbol" ,
                  	 render: function ( data, type, row ) {
                         
                         return '<span class="symbol">'+data+'</span>';
                       
                     } 
                	},
                { "data": "weightage" },
                { "data": "open" },
                { "data": "high" },
                { "data": "low" },
                { "data": "ltP" },
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
                              return '<span class="positive">'+data+' %</span>';
                            } else {
                              return '<span class="negative">'+data+' %</span>';
                            }
                          } 
                		},
                { "data": "trdVol" },
                { "data": "trdVolM" },
                { "data": "wkhi" },
                { "data": "wklo" },
                { "data": "yPC" ,
                	render: function ( data, type, row ) {
                        if (data >= 0) {
                          return '<span class="positive">'+data+' %</span>';
                        } else {
                          return '<span class="negative">'+data+' %</span>';
                        }
                      } 
                	},
                { "data": "mPC" ,
                    	render: function ( data, type, row ) {
                            if (data >= 0) {
                              return '<span class="positive">'+data+' %</span>';
                            } else {
                              return '<span class="negative">'+data+' %</span>';
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
				 	  <th>Open</th>
					  <th>High</th>
					  <th>Low</th>
  				      <th>Ltp</th>
					  <th>preClose</th>
				 	  <th>Val Chng</th>
					  <th>% Chng</th>
					  <th>Volume(L)</th>
					   <th>365d %chng</th>
				 	  <th>52wH</th>
					  <th>52wL</th>
					  <th>%YearChng</th>
					  <th>%MonChng</th>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
</body>
</html>