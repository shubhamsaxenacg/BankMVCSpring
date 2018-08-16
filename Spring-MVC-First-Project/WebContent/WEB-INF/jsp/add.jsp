<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
      label {
      color: black;
      }
      #current, #saving, #amount {
      display: none;
      }
   </style>
   <script>
	window.history.forward(1);
</script>
 <script type="text/javascript">
      function show(aval) {
    
      	if (aval == "sav") {
      		saving.style.display = 'inline-block';
      		amount.style.display = 'none';
      		current.style.display = 'none';
      	} else if (aval == "cur") {
      		saving.style.display = 'none';
      		amount.style.display = 'inline-block';
      		current.style.display = 'inline-block';
      	} else {
      		saving.style.display = 'none';
      		amount.style.display = 'none';
      		current.style.display = 'none';
      	}
      }
      function ShowHideDiv() {
          var chkYes = document.getElementById("nosal");
          var dvPassport = document.getElementById("amouunt");
          amount.style.display = chkYes.checked ? "block" : "none";
      }
      
      function check() {
  	    var Bdate = document.getElementById('dob').value;
  	      var amount= document.getElementById('amt').value;
  	      var ODL= document.getElementById('od').value;
  	      var chkYes = document.getElementById("nosal");
  	      var Yes = document.getElementById("sal");
  	      var dd = document.getElementById("type");
  	      var selectedItem = dd.options[dd.selectedIndex].value;
  	      
  	      var theBday = document.getElementById('resultBday');
  	     var ret=true;
  	      
  	     if(Math.floor((Date.now() - new Date(Bdate)) / (31557600000))<18){
  	      		alert("Age Must be 18 or greater");
  	      		ret= false;
  	      	} 
  	     else if(selectedItem=="ch"){
  	    	 alert("Select Account Type");
	      		ret= false;
  	     }else if(selectedItem=="sav"){
  	    	 if(acc_add.c_salary.value == '') {
      	    	 alert("Error: Please select a radio button!");
      	    	 ret=false;
      	    	 }
  	    	 else if(chkYes.checked){
     	    	  if(amount<5000){
     	    		  alert("Amount Must be 5000 or greater");
     	      		ret= false;
     	    	  }
     	      	}  
  	     }
  	      	
  	      	else if(selectedItem=="cur"){
  	      		if(amount<1){
    				  alert("Amount Must be greater then 0");
    				  ret=false;
    			  }
  	      		else if(ODL<10000){
  				  alert("ODLimit Must be 10000 or greater");
  				  ret=false;
  			  }
  	      	}else{
  	      		ret=true;
  	      	}
  	      	
  	  	  return ret;
  		    	
  	      }
   </script>
<body>
	     <jsp:include page="header.jsp"></jsp:include>               
          <header class="card-header"
             style="background-color: rgba(30, 144, 255, 0.1);">
             <h3 class="card-title mt-2"
                style="text-align: center; color: black;">Open New Account</h3>
          </header>
          <div align="center">
                     <form onsubmit="return check()" id="add" action="addAccount" name="acc_add" method="post">
                        
                              <label>Name</label> <input type="text" class="form-control"
                                 placeholder="Enter Your Full Name"required name="c_Name"><br>
                           
                              <label>Nationality</label> <input type="text" class="form-control"
                                 placeholder="Enter Your Nationality" required name="nationality"><br>
                           
                           		<label>Email</label> <input type="email" class="form-control"
                                 placeholder="Enter Your Email" required name="c_Email"><br>
                           
                           		
                              <label>Contact Number</label> <input type="tel"
                                 pattern="[2-9]{1}[0-9]{9}" class="form-control"
                                 placeholder="Enter Contact Number" required name="c_contact"><br>
                           
                              <label>Date of Birth</label> <input type="date"
                                 class="form-control" required name="c_dob" id="dob"><br>
                           
                             <label>Gender</label>
                                 <label class="form-check form-check-inline"> <input
                                    class="form-check-input" type="radio" required="required"
                                    value="male" name="gender"> <span class="form-check-label">
                                 Male </span>
                                 </label> <label class="form-check form-check-inline"> <input
                                    class="form-check-input" type="radio" required="required"
                                    value="Female" name="gender"> <span class="form-check-label">
                                 Female</span>
                                 </label><br>
                           <label>Address</label>
                              <textarea placeholder="Enter Your Adress" class="form-control" name="c_Address"></textarea><br>
                        
                              <label>Account Type</label> 
                              <select id="type" required="required"
                                 class="form-control" 
                                 onchange="java_script_:show(this.options[this.selectedIndex].value)" name="c_AccType">
                                 <option value="ch">Choose...</option>
                                 <option value="sav">Savings</option>
                                 <option value="cur">Current</option>
                              </select><br>
                           
                           <div class="col form-group" id="amount" style="display: none;">
                              <label>Amount</label> <input type="number" id="amt"
                                 class="form-control" placeholder="Enter Amount"required" name="c_amount">
                           </div><br>
                        <div class=" col form-row">
                           <div class="col form-group col-md-8" id="saving"
                              style="display: none;">
                              <label class="form-check form-check-inline"> <input
                                 class="form-check-input" type="radio" 
                                 value="salary" onclick="ShowHideDiv()" name="c_salary" id="sal" > <span class="form-check-label">
                              Salary </span>
                              </label> <label class="form-check form-check-inline"> <input
                                 class="form-check-input" type="radio" 
                                 value="notSalary" onclick="ShowHideDiv()" name="c_salary"  id="nosal"> <span class="form-check-label">
                              Not Salary</span>
                              </label>
                           </div>
                           <div class="col form-group col-md-5" id="current"
                              style="display: none;">
                              <label>ODLimit</label> <input type="number" id="od"
                                 class="form-control" placeholder="Enter ODLimit" name="c_ODLimit" >
                           </div>
                        </div>
                        
							<input type="submit"  value="Create" class="btn btn-primary">
                            <input type="reset" value="clear" class="btn btn-light">
                         

                     </form>
                     </div>
</body>
</html>