Vue.component("feed", {
    template: `<div id="feed">
                    <span class="feedTitle">{{feedItem.title}}</span></br>
                    <span class="feedText">{{feedItem.description}}</span>
               </div>`,
    props: ['time','url'],
    data: function(){
        return {
           feedItem: '',
           feedItems: [],
           unshownFeedItems: []
        }
    },
    mounted: function(){
        var self = this;
        $.getJSON( "https://api.rss2json.com/v1/api.json?rss_url=" + this.url, function( data ) {
            self.feedItems = data.items;
            self.unshownFeedItems = self.feedItems.slice();
            self.showNext();
            self.timerNext = setInterval(self.showNext,self.time*1000)
            self.timerReloadUrls = setInterval(self.getFeedItems,600000)
        });
    },
    methods: {
        getFeedItems: function(){
            var self = this;
            $.getJSON( "https://api.rss2json.com/v1/api.json?rss_url=" + this.url, function( data ) {
                self.feedItems = data.items;
                self.unshownFeedItems = self.feedItems.slice();
            });
        },
        showNext: function() {
            if (this.unshownFeedItems.length == 0) {
                this.unshownFeedItems = this.feedItems.slice();
            }
            this.feedItem = this.unshownFeedItems[0];
            this.unshownFeedItems.splice(0,1);
        },
    }
});




