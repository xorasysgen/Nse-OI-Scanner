<!doctype html>
<html>
  <head>
    <title>My AngularJS App</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<!-- begin js files -->    
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.1/js/dataTables.responsive.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.1/js/responsive.bootstrap.min.js"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
 
 </head>
<!-- end js files -->

<!-- begin css files -->
 <link rel="stylesheet"   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css">
 <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.2.1/css/responsive.bootstrap.min.css">
 <!-- end css files -->
 
 
   
    <script type="text/javascript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "ajax": "https://jsr101.herokuapp.com/top_gainer/",
            "columns": [
                { "data": "symbol" },
                { "data": "openPrice" },
                { "data": "highPrice" },
                { "data": "lowPrice" },
                { "data": "ltp" },
                { "data": "previousPrice" },
                { "data": "netPrice" },
                { "data": "tradedQuantity" },
                { "data": "turnoverInLakhs" },
                { "data": "lastCorpAnnouncementDate" },
                { "data": "lastCorpAnnouncement" }
            ]
        } );
    } );
    </script>
    
    
    
  </head>
  <body>
  <nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Spring Boot</a>
      <!-- <img alt="Brand" src="https://bgasparotto.com/wp-content/uploads/2017/12/spring-logo.png" height="20%" width="20%"> -->	
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Advance/Decline <span class="sr-only">(current)</span></a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">NSE-Stocks <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
        
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Derivative<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>
        
        <!-- <li><a href="#">Link</a></li>
        <li><a href="#">Link</a></li>
        <li><a href="#">Link</a></li>
        <li><a href="#">Link</a></li> -->
      </ul>
     
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
  
  
  
  
<fieldset class="field_set" style="margin-left:28px;margin-right:28px;">
<legend>Intraday Top Ten Gainers</legend>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Top Gainers</h3>
    </div>
    <div class="panel-body">
	<table id="example"		class="table table-striped table-bordered dt-responsive nowrap" style="width: 90%">
		<thead>
			<tr>
				<th>symbol</th>
				<th>openPrice</th>
				<th>highPrice</th>
				<th>lowPrice</th>
				<th>ltp</th>
				<th>previousPrice</th>
				<th>netPrice %</th>
				<th>tradedQuantity</th>
				<th>turnoverInLakhs</th>
				<th>lastCorpAnnouncementhate</th>
				<th>lastCorpAnnouncement</th>
			</tr>
		</thead>

	</table>

		</div>
	</div>
	</fieldset>
</body>
</html>