Vue.component("feed", {
    template: `<div id="feed">
                    <span class="feedTitle">{{feedItem.title}}</span></br>
                    <span class="feedText">{{feedItem.description}}</span>
               </div>`,
    data: function(){
        return {
           feedItem: '',
           feedItems: [],
           unshownFeedItems: []
        }
    },
    mounted: function(){
        var self = this;
        var rss_url = "http://www.tagesschau.de/xml/rss2";
        $.getJSON( "https://api.rss2json.com/v1/api.json?rss_url=" + rss_url, function( data ) {
            self.feedItems = data.items;
            self.unshownFeedItems = self.feedItems.slice();
            self.showNext();
            self.timerNext = setInterval(self.showNext,10000)
            self.timerReloadUrls = setInterval(self.getFeedItems,600000)
        });
    },
    methods: {
        getFeedItems: function(){
            var self = this;
            $.getJSON( "https://api.rss2json.com/v1/api.json?rss_url=" + rss_url, function( data ) {
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




