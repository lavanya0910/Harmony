<!-- SITE TITTLE -->
<%@page import="model.Registration"%>
<%@page import="service.RegistrationDaoImpl"%>
<%@page import="service.RegistrationDao"%>
<%@page import="java.io.PrintWriter"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
  <style>
  @import url("//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css");
.login-block{
    background: #DE6262;  /* fallback for old browsers */
background: -webkit-linear-gradient(to bottom, #FFB88C, #DE6262);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to bottom, #FFB88C, #DE6262); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
float:left;
width:100%;
padding : 50px 0;
}
.banner-sec{background:url(https://static.pexels.com/photos/33972/pexels-photo.jpg)  no-repeat left bottom; background-size:cover; min-height:500px; border-radius: 0 10px 10px 0; padding:0;}
.container{background:#fff; border-radius: 10px; box-shadow:15px 20px 0px rgba(0,0,0,0.1);}
.carousel-inner{border-radius:0 10px 10px 0;}
.carousel-caption{text-align:left; left:5%;}
.login-sec{padding: 50px 30px; position:relative;}
.login-sec .copy-text{position:absolute; width:80%; bottom:20px; font-size:13px; text-align:center;}
.login-sec .copy-text i{color:#FEB58A;}
.login-sec .copy-text a{color:#E36262;}
.login-sec h2{margin-bottom:30px; font-weight:800; font-size:30px; color: #DE6262;}
.login-sec h2:after{content:" "; width:100px; height:5px; background:#FEB58A; display:block; margin-top:20px; border-radius:3px; margin-left:auto;margin-right:auto}
.btn-login{background: #DE6262; color:#fff; font-weight:600;}
.banner-text{width:70%; position:absolute; bottom:40px; padding-left:20px;}
.banner-text h2{color:#fff; font-weight:600;}
.banner-text h2:after{content:" "; width:100px; height:5px; background:#FFF; display:block; margin-top:20px; border-radius:3px;}
.banner-text p{color:#fff;}
  </style>
</head>
<body id="index" class="body-wrapper">

<!--========================================
=            Navigation Section            =
=========================================-->
<nav class="navbar main-nav border-less fixed-top navbar-expand-lg p-0">
  <div class="container-fluid p-0">
      <a class="navbar-brand" href="index.html">
        <a href="http://christuniversity.in/" target="_blank"><img src="images/culogo.jpg" alt="logo"></a>
      </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="fa fa-bars"></span>
      </button>
 

<div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav mx-auto">
        <li class="nav-item">
          <a class="nav-link" href="#index" >Home
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#concept">Concept</a>
        </li>
       
      <li class="nav-item">
          <a class="nav-link" href="#callforpapers">Call for Papers</a>
        </li>
      <li class="nav-item">
          <a class="nav-link" href="#registration">Register</a>
        </li>

        <li class="nav-item">
          <a class="nav-link" href="#eventpartners">Partners</a>
        </li>
<!--
       <li class="nav-item">
          <a class="nav-link" href="#keynotespeakers">Speakers</a>
        </li>
-->

<li class="nav-item">
          <a class="nav-link" href="#committee">Committee</a>
        </li>
<li class="nav-item active">
          <a class="nav-link" href="login.jsp">Login</a>
        </li>
<li class="nav-item">
          <a class="nav-link" href="#contact">Contact</a>
        </li>
      </ul>
      <a href="#" class="navbar-brandr">
      <a href="http://dvk.in/" target="_blank"><img src="images/dvklogo.jpg" alt="ticket"></a>
      
      </a>
      </div>
  </div>
</nav>

<br><br><br>
<br>

<!--====  End of Navigation Section  ====-->
<!-- login section -->
<section class="login-block">
    <div class="container">
    
<c:if test="${sessionScope.mess!= null}">
              <div id="error" class="alert alert-success">
 <center><strong>${mess}</strong></center>
</div>

</c:if>
 
<% session.removeAttribute("mess"); %>
 <div class="row">
 
  <div class="col-md-4 login-sec">
      <h2 class="text-center">Accommodation</h2>
      <form class="login-form" action="Accummodate" method="post" >
  <div class="form-group">
    <label for="exampleInputEmail1" class="text-uppercase">Email ID</label>
    <input type="text" name="email" id="email" onchange="fuc()"   class="form-control" placeholder="" required>
  </div>
   <div id="error" class="alert alert-danger" Style="display:none">
</div>
   <script>
     function fuc()
     {
    	 
    	 
    	 
    	 
         var email=document.getElementById("email").value;
         
    	 var xhttp;
    	 if (window.XMLHttpRequest) {
    		    // code for modern browsers
    		    xhttp = new XMLHttpRequest();
    		 } else {
    		    // code for old IE browsers
    		    xhttp = new ActiveXObject("Microsoft.XMLHTTP");
    		} 
    	    xhttp.onreadystatechange = function() {
    	        if (this.readyState == 4 && this.status == 200) {
    	            document.getElementById("regnum").value=this.responseText;
    	            document.getElementById("bankname").disabled = false;
    	        	document.getElementById("currency").disabled = false;
    	        	document.getElementById("amount").disabled = false;
    	        	document.getElementById("transsactionalrefno").disabled = false;
    	        	document.getElementById("dateof").disabled = false;
    	        	document.getElementById("sub").disabled = false;
    	        	var x = document.getElementById("error");
    	        	x.style.display = "none";
    	        	
    	            
    	       }
    	        if (this.readyState != 4 && this.status != 200) {
    	        	document.getElementById("bankname").disabled = true;
    	        	document.getElementById("regnum").value=0;
    	        	document.getElementById("currency").disabled = true;
    	        	document.getElementById("amount").disabled = true;
    	        	document.getElementById("transsactionalrefno").disabled = true;
    	        	document.getElementById("dateof").disabled = true;
    	        	document.getElementById("sub").disabled = true;
    	        	document.getElementById("error").innerHTML = "This EmailID is not registered with us. Use the same Email ID used during conference registartion <a href='register.jsp'>click here to register</a>";
    	        	var x = document.getElementById("error");
    	        	x.style.display = "block";
    	       }
    	        
    	    };
    	    
    	    xhttp.open("POST", "/Harmony/Getnumber?"+email, true);
    	    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    	    xhttp.send("email="+email);

     }
   </script>
  <div class="form-group">
    <label for="exampleInputEmail1" class="text-uppercase">Registration Number</label><br>
    <input type="text" name="regnum" id="regnum" class="form-control" placeholder="" value=0 readonly="readonly" required>
  </div>
  <center><lable><h1> Bank Information</h1> </lable></center>
  <div class="form-group">
    <label  class="text-uppercase">Bank Name</label>
    <input type="text" class="form-control" id="bankname" name="bankname" disabled="disabled" required>
  </div>
 
  <div class="form-group">
   <label for="sel1">Select Currency</label>
  <select class="form-control" id="currency" name="currency" disabled="disabled">
    <option value="rupee">Rupee</option>
    <option value="Euro">Euro</option>
    <option value="Dollar">Dollar</option>
   
  </select>
  </div>
 
  <div class="form-group">
    <label for="exampleInputPassword1" class="text-uppercase" >Amount</label>
    <input type="text" class="form-control"  id="amount" name="amount" placeholder="" disabled="disabled" required>
  </div> 
 
  <div class="form-group">
    <label for="exampleInputPassword1" class="text-uppercase"><b>Cheque/DD/Transaction Ref: Number</b></label>
    <input type="text" class="form-control"  id="transsactionalrefno" name="transsactionalrefno" placeholder="" disabled="disabled" required>
  </div>
 
   <div class="form-group">
    <label for="exampleInputPassword1" class="text-uppercase">Date of  Transaction</label>
    <input type="date" class="form-control"  id="dateof" name="dateof" placeholder="" disabled="disabled" required>
  </div>
 
   
    <button type="submit" id="sub" class="btn btn-login float-right">Submit</button>
  </div>
 
</form>
  </div>
  <div class="col-md-8 banner-sec">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                 <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                  </ol>
            <div class="carousel-inner" role="listbox">
    <div class="carousel-item active">
      <img class="d-block img-fluid" src="https://static.pexels.com/photos/33972/pexels-photo.jpg" alt="First slide">
      <div class="carousel-caption d-none d-md-block">
  </div>
    </div>
  </div>
            </div>   
     
  </div>
 </div>
</div>
</section>