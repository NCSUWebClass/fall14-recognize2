	<%@page import="com.istudy.db.RecogDBException"%>
<%@page import="com.istudy.enums.Difficulty"%>
<%@page import="com.istudy.action.SettingsAction"%>
<%@page import="com.istudy.action.LeaderboardAction"%>
<%@page import="com.istudy.action.HomeAction"%>
	<%@page import="java.util.List" %>
	<%@include file="/global.jsp"%>
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/skeleton.css">
	<link rel="stylesheet" href="css/layout.css">
		
		<%
		SettingsAction action = new SettingsAction(recogFactory,currentUser);
		if("optionForm".equals(submittedFormName)){
			OptionBean updatedBean = new OptionBean(currentUser.getUID());
			
			if(request.getParameter("music") == null){
				updatedBean.setMusicSetting(false);
			}
			if(request.getParameter("sfx") == null){
				updatedBean.setSfxSetting(false);
			}
			if(Integer.parseInt(request.getParameter("diffSlider")) == 1){
				updatedBean.setDiffSetting(Difficulty.EASY);
			} else if (Integer.parseInt(request.getParameter("diffSlider")) == 2) {
				updatedBean.setDiffSetting(Difficulty.MED);
			} else {
				updatedBean.setDiffSetting(Difficulty.HAR);
			}
			try {
				action.updateOptions(updatedBean);
				currentUserOptions = updatedBean;
				session.setAttribute("currentUserOptions", currentUserOptions);
				%>
				<script type=text/javascript>
				alert("Settings Successfully Updated");
				window.top.location.reload(true);
				</script>
				<%
			} catch (RecogDBException e){
				%>
				<script type=text/javascript>
				alert("Error occured when attempting to update your settings.");
				</script>
				<%
			}
		}
		if("deactivateForm".equals(submittedFormName)){
			%>
				<script type=text/javascript>
					alert("Account Removed...You will be redirected to login screen now.");
				</script>
			<%
			action.deactivateAccount();
			session.setAttribute("currentUser", null);
			session.setAttribute("currentUserOptions", null);
			%>
			<script type=text/javascript>
				window.top.location.href = "login.jsp";
			</script>
			<%
		}
%>
	<h2 class="otherPage">Options</h2>
	<hr>
	<div class='clear'></div>
		<form action="options.jsp" method="post" class="options">
		<input type="hidden" name="formIsFilled" value="true"> <br />
		<input type="hidden" name="formName" value="optionForm" value="true"/>
		<div> Music Setting: </div> 
			<% if (currentUserOptions.getMusicSetting() == true) { %>
			<div class="slideThree">	
				<input type="checkbox" value="None" id="slideThree" name="music" hidden="hidden" checked/>
				<label for="slideThree"></label>
			</div>
			<% } else { %>
			<div class="slideThree">	
				<input type="checkbox" value="None" id="slideThree" name="music" hidden="hidden" />
				<label for="slideThree"></label>
			</div>
			<% } %>
		<div> SFX Setting: </div>
			<% if (currentUserOptions.getSfxSetting() == true) { %>
			<div class="slideThree">	
				<input type="checkbox" value="None" id="slideThreee" name="sfx" hidden="hidden" checked/>
				<label for="slideThreee"></label>
			</div>
			<% } else { %>
			<div class="slideThree">	
				<input type="checkbox" value="None" id="slideThreee" name="sfx" hidden="hidden" />
				<label for="slideThreee"></label>
			</div>
			<% } %>
		<div> Difficulty: </div>
			<% if (currentUserOptions.getDiffSetting().equals(Difficulty.EASY)) { %>
			<input type="range" min="1" max="3" value="1" name="diffSlider" id="diffSlider"/> <div id="diffText">Easy</div>
			<% } else if (currentUserOptions.getDiffSetting().equals(Difficulty.MED)) { %>
			<input type="range" min="1" max="3" value="2" name="diffSlider" id="diffSlider"/> <div id="diffText">Medium</div>
			<% } else  { %>
			<input type="range" min="1" max="3" value="3" name="diffSlider" id="diffSlider"/> <div id="diffText">Hard</div>			
			<%} %>
			<input type="submit" value="Save Options" name="submit"/>
		</form>
		<form action="options.jsp" method="post" class="options">
		<input type="hidden" name="formIsFilled" value="true"> <br />
		<input type="hidden" name="formName" value="deactivateForm" value="true"/>
		<input type="submit" value="Deactivate Account" name="deactivate"/>
		</form>
		<script>
			var diffSlider = document.getElementById('diffSlider');
			var diffValue = document.getElementById('diffText');
			diffSlider.onchange = function() {
				if (this.value == 1){
					diffValue.innerHTML = "Easy";
				} else if (this.value == 2){
					diffValue.innerHTML = "Medium";
				} else {
					diffValue.innerHTML = "Hard";
				}
			}
		</script>