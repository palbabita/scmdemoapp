// let currentTheme = getTheme();
// changeTheme();

// function changeTheme() {
//   document.querySelector("html").classList.add(currentTheme);
//   const themeBtn = document.querySelector("#theme_btn");
//   themeBtn.addEventListener("click", (event) => {
//     const oldTheme = currentTheme;
//     console.log("theme button clicked");
//     if (currentTheme == "dark") {
//       currentTheme = "light";
//     } else {
//       currentTheme = "dark";
//     }

//     setTheme(currentTheme);
//     document.querySelector("html").classList.remove(oldTheme);
//     document.querySelector("html").classList.add(currentTheme);
//   });
// }
// function setTheme(theme) {
//   localStorage.setItem("theme", theme);
// }
// function getTheme() {
//   let theme = localStorage.getItem("theme");
//   if (theme) return theme;
//   else return "light";
// }

console.log("Script loaded");

// change theme work
let currentTheme = getTheme();
//initial -->

document.addEventListener("DOMContentLoaded", () => {
  changeTheme();
});

//TODO:
function changeTheme() {
  //set to web page

  changePageTheme(currentTheme, "");
  //set the listener to change theme button
  const changeThemeButton = document.querySelector("#theme_btn");

  changeThemeButton.addEventListener("click", (event) => {
    let oldTheme = currentTheme;
    console.log("change theme button clicked");
    if (currentTheme === "dark") {
      //theme ko light
      currentTheme = "light";
    } else {
      //theme ko dark
      currentTheme = "dark";
    }
    console.log(currentTheme);
    changePageTheme(currentTheme, oldTheme);
  });
}

//set theme to localstorage
function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

//get theme from localstorage
function getTheme() {
  let theme = localStorage.getItem("theme");
  return theme ? theme : "light";
}

//change current page theme
function changePageTheme(theme, oldTheme) {
  //localstorage mein update karenge
  setTheme(currentTheme);
  //remove the current theme

  if (oldTheme) {
    document.querySelector("html").classList.remove(oldTheme);
  }
  //set the current theme
  document.querySelector("html").classList.add(theme);

  // change the text of button
  document
    .querySelector("#theme_btn")
    .querySelector("span").textContent = theme == "light" ? "Dark" : "Light";
}

//change page change theme
