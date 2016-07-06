<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Materializer</title>

    <!-- Stylesheets -->
  	<link rel="stylesheet" href="bootstrap-3.3.6/css/bootstrap.css">
    <link rel="stylesheet" href="stylesheets/main.css" media="screen" title="no title" charset="utf-8">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300' rel='stylesheet' type='text/css'>

    <!-- Scripts -->
    <script src="js/jquery-2.1.4.min.js"></script>
    <script src="bootstrap-3.3.6/js/bootstrap.min.js"></script>
  </head>
  <body>

    <nav class="navbar navbar-default">
      <div class="container-fluid">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a href="#" class=""><img src="img/logo2.png" alt="" class="brand navbar-brand" id="head-logo"></a>
        <a class="navbar-brand" href="#">Materializer</a>
      </div>

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav navbar-right">
          <li class="active"><a href="#intro">Intro <span class="sr-only">(current)</span></a></li>
          <li class="dropdown">
            <a href="#visualization" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Visualization <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="#">Action</a></li>
              <li><a href="#">Another action</a></li>
              <li><a href="#">Something else here</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="#">Separated link</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="#">One more separated link</a></li>
            </ul>
          </li>
          <li><a href="#about">About</a></li>
        </ul>
      </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
    </nav>

    <header>
      <div class="container">
        <div class="row">
          <div class="col-10">
            <img src="img/logo2.png" alt="" />
            <h1> | Materializer</h1>
            
          </div>
        </div>
      </div>
    </header>

    <section id="intro">
      <div class="container">
        <h2>Intro</h2>
        <p>Dockership ist ein Projekt von drei Studenten des Fachbereichs Informatik der Universität Hamburg. Das Projekt beschäftigt sich mit der Entwicklung kontextbasierter verteilter Anwendungen. Ziel des DockerShip-Projektes ist die Visualisierung von Docker-Ressourcen. Dabei sollen die Ressourcen, welche über einen zentralen Server geleitet werden, auf verschiede Arten visuell dargestellt werden. Langfristig ist das Ziel von DockerShip eine generische API für verschiedene Ressourcen (nicht nur Docker) anzubieten und diese auf verschiedene Arten zu visualiesieren.</p>
      </div>
    </section>

    <section id="visualization">
      <div class="container">
        <h2>Visualization</h2>
        
		<?php include 'visualization.php'; ?>
      </div>
    </section>

    <footer>
		<div class="container">
			<!-- <div class="row">
	        	<div class=".col-md-6">  -->
	        	<h2>Links</h2>
	        		<ul>
	        			<li><a href="https://github.com/SKacmaz/DockerShip-Project">Haven</a></li>
	        			<li><a href="https://github.com/SKacmaz/DocBot-Materializer">Materializer</a></li>
	        			<li><a href="https://github.com/SKacmaz/IVC">EV3-Controller</a></li>
	        		</ul>
	        	<!-- </div>
	        	<div class=".col-md-6"></div>
	        </div> -->
      	</div>
    </footer>
  </body>
</html>
