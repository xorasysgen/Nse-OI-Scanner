<!doctype html>
<html>
  <head>
    <title>Latest dividend declared by Securities</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="js_css_include.jsp"/>
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "order": [],
            "pageLength": 100,
            "ajax": "forthcoming_dividends",
            "columns": [
                		{ "data": "symbol" ,
                			render: function ( data, type, row ) {
                                
                                return '<span class="symbol">'+data+'</span>';
                              
                            } 
                		},
                        { "data": "company" },
                        { "data": "faceValue" }, 
                        { "data": "purpose" ,
                			render: function ( data, type, row ) {
                                
                                return '<span class="positive">'+data+'</span>';
                              
                            } 
                        },
                        { "data": "exDate" ,
                			render: function ( data, type, row ) {
                                
                                return '<span class="darkviolet">'+data+'</span>';
                              
                            } 
                        },
                        { "data": "recordDate" ,
                			render: function ( data, type, row ) {
                                
                                return '<span class="olive">'+data+'</span>';
                              
                            } 
                        },
                        { "data": "bcStartDate" },
                        { "data": "bcEndDate" }
                        
                
            ]
        } );
    } );
    </script>
    
    
    
  </head>
  <body>
  <jsp:include page="menu.jsp"/>
  
  
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>Latest dividend declared by Securities > Forthcoming Dividends</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Did You Know# The ex-dividend date is the date after which people buying shares would not be entitled to the dividend. The ex-dividend date is usually 2 days prior to the record date in order to give the custodian time to register all new shareholders. If you buy shares prior to the ex-dividend date, you will receive the dividend..</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 100%">
		<thead>
			<tr>
							<th>Symbol</th>
							<th>Company</th>
							<th>FaceValue</th>
							<th>Purpose</th>
							<th>ExDate</th>
							<th>RecordDate</th>
							<th>BCStartDate</th>
							<th>BCEndDate</th>
						</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
	<jsp:include page="footer.jsp" />	
</body>
</html>