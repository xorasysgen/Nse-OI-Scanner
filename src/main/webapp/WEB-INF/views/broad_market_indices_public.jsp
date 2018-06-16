<!doctype html>
<html>
  <head>
    <title>Broad Market Indices-Latest Close-Previous Day-One Week Ago-One Month Ago-One Year Ago</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
<script>
        $.ajax({
        	type:'Get',
        	url: 'broad_market_indices',
        	success: function(result){
            $("#broad_market_indices").html(result);
        	
        }
        })

</script>
    
    
    
  </head>
  <body>
  <jsp:include page="menu.jsp"/>
  
  
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Broad Market Indices > Latest Close > Previous Day > One Week Ago > One Month Ago > One Year Ago</h3>
    </div>
    <div class="panel-body">
	<span id="broad_market_indices"></span>
		</div>
	</div>
	</fieldset>
	<jsp:include page="footer.jsp" />	
</body>
</html>