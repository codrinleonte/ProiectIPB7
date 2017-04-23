

function showImageMed() {
  document.getElementById('imageMed').style.content = "url('../images/Sonic_sonicx.png')";
  document.getElementById('imageMed').style.display = "block";
  document.getElementById('StartBut').style.display = "block";
   
}
function showImageEasy() {
   document.getElementById('imageMed').style.content = "url('../images/yin.png')";
   document.getElementById('imageMed').style.display = "block";
   document.getElementById('StartBut').style.display = "block";
}
function showImageHard() {
  document.getElementById('imageMed').style.content = "url('../images/Johnny_Bravo.png')";
   document.getElementById('imageMed').style.display = "block";
   document.getElementById('StartBut').style.display = "block";
   
}

function showDifficultyForm(){
	document.getElementById('difficultyForm').style.display = "block";
}