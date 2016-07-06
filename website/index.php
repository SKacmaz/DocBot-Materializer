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
            <a href="#visualization">Visualization</a>
          </li>
          <li><a href="#console">Ev3 Console</a></li>
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
        <div class="col-lg-12">
          <h2>Intro</h2>

        </div>
        <div class="col-lg-8">
          <p>Dockership ist ein Projekt von drei Studenten des Fachbereichs Informatik der Universität Hamburg.
          </p>
          <p>
            Das Projekt beschäftigt sich mit der Entwicklung kontextbasierter verteilter Anwendungen.
            Ziel des DockerShip-Projektes ist kurzfristig die Visualisierung von Docker-Ressourcen.
            Dabei sollen die Ressourcen, welche über einen zentralen Server geleitet werden, auf verschiede Arten visuell dargestellt werden.
          </p>
            <p>
              Langfristig ist das Ziel von DockerShip eine generische API für verschiedene Ressourcen (nicht nur Docker) anzubieten und
              diese auf verschiedene Arten zu visualiesieren.
            </p>
        </div>
        <div class="col-lg-4">
            <img src="img/red.jpg" alt="" />
        </div>
      </div>
    </section>

    <div class="panorama2 panoramaImage1"></div>

    <section id="visualization">
      <div class="container">
        <div class="col-lg-12">
          <h2>Visualization</h2>
        </div>

		<?php include 'visualization.php'; ?>
      </div>
    </section>

    <div class="panorama2 panoramaImage2"></div>

    <section id="#console">
      <div class="container">
        <div class="col-lg-12">
          <h2>Ev3 Console</h2>

        <div class="col-lg-12">
          <button type="button" class="btn btn-default" onclick="driveForward();">Forward</button>
          <button type="button" class="btn btn-default" onclick="driveBackward();">Backward</button>
          <button type="button" class="btn btn-default" onclick="turnRight();">turnRight</button>
          <button type="button" class="btn btn-default" onclick="turnLeft();">turnLeft</button>
          <button type="button" class="btn btn-default" onclick="grab();">grab</button>
          <button type="button" class="btn btn-default" onclick="drop();">drop</button>
          <button type="button" class="btn btn-default" onclick="exit();">exit</button>
        </div>


      </div>

    </section>

    <div class="panorama2 panoramaImage3"></div>


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

<script type="text/javascript">

var eveUrl = "http://192.168.104.74/";
// var eveUrl = "http://192.168.178.55/";

function driveForward()
{
  var command = "forward-20";
  httpGet(eveUrl + command);
  console.log("drive forward command send");

}

function driveBackward()
{
  var command = "backward-20";
  httpGet(eveUrl + command);
  console.log("driveBackward command send");
}

function turnRight()
{
  var command = "turnright-90";
  httpGet(eveUrl + command);
  console.log("command send");
}

function turnLeft()
{
  var command = "turnleft-90";
  httpGet(eveUrl + command);
  console.log("command send");
}

function grab()
{
  var command = "grab";
  httpGet(eveUrl + command);
  console.log("command send");
}

function drop()
{
  var command = "drop";
  httpGet(eveUrl + command);
  console.log("command send");
}

function exit()
{
  var command = "exit";
  httpGet(eveUrl + command);
  console.log("command send");
}

function httpGet(theUrl)
{

    console.log("URL: " + theUrl);
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
    xmlHttp.send(null);
    // return xmlHttp.responseText;
}

</script>

  </body>
</html>
