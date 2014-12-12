<html>
<head>
<link href="css/gamestyle.css" type="text/css" rel="stylesheet" />
</head>
<body>
<%@include file="/gamemanager.jsp"%>
<%
	try {
%>
	<button class="button red medium" id="nextImage" onclick="nextImage()" hidden="hidden">Next Image</button>
	<input type="range" min="2" max="80" value="80" id="range"
		hidden="hidden" />
	<img id="currentGameImage" hidden="hidden"
		src="<%=RecognizeUtil.generateLinkToSubAlbumImages(action.getSelectedAlbum(), randGameTitle)%>_0.jpg" />
	<br>
	<table>
		<tr>
			<% int i = 0; %>
			<td><input type="image" class="imgChoices"
				onclick="checkAnswer('<%=generateRandom.get(i)%>')"
				src="<%=RecognizeUtil.generateLinkToSubAlbumImages(action.getSelectedAlbum(), randGameTitle)%><%=generateRandom.get(i++)%>.jpg" />
			</td>
		</tr>
		<tr>
			<td><input type="image" class="imgChoices"
				onclick="checkAnswer('<%=generateRandom.get(i)%>')"
				src="<%=RecognizeUtil.generateLinkToSubAlbumImages(action.getSelectedAlbum(), randGameTitle)%><%=generateRandom.get(i++)%>.jpg" />
			</td>
		</tr>
		<tr>
			<td><input type="image" class="imgChoices"
				onclick="checkAnswer('<%=generateRandom.get(i)%>')"
				src="<%=RecognizeUtil.generateLinkToSubAlbumImages(action.getSelectedAlbum(), randGameTitle)%><%=generateRandom.get(i++)%>.jpg" />
			</td>
		</tr>
		<tr>
			<td><input type="image" class="imgChoices"
				onclick="checkAnswer('<%=generateRandom.get(i)%>')"
				src="<%=RecognizeUtil.generateLinkToSubAlbumImages(action.getSelectedAlbum(), randGameTitle)%><%=generateRandom.get(i++)%>.jpg" />
			</td>
		</tr>
		<tr>
			<td><input type="image" class="imgChoices"
				onclick="checkAnswer('<%=generateRandom.get(i)%>')"
				src="<%=RecognizeUtil.generateLinkToSubAlbumImages(action.getSelectedAlbum(), randGameTitle)%><%=generateRandom.get(i++)%>.jpg" />
			</td>
		</tr>
		<tr>
			<td><input type="image" class="imgChoices"
				onclick="checkAnswer('<%=generateRandom.get(i)%>')"
				src="<%=RecognizeUtil.generateLinkToSubAlbumImages(action.getSelectedAlbum(), randGameTitle)%><%=generateRandom.get(i++)%>.jpg" />
			</td>
		</tr>
	</table>
	<% } catch(Exception e) { %>
		<script>
			alert("OH SNAP");
		</script>
	<% } %>
	<script src="js/close-pixelate.js"></script>
	<script src="js/jquery-2.1.1.js"></script>
	<script src="js/processing.js"></script>
	<script type="text/javascript">
	
		var yes = new Audio();
		yes.src = 'sounds/YES.mp3';

		var no = new Audio();
		no.src = 'sounds/NO.mp3'

		var ispaused = false;
		var imgcount = 20;
		var currentScore = imgcount * 5;
		var imgcounter = setInterval(timeImage, 1000);
		var event = new Event('change');

		var score = parent.document.getElementById('cpoints');
		var currentPlayerPoints = parent.document
				.getElementById('currentPlayerScore');
		var currentGameImage = document.getElementById('currentGameImage');
		var range = document.getElementById('range');
		var pscoreinput = parent.document.getElementById('pscore');

		function timeImage() {
			if ((imgcount - 2) >= 0 && (currentScore - 10) >= 0) {
				imgcount = imgcount - 2;
				currentScore = currentScore - 10;
				score.innerHTML = currentScore;
				range.setAttribute('value', imgcount);
				range.dispatchEvent(event);
			} else {
				clearTimeout(imgcounter);
			}
		}

		function pause() {
			if (ispaused == false) {
				clearTimeout(imgcounter);
				$("#currentGameImage").hide();
				$(".imgChoices").hide();
				ispaused = true;
			} else {
				imgcounter = setInterval(timeImage, 1000);
				$("#currentGameImage").show();
				$(".imgChoices").show();
				ispaused = false;
			}
		}

		function checkAnswer(answerChoice) {
			pause();
			$("#nextImage").show();
			var playerScore = parseInt(currentPlayerPoints.innerHTML);
			if (answerChoice == '_correct') {
				playerScore = playerScore + currentScore;
				currentPlayerPoints.innerHTML = playerScore;
				pscoreinput.value = playerScore;
				yes.play();
			} else {
				no.play();
			}
		}

		window.onload = function() {
			var pixelOpts = [ {
				resolution : imgcount
			} ]
			var pixelImage = currentGameImage.closePixelate(pixelOpts)
			range.addEventListener('change', function(event) {
				var res = parseInt(event.target.value, 10)
				pixelOpts = [ {
					resolution : res
				} ]
				pixelImage.render(pixelOpts)
			}, false)
		}

		function nextImage() {
			window.location.href = "gamesection.jsp";
		}
	</script>
</body>
</html>