<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
  <meta name="author" content="GeeksLabs">
  <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
  <link rel="shortcut icon" href="img/favicon.png">

  <title>Creative - Bootstrap Admin Template</title>

  <!-- Bootstrap CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- bootstrap theme -->

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
 <%@ page import="service.accummodateDaoImpl" %>
  <%@ page import="model.accummodate" %>
  <%@ page import="service.accummodateDao" %>
 
   <%@ page import="service.RegistrationDaoImpl" %>
  <%@ page import="model.Registration" %>
  <%@ page import="service.RegistrationDao" %>
  
  <%@ page import="java.util.*" %>
  <!--external css-->
  <!-- font icon -->
  <link href="css/elegant-icons-style.css" rel="stylesheet" />
  <link href="css/font-awesome.min.css" rel="stylesheet" />
  <!-- full calendar css-->
  <link href="assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
  <link href="assets/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" />
  <!-- easy pie chart-->
  <link href="assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen" />
  <!-- owl carousel -->
  <link rel="stylesheet" href="css/owl.carousel.css" type="text/css">
  <link href="css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
  <!-- Custom styles -->
  <link rel="stylesheet" href="css/fullcalendar.css">
  <link href="css/widgets.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet" />
  <link href="css/xcharts.min.css" rel=" stylesheet">
  <link href="css/jquery-ui-1.10.4.min.css" rel="stylesheet">
  <!-- =======================================================
    Theme Name: NiceAdmin
    Theme URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
    Author: BootstrapMade
    Author URL: https://bootstrapmade.com
  ======================================================= -->
</head>
<%
accummodateDao accommodateDao = new accummodateDaoImpl();
accummodate res = new accummodate();
List<accummodate> ares=accommodateDao.Li();
RegistrationDao registrationDao = new RegistrationDaoImpl();
Registration res2 = new Registration();
%>
<body>
  <!-- container section start -->
  <section id="container" class="">

<c:if test="${sessionScope.messs!= null}">
  <div class="alert alert-danger">
  <center>  <strong>${messs}</strong></center> 
</div>
</c:if>

    <header class="header dark-bg">
      <div class="toggle-nav">
        <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"><i class="icon_menu"></i></div>
      </div>

      <!--logo start-->
      <a href="dashboard.jsp" class="logo">Har <span class="lite">mony</span></a>
      <!--logo end-->

      <div class="nav search-row" id="top_menu">
        <!--  search form start -->
        <ul class="nav top-menu">
          <li>
            <form class="navbar-form">
              <input class="form-control" placeholder="Search" type="text" required>
            </form>
          </li>
        </ul>
        <!--  search form end -->
      </div>

      <div class="top-nav notification-row">
        <!-- notificatoin dropdown start-->
        <ul class="nav pull-right top-menu">

          


          <!-- alert notification end-->
          <!-- user login dropdown start-->
          <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="profile-ava">
<!--                                 <img alt="" src="img/avatar1_small.jpg"> -->
                            </span>
                            <span class="username">Jenifer Smith</span>
                            <b class="caret"></b>
                        </a>
            <ul class="dropdown-menu extended logout">
              <div class="log-arrow-up"></div>
              
              <li>
                <a href="#"><i class="icon_key_alt"></i> Log Out</a>
              </li>
            </ul>
          </li>
          <!-- user login dropdown end -->
        </ul>
        <!-- notificatoin dropdown end-->
      </div>
    </header>
    <!--header end-->

    <!--sidebar start-->
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu">
          <li class="active">
            <a class="" href="dashboard.jsp">
                          <i class="icon_house_alt"></i>
                          <span>Registration</span>
                      </a>
          </li>
          <li class="sub-menu">
            <a href="javascript:;" class="">
                          <i class="icon_document_alt"></i>
                          <span>Pay Now</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
            <ul class="sub">
              <li><a class="" href="#">Bank Transaction</a></li>
              <li><a class="" href="#">Collaboration Transaction</a></li>
            </ul>
          </li>
          <li>
            <a class="" href="accomodation.jsp">
                          <i class="icon_genius"></i>
                          <span>Accommodation</span>
                      </a>
          </li>
          <li>
            <a class="" href="#">
                          <i class="icon_documents_alt"></i>
                          <span>Submit Paper</span>

                      </a>

          </li>

          <li>
            <a class="" href="#">
                          <i class="icon_documents_alt"></i>
                          <span>View Approval</span>

                      </a>

          </li>

          

        </ul>
        
        <!-- sidebar menu end-->
      </div>
    </aside>
    <!--sidebar end-->

    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <!--overview start-->
        <div class="row">
          <div class="col-lg-12">
            <h3 class="page-header"><i class="fa fa-laptop"></i>Accomodation</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="dashboard.jsp">Home</a></li>
              <li><i class="fa fa-laptop"></i>Accomodation</li>
            </ol>
          </div>
        </div>

               <style>
         .topnav .search-container button {
  float: right;
  padding: 6px 10px;
  margin-top: 8px;
  margin-right: 16px;
  background: #ddd;
  font-size: 20px;
  border: none;
  cursor: pointer;
} 
         .topnav input[type=text] {
    float: right;
    padding: 6px;
    border: none;
    margin-top: 8px;
    font-size: 20px;
}
        
         </style>
        <div class="col-lg-12">
         <div class="topnav">
  		<div class="search-container pull-right">
    	<form action="Asearch" method="post">
      	<button type="submit"><i class="fa fa-search"></i></button>
    <input type="text" placeholder="Search.." name="search" id="search" required>
    </form>
  </div>
