// times should be configurable by user in final version
const showTimeInMilliseconds = 3000;
const fadeTimeInMilliseconds = 1000;

let pics = [];
let bgs = document.getElementsByClassName('bg');

bgs[1].addEventListener("transitionend", event => {
    let changeElement = event.target.classList.contains('hide') ? bgs[1] : bgs[0];
    changeBg(changeElement);
    setTimeout(() => bgs[1].classList.toggle('hide'), checkLoading());
}, false);

function getRandomInteger(min, max) {
    return Math.floor(Math.random() * (max - min) + min);
}

function changeBg(element) {
    if (pics.length > 0) {
        let randomIndex = getRandomInteger(0, pics.length);
        element.style.backgroundImage = "url(" + pics[randomIndex] + ")";
    }
}

async function startPictureLogic() {
    bgs[1].classList.toggle('hide');
    pics = await fakeFetcher('url', 3000);
    bgs[1].style.setProperty("--backgroundTwoTransition", `opacity ${fadeTimeInMilliseconds}ms`);
}

// START optional code
// only used for 'nicer' animation of loading screen
// loading screen has fixed transition time
bgs[1].style.setProperty("--backgroundTwoTransition", `opacity 800ms`);
function checkLoading() {
    if (pics.length == 0) {
        return bgs[1].classList.contains('hide') ? 1200 : 50;
    }
    return showTimeInMilliseconds;
}
// END optional code

startPictureLogic();