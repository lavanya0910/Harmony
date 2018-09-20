<aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu">
           <% String rol=(String)session.getAttribute("uname"); %>
          <% if(rol.equals("Addmin")) {%>
          <li class="active">
            <a class="" href="dashboard.jsp">
                          <i class="icon_house_alt"></i>
                          <span>Registration</span>
                      </a>
          </li>
          <% } %>
          
          <% if(rol.equals("user")) {%>
          <li class="active">
            <a class="" href="dashboard2.jsp">
                          <i class="icon_house_alt"></i>
                          <span>Profile</span>
                      </a>
          </li>
          <% } %>
          
          <% if(rol.equals("Addmin")) {%>
          <li>
            <a class="" href="accomodation.jsp">
                          <i class="icon_genius"></i>
                          <span>Accommodation</span>
                      </a>
          </li>
          <%} %>
          <% if(rol.equals("Addmin")) {%>
          <li>
            <a class="" href="uploadApproval.jsp">
                          <i class="icon_documents_alt"></i>
                          <span>Submit Approved Paper</span>

                      </a>

          </li>
        <%} %>
          <% if(rol.equals("Addmin")) {%>
          <li>
            <a class="" href="viewApproval.jsp">
                          <i class="icon_documents_alt"></i>
                          <span>View Approval</span>

                      </a>

          </li>
          <%} %>
          <% if(rol.equals("user")) {%>
          <li>
            <a class="" href="viewStatus.jsp">
                          <i class="icon_documents_alt"></i>
                          <span>View Status</span>

                      </a>

          </li>
          <% } %>
          <% if(rol.equals("user")) {%>
          <li>
            <a class="" href="uploadpaper.jsp">
                          <i class="icon_documents_alt"></i>
                          <span> Upload Paper</span>

                      </a>

          </li>
          <% } %>
          <% if(rol.equals("Addmin")) {%>
           <li>
            <a class="" href="approval.jsp">
                          <i class="icon_documents_alt"></i>
                          <span>Approve Papers</span>

                      </a>

          </li>
          <%} %>

  <li>
            <a class="" href="logout">
                          <i class="icon_documents_alt"></i>
                          <span>Log Out</span>

                      </a>

          </li>



        </ul>
        
                    
        <!-- sidebar menu end-->
      </div>
    </aside>