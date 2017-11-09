Vue.component("photosettings", {
    template: `<div>
                    <div class="settingsbox">
                        <div class="settingsboxtitle">
                            <span>Anzeigeeinstellungen</span>
                        </div>
                        <div class="settingsoption">
                            <span class="settingslabel">
                                Bildintervall
                            </span>
                            <span class="settingsvalue">
                                <input type="range" min="1" max="300" v-model="settings.photoSettings.photoTransitionTime"> {{settings.photoSettings.photoTransitionTime}} Sekunden
                            </span>
                        </div>
                    </div>
                    <button class="savesettingsbtn" @click="save()">Speichern</button>
               </div>`,
    props: ['settings'],
    methods:{
        save: function(){
            this.$parent.$options.methods.save(this.settings);
        }
    }
});