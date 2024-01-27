<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login Page</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="styles.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@600&family=Tangerine:wght@700&family=Yeseva+One&display=swap" rel="stylesheet">
  <script src="script.js"></script>
</head>
<body>
<input type="hidden" id="status" values ="<%= request.getAttribute("status")%>">
<section class="vh-100" style="background-color: #DFD7BF;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col col-xl-10">
        <div class="card" style="border-radius: 1rem;">
          <div class="row g-0">
            <div class="col-md-6 col-lg-5 d-none d-md-block">
              <img src="imgs/lo.jpeg"
                   alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem;" />
            </div>
            <div class="col-md-6 col-lg-7 d-flex align-items-center">
              <div class="card-body p-4 p-lg-5 text-black">

                <form name="fname" action="loginServlet" method="post">

                  <div class="d-flex align-items-center mb-3 pb-1">
                    <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                    <div class="h12"><svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-snow2" viewBox="0 0 16 16">

                    </svg>EnchantedJewels</div>
                  </div>

                  <h5 class="sepl" style="font-size: 25px;">Sign into your account</h5>
                  <br>

                  <div class="sepl">
                    <label class="form-label" for="form2Example17">Email address</label>
                    <input type="email" id="form2Example17" class="form-control form-control-lg" name="email" />
                  </div>

                  <div class="sepl">
                    <label class="form-label" for="form2Example27">Password</label>
                    <input type="password" id="form2Example27" class="form-control form-control-lg" name="pwd" />
                  </div>
                  <br>

                  <div class="sepl">
                    <button type="submit" class="btn btn-dark btn-lg btn-block" onclick="location.href='index.jsp'">Login</button>
                  </div>

                  <br>

                  <p class="sepl" style="color: #393f81;">Don't have an account? <a href="sign.jsp"
                                                                                    style="color:#393f81;">Register here</a></p>
                </form>

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>