</div>    			
    	</div>

        <!-- project team & activity end -->
<div class="tablediv">

<table class="table  table-light table-hover table-bordered text-justify">
  <thead>
    <tr>
      <th scope="col" colspan="4"><center>Personal</center></th>
      <th scope="col" colspan="5"><center>Bank</center></th>
	</tr>
	  <tr class="text-center">
		<th scope="col">Register Number</th>
		<th scope="col">Name</th>
		<th scope="col">Email</th>
		<th scope="col">Accomodation id</th>


		<th scope="col">Amount</th>
		<th scope="col">Currency</th>
		<th scope="col">Bank Name</th>
		<th scope="col">Reference No.</th>
		<th scope="col">Date(transaction)</th>
	</tr>
	</thead>
	

	 <tr>
	 <td>${message2.getRegister_id()}</td>
	 <% 
	 HttpSession session1 = request.getSession();
	 accummodate a1=(accummodate)session1.getAttribute("message2");
	 res2= registrationDao.getemail(a1.getEmail()); %>
	 <td><%=res2.getName() %></td>
	 <td>${message2.getEmail()}</td>
	 <td>${message2.getAccum_id()}</td>
	 <td class="bg-primary text-white">${message2.getAmount()}</td>
	 <td class="bg-primary text-white">${message2.getCurren()}</td>
	 <td class="bg-primary text-white">${message2.getBankName()}</td>
	 <td class="bg-primary text-white">${message2.getTranssactionalrefno()}</td>
	 <td class="bg-primary text-white">${message2.getDateoftrans()}</td>

	 </tr>
 
  <tbody>

	
    </tbody>
    </table>
</div>
    <!--main content end-->
  </section>
  <!-- container section start -->

  <!-- javascripts -->
  <script src="js/jquery.js"></script>
  <script src="js/jquery-ui-1.10.4.min.js"></script>
  <script src="js/jquery-1.8.3.min.js"></script>
  <script type="text/javascript" src="js/jquery-ui-1.9.2.custom.min.js"></script>
  <!-- bootstrap -->
  <script src="js/bootstrap.min.js"></script>
  <!-- nice scroll -->
  <script src="js/jquery.scrollTo.min.js"></script>
  <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
  <!-- charts scripts -->
  <script src="assets/jquery-knob/js/jquery.knob.js"></script>
  <script src="js/jquery.sparkline.js" type="text/javascript"></script>
  <script src="assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
  <script src="js/owl.carousel.js"></script>
  <!-- jQuery full calendar -->
  <script src="js/fullcalendar.min.js"></script>
    <!-- Full Google Calendar - Calendar -->
    <script src="assets/fullcalendar/fullcalendar/fullcalendar.js"></script>
    <!--script for this page only-->
    <script src="js/calendar-custom.js"></script>
    <script src="js/jquery.rateit.min.js"></script>
    <!-- custom select -->
    <script src="js/jquery.customSelect.min.js"></script>
    <script src="assets/chart-master/Chart.js"></script>

    <!--custome script for all page-->
    <script src="js/scripts.js"></script>
    <!-- custom script for this page-->
    <script src="js/sparkline-chart.js"></script>
    <script src="js/easy-pie-chart.js"></script>
    <script src="js/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="js/jquery-jvectormap-world-mill-en.js"></script>
    <script src="js/xcharts.min.js"></script>
    <script src="js/jquery.autosize.min.js"></script>
    <script src="js/jquery.placeholder.min.js"></script>
    <script src="js/gdp-data.js"></script>
    <script src="js/morris.min.js"></script>
    <script src="js/sparklines.js"></script>
    <script src="js/charts.js"></script>
    <script src="js/jquery.slimscroll.min.js"></script>
    <script>
      //knob
      $(function() {
        $(".knob").knob({
          'draw': function() {
            $(this.i).val(this.cv + '%')
          }
        })
      });

      //carousel
      $(document).ready(function() {
        $("#owl-slider").owlCarousel({
          navigation: true,
          slideSpeed: 300,
          paginationSpeed: 400,
          singleItem: true

        });
      });

      //custom select box

      $(function() {
        $('select.styled').customSelect();
      });

      /* ---------- Map ---------- */
      $(function() {
        $('#map').vectorMap({
          map: 'world_mill_en',
          series: {
            regions: [{
              values: gdpData,
              scale: ['#000', '#000'],
              normalizeFunction: 'polynomial'
            }]
          },
          backgroundColor: '#eef3f7',
          onLabelShow: function(e, el, code) {
            el.html(el.html() + ' (GDP - ' + gdpData[code] + ')');
          }
        });
      });
    </script>

</body>

</html>
