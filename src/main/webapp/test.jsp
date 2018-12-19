<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>Document</title>

<style type="text/css">
ul, li, p { margin: 0; padding: 0; }
.graph  { width: 90%; list-style: none; }
.graph li   { position: relative; padding: 1px 0; white-space:nowrap; }
.graph li span  { display: inline-block; position: relative; height: 20px; line-height: 20px; background: #eee; }
.graph li em    { position: absolute; top: 0; right: -45px; font-family: arial; color: #000; }
</style>

 </head>
 <body>

 <h1>애니메이션 수평 막대 그래프</h1>
 <ul id="g1" class="graph">
  <li>0 : <span style="width: 0%"><em>0%</em></span></li>
        <li>1 : <span style="width: 20%"><em>20%</em></span></li>
        <li>2 : <span style="width: 40%"><em>40%</em></span></li>
        <li>3 : <span style="width: 60%"><em>60%</em></span></li>
        <li>4 : <span style="width: 80%"><em>80%</em></span></li>
        <li>5 : <span style="width: 100%"><em>100%</em></span></li>
    </ul>

    <hr />

    <ul id="g2" class="graph">
        <li><span style="width: 50%"><em>50%</em></span></li>
        <li><span style="width: 5%"><em>5%</em></span></li>
        <li><span style="width: 60%"><em>60%</em></span></li>
        <li><span style="width: 70%"><em>70%</em></span></li>
        <li><span style="width: 99%"><em>99%</em></span></li>
    </ul>

<script type="text/javascript">
drawGraph(document.getElementById("g1"));
drawGraph(document.getElementById("g2"));

function drawGraph(obj) {
    this.gages = obj.getElementsByTagName("span");
    this.values = obj.getElementsByTagName("em");

    for(var i = 0; i < this.gages.length; i ++) {
        (function(idx) {
            var current_value = 0;
            var gage_object = this.gages[idx]; 
            var gage_value = this.values[idx];
            var gage_width = parseInt(gage_object.style.width);
            var timer = null;

            timer = setInterval(function() {
                if(current_value < gage_width) {
                    current_value += Math.ceil((gage_width - current_value) / 15);
                    gage_object.style.width = current_value + "%";
                    gage_value.innerHTML = current_value + "%";
                } else {
                    clearInterval(timer);
                }
            }, 100);
        })(i);
    }
}
</script> 

 </body>
</html> 