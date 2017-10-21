let pics = [];

const showTimeInMilliseconds = 3000;
const fadeTimeInMilliseconds = 1000;

let one = document.getElementById('bg1');
let two = document.getElementById('bg2');

two.addEventListener("transitionend", event => {
    let changeElement = event.target.classList.contains('hide') ? two : one;
    changeBg(changeElement);
    setTimeout(() => two.classList.toggle('hide'), checkLoading());
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

// this function fully optional
// only used for 'nicer' animation of loading screen
function checkLoading() {
    if (pics.length == 0) {
        return two.classList.contains('hide') ? 1200 : 50;
    }
    return showTimeInMilliseconds;
}

async function startPictureLogic() {
    // loading screen has fixed transition time
    two.style.setProperty("--backgroundTwoTransition", `opacity 800ms`);
    two.classList.toggle('hide');
    pics = await fakeFetcher('url', 3000);
    two.style.setProperty("--backgroundTwoTransition", `opacity ${fadeTimeInMilliseconds}ms`);
}

startPictureLogic();