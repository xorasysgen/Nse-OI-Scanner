<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style>
a.menu_links { cursor: pointer; }
</style>
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
      <a class="navbar-brand" href="boot"><span class="glyphicon glyphicon-home" style="color:#28a745;"></span> <span style="color:#28a745;"> Boot</span><!--<span class="glyphicon glyphicon-leaf" style="color:#28a745;"></span> --></a>
      <!-- <img alt="Brand" src="https://bgasparotto.com/wp-content/uploads/2017/12/spring-logo.png" height="20%" width="20%"> -->	
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
    	   	 <li class="active"><a href="most_active_underlying"><span class="glyphicon glyphicon-chevron-right" style="color:#007bff;"></span> Most Active<span class="sr-only">(current)</span></a></li>
	         <li class="dropdown">
         	 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-list" style="color:#ffc107;"></span>  NSE-Stocks <sup><span class="badge">12</span></sup><span class="caret"></span></a>
         <ul class="dropdown-menu">
         <li><a href="nifty50Intraday_ohl_strategy"><span class="glyphicon glyphicon-chevron-right" style="color:#ffc107;"></span> Nifty-50 OHL</a></li>
         <li><a href="nifty50FOALLIntraday_ohl_strategy"><span class="glyphicon glyphicon-chevron-right" style="color:#ffc107;"></span> F&amp;O OHL</a></li>
         <li role="separator" class="divider"></li>
	         <li><a href="world_market_futures"><span class="glyphicon glyphicon-chevron-right" style="color:#ffc107;"></span> World Market-FUT</a></li>
         <li role="separator" class="divider"></li>
         	  <li><a href="nifty_top_ten_heroes_weightage"><span class="glyphicon glyphicon-chevron-right" style="color:#ffc107;"></span> Nifty Heroes</a></li>
	          <li><a href="bank_nifty_page"><span class="glyphicon glyphicon-chevron-right" style="color:#ffc107;"></span> Bank Nifty</a></li>
	          <li><a href="all_nifty_indices_nse"><span class="glyphicon glyphicon-chevron-right" style="color:#ffc107;"></span> Nifty Indices</a></li>
	          <li><a href="indices_nse"><span class="glyphicon glyphicon-chevron-right" style="color:#ffc107;"></span> Indices</a></li>
	          <li role="separator" class="divider"></li>
	          <li><a href="gainers"><span class="glyphicon glyphicon-chevron-right" style="color:#ffc107;"></span> Top Gainers</a></li>
	          <li><a href="losers"><span class="glyphicon glyphicon-chevron-right" style="color:#ffc107;"></span> Top Losers</a></li>
	          <li><a href="25_volume_gainers"><span class="glyphicon glyphicon-chevron-right" style="color:#ffc107;"></span> 25 Volume Gainers</a></li>
	          <li role="separator" class="divider"></li>
	          <li><a href="most_active_securities_value"><span class="glyphicon glyphicon-chevron-right" style="color:#ffc107;"></span> Most Active Stocks Val</a></li>
	          <li><a href="most_active_securities_volume"><span class="glyphicon glyphicon-chevron-right" style="color:#ffc107;"></span> Most Active Stocks Vol</a></li>
         </ul>
          
          
        </li>
        
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-eye-open" style="color:#0277bd; font-size: 14px;"></span> Open-Interest <sup><span class="badge">9</span></sup> <span class="caret"></span></a>
          <ul class="dropdown-menu">
	           	<li><a href="currency_weekly"><span class="glyphicon glyphicon-chevron-right" style="color:#007bff;"></span> Currency OptionChain-Full</a></li>
          		<li role="separator" class="divider"></li>
	            <li><a href="oispurts"><span class="glyphicon glyphicon-chevron-right" style="color:#007bff;"></span> OI Spurts</a></li>
	            <li role="separator" class="divider"></li>
	            <li><a href="bullish"><span class="glyphicon glyphicon-chevron-right" style="color:#007bff;"></span> Bullish</a></li>
	            <li><a href="bearish"><span class="glyphicon glyphicon-chevron-right" style="color:#007bff;"></span> Bearish</a></li>
	            <li><a href="short_covering"><span class="glyphicon glyphicon-chevron-right" style="color:#007bff;"></span> Short Covering</a></li>
	            <li><a href="long_unwinding"><span class="glyphicon glyphicon-chevron-right" style="color:#007bff;"></span> Long Unwinding</a></li>
	            <li role="separator" class="divider"></li>
	            <li><a href="top_open_interest"><span class="glyphicon glyphicon-chevron-right" style="color:#007bff;"></span> Top Hot Open Interest</a></li> 
	            <li role="separator" class="divider"></li>
	            <li><a href="active_fo_call"><span class="glyphicon glyphicon-chevron-right" style="color:#007bff;"></span> Active F&amp;O Stocks Call</a></li>
	            <li><a href="active_fo_put"><span class="glyphicon glyphicon-chevron-right" style="color:#007bff;"></span> Active F&amp;O Stocks Put</a></li>
          </ul>
        </li>
        
          <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-th-large" style="color:#28a745;"></span> Derivatives <sup><span class="badge">16</span></sup> <span class="caret"></span></a>
          <ul class="dropdown-menu">
	            <li><a href="top_20_contracts_intraday"><span class="glyphicon glyphicon-chevron-right" style="color:#28a745;"></span> Top 20 Contracts</a></li>
	            <li><a href="nifty_50_options_public"><span class="glyphicon glyphicon-chevron-right" style="color:#28a745;"></span> Nifty50 Contracts</a></li>
	           	<li role="separator" class="divider"></li>
	           	<li><a href="nifty_weekly"><span class="glyphicon glyphicon-chevron-right" style="color:#28a745;"></span> Nifty OptionChain-Full</a></li>
	           	<li><a href="bank_nifty_weekly"><span class="glyphicon glyphicon-chevron-right" style="color:#28a745;"></span> BankNifty OptionChain-Full</a></li>
	           	<li role="separator" class="divider"></li>
	           	<li><a href="option_chain_nifty_fifty"><span class="glyphicon glyphicon-chevron-right" style="color:#28a745;"></span> Nifty Option Chain(C)</a></li>
	           	<li><a href="option_chain_nifty_fifty_mobile"><span class="glyphicon glyphicon-chevron-right" style="color:#28a745;"></span> Nifty Option Chain Mobile(C)</a></li>
	          	<li role="separator" class="divider"></li>
	          	<li><a href="bank_nifty_option_chain_12"><span class="glyphicon glyphicon-chevron-right" style="color:#28a745;"></span> Bank Nifty Option Chain(C)</a></li>
	          	<li><a href="bank_nifty_option_chain_12_mobile"><span class="glyphicon glyphicon-chevron-right" style="color:#28a745;"></span> Bank Nifty OC Mobile(C)</a></li>
	          	<li role="separator" class="divider"></li>
	          	<li><a href="option_chain_stocks_pcr"><span class="glyphicon glyphicon-chevron-right" style="color:#28a745;"></span> Stocks Option Chain</a></li>
	          	
	          	
	            <li role="separator" class="divider"></li>
	            <li><a href="derivative_call_all"><span class="glyphicon glyphicon-chevron-right" style="color:#28a745;"> </span> All Calls-CE</a></li>
	            <li><a href="derivative_call_nifty_bank"><span class="glyphicon glyphicon-chevron-right" style="color:#28a745;"> </span> Bank Nifty Calls-CE</a></li>
	            <li><a href="derivative_call_nifty"><span class="glyphicon glyphicon-chevron-right" style="color:#28a745;"> </span> Nifty Calls-CE</a></li>
	            <li role="separator" class="divider"></li>
	            <li><a href="derivative_put_all"><span class="glyphicon glyphicon-chevron-right" style="color:#28a745;"> </span> All Puts-PE</a></li>
	            <li><a href="derivative_put_nifty_bank"><span class="glyphicon glyphicon-chevron-right" style="color:#28a745;"> </span> Bank Nifty Puts-PE</a></li>
	            <li><a href="derivative_put_nifty"><span class="glyphicon glyphicon-chevron-right" style="color:#28a745;"> </span> Nifty Puts-PE</a></li>
	            <li role="separator" class="divider"></li>
	            <li><a href="option_chain_pcr_reader_months_all"><span class="glyphicon glyphicon-chevron-right" style="color:#28a745;"> </span> Nifty Put-Call Ratio</a></li>
          </ul>
        </li>



 		<li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-fire" style="color:#CC0000;"></span> Hot Futures <sup><span class="badge">4</span></sup> <span class="caret"></span></a>
	          <ul class="dropdown-menu">
					<li><a href="fostocks"><span class="glyphicon glyphicon-chevron-right" style="color:#CC0000;"></span> Future &amp; Options Stocks</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="most_active_future_volume_public"><span class="glyphicon glyphicon-chevron-right" style="color:#CC0000;"> </span> Active Future Volume Wise</a></li>
		            <li><a href="most_active_future_value_public"><span class="glyphicon glyphicon-chevron-right" style="color:#CC0000;"> </span> Active Future Value Wise</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="coc"><span class="glyphicon glyphicon-chevron-right" style="color:#CC0000;"> </span> Stock Future Scrutiny</a></li>
	          </ul>
        </li>
        
      		<li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-leaf" style="color:#28a745;"></span> Post Market Analysis <sup><span class="badge">6</span></sup> <span class="caret"></span></a>
       	   <ul class="dropdown-menu">
	            <li><a href="security_wise_deliverable_positions"><span class="glyphicon glyphicon-chevron-right" style="color:#28a745;"> </span> Security Deliverable</a></li>
	            <li><a href="security_var_public"><span class="glyphicon glyphicon-chevron-right" style="color:#28a745;"> </span> Security VaR</a></li>
	            <li role="separator" class="divider"></li>
	            <li><a href="market_capitalisation_most_active_year_wise_public"><span class="glyphicon glyphicon-chevron-right" style="color:#28a745;"> </span> Most Active This Year</a></li>
	            <li><a href="broad_market_indices_all_sectors"><span class="glyphicon glyphicon-chevron-right" style="color:#28a745;"> </span> Broad Market Indices</a></li>
	            <li><a href="cal_sha_avg_price"><span class="glyphicon glyphicon-chevron-right" style="color:#28a745;"> </span> Average Calculator</a></li>
	            <li><a href="wd_gann_pred"><span class="glyphicon glyphicon-chevron-right" style="color:#28a745;"> </span> Gann Prediction</a></li>
	            
          </ul>
          
          
        </li>
                
    
      <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-calendar" style="color:#33b5e5;"></span> Watcher <sup><span class="badge">2</span></sup> <span class="caret"></span></a>
	          <ul class="dropdown-menu">
					<li><a href="forthcoming_dividends_public"><span class="glyphicon glyphicon-chevron-right" style="color:#33b5e5;"></span> ForthComing Dividends</a></li>
					<li><a href="forthcoming_results_public"><span class="glyphicon glyphicon-chevron-right" style="color:#33b5e5;"></span> ForthComing Results</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="#"> <span class="glyphicon glyphicon-chevron-right" style="color:#33b5e5;"></span> To do...</a></li>
	          </ul>
       </li>
       
       <li class="nav-item">
       		 <a class="menu_links" onclick="document.forms['logoutForm'].submit()" onmouseover="" style="cursor: pointer;">
				<span class="glyphicon glyphicon-log-out" style="color:#ff4444;"></span> Log out
			</a>
      </li>
       
        
      </ul>
     
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
  
  
<form id="logoutForm" method="POST" action="${contextPath}/logout">
<sec:csrfInput /> 
</form>
  