<!doctype html>
<html>
  <head>
    <title>Top 20 Contracts</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "order": [[ 4, "desc" ]],
            "pageLength": 25,
            "ajax": "top_20_contracts_nse_fo",
            "columns": [
                { "data": "underlying" ,
                	render: function ( data, type, row ) {
                        if (data == 'NIFTY') {
                          return '<span class="nifty">'+data+'</span>';
                        } else {
                          return '<span class="bankNifty">'+data+'</span>';
                        }
                      }
                },
                { "data": "expiryDate",
                  	 render: function ( data, type, row ) {
                         
                         return '<span class="black">'+data+'</span>';
                       
                     } 
                },
                { "data": "optionType" ,
                	render: function ( data, type, row ) {
                        if (data == 'CE') {
                          return '<span class="positive">'+data+'</span>';
                        } else {
                          return '<span class="yellow">'+data+'</span>';
                        }
                      }
                },
                { "data": "strikePrice" ,
                  	 render: function ( data, type, row ) {
                         
                         return '<span class="symbol">'+data+'</span>';
                       
                     } 
                },
                { "data": "premiumTurnoverLacs" , 
	               	 render: function ( data, type, row ) {
	                     return '<span class="navy">'+data+'</span>';
	                 } 
        	    },
                { "data": "prevClose" , 
                	 render: function ( data, type, row ) {
                         return '<span class="orange">'+data+'</span>';
                     } 
                },
                { "data": "openPrice" },
                { "data": "highPrice" , 
               	 render: function ( data, type, row ) {
                     return '<span class="positive">'+data+'</span>';
                 } 
                },
                { "data": "lowPrice" , 
                 	 render: function ( data, type, row ) {
                        return '<span class="negative">'+data+'</span>';
                    } 
                },
                { "data": "lastPrice" ,
                  	 render: function ( data, type, row ) {
                         return '<span class="liteGreen">'+data+'</span>';
                     } 
                },
                { "data": "volumeContracts" }, 
                { "data": "turnoverLacs" , 
	               	 render: function ( data, type, row ) {
	                     return '<span class="navy">'+data+'</span>';
	                 } 
                },
                {"data": "underlyingValue",
                  	 render: function ( data, type, row ) {
                  		if (data >= 7000 && data<=12500) {
                         return '<span class="nifty">'+data+'</span>';
                  		}
                  		else{
                  			return '<span class="bankNifty">'+data+'</span>';
                  		}
                  			
                       
                     }
                }                
                
            ]
        } );
        
var selected = [];
    	
    	$('#example tbody').on('click', 'tr', function () {
            var id = this.id;
            var index = $.inArray(id, selected);
     
            if ( index === -1 ) {
                selected.push( id );
            } else {
                selected.splice( index, 1 );
            }
     
            $(this).toggleClass('selected');
        } );
        
        
    } );
    
    
    </script>
    
    
    
  </head>
  <body>
  <jsp:include page="menu.jsp"/>
  
  
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>Intraday &amp; Positional  Top 20 Contracts</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Top 20 Contracts Order By Premium (Lacs) </h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="display compact row-border table-bordered dt-responsive" style="width: 100%">
		<thead>
			<tr>
				 <th>Underlying</th>
	              <th>ExpiryDate</th>
	              <th>Opt Ty</th>
	              <th>StrikePrice</th>
	              <th>Premium<br>Lacs</th>
	              <th>PrevClose</th>
	              <th>OpenPrice</th>
	              <th>HighPrice</th>
	              <th>LowPrice</th>
	              <th>LastPrice</th>
	              <th>Volume<br>Contract</th> 
	              <th>Turnover<br>Lacs</th>
	              <th>Price</th>
	              
			</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
	<jsp:include page="footer.jsp" />	
</body>
</html>