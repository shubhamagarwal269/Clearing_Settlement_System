<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Dashboard | Admin</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" href="images/favicon.ico" type="image/ico" />

    <title>WELCOME | </title>

    <!-- Bootstrap -->
    <link href="dashboard/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="dashboard/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="dashboard/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="dashboard/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
	
    <!-- bootstrap-progressbar -->
    <link href="dashboard/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="dashboard/vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
    <!-- bootstrap-daterangepicker -->
    <link href="dashboard/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="dashboard/build/css/custom.min.css" rel="stylesheet">

</head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="adminHome" class="site_title"><span>Welcome</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
                <img src="dashboard/images/h.png" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Administrator,</span>
                <h2>CLEARING HOUSE</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>MENU</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-home"></i> Main <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="adminHome">Home</a></li> 
                      <li><a href="fetch">Trade List</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-edit"></i>Clearing Member Stats<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="form.html">Profiles</a></li>
                      <li><a href="form_advanced.html">Reports</a></li>
                      <li><a href="shortSettle.jsp">Shortage Settlement</a></li>
            
                    </ul>
                  </li>
            
                  <li><a><i class="fa fa-desktop"></i> Algorithm Stats<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="general_elements.html">Algorithm</a></li>
                      <li><a href="media_gallery.html">Metrics</a></li>
                     
                    </ul>
                  </li>
                  
                  <li><a href="updateMarket.jsp"><i class="fa fa-bar-chart-o"></i> Update Market Stats <span class="fa fa-chevron"></span></a></li>
                  
                </ul>
              </div>
              
              <div class="menu_section"></div>

            </div>
            <!-- /sidebar menu -->


            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    Admin
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                  <li><a href="logout"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                </ul>
                </li>

                <li role="presentation" class="dropdown">
               
                  <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                    <li>
                      <a>
                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <div class="text-center">
                        <a>
                          <strong>See All Alerts</strong>
                          <i class="fa fa-angle-right"></i>
                        </a>
                      </div>
                    </li>
                  </ul>
                </li>
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
         <div class="right_col" role="main">
          <!-- top tiles -->
           <div class="row tile_count">
            <div class="col-md-3 col-sm-4 col-xs-6 tile_stats_count">
              <span class="count_top"><i class="fa fa-user"></i> Total Clearing Members</span>
              <div class="count"><small style="font-size:75%"><c:out value="${member}"></c:out></small></div>
             
            </div>
            <div class="col-md-3 col-sm-4 col-xs-6 tile_stats_count">
              <span class="count_top"><i class="fa fa-shopping-cart"></i> Total Trades</span>
              <div class="count"><small style="font-size:75%"><c:out value="${trade}"></c:out></small></div>
             
            </div>
            <div class="col-md-3 col-sm-4 col-xs-6 tile_stats_count">
              <span class="count_top"><i class="fa fa-user"></i> Member With Most Security Shortages</span>
              <div class="count green"><small style="font-size:65%"><c:out value="${Security}"></c:out></small></div>
             
            </div>
            <div class="col-md-3 col-sm-4 col-xs-6 tile_stats_count">
              <span class="count_top"><i class="fa fa-user"></i> Member With Most Fund Shortages</span>
              <div class="count"><small style="font-size:65%"><c:out value="${Funds}"></c:out></small></div>
            
            </div>
            
          </div>
          <!-- /top tiles -->


          
        <!-- /page content -->
		<div role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Charts</h3>
              </div>

            </div>

            <div class="clearfix"></div>

            <div class="row">
			
			<!-- bar charts group -->
              <div class="col-md-12 col-sm-6 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Securities Graph <small>X-Axis: Clearing Member , Y-Axis: Amount Of Securities</small></h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content2">
                    <div id="graphx" style="width:100%; height:300px;" ></div>
                  </div>
                </div>
              </div>
              <!-- /bar charts group -->
              <!-- bar chart -->
              <div class="col-md-12 col-sm-6 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Funds Chart <small>X-Axis: Clearing Member , Y-Axis: Funds</small></h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <div id="graph_bar" style="width:100%; height:280px;"></div>
                  </div>
                </div>
              </div>
              <!-- /bar charts -->

              
         

              

              
              
              </div>
              
            </div>
          </div>
        </div>
		
		
		<!--page content end-->

        <!-- footer content -->
        
        <!-- /footer content -->
      </div>
    </div>

    <!-- jQuery -->
    <script src="dashboard/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="dashboard/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="dashboard/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="dashboard/vendors/nprogress/nprogress.js"></script>
    <!-- Chart.js -->
    <script src="dashboard/vendors/Chart.js/dist/Chart.min.js"></script>
    <!-- gauge.js -->
    <script src="dashboard/vendors/gauge.js/dist/gauge.min.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="dashboard/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="dashboard/vendors/iCheck/icheck.min.js"></script>
    <!-- Skycons -->
    <script src="dashboard/vendors/skycons/skycons.js"></script>
    <!-- Flot -->
    <script src="dashboard/vendors/Flot/jquery.flot.js"></script>
    <script src="dashboard/vendors/Flot/jquery.flot.pie.js"></script>
    <script src="dashboard/vendors/Flot/jquery.flot.time.js"></script>
    <script src="dashboard/vendors/Flot/jquery.flot.stack.js"></script>
    <script src="dashboard/vendors/Flot/jquery.flot.resize.js"></script>
    <!-- Flot plugins -->
    <script src="dashboard/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
    <script src="dashboard/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
    <script src="dashboard/vendors/flot.curvedlines/curvedLines.js"></script>
    <!-- DateJS -->
    <script src="dashboard/vendors/DateJS/build/date.js"></script>
    <!-- JQVMap -->
    <script src="dashboard/vendors/jqvmap/dist/jquery.vmap.js"></script>
    <script src="dashboard/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
    <script src="dashboard/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="dashboard/vendors/moment/min/moment.min.js"></script>
    <script src="dashboard/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
	
	<!-- Datatables -->
    <script src="dashboard/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="dashboard/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="dashboard/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="dashboard/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
    <script src="dashboard/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
    <script src="dashboard/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="dashboard/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="dashboard/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
    <script src="dashboard/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="dashboard/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="dashboard/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="dashboard/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
    <script src="dashboard/vendors/jszip/dist/jszip.min.js"></script>
    <script src="dashboard/vendors/pdfmake/build/pdfmake.min.js"></script>
    <script src="dashboard/vendors/pdfmake/build/vfs_fonts.js"></script>


    <!-- jQuery -->
    <script src="dashboard/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="dashboard/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="dashboard/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="dashboard/vendors/nprogress/nprogress.js"></script>
    <!-- morris.js -->
    <script src="dashboard/vendors/raphael/raphael.min.js"></script>
    <script src="dashboard/vendors/morris.js/morris.min.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="dashboard/build/js/custom.js"></script>
    <script>
    
    
    $(document).ready(function()
    {
    	$.ajax({
            url: "getsecuritiesdata", // getchart.php
            dataType: 'JSON',
            type: 'GET',
            data: {get_values: true},
            success: function(response) {
            	if( typeof (Morris) === 'undefined'){ return; }
    			console.log('init_morris_charts');
    			
    			if ($('#graphx').length ){
    				
    				Morris.Bar({
    				  element: 'graphx',
    				  data: response,
    				  xkey: 'CM',
    				  ykeys: ['Apple','Facebook','GE','LinkedIn','Walmart'],
    				  barColors: ['#26B99A', '#34495E', '#ACADAC', '#3498DB'],
    				  hideHover: 'auto',
    				  labels: ['Apple','Facebook','GE','LinkedIn','Walmart'],
    				  resize: true
    				}).on('click', function (i, row) {
    					console.log(i, row);
    				});
    			}
    			
    			
            
    			

    			
    			
    			if ($('#graph_bar').length){ 
    				Morris.Bar({
	                	element:"graph_bar",
	                    data: response,
	                    xkey: 'CM',
	                    ykeys: ['Funds'],
	                    labels: ['Funds']
	                });
            	}
    			    			
            },
            error: function (error) {
                alert('error ');
            }
            
            
            
        });// closing of first ajax
        
        
        
    });//closing of ready


    
    
    </script>
    </body>
    </html>
    
