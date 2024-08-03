<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.sql.*" %> 
     <%@page import = "com.Swaraj.data.*" %>
<!DOCTYPE html>
<head>
<title>Vehicle CNG Booking Application (Web Application)</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="css/bootstrap.min.css" >
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/style-responsive.css" rel="stylesheet"/>
<!-- font CSS -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
<script src="js/jquery2.0.3.min.js"></script>
</head>
<body>
<section id="container">
<!--header start-->
<header class="header fixed-top clearfix">
<!--logo start-->
<div class="brand">

    <a href="index.html" class="logo">
       CNG Admin
    </a>
    <div class="sidebar-toggle-box">
        <div class="fa fa-bars"></div>
    </div>
</div>
<!--logo end-->
 
<div class="top-nav clearfix">
    <!--search & user info start-->
    <ul class="nav pull-right top-menu">
        <li>
            <input type="text" class="form-control search" placeholder=" Search">
        </li>
        <!-- user login dropdown start-->
        <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                <img alt="" src="images/2.png">
                <span class="username">Vijay Mali</span>
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu extended logout">
                <li><a href="#"><i class=" fa fa-suitcase"></i>Profile</a></li>
                <li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
                <li><a href="login.html"><i class="fa fa-key"></i> Log Out</a></li>
            </ul>
        </li>
        <!-- user login dropdown end -->
       
    </ul>
    <!--search & user info end-->
</div>
</header>
<!--header end-->
<!--sidebar start-->
<aside>
    <div id="sidebar" class="nav-collapse">
        <!-- sidebar menu start-->
        <div class="leftside-navigation">
            <ul class="sidebar-menu" id="nav-accordion">
                <li>
                    <a href="menu.html">
                        <i class="fa fa-dashboard"></i>
                        <span>Dashboard</span>
                    </a>
                </li>
                
                <li class="sub-menu">
                    <a href="VApprove.jsp">
                        <i class="fa fa-book"></i>
                        <span>Approve CNG Pumps</span>
                    </a>
                   
                </li>
                <li>
                    <a href="ViewCNG.jsp">
                        <i class="fa fa-bullhorn"></i>
                        <span>View CNG Pumps </span>
                    </a>
                </li>
                <li class="sub-menu">
                    <a class="active" href="delete.jsp">
                        <i class="fa fa-th"></i>
                        <span>Delete CNG Pump</span>
                    </a>
                   
                </li>
            
           
                         </div>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->
<!--main content start-->
<form action="pumpdelete.jsp">
<section id="main-content">
	<section class="wrapper">
		<div class="table-agile-info">
 <div class="panel panel-default">
    <div class="panel-heading">
     CNG Pump Table
    </div>
    <div>
      <table class="table" ui-jq="footable" ui-options='{
        "paging": {
          "enabled": true
        },
        "filtering": {
          "enabled": true
        },
        "sorting": {
          "enabled": true
        }}'>
        <thead>
          <tr>
            <th>ID</th>
            <th>Pump_Name</th>
            <th>Address</th>
            <th>City</th>
            <th>Taluka</th>
            <th>District</th>
            <th>Open_Time</th>
            <th>Close_Time</th>
            <th>MObile</th>
            <th>Password</th>
            <th>Lattitude</th>
            <th>Longitude</th>
            <th>Action</th>
            
            <%
			    Connection con = ConnectJDBC.connect();

 				try
				{
					PreparedStatement ps1 = con.prepareStatement("select * from cngpumps");
					ResultSet rs = ps1.executeQuery();
					
					
 					while (rs.next())
					{
			%>
															    	
															    		 
															    		 
															    	
		<tr>
															    	    
															    		  
					<td><%=rs.getInt("id") %></td>
					<td><%=rs.getString("pump_name") %></td>
					<td><%=rs.getString("address") %></td>
					<td><%=rs.getString("city") %></td>
					<td><%=rs.getString("taluka") %></td>
					<td><%=rs.getString("district") %></td>
					<td><%=rs.getString("open_time") %></td>
					<td><%=rs.getString("close_time") %></td>
					<td><%=rs.getString("mobile") %></td>
					<td><%=rs.getString("password") %></td>
					<td><%=rs.getString("lattitude") %></td>
					<td><%=rs.getString("longitude") %></td>
					<td><a href ="pumpdelete.jsp?id=<%=rs.getString("mobile")%>">Delete</a></td>
															    		
															    		
															    		
		</tr>
															    	
			 <% 
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			%>
           
            
          </tr>
        </thead>
 
      </table>
    </div>
  </div>
</div>
</section>
</form>
 <!-- footer -->
		  <div class="footer">
			<div class="wthree-copyright">
			  <p>© 2022 RCPIT. All rights reserved | Design by Vijay Mali</a></p>
			</div>
		  </div>
  <!-- / footer -->
</section>

<!--main content end-->
</section>
<script src="js/bootstrap.js"></script>
<script src="js/jquery.dcjqaccordion.2.7.js"></script>
<script src="js/scripts.js"></script>
<script src="js/jquery.slimscroll.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="js/jquery.scrollTo.js"></script>
</body>
</html>
