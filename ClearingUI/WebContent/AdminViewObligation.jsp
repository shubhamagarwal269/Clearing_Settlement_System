<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>ViewObligation | Admin</title>

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
    
    <style>
    	.table-hover tbody tr:hover td, .table-hover tbody tr:hover th {
  			background-color: #8cf7e2;
		}
		.enMoney::before {
	    content:"$ ";
	}
    </style>

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
                  <!--  <li><a><i class="fa fa-edit"></i>Clearing Member Stats<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="form.html">Profiles</a></li>
                      <li><a href="form_advanced.html">Reports</a></li>
                      <li><a href="shortSettle.jsp">Shortage Settlement</a></li>
            
                    </ul>
                  </li> -->
                  
                  <li><a><i class="fa fa-edit"></i>Reports<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="viewNetting">Netting Report</a></li>
                      <li><a href="viewObligation">Member Obligation Reports</a></li>            
                    </ul>
                  </li>
                  
                  <li><a href="fetchmarket"><i class="fa fa-bar-chart-o"></i> Update Market Stats <span class="fa fa-chevron"></span></a></li>
                  
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
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Obligation Report</h3>
              </div>

              
            </div>

            <div class="clearfix"></div>

            <div class="row">

      
              <div class="col-md-12 col-sm-12 col-xs-12">
              <c:forEach var="MemberReport"  items="${reps}" varStatus="status">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><b><c:out value="${MemberReport.memberName}"></c:out></b></h2> 
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      
                      
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
					
                    <table class="table table-bordered table-striped table-hover">
                      <thead>
                        <tr>
						<th></th>
                          <th>Balances</th>
                          <th>Obligations</th>
                          <th>Shortages</th>
                          <th>Market Price</th>
						  <th>Borrowing Rate (%)</th>
						  <th>Settlement Cost</th>
                        </tr>
                      </thead>
                      <tbody>
                      
                        <tr>
                        
                          <td>Apple</td>
                          
                          <c:if  test="${MemberReport.currentBalance.get(0) <0}">
                          <td  style="color:#FF0000">
                   		  <c:out value="${fundBalance0[status.index]*-1 }"></c:out>
                   		  </td> 
                          </c:if>
                          <c:if  test="${MemberReport.currentBalance.get(0) >=0}">
                          <td  style="color:#008000">
                   		  <c:out value="${fundBalance0[status.index]}"></c:out>
                   		  </td> 
                          </c:if>
						  
                          <c:if  test="${MemberReport.obligation.get(0) <0}">
                          <td  style="color:#FF0000">
                   		  <c:out value="${fundObligation0[status.index]*-1}"></c:out>
                   		  </td> 
                          </c:if>
                          <c:if  test="${MemberReport.obligation.get(0) >=0}">
                          <td  style="color:#008000">
                   		  <c:out value="${fundObligation0[status.index]}"></c:out>
                   		  </td> 
                          </c:if>
                          
                          
                          <c:if  test="${MemberReport.shortage.get(0) >0}">
                          <td  style="color:#FF0000">
                   		  <c:out value="${fundShortage0[status.index]}"></c:out>
                   		  </td> 
                          </c:if>
                          <c:if  test="${MemberReport.shortage.get(0) <=0}">
                          <td  style="color:#008000">
                   		  <c:out value="${fundShortage0[status.index]}"></c:out>
                   		  </td> 
                          </c:if>
						  <td><c:out value="${MemberReport.marketPriceList.get(0) }"></c:out></td>
						  <td><c:out value="${MemberReport.borrowingRateList.get(0) }"></c:out></td>
					 	  <td><price><c:out value="${fundSettlement0[status.index] }"></c:out></price></td> 
                        </tr>
                        
                        <tr>
                          <td>Facebook</td>
                          
                          <c:if  test="${MemberReport.currentBalance.get(1) <0}">
                          <td  style="color:#FF0000">
                   		  <c:out value="${fundBalance1[status.index] *-1 }"></c:out>
                   		  </td> 
                          </c:if>
                          <c:if  test="${MemberReport.currentBalance.get(1) >=0}">
                          <td  style="color:#008000">
                   		  <c:out value="${fundBalance1[status.index]}"></c:out>
                   		  </td> 
                          </c:if>
                          
                          <c:if  test="${MemberReport.obligation.get(1) <0}">
                          <td  style="color:#FF0000">
                   		  <c:out value="${fundObligation1[status.index]*-1}"></c:out>
                   		  </td> 
                          </c:if>
                          <c:if  test="${MemberReport.obligation.get(1) >=0}">
                          <td  style="color:#008000">
                   		  <c:out value="${fundObligation1[status.index]}"></c:out>
                   		  </td> 
                          </c:if>
                          
                          
                          <c:if  test="${MemberReport.shortage.get(1) >0}">
                          <td  style="color:#FF0000">
                   		  <c:out value="${fundShortage1[status.index]}"></c:out>
                   		  </td> 
                          </c:if>
                          <c:if  test="${MemberReport.shortage.get(1) <=0}">
                          <td  style="color:#008000">
                   		  <c:out value="${fundShortage1[status.index]}"></c:out>
                   		  </td> 
                          </c:if>
                          
						  <td><c:out value="${MemberReport.marketPriceList.get(1) }"></c:out></td>
						  <td><c:out value="${MemberReport.borrowingRateList.get(1) }"></c:out></td>
						  <td><price><c:out value="${fundSettlement1[status.index]}"></c:out></price></td>
                        </tr>
                        
                        
                        <tr>
                          <td>GE</td>
                          
                          
                          <c:if  test="${MemberReport.currentBalance.get(2) <0}">
                          <td  style="color:#FF0000">
                   		  <c:out value="${fundBalance2[status.index] *-1}"></c:out>
                   		  </td> 
                          </c:if>
                          <c:if  test="${MemberReport.currentBalance.get(2) >=0}">
                          <td  style="color:#008000">
                   		  <c:out value="${fundBalance2[status.index] }"></c:out>
                   		  </td> 
                          </c:if>
                          
                          
                          <c:if  test="${MemberReport.obligation.get(2) <0}">
                          <td  style="color:#FF0000">
                   		  <c:out value="${fundObligation2[status.index]*-1}"></c:out>
                   		  </td> 
                          </c:if>
                          <c:if  test="${MemberReport.obligation.get(2) >=0}">
                          <td  style="color:#008000">
                   		  <c:out value="${fundObligation2[status.index]}"></c:out>
                   		  </td> 
                          </c:if>
                          <c:if  test="${MemberReport.shortage.get(2) >0}">
                          <td  style="color:#FF0000">
                   		  <c:out value="${fundShortage2[status.index]}"></c:out>
                   		  </td> 
                          </c:if>
                          <c:if  test="${MemberReport.shortage.get(2) <=0}">
                          <td  style="color:#008000">
                   		  <c:out value="${fundShortage2[status.index]}"></c:out>
                   		  </td> 
                          </c:if>
						  <td><c:out value="${MemberReport.marketPriceList.get(2) }"></c:out></td>
						  <td><c:out value="${MemberReport.borrowingRateList.get(2) }"></c:out></td>
						  <td><price><c:out value="${fundSettlement2[status.index] }"></c:out></price></td>
                        </tr>
						<tr>
						
                          <td>LinkedIn</td>
                          
                          
                          <c:if  test="${MemberReport.currentBalance.get(3) <0}">
                          <td  style="color:#FF0000">
                   		  <c:out value="${fundBalance3[status.index] *-1 }"></c:out>
                   		  </td> 
                          </c:if>
                          <c:if  test="${MemberReport.currentBalance.get(3) >=0}">
                          <td  style="color:#008000">
                   		  <c:out value="${fundBalance3[status.index] }"></c:out>
                   		  </td> 
                          </c:if>
                          
                          
                          
                          
                          <c:if  test="${MemberReport.obligation.get(3) <0}">
                          <td  style="color:#FF0000">
                   		  <c:out value="${fundObligation3[status.index]*-1}"></c:out>
                   		  </td> 
                          </c:if>
                          <c:if  test="${MemberReport.obligation.get(3) >=0}">
                          <td  style="color:#008000">
                   		  <c:out value="${fundObligation3[status.index]}"></c:out>
                   		  </td> 
                          </c:if>
                         <c:if  test="${MemberReport.shortage.get(3) >0}">
                          <td  style="color:#FF0000">
                   		  <c:out value="${fundShortage3[status.index]}"></c:out>
                   		  </td> 
                          </c:if>
                          <c:if  test="${MemberReport.shortage.get(3) <=0}">
                          <td  style="color:#008000">
                   		  <c:out value="${fundShortage3[status.index]}"></c:out>
                   		  </td> 
                          </c:if>
						  <td><c:out value="${MemberReport.marketPriceList.get(3) }"></c:out></td>
						  <td><c:out value="${MemberReport.borrowingRateList.get(3) }"></c:out></td>
						  <td><c:out value="${fundSettlement3[status.index] }"></c:out></td>
                        </tr>
                        
                        
						<tr>
                          <td>Walmart</td>
                         	<c:if test="${MemberReport.currentBalance.get(4) <0}"> 
                         	<td style="color:#FF0000">
                         		<c:out value="${fundBalance4[status.index] *-1}"></c:out>
                         	</td>
                         	</c:if>
                         	<c:if test="${MemberReport.currentBalance.get(4) >=0}"> 
                         	<td style="color:#008000">
                         		<c:out value="${fundBalance4[status.index] }"></c:out>
                         	</td>
                         	</c:if>
                           <c:if  test="${MemberReport.obligation.get(4) <0}">
                          <td  style="color:#FF0000">
                   		  <c:out value="${fundObligation4[status.index]*-1}"></c:out>
                   		  </td> 
                          </c:if>
                          <c:if  test="${MemberReport.obligation.get(4) >=0}">
                          <td  style="color:#008000">
                   		  <c:out value="${fundObligation4[status.index]}"></c:out>
                   		  </td> 
                          </c:if>
                          <c:if  test="${MemberReport.shortage.get(4) >0}">
                          <td  style="color:#FF0000">
                   		  <c:out value="${fundShortage4[status.index]}"></c:out>
                   		  </td> 
                          </c:if>
                          <c:if  test="${MemberReport.shortage.get(4) <=0}">
                          <td  style="color:#008000">
                   		  <c:out value="${fundShortage4[status.index]}"></c:out>
                   		  </td> 
                          </c:if>
						  <td><c:out value="${MemberReport.marketPriceList.get(4) }"></c:out></td>
						  <td><c:out value="${MemberReport.borrowingRateList.get(4) }"></c:out></td>
						  <td><price><c:out value="${fundSettlement4[status.index] }"></c:out></price></td>
                        </tr> 
						<tr>
                          <td><b>Funds</b></td>
                          <c:if  test="${MemberReport.currentBalance.get(5) <0}">
                          <td  style="color:#FF0000">
                   		  <price><c:out value="${fundBalance5[status.index]*-1}"></c:out></price>
                   		  </td> 
                          </c:if>
                          <c:if  test="${MemberReport.currentBalance.get(5) >=0}">
                          <td  style="color:#008000">
                   		  <price><c:out value="${fundBalance5[status.index]}"></c:out></price>
                   		  </td> 
                          </c:if>
                          
                          
                          
                           <c:if  test="${MemberReport.obligation.get(5) <0}">
                          <td  style="color:#FF0000">
                   		  <price><c:out value="${fundObligation5[status.index]*-1}"></c:out></price>
                   		  </td> 
                          </c:if>
                          <c:if  test="${MemberReport.obligation.get(5) >=0}">
                          <td  style="color:#008000">
                   		  <price><c:out value="${fundObligation5[status.index]}"></c:out></price>
                   		  </td> 
                          </c:if>
                          <c:if  test="${MemberReport.shortage.get(5) >0}">
                          <td  style="color:#FF0000">
                   		  <price><c:out value="${fundShortage5[status.index]}"></c:out></price>
                   		  </td> 
                          </c:if>
                          <c:if  test="${MemberReport.shortage.get(5) <=0}">
                          <td  style="color:#008000">
                   		  <price><c:out value="${fundShortage5[status.index]}"></c:out></price>
                   		  </td> 
                          </c:if>
						  <td> &nbsp;&nbsp;&nbsp;&nbsp;-</td>
						  <td>1.25</td>
						  <td><price><c:out value="${fundSettlement5[status.index] }"></c:out></price></td>
                        </tr>
                      </tbody>
                      
                    </table>
					
					<h4><b>Total Settlement Cost:&nbsp;</b><price> <c:out value="${MemberReport.settlementCost.get(0)+MemberReport.settlementCost.get(1)+MemberReport.settlementCost.get(2)+MemberReport.settlementCost.get(3)+MemberReport.settlementCost.get(4)+MemberReport.settlementCost.get(5) }"></c:out></price></h4>
					

                  </div>
                </div>
                </c:forEach>
              </div>
            

              <div class="clearfix"></div>

                   </div>
          </div>
        </div>
        <!-- /page content -->

       
        <!-- footer content -->
        <footer>
          <div class="pull-right">
            ...
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
    
    <script>
    $('* price').each(function () {
        var item = $(this).text();
        var num = Number(item).toLocaleString('en');    

        if (Number(item) < 0) {
            num = num.replace('-','');
            $(this).addClass('negMoney');
        }else{
            $(this).addClass('enMoney');
        }
        
        $(this).text(num);
    });
    </script>
	
  </body>

</html>