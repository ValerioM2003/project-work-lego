// script.js

// Funzione per aggiungere il prodotto al carrello
//function aggiungiAlCarrello() {
    // Mostra un alert quando il pulsante "Aggiungi al Carrello" viene premuto
    //alert("Prodotto aggiunto al carrello!");
//}
function openNav() {
      document.getElementById("mySidebar").style.width = "250px"}

function closeNav() {
      document.getElementById("mySidebar").style.width = "0"}

function goToHomePage() {
        window.location.href = '/';
    }
// script.js

function aggiungiAlCarrello() {
    alert("Prodotto aggiunto al carrello!");
}

let slideIndex = 0;
showSlides();

function showSlides() {
  let i;
  const slides = document.getElementsByClassName("slide");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}
  slides[slideIndex-1].style.display = "block";
  slides[slideIndex-1].style.opacity = 1; // Imposta l'opacità a 1 per mostrare la diapositiva
  setTimeout(showSlides, 4000); // Cambia immagine ogni 2 secondi (2000 millisecondi)
}

function plusSlides(n) {
  showSlides(slideIndex += n);
}
 function openNav() {
      document.getElementById("mySidebar").style.width = "250px";
    }

    function closeNav() {
      document.getElementById("mySidebar").style.width = "0";
    }


