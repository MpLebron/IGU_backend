var app = new Vue({
    el: '#app',
    data: {
        activeMenuIndex:"Home",
        activeTabName:"2022",
        activeNewsName:"Call-for-Nominations",
    },
    methods : {
        menuSelect: function (index, indexPath) {
            if(index == "userentrance"){
                return
            }
            let origin = "#" + this.activeMenuIndex
            let destination
            if(indexPath.length == 1)
                 destination = "#" + index
            else
                 destination = "#" + indexPath[1]


            $(origin).hide();
            $(destination).fadeIn();
            this.activeMenuIndex = index

        },
        newsJump(e,year){
            id = (e.target.id).replace("#","")
            $("#" + this.activeMenuIndex).hide()
            this.activeTabName = year.toString()
            this.activeNewsName = id
            $("#" + "Events").fadeIn()
            this.activeMenuIndex = "Events"
        },
    }

})