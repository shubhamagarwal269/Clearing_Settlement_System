<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Trades | Admin</title>

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
    
    <style type="text/css">
    
    .disabledbutton {
    pointer-events: none;
    opacity: 0.4;
    }
    
    </style>

</head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.html" class="site_title"><span>Welcome</span></a>
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
                      <li><a href="dashAdmin.jsp">Home</a></li> 
                      <li><a href="fetch">Trade List</a></li>
                    </ul>
                  </li>
      <!--  <li><a><i class="fa fa-edit"></i>Clearing Member Stats<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="form.html">Profiles</a></li>
                      <li><a href="form_advanced.html">Reports</a></li>
                      <li><a href="shortSettle.jsp">Shortage Settlement</a></li>
            
                    </ul>
                  </li> -->
                  
                  <li><a><i class="fa fa-edit"></i>Reports<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="form.html">Netting Report</a></li>
                      <li><a href="form_advanced.html">Member Obligation Reports</a></li>            
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
                    <img src="images/h.png" alt="">Admin
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                 <li><a href="logout"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                 </ul>
                </li>

                <li role="presentation" class="dropdown">
                  <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                    <i class="fa fa-envelope-o"></i>
                    <span class="badge bg-green">6</span>
                  </a>
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
          <div class="">
          
          	  <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                      
                      
                      <h3>Shortage Settlement</h3> &nbsp;
                      <!-- 
                      <button type="button" class="btn btn-info btn-sm">
                           Refresh	
					  </button> 
					  -->
                 
                    <ul class="nav navbar-right panel_toolbox">
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  
                  	<h4>Defaulting Member name:</h4> 
                    <table id="datatable-buttons" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                        
                          <th>Fund Shortage</th>
                          <th>Security shortage</th>
                        </tr>
                      </thead>
                      
                      <tbody>
                            <tr>
	                          
	                          <td>
	                          <div>
	                          <form action="" method="get">
	                          
								Bank Account number: &nbsp;&nbsp; 81341030<br><br>
								Current fund balance: &nbsp;&nbsp; 1030<br><br>
								Required fund balance: &nbsp;&nbsp; 5000<br><br>
								Fund borrowing rate(% p.a.): &nbsp;&nbsp; 5<br><br>
								<button type="button" class="btn btn-success"> Settle </button>

							  
							  </form>
	                          </div>
							  </td>
	                          
	                          <!------------------------------>
	                          
	                          <td>
	                          <div class="disabledbutton">
	                          <form action="" method="get">
	                          
								<table id="datatable-buttons" class="table table-striped table-bordered">
			                      <thead>
			                        <tr>
			                        
			                          <th>ISIN</th>
			                          <th>Security name</th>
			                          <th>Market price</th>
			                          <th>Holding volume</th>
			                          <th>Required volume</th>
			                          <th>Borrowing rate</th>
			                          <th>Settle</th>
			                          
			                        </tr>
			                      </thead>
			
			
			                      <tbody>
				                        <tr>
				                          <td>1001</td>
				                          <td>Facebook</td>
				                          <td>208.2</td>
				                          <td>200</td>
				                          <td>350</td>
				                          <td>5%</td>
				                          <td>
				                          <button type="button" class="btn btn-success"> Settle </button>
										  </td>
				                        </tr>
				                        
				                        				                        <tr>
				                          <td>1001</td>
				                          <td>Facebook</td>
				                          <td>208.2</td>
				                          <td>200</td>
				                          <td>350</td>
				                          <td>5%</td>
				                          <td>
				                          <button type="button" class="btn btn-success"> Settle </button>
										  </td>
				                        </tr>
				                        
				                        				                        <tr>
				                          <td>1001</td>
				                          <td>Facebook</td>
				                          <td>208.2</td>
				                          <td>200</td>
				                          <td>350</td>
				                          <td>5%</td>
				                          <td>
				                          <button type="button" class="btn btn-success"> Settle </button>
										  </td>
				                        </tr>			
			                      </tbody>
			                    </table>
						 
							  </form>
	                          </div>
							  </td>
							  
	                        </tr>
	                  </tbody>


                    </table>
                  </div>
                </div>
              </div>
              
              
          
          </div>
        </div>
        
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
            Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
          </div>
          <div class="clearfix"></div>
        </footer>
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

    <!-- Custom Theme Scripts -->
    <script src="dashboard/build/js/custom.min.js"></script>
    
    <script type="text/javascript">
    $("#mydiv").addClass("disabledbutton");
    </script>
    
  </body>

</html>