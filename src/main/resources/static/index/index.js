
/*SLIDER*/
const slider = document.querySelector('.galeria');
let sinClick = false;
let inicioX;
let scrollLeft;

slider.addEventListener('mousedown', e => {
  sinClick = true;
  slider.classList.add('active');
  inicioX = e.pageX - slider.offsetLeft;
  scrollLeft = slider.scrollLeft;
});
slider.addEventListener('mouseleave', _ => {
  sinClick = false;
  slider.classList.remove('active');
});
slider.addEventListener('mouseup', _ => {
  sinClick = false;
  slider.classList.remove('active');
});
slider.addEventListener('mousemove', e => {
  if (!sinClick) return;
  e.preventDefault();
  const x = e.pageX - slider.offsetLeft;
  const SCROLL_SPEED = 2;
  const walk = (x - inicioX) * SCROLL_SPEED;
  slider.scrollLeft = scrollLeft - walk;
});
/* //// */


 