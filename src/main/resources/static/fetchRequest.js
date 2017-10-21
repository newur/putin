let urls = [
    "https://lh3.googleusercontent.com/ZYmZE_Sz8qggqotsBIIWGFCrFqFFws6Lyojubs7sbg7emy-Wr1-IrUhI30W-VOtVCNXVbzWyMH4PT0LQQCYbHO7RGwWoyR7cr03H4Mhnrlax9D77jg1xmnkZJpVCxs33j-1JFN3hhAkL4Ru1Vu_lGficTAXCugpm-9BzLMH9hSoKBciOK-iWemt0UJCiQLlxfmpXqUyzH3DdWFPzDcb22Hq1-_-mNxhP2FW4FX_5Q7Lui2cwGLNiFJy-dbH1wOFEXJkSyLkH1i6vj9Nw-3-c2o_HInE-9eTXrBvGizMqs2i0R3SUZqVMQYIVzdgJai61ynjuUAXPhBxRXLX2r_rDinGR218lI5ReRuN0wMg_mBC1H9W2Ifa6ZKRijCKfK3R2j9CLsvnryZbtAYU_2bUZkLxWy9zoyryWlaleuCqPEcQ_IxYSyOT2gGlmTAt4s8NaRrKnex1nfiVnjcq_SnamBQUUe5foiVdqSjf5YdOpsalIPurdAbFu1RC-lI_FwGgIa-G_Gq8vhA2A6mOXULao3GjCzQOUuulR6NK1BBrlyxKD00SgvYk0CmW0ax9yuzeu6wQTKXRspYuxoTfrrzNvCfrzrfXDuYn9ZPYg1OK-Dg",
    "https://lh3.googleusercontent.com/rjSxZ_k4csY7TUwnjKS0dkP4OEOs5z1_h6Vi2664lpICogp7Z7ilZm_csdHUsbn5WOfVy285_xNDpZFB7upiRXXkOFobKSSXgKP7E1Du2rwhD6ctn9BPwKUg9GGwWO4jgC9IvIxegWXMNji7aNiuU-Pkb4V0hCtUNzdcfWgyolLqlrB6Y2fdPuhtAY7Clz5dpZYQlBG5ERlpIiFLuSipMN5y0g8WjruEumqIGTYukmReOQ9FUsWG2p9YGdcn6yyyCn368T5vPlDj1wseFvAtsCaLr1l_nllZze8No7FUlzKo86SX7gqgTERBUT-6dLvVyozs8CzajBPRENL5aReIEDk_NsZLS_gbTgHI3CzlZ1S1_BLhP160Qqh3ZLDjzBUDwleFslryL7by_4hM0gbiTYSkGr6D2OG-iryo8crvFHd_INsjL_MOt6t2Y8DlQsg8vA-vW_dnP14fq9-ytScFMVQXTvQVLtYgpVtHMUKio2Ce8zoSkAPuTYYGP11jPA2TgMXQtV_ReG4oJLK4LyHPdA4mS5wSui87NSsslAtswb-RCBn60l6FjnzYeccH89k7idO7sAqEn2WL69zjrU0fwv0G_SS5SEhvHeohu3uK7g",
    "https://lh3.googleusercontent.com/12daY-KZ43z_A6SwOmMmDjXr2CwMFDYlC85_p3YxgjE2BytEMD-BKpWhjJc-rwJOToodrXyb4HvGQlNzSUlPM4GVKDnM9TfOR8bwnc0LWeTdAHXGkx68RK-6ufJdv_eg_QCmnpVG1Ttkg9_-FgLtrPI7ZLJ8n-bzxh0s5akFhVPWrMxqWkAKqLB-9ckWnXdf6uQs95xPM7kEXk759ucXX16jl3j8wH1VO-tRUZE3Y5IHj3bi8Myb4ii8F1_1iUNi_fG3zfyAbjc-0AHl7qU3pVZYcIAtN3BOOZNM4svYlH4MKU1SkGOrQFC7FMOhYe8_WkEmNH-pZ23tal9VrEfooSQUYJ_qCchx6Lh4xgviwynbzatqh-v8NTMtCmJqYaMQERqWuapTz-OKXfYqKNwekXfZLLsrXORTlU6EPxTGSIhojQ0yl58RASijPXQeUZDP3XjBOQ7dwz96vm9E8D7UH-v6ly3zUfpmcKCEY4TH2pC5D7xSyQYH2MFuYA5D0AVGLCcxMyb9mF6DdJ4CUYInOxQOmWCCJ7sBQLDeeebc5WwabGADMOGRjx-b03jgDFhzuDNMzOiWx4Mhrn_iSEWyAMW9A8sN1WGkqYlEe_rjBg",
    "https://lh3.googleusercontent.com/humF4jPAdhckSnPRh9LodN84mfqV11S7A6nTb3ZfBPVS7mjHiHsXHQqJQfAj2ZNp-bQIohOQDG7bKpqDPlK6OJ6_1LgstoELmmbIC8dVuOsB8IICVWTToJgWBHcBJ4Y6OP7BP82pg2vP1vZ8NXqiRlrlw7vWGgWltkorVHNSOqRdTCkt2wZR8d8ULK616u09v2-5J57s7JqCG8Pu3URXhwFcgZeywPFPSELPvL8ti1mrtTY4lIcCPMCBFTvLPs8XjN4M4Oh8GoBfEzSfwxcLjc31PQqWK8PJ1Useku-PiUEDnECwwGB92D8OhNYJUMQNOClJVFqfYj4RDwexl_X0xxDV6RVIJsWkrAkJakugA7_uOMe6Juf4FG1w7rZd78hX0uinVLDSmK2rbE_VWFmnXDZ_9dPwYzo8IVbXusOs9jca8x57tDlZhntbP5pT85NWUwuCKdJ5exNuVAXchPtfn3A37qiGVwBqisVZqEAsoIOLr37I9D2-ithFrViQsTbY54pcVzOpfo-qmH5UQcdguAiD5pK9PsLq2HjaM977fwL_xe4AuyaPtbMl0-kUGVPb4QBYwtO63WI7oyt9TgSyJio_iEPRgvnCQyUT8UEFmw",
    "https://lh3.googleusercontent.com/bXWOlA8ssIo7ia4Iwv07AXbS7GSXUESAtFtUjlXy94j1H5OLkKPMYCgk6twpPo56mmW4pdWAm4XwJs2VOYL6gtlj5GOyN20D6WpVZ12MWOVkww6xVMm-y1m-Mii-F2cHXC8PB32qZ24KtApH9JireG67vHpDGiiFBz4KN1h8mT9qoTyM78Vik_OIu-r0MZpNs6gMnczoOZbmN2aP8fRY_ZIk90ZerSDSm8Og3mWmqeIX64QXrSMOm7LRNpVd9TFJbg3W6xHk5nVIyuroW55L-ZbmQnoldFlfzvNvjX2JxzyPaRvSM7FRXciTs3y22W22i30iDubfsLD26aOkWhK7yjWAmn1Jjujg7jvTcuf9dQIfzwnjqORuYB9GtcHXw8Lks_fS8fyVTG7l3VeOl6Lssxp2oafb5csoLn6Kvp7w4Tz7WAn9nxxlkk8d1mJEUoH2TkqV_hEWCjG8C_4v_sGPQB9ph9aEFYHeOuBhrK_pfGEvLWbfat7BDHfeosw8knWRhQk4cgp3T8j4ydLctilTttQREBkcOR_grvPAJGeanFhFXID9III-hd9Xv3kBQI4gttqRdaa3ez0bsPi87sl2GFv-XqeOmodz5HjaIzU5DA",
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
    return new Promise(
        function(resolve, reject) {
            setTimeout(function () {
                result = urls;
                console.log('simulated fetch time over...');
                resolve(urls);
            }, simulatedWaitTime);
        }
    )
}