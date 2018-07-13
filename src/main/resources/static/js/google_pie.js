var advances,declines,unchanged,total;

      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
    	   $.ajax( {
    	  	  type:'Get',
    	  	  url:'advances_declines',
    	  	  success:function(data) {
    	  	  // console.log(data);
    	  	   abc(data);
    	  	
    	  	  }

    	  	  })
    	   function abc(data){
    	    	 advances = data.rows[0].advances;
    	    	 declines=data.rows[0].declines ;
    	    	 unchanged=data.rows[0].unchanged;
    	    	 total=data.rows[0].total;
    	    	  var data = google.visualization.arrayToDataTable(
    	    			  [ ['Task', 'task' ],
    	    				['unused',0],  
    	    	            ['Declines',  declines],
    	    	            ['Unchanged',  unchanged],
    	    			    ['Advances',   advances]
    	    			    
    	    	           ]);
    	    	                                                  
    	    	          var options = {
    	    	          title: 'Market breadth & Overall Advances & Declines Ratio Chart',
    	    	          is3D: true,
    	    	          chartArea: {
    	                      left: "10%",
    	                      top: "10%",
    	                      height: "50%",
    	                      width: "50%"
    	                  }
    	    	          };
                   var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
                   chart.draw(data, options);
    	      }
        
      }
      