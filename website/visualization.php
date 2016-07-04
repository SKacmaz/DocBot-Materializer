<script src="js/jquery-3.0.0.min.js"></script>
<script src="//d3js.org/d3.v3.min.js"></script>

<link rel="stylesheet" href="stylesheets/diagram.css" media="screen" title="no title" charset="utf-8">

<svg id="chart" class="chart">
</svg>


<script type="text/javascript">

handleResourceResult = function(data)
{
  console.log(data.resources);
  var resources  = data.resources;
  // var resources = getSampleJson();
  console.log(resources.length);

  var types = d3.nest()
    .key(function(d){return d.type})
    .entries(resources);

    console.log("TYPES: ", types);
    console.log(types[1].values.length);

//### create array of domain, what types of containers are there
    var domain = [];
    for(var i = 0; i < types.length; i++)
    {
      domain.push(types[i].key);
    }
    console.log("Domain: " , domain);

//### set basics for the chart
    var fullWidth = 900;
    var fullHeight = 500;
    var margin = {top : 50, right: 50, bottom: 50, left: 50}

    var width = fullWidth - margin.left - margin.right,
        height = fullHeight - margin.top - margin.bottom;

    var highestValue = d3.max(types, function(type) {return type.values.length;});
    var y = d3.scale.linear()
        .range([height, 0])
        .domain([0, highestValue]);

    var x = d3.scale.ordinal()
        .domain(domain)
        .rangeRoundBands([0, width], .5);

    var xAxis = d3.svg.axis()
        .scale(x)
        .orient("bottom");

    var yAxis = d3.svg.axis()
        .scale(y)
        .tickFormat(d3.format("d"))
        .ticks(highestValue)
        .orient("left");

    var chart = d3.select(".chart")
      .attr("width", fullWidth)
      .attr("height", fullHeight)
      .append("g")
        .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

// ####### append bars
    var bar = chart.selectAll("g")
      .data(types)
    .enter().append("g")
      .attr("transform", function(d, i) {return "translate(" + x(domain[i]) + ", 0)";});

    bar.append("rect")
      .attr("y", function(d) {return y(d.values.length);})
      .attr("height", function(d){return height - y(d.values.length);})
      .attr("width", x.rangeBand())
      .attr("class", function(d, i){return domain[i] + ""});

      // ####### append axes
      chart.append("g")
        .attr("class", "x axis")
        .attr("transform", "translate(0," + height + ")")
        .call(xAxis);

      chart.append("g")
        .attr("class", "y axis")
        .call(yAxis);


  }

  var getSampleJson = function(){
    json = {
      "resources": [
        {
          "type": "orange",
          "user": {
            "id": 2,
            "firstName": "Bob",
            "lastName": "Marley"
          },
          "dockerId": "15c515f8-bcbb-4e90-99b6-cbf254fe4e0c",
          "custom": {},
          "id": 1
        },
        {
          "type": "blue",
          "user": {
            "id": 2,
            "firstName": "Bob",
            "lastName": "Marley"
          },
          "dockerId": "15c515f8-bcbb-4e90-99b6-cbf254fe4e0c",
          "custom": {},
          "id": 2
        },
        {
          "type": "blue",
          "user": {
            "id": 2,
            "firstName": "Bob",
            "lastName": "Marley"
          },
          "dockerId": "15c515f8-bcbb-4e90-99b6-cbf254fe4e0c",
          "custom": {},
          "id": 3
        },
        {
          "type": "blue",
          "user": {
            "id": 2,
            "firstName": "Bob",
            "lastName": "Marley"
          },
          "dockerId": "15c515f8-bcbb-4e90-99b6-cbf254fe4e0c",
          "custom": {},
          "id": 4
        },
        {
          "type": "yellow",
          "user": {
            "id": 2,
            "firstName": "Bob",
            "lastName": "Marley"
          },
          "dockerId": "15c515f8-bcbb-4e90-99b6-cbf254fe4e0c",
          "custom": {},
          "id": 5
        },
        {
          "type": "blue",
          "user": {
            "id": 2,
            "firstName": "Bob",
            "lastName": "Marley"
          },
          "dockerId": "15c515f8-bcbb-4e90-99b6-cbf254fe4e0c",
          "custom": {},
          "id": 5
        },
        {
          "type": "orange",
          "user": {
            "id": 1,
            "firstName": "Bob",
            "lastName": "Marley"
          },
          "dockerId": "4b04825f-843b-4756-9ba2-b0e291686754",
          "custom": {},
          "id": 6
        }
      ]
    };
    return json.resources;
  };

</script>

<!-- get info from Haven via callback to overcome x-Origin-rules -->
<script src="http://localhost:8081/resources/all/?callback=handleResourceResult"></script>
