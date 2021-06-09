const form = document.querySelector('form');
const mensaje = document.getElementById('mensaje');
const mensajepeq = document.getElementById('mensajepeq');
const usuarioMensaje = 'Escribe tu nombre de usuario';
const passwordMensaje = 'Escoje tu contraseña';
const nombreusuario = document.getElementById('nombreusuario');
const password = document.getElementById('password');
const submitBtn = document.getElementById('submit');

function firstMessage(){
	mensaje.innerHTML = usuarioMensaje;
	mensajepeq.innerHTML = "";

}


function segundoMsg(){
	mensaje.innerHTML = passwordMensaje;
}

function length(){
	if(password.value.length <= 3){
		mensajepeq.innerHTML = "(Escoje una contraseña segura)";
		
	} 
	else if(password.value.length  > 3 && password.value.length <10){
		mensajepeq.innerHTML = "No está mal...";
		
	}
	else if(password.value.length >=10){
		mensajepeq.innerHTML = "Contraseña muy segura :-)";
		
	}
	else{
		mensajepeq.innerHTML = "";
	}
}

function formValidation(){
	//step 1 email
	//display Type your email when user clicks on input and types, 
	//hide after user clicks on something else
	nombreusuario.addEventListener("input",firstMessage);
	//step 2 password 
	//display Choose your password as user clicks on input
	//change small message as user enters longer password 
	password.addEventListener('input', segundoMsg);
	password.addEventListener('keyup', length);

	
	
}

formValidation();




