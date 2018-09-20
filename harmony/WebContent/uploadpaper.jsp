<!DOCTYPE html>
<%@page import="service.PaperUplodeDaoImpl"%>
<%@page import="service.PaperUplodeDao"%>
<%@page import="model.PaperUplode"%>
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
  <link href="${css}/bootstrap.min.css" rel="stylesheet">
  <link href="${css}/fa.css" rel="stylesheet">
  <!-- bootstrap theme -->

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
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
RegistrationDao registrationDao = new RegistrationDaoImpl();
Registration res = new Registration();
List<Registration> rea=registrationDao.Li();
%>
<body>
<c:if test="${sessionScope.messs!= null}">
              <div class="alert alert-danger">
<center>  <strong>${messs}</strong></center> 
</div>
</c:if>
<%  session.removeAttribute("messs"); %>

  <!-- container section start -->
  <section id="container" class="">

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

<!-- sidebar menu end-->
 <%@include file="sidnav.jsp" %>
    <!--sidebar end-->

    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <!--overview start-->
        
        <div class="row">
          <div class="col-lg-12">
            <h3 class="page-header"><i class="fa fa-laptop"></i>Registration</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="dashboard.jsp">Home</a></li>
              <li><i class="fa fa-laptop"></i>Upload Papers</li>
              
            </ol>
          </div>
        </div>
     <div class="container">
  <h2>Upload Paper</h2>
 
  <% 
  PaperUplode p;
  PaperUplodeDao pd=new PaperUplodeDaoImpl();
  Registration r=(Registration)session.getAttribute("p");
  p=pd.get(r.getRegister_id());
  if(p==null)
  {
  %>
  
  <form action="PaperUplodes" method="post">
    <div class="form-group">
      <label for="usr">Title</label>
      <input type="text" class="form-control" id="tit" name="tit" required>
    </div>
    <div class="form-group">
      <label for="pwd">Descripton</label>
      <input type="text" class="form-control" id="des" name="des" required>
    </div>
    
    <center><div class="container">
    <button type="submin" class="btn btn-primary">Submit</button></center>
   </form>
    <% }else{ %>
     <p><h3><u>The Paper Should Be in Word Format</u></h3> </p>
    <form action="Uplodeddata" method="post"  enctype = "multipart/form-data">
    <div class="form-group">
      <label for="usr">Upload</label>
      <input type="file" class="form-control" id="pap" name="pap" required>
      
    </div>
    <button type="submin" class="btn btn-primary">Submit</button></center>
    </form>
    <% }%>
    
    
    
     
</div>
     
        <!-- project team & activity end -->
	
</html>
