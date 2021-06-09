const form = document.querySelector('form');
const mensaje = document.getElementById('mensaje');
const mensajepeq = document.getElementById('mensajepeq');
const usuarioMensaje = 'Escribe tu nombre de usuario';
const passwordMensaje = 'Escribe tu contraseña';
const nombreusuario = document.getElementById('nombreusuario');
const password = document.getElementById('password');
const submitBtn = document.getElementById('submit');

function primerMensaje(){
	mensaje.innerHTML = usuarioMensaje;
	mensajepeq.innerHTML = "";

}

function segundoMsg(){
	mensaje.innerHTML = passwordMensaje;
}

function formValidacion(){
	
	nombreusuario.addEventListener("input",primerMensaje);
	password.addEventListener('input', segundoMsg);
	password.addEventListener('keyup', length);
}

formValidacion();




