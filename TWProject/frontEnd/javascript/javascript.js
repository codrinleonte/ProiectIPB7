var questionCount = 0;

function showImageMed() {
  document.getElementById('imageMed').style.content = "url('../images/Sonic_sonicx.png')";
  document.getElementById('imageMed').style.display = "block";
  document.getElementById('StartBut').style.display = "block";
   
}
function showImageEasy() {
   document.getElementById('imageMed').style.content = "url('../images/yin_by_lucius4277-d53xsf1.png')";
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


function nextQuestion(){
	
	if(questionCount===7){
		document.getElementById('finishButton').style.display = "block";
		document.getElementById('nextButton').style.display = "none";
		exit;
	}
	
	
	questionCount++;
	
	
	document.getElementById('quest').innerHTML = "Intrebare".concat(questionCount.toString());;
	var r = document.getElementsByTagName("label")   


	
	r[0].innerHTML ="answerA".concat(questionCount.toString());
	r[1].innerHTML ="answerB".concat(questionCount.toString());
	r[2].innerHTML ="AnswerC".concat(questionCount.toString());
	r[3].innerHTML ="answerD".concat(questionCount.toString());
    
	
}