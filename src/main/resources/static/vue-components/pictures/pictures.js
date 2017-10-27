Vue.component("pictures", {
    template: `<div class="bgvue">
                    <img id="bottom"/>
                    <img id="top"/>
               </div>`,
    props: ['time'],
    data: function(){
        return {
            topImgActive: '',
            images: [],
            unshownImages: []
        }
    },
    mounted: function(){
        this.images = [
            "http://lh3.googleusercontent.com/2HJ6PSWOpqt6zUNS8eDVPOTYd1NN3NNJNUXUn80Wb1Tdm37nJ_QbKh8Sq-Eztvtcz8Hq3w68jJsJHZxic9ZP8xOHHpA_DweqYU5tEApxO6w3gOLHXsrvuUK2PwVBjwV4g4rKLSY10tnl73jAVdet06gK2wo4xXI1wVjd9TFqAEwEim1Q6Ge_T8cqPdvccFcKQdd3dI9wmlZ8Pj2uyeM0Jg48_Ky_tASAu7WS4Fv8-03ninnobVO_fk85Fkwu62Z47YGQZc5ojnYzY5K7ur_1X6rmTM_LvuNKzamDxdBQjBvlKpAvnSI4tYXxJGlriqYdgWigqpWe6a8dnJdYuYnQNXLlEBsJdJps6xxFja3SblSnmNdGgPjb6aNhfgO9v_Ph50HnFZ11Yfp4bpsKQNYxVs2MVnR-g7jejVgUVEcSWC4IU5jfeTsxO1UGmq5d0fzXgW99DkgVy1xmmvGOit5BSVXzi5Zr-VQ-5f0JfHBFAX0F1Da92EM-TJTI7lm2xqR4gxLW0UOWEusxGHxDNkLvntKjfOceLkA3dnwgTSbnw6nQPoQDzu513w13rzFxCce-wIY7iBi4Zav913I_m-ll_FTla98SbjAHbnGDxUFC",
            "http://lh3.googleusercontent.com/f6PeGdoOGoXUx_zo-babP6Vhll3VwnL7AW0j83xd3vI1n2ZzRi2IccpmZgFcaRafghKmxJgHQlhssXCzyA0WAowuhdMn35YQGuvPtgaDMXIyOPRr4fttOTigvC4BcX3Fcg8oq8hsHsI071bxyzIdTQCVyF9tPU0kFOCknZQsXT_kAWqPNIUrGv-t21gz5rfudZ6o_ugJ7tvzmSo0djuXCOXFFtcF7MEBdrhe7GVnGUz1_f91F5RKgxPHXVuNlEnhCziM8KEdZndSFheUkM4lS_i095sR8XwEk8uNBH4X59M4xJ9tofgAacluq-I9HGPWSVP2JjxknC58ckk0IjkaAk2frQWCGcBxPT11YZOhq3rTM8hXKQo3dg53yFr6v4XlRC1B04VorJWytPvVV6J0nD9Q8q6yFS6YVl-lBp6ZdDM1PvinPKjoXZn2u7husRrbWqxZyqmVxuehl0gU8PVpIq7UBTICnZu_I4TcjJdbe-MRnmbaTQZHAIg9O4sJYKoI8U1Gf6CuVIOupVpkKRCUc9oBcd8e_aodMJmYXkZOOQQE0IvzB3QQksx1cPhaN2O_qYrM6RqaYTcnHySlzZMDAMvUxJX7OGPirJFXXanU",
            "https://lh3.googleusercontent.com/kSO7MS_CEFZAnVE4HT5Vv4WdpMyj-sE_zBrPJeKf80nBec3S38EBNRtaXVcOuJhP21Rr1t5lViD793b-aHmgMNVU5KAT9tjPAP2jWH3lpLbXKZHGGzwVYjfNZf_6Vh_Pefg8XOlrkJtdEBdxCZ3-jZ2HRC7BhhbXflmBDwmVCaAnSEwhMAPCAsvN4ruy0mDnx1TsT7yWGZMe54q_4x8OW5nBqTyXF53_YPeciVF0auEkxQ3qfs-ziKFAG_EqMkRFplQw6P_rsyrsL-NuNM0dByrFzMo9gM0fKzl7rhxogDnTp6AvvQJ0JzJI-eLrUGQFFjDa5OWWux8m4DQsRmiaHxEkzR1yafs_t7z06bwlZqeFinyH16r2wyfJgT7wkcSN1alUqNx_wVZW5U1MlhBLr1EidAY3TadRFuAStyDR9MRtYXDuvn4NkUupGQ-v9DaQX4otfBCFdLZWdZN2AApDVYWnrxXaXk4xM209JC-U0mB8bXMMg-gDO5VxF35dYT7ylz808xA4oH6KllX2AkZ_Yd8-QMGGtEzUNpNZZV6eLieUeX4nBlVJBaSyv5FVCJSaPU-nN7aUgiLlBYynhtSwsKSq9-agReSuEwzzLOc1",
            "https://lh3.googleusercontent.com/1qXXLbrgqVOyeaxTAL3FOV9rvsLdsu0M2DdE1eTMISIiaQaaaeJ5qbY3uMHuT0q7EwIlk0jOPiAnmq_7JBiIJBbCFJc7wJdOaovvEyEEHWnYKdfj82X-kbGpwmyYoFP6fj08WuoGwokCAl_xVYfbyguH4P0jkiRvx8WWvF_fPNqGRXsFrxk5TIt50O0YCFo703XLBZCAK1pPaEeaEOfrZnT9Lhx22Qt-V8Na_3olVLzVuvSuEz6x2dDakVW8Dpcu5wQnCPpnL87b-jgoG73AmbfOP4KSCMZ03LrFBoA-ZFIIaPekhfB7nlI9RQFGqLIQsGlYjtlmMG-XxDq-vsWg2EjzhK1KoODUnwBQiqqqIMYnXa4fuTgZR7__qNND9LyfOg07mbFlf1nOAZqoPrpYMv3wcG11RQD70nqtvpEa6AvARIvrypjQSU378JZdcBj7FQGOagXdN2wuDG-hX_hgywfI_5E657eEIxffj1VYzF6-qoUoy7EtQKcQk_8qfotjaJWmHKUE9p19nzaeWzfHH_Whizm0sCZ9fkTI0mGW3fWKxtML1CIGGmQIYdzCBFlP_y33SA3sHZTGCgzM937JL7kx9rBFOBOB1NrxjF3T"
        ];
        this.unshownImages = this.images.slice();
        this.showFirst();
        this.timer = setInterval(this.showNext,this.time*1000)
        /*var self = this;
        $.getJSON( "/rest/selenium/demo", function( data ) {
            self.images=data;
            self.unshownImages = self.images.slice();
            self.showFirst();
            self.timer = setInterval(self.showNext,self.time*1000)
        });*/
    },
    methods: {
        showFirst: function() {
            var self = this;
            $( "#top" ).fadeOut( 1, function() {
                topImgActive = false;
                document.getElementById('bottom').src = self.nextPicture();
                document.getElementById('top').src = self.nextPicture();
            });
        },
        showNext: function() {
            var self = this;
            if(!topImgActive){
                $( "#top" ).fadeIn( 1000, function() {
                    document.getElementById('bottom').src = self.nextPicture();
                });
                topImgActive = true;
            }
            else {
                $( "#top" ).fadeOut( 1000, function() {
                    document.getElementById('top').src = self.nextPicture();
                });
                topImgActive = false;
            }
        },
        nextPicture: function(){
            if (this.unshownImages.length == 0) {
                this.unshownImages = this.images.slice();
            }
            var randomInt = Math.floor(Math.random() * this.unshownImages.length);
            nextPictureUrl = this.unshownImages[randomInt];
            this.unshownImages.splice(randomInt,1);
            return nextPictureUrl+"=s0";
        }
    }
});