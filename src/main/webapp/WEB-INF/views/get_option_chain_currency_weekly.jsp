<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!doctype html>
<html>
  <head>
    <title>Currency USDINR Option Chain Analysis</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
<jsp:include page="menu.jsp"/>
 
 
<style type="text/css">
div.container {
        width: 80%;
}
    
td.highlight {
    background-color: whitesmoke !important;
}
 </style>
  
  
<script>

        
function blinker() {
	$('.blinking').fadeOut(500);
	$('.blinking').fadeIn(500);
}
setInterval(blinker, 1000);

</script>
  
  
<script type="text/javascript">
$(document).ready(function() {
$("#loadContent").change(function() {
	console.log("input value=" + this.value);
	var data=this.value;
	
    $.ajax({
    	type:'Get',
    	url: 'currency_weekly_optionChain/' + data,
    	success: function(result){
    		var json = result.pcr.pcrOI;
    		var puts = result.pcr.puts;
    		var calls = result.pcr.calls;
    		var putsVolume = result.pcr.putsVolume;
    		var callsVolume = result.pcr.callsVolume;
    		var pcrVolume = result.pcr.pcrVolume;
    		
    		if(json>1)
    			text="<span class='blinking' style='color: #00c853; font-weight: bold; font-size: 18px;'>" +json+ "</span>";
    			else
    			text="<span class='blinking' style='color: #CC0000; font-weight: bold; font-size: 18px;'>" +json+ "</span>";
    			
    			
    			text1="<span class='blinking' style='color: #red; font-weight: bold; font-size: 18px;'>" +calls+ "</span>";
    			text2="<span class='blinking' style='color: #green; font-weight: bold; font-size: 18px;'>" +puts+ "</span>";
    			text3="<span class='blinking' style='color: #green; font-weight: bold; font-size: 18px;'>" +putsVolume+ "</span>";
    			text4="<span class='blinking' style='color: #red; font-weight: bold; font-size: 18px;'>" +callsVolume+ "</span>";
    			text5="<span class='blinking' style='color: #00c853; font-weight: bold; font-size: 18px;'>" +pcrVolume+ "</span>";
    			
      		 $("#OptionsStockPCR").html(text);
      		 $("#calls").html(text1);
      		 $("#puts").html(text2);
      		 $("#putsVolume").html(text3);
      		 $("#callsVolume").html(text4);
      		 $("#pcrVolume").html(text5);
      		 
    	
    }
    })
	
	
	
	if ($.fn.DataTable.isDataTable("#example")) {
		  $('#example').DataTable().clear().destroy();
		}	
	var table= $('#example').DataTable( {
        "processing": true,
        "order": [[ 8, "asc" ]],
        "pageLength": 100,
        "ajax": "currency_weekly_optionChain/"+data,
        "responsive" : true,
        "columns": [
        	  { "data": "oi_call" ,
                	render: function ( data, type, row ) {
                		data=data.split(',').join('');//remove comma
                		 if (data >= 100000) {
                             return '<span class="superolive">'+data+'</span>';
                        }else if (data >= 75000 && data < 100000) {
                          return '<span class="olive">'+data+'</span>';
                        } else	if (data >= 50000 && data < 75000) {
                        	 return '<span class="darkviolet">'+data+'</span>';
                        } else	if (data >= 25000 && data < 50000) {
                       	 return '<span class="liteviolet">'+data+'</span>';
                        }else {
                          return '<span>'+data+'</span>';
                        }
                      }
        	  },
              { "data": "chng_in_oi_call" ,
              	render: function ( data, type, row ) {
            		data=data.split(',').join('');//remove comma
                    if (data >= 20000) {
                      return '<span class="pink">+'+data+'</span>';
                    } else	if (data >= 10000 && data < 20000) {
                    	 return '<span class="darkviolet">+'+data+'</span>';
                    }else if (data<=-1000){
                    	return '<span class="negative">'+data+'</span>';
                    }
                    else if (data>=0 && data<2000){
                    	return '<span class="cyan">'+data+'</span>';
                    } else {
                      return '<span class="darksalmon">'+data+'</span>';
                    }
                  }
              },
              { "data": "volume_call" },
              { "data": "ltp_call" ,
                 	 render: function ( data, type, row ) {
                       
                       return '<span class="navy">'+data+'</span>';
                     
                   }
              },
              { "data": "net_chng_call" ,
                	render: function ( data, type, row ) {
                        if (data >= 0) {
                          return '<span class="positive">'+data+'</span>';
                        } else {
                          return '<span class="negative">'+data+'</span>';
                        }
                      }
              },
              { "data": "bid_qty_call" },
              { "data": "bid_price_call" },
              { "data": "iv_call" },
              { "data": "strikePrice",
             	 render: function ( data, type, row ) {
                     
                     return '<span class="navy">'+data+'</span>';
                   
                 } 
              },
              { "data": "iv_put" },
              { "data": "bid_qty_put" },
              { "data": "bid_price_put" },
              { "data": "net_chng_put" ,
              	render: function ( data, type, row ) {
                    if (data >= 0) {
                      return '<span class="positive">'+data+'</span>';
                    } else {
                      return '<span class="negative">'+data+'</span>';
                    }
                  }
              },
              { "data": "ltp_put" ,
              	 render: function ( data, type, row ) {
                     
                     return '<span class="navy">'+data+'</span>';
                   
                 }
              },
              { "data": "volume_put" },
              { "data": "chng_in_oi_put" ,
                	render: function ( data, type, row ) {
                		data=data.split(',').join('');//remove comma
                        if (data >= 20000) {
                          return '<span class="pink">+'+data+'</span>';
                        } else	if (data >= 10000 && data < 20000) {
                        	 return '<span class="darkviolet">+'+data+'</span>';
                        }else if (data<=-1000){
                        	return '<span class="negative">'+data+'</span>';
                        }
                        else if (data>=0 && data<2000){
                        	return '<span class="cyan">'+data+'</span>';
                        } else {
                          return '<span class="darksalmon">'+data+'</span>';
                        }
                      }
              },
              { "data": "oi_put" ,
              	render: function ( data, type, row ) {
            		data=data.split(',').join('');//remove comma
            		 if (data >= 100000) {
                         return '<span class="superolive">'+data+'</span>';
                    }else if (data >= 75000 && data < 100000) {
                      return '<span class="olive">'+data+'</span>';
                    } else	if (data >= 50000 && data < 75000) {
                    	 return '<span class="darkviolet">'+data+'</span>';
                    } else	if (data >= 25000 && data < 50000) {
                   	 return '<span class="liteviolet">'+data+'</span>';
                    }else {
                      return '<span>'+data+'</span>';
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
    
	
	
	
});
});

</script>

</head>
<body>
	<div class="container ">
		<form:form class="form-horizontal" method="post"	action="${pageContext.request.contextPath}${actionUri}"	modelAttribute="stockName">
			<h3 class="form-signin-heading form-group col-sm-8"><strong>Currency USDINR</strong> Weekly Option Chain Analysis</h3>
			

	<div class="form-group col-sm-8">
			 <!--  <label for="country">Stock Option Scrutiny</label>  -->
			 <form:select path="stockName" class="form-control" id="loadContent">
			  		<form:option value="-1" label="Please Select Future and Option Stock"  selected="selected"/>
					<form:options items="${dateList}" />
			</form:select>
			  
		</div><br>
			
</form:form>
</div>	
			<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>Bank Nifty Option Chain (Equity Derivatives)<span class="pink"> </sub></span></legend>

<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Stock Dashboard <span class="glyphicon glyphicon-dashboard" style="font-size: 12px; color: #ffbb33;"></span>
         Put-Call-Ratio (PCR)# [&nbsp;<span style="color: #00e676;" id="OptionsStockPCR"></span>&nbsp;<span class="nobr">]
      <span class="supsub"><span style="color: #00e676;"><strong>0.53 &nbsp;Buy@0.50 - 0.47 - 0.33</strong></span><br /><span style="color: #ffc107;"><strong>1.50&nbsp; exp#1.87-2.27</strong></span></span>
      
      [All Calls/All Puts# &nbsp;<span class="nobr">]
      <span class="supsub"><span style="color: red;"><strong><span id="calls"></span></strong></span><br /><span style="color: #00e676;"><span id="puts"></span></span></span>
      
      Put-Call-Volume# [&nbsp;<span style="color: #00e676;" id="pcrVolume"></span>&nbsp;<span class="nobr">]
      <span class="supsub"><span style="color: red;"><strong><span id="callsVolume"></span></strong></span><br /><span style="color: #00e676;"><span id="putsVolume"></span></span></span>
      
       </h3>
    </div> 
    <div class="panel-body">
	<table id="example"	class="display compact row-border table-bordered dt-responsive" style="width: 100%">
		<thead>
		 <tr>
                <th rowspan="2">OI</th>
                <th style="text-align:center;  vertical-align:middle;" colspan="7">CALLS</th>
                <th colspan="1">Strike</th>
                <th style="text-align:center;  vertical-align:middle;" colspan="7">PUTS</th>
                <th rowspan="2">OI</th>
            </tr>
		
			<tr>
							<!-- <th>OI</th> -->
							<th style="text-align:center;  vertical-align:middle;">Chng<br/>OI</th>
							<th style="text-align:center;  vertical-align:middle;">Vol</th>
							<th style="text-align:center;  vertical-align:middle;">LTP</th>
							<th style="text-align:center;  vertical-align:middle;">Net<br/>Chng</th>
							<th style="text-align:center;  vertical-align:middle;">Bid<br/>Qty</th>
							<th style="text-align:center;  vertical-align:middle;">Bid<br/>Price</th>
							<th style="text-align:center;  vertical-align:middle;">IV</th>
							<th style="text-align:center;  vertical-align:middle;">Strike</th>
							<th style="text-align:center;  vertical-align:middle;">IV</th>
							<th style="text-align:center;  vertical-align:middle;">Bid<br/>Qty</th>
							<th style="text-align:center;  vertical-align:middle;">Bid<br/>Price</th>
							<th style="text-align:center;  vertical-align:middle;">Net<br/>Chng</th>
							<th style="text-align:center;  vertical-align:middle;">LTP</th>
							<th style="text-align:center;  vertical-align:middle;">Vol</th>
							<th style="text-align:center;  vertical-align:middle;">Chng<br/>OI</th>
							<!-- <th>OI</th> -->
						</tr>
		</thead>

	</table>

		</div>
	</div>
	<span class="glyphicon glyphicon-info-sign" style="color: #40c4ff;"></span>&nbsp; <span class="superolive">Color Code#</span> Major Support/Resistance and Higher Built Open Interest Positions<span class="superolive">(OI >=2000000)</span><br>
	<span class="glyphicon glyphicon-info-sign" style="color: #40c4ff;"></span>&nbsp; <span class="olive">Color Code#</span> Major Support/Resistance and Higher Built Open Interest Positions<span class="olive">(OI >=1000000 && OI < 2000000)</span><br>
	<span class="glyphicon glyphicon-info-sign" style="color: #40c4ff;"></span>&nbsp; <span class="darkviolet">Color Code#</span> Immediate Support/Resistance and Open Interest Built Positions<span class="darkviolet">(OI >=500000  && OI<1000000)</span><br>
	<span class="glyphicon glyphicon-info-sign" style="color: #40c4ff;"></span>&nbsp; <span class="pink">Color Code#</span> Intraday new added Open Interest/Very Active Built Positions<span class="pink">(OI >=300000)</span><br>
	<span class="glyphicon glyphicon-info-sign" style="color: #40c4ff;"></span>&nbsp; <span class="cyan">Color Code#</span> Normal Open Interest Built Positions<span class="cyan">(OI <=200000)</span><br>
	<span class="glyphicon glyphicon-info-sign" style="color: #40c4ff;"></span>&nbsp; <span class="navy">Color Code#</span> Strike and Strike Price<br>
	<span class="glyphicon glyphicon-info-sign" style="color: #40c4ff;"></span>&nbsp; <span class="positive">Color Code#</span> Positive Values<br>
	<span class="glyphicon glyphicon-info-sign" style="color: #40c4ff;"></span>&nbsp; <span class="negative">Color Code#</span> Negative Values<br>
	
	
	</fieldset>

	<!-- /container -->
<jsp:include page="footer.jsp" />	
</body>
</html>