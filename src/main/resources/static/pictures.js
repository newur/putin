let pics = [];


const changeTimeInMilliseconds = 3000;

let one = document.getElementById('bg1');
let two = document.getElementById('bg2');

two.addEventListener("transitionend", event => {
    let changeElement = event.target.classList.contains('hide') ? two : one;
    changeBg(changeElement);
}, false);

function infinitLoop() {
    setTimeout(() => {
        two.classList.toggle('hide')
        infinitLoop();
    }, changeTimeInMilliseconds);
}

function getRandomInteger(min, max) {
    return Math.floor(Math.random() * (max - min) + min);
}

function changeBg(element) {
    let randomIndex = getRandomInteger(0, pics.length);
    element.style.backgroundImage = "url(" + pics[randomIndex] + ")";
}

async function startPictureLogic() {
    pics = await fakeFetcher('url');
    infinitLoop();
}
// make initial background a fixed time
setTimeout(() => two.classList.toggle('hide'), 500);

startPictureLogic();