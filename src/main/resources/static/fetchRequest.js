let urls = [
    "https://lh3.googleusercontent.com/2HJ6PSWOpqt6zUNS8eDVPOTYd1NN3NNJNUXUn80Wb1Tdm37nJ_QbKh8Sq-Eztvtcz8Hq3w68jJsJHZxic9ZP8xOHHpA_DweqYU5tEApxO6w3gOLHXsrvuUK2PwVBjwV4g4rKLSY10tnl73jAVdet06gK2wo4xXI1wVjd9TFqAEwEim1Q6Ge_T8cqPdvccFcKQdd3dI9wmlZ8Pj2uyeM0Jg48_Ky_tASAu7WS4Fv8-03ninnobVO_fk85Fkwu62Z47YGQZc5ojnYzY5K7ur_1X6rmTM_LvuNKzamDxdBQjBvlKpAvnSI4tYXxJGlriqYdgWigqpWe6a8dnJdYuYnQNXLlEBsJdJps6xxFja3SblSnmNdGgPjb6aNhfgO9v_Ph50HnFZ11Yfp4bpsKQNYxVs2MVnR-g7jejVgUVEcSWC4IU5jfeTsxO1UGmq5d0fzXgW99DkgVy1xmmvGOit5BSVXzi5Zr-VQ-5f0JfHBFAX0F1Da92EM-TJTI7lm2xqR4gxLW0UOWEusxGHxDNkLvntKjfOceLkA3dnwgTSbnw6nQPoQDzu513w13rzFxCce-wIY7iBi4Zav913I_m-ll_FTla98SbjAHbnGDxUFC=w1420-h951-no",
    "https://lh3.googleusercontent.com/f6PeGdoOGoXUx_zo-babP6Vhll3VwnL7AW0j83xd3vI1n2ZzRi2IccpmZgFcaRafghKmxJgHQlhssXCzyA0WAowuhdMn35YQGuvPtgaDMXIyOPRr4fttOTigvC4BcX3Fcg8oq8hsHsI071bxyzIdTQCVyF9tPU0kFOCknZQsXT_kAWqPNIUrGv-t21gz5rfudZ6o_ugJ7tvzmSo0djuXCOXFFtcF7MEBdrhe7GVnGUz1_f91F5RKgxPHXVuNlEnhCziM8KEdZndSFheUkM4lS_i095sR8XwEk8uNBH4X59M4xJ9tofgAacluq-I9HGPWSVP2JjxknC58ckk0IjkaAk2frQWCGcBxPT11YZOhq3rTM8hXKQo3dg53yFr6v4XlRC1B04VorJWytPvVV6J0nD9Q8q6yFS6YVl-lBp6ZdDM1PvinPKjoXZn2u7husRrbWqxZyqmVxuehl0gU8PVpIq7UBTICnZu_I4TcjJdbe-MRnmbaTQZHAIg9O4sJYKoI8U1Gf6CuVIOupVpkKRCUc9oBcd8e_aodMJmYXkZOOQQE0IvzB3QQksx1cPhaN2O_qYrM6RqaYTcnHySlzZMDAMvUxJX7OGPirJFXXanU=w1522-h951-no"
    ];

async function fetchAsync (url) {
  let response = await fetch(url);
  return await response.json();
}

// trigger async function
// log response or catch error of fetch promise
function doFetch(url, func) {
fetchAsync(url)
    .then(urls => func(urls))
    .catch(reason => console.log(reason.message))
}

function fakeFetcher(url, simulatedWaitTime = 10000) {
    console.log('start to simulate async fetch operation...');
    return new Promise(
        function(resolve, reject) {
            setTimeout(function () {
                result = urls;
                console.log('simulated fetch result arrived!');
                resolve(urls);
            }, simulatedWaitTime);
        }
    )
}