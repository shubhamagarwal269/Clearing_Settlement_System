<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" href="images/favicon.ico" type="image/ico" />

    <title>Clearing Member </title>

    <!-- Bootstrap -->
    <link href="dashboard/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="dashboard/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="dashboard/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="dashboard/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
	<!-- Datatables -->
    <link href="dashboard/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="dashboard/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="dashboard/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="dashboard/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="dashboard/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">
	
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
              <a href="index.html" class="site_title"><i class="fa fa-bank"></i> </a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
                <img src="dashboard/images/user.png" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Welcome,</span>
                <h2>Clearing Member</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>Options</h3>
                <ul class="nav side-menu">
                  <li class="active"><a><i class="fa fa-bar-chart-o"></i> Obligation Report</a>
                  </li>
                  <li><a><i class="fa fa-bell"></i> Settlement Report </a>
                  </li>
                  <li><a><i class="fa fa-money"></i> View Fund Balance </a>
                    
                  </li>
                  <li><a><i class="fa fa-info"></i> View DEMAT Balance </span></a></li>
				  
				  <li><a><i class="fa fa-mail-reply"></i> View Past Reports </span></a></li>
                  
                
                </ul>
              </div>
              

            </div>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
           
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
                    <img src="dashboard/images/user.png" alt="">Clearing Member
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="javascript:;"> Profile</a></li>
                    <li>
                      <a href="javascript:;">
                    
                        <span>Settings</span>
                      </a>
                    </li>
                    <li><a href="javascript:;">Help</a></li>
                    <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
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
            <div class="col-md-6 col-sm-4 col-xs-6 tile_stats_count">
              <span class="count_top"><i class="fa fa-shopping-cart"></i> Securities Shortage</span>
              <div class="count">2500</div>
              <span class="count_bottom"><i class="green">4% </i> From last Week</span>
            </div>
            <div class="col-md-6 col-sm-4 col-xs-6 tile_stats_count">
              <span class="count_top"><i class="fa fa-money"></i> Funds Shortage</span>
              <div class="count">123.50</div>
              <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>3% </i> From last Week</span>
            </div>
            
          </div>
          <!-- /top tiles -->


          
        <!-- /page content -->
		<div  role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <p><b><h3>Dear Clearing Member, 
				<br>Your Obligation Report Is Mentioned Below</h3></b></p>
              </div>



            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-6 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Securities Oblition</h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <p class="text-muted font-13 m-b-30">
                      Your Security settlement obligation for today is:
                    </p>
                    <table class="table">
                      <thead>
                        <tr>
                          <th>ISIN</th>
                          <th>Security Name</th>
                          <th>Quantity</th>
              
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <th>1</th>
                          <td>Facebook</td>
                          <td>10</td>
                       
                        </tr>
                        <tr>
                          <th>2</th>
                          <td>Apple</td>
                          <td>5</td>
                          
                        </tr>
                        <tr>
                          <th>3</th>
                          <td>Wipro</td>
                          <td>20</td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
			  
			  
			  <div class="col-md-6 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Fund Oblition</h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <p class="text-muted font-13 m-b-30">
                      Your Fund settlement obligation for today is:
                    </p>
                    <table class="table">
                      <thead>
                        <tr>
                          <th>ISIN</th>
                          <th>Security Name</th>
                          <th>Quantity</th>
              
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <th>1</th>
                          <td>Facebook</td>
                          <td>10</td>
                       
                        </tr>
                        <tr>
                          <th>2</th>
                          <td>Apple</td>
                          <td>5</td>
                          
                        </tr>
                        <tr>
                          <th>3</th>
                          <td>Wipro</td>
                          <td>20</td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>

            

        
            

       
            </div>
          </div>
        </div>

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


    <!-- Custom Theme Scripts -->
    <script src="dashboard/build/js/custom.min.js"></script>
	
  </body>
</html>
