jQuery(document).ready(function ($) {
    //hide the subtle gradient layer (.cd-pricing-list > li::after) when pricing table has been scrolled to the end (mobile version only)
    checkScrolling($('.cd-pricing-body'));
    $(window).on('resize', function () {
        window.requestAnimationFrame(function () {
            checkScrolling($('.cd-pricing-body'))
        });
    });
    $('.cd-pricing-body').on('scroll', function () {
        var selected = $(this);
        window.requestAnimationFrame(function () {
            checkScrolling(selected)
        });
    });

    function checkScrolling(tables) {
        tables.each(function () {
            var table = $(this),
                totalTableWidth = parseInt(table.children('.cd-pricing-features').width()),
                tableViewport = parseInt(table.width());
            //console.log(table.scrollLeft() - totalTableWidth + tableViewport)
            if (table.scrollLeft() >= totalTableWidth - tableViewport - 1) {
                table.parent('li').addClass('is-ended');
            } else {
                table.parent('li').removeClass('is-ended');
            }
        });
    }


    //*seguir en otro momento */

    function getQueryVariable(variable) {
        var query = window.location.search.substring(1);
        var vars = query.split("&");
        for (var i = 0; i < vars.length; i++) {
            var pair = vars[i].split("=");
            if (pair[0] == variable) {
                return pair[1];
            }
        }
        console.log(variable + ' not found');
    }

    function cleanArray(actual) {
        var newArray = new Array();
        for (var i = 0; i < actual.length; i++) {
            if (actual[i]) {
                newArray.push(actual[i]);
            }
        }
        return newArray;
    }

    function getWorkspace() {
        var ws = getQueryVariable("workspace");
        if (!ws) {
            ws = "http://labs.isa.us.es/ir/DemoMaster/PapamoscasBinding/Papamoscas/";
            console.log("default workspace");
        }
        if (ws.slice(-1) !== "/") {
            ws += "/";
        }
        window.workspace = ws;
    }

    function getAgreementTemplates() {
        var ws = getQueryVariable("workspace");
        if (!ws) {
            ws = "http://labs.isa.us.es/ir/DemoMaster/PapamoscasBinding/Papamoscas/";
            console.log("default workspace");
        }
        if (ws.slice(-1) !== "/") {
            ws += "/";
        }
        console.log("selected workspace: " + ws);
        $.ajax({
            url: 'http://query.yahooapis.com/v1/public/yql?q=' + encodeURIComponent('select * from html where url="' + ws + "list.txt" + '"') + '&format=json',
            dataType: "text",
            async: true,
            success: function (data) {
                //getAgreementTemplatesContent(JSON.parse(data).query.results.body.split("\n"), ws);
                window.tmplNames = JSON.parse(data).query.results;
                if (tmplNames === null && typeof tmplNames === "object") {
                    alert("Please create a list.txt file inside IDEAS editor.")
                } else {
                    tmplNames = cleanArray(tmplNames.body.split("\n"));
                }
                window.tmplPaths = [];
                for (var i in tmplNames) {
                    if (tmplNames[i]) {
                        tmplPaths.push(workspace + tmplNames[i]);
                    }
                }
                generatePricingItems();
            }
        });
    }

    function generatePricingItems() {
        console.log(window.tmplNames);
        for (var i in tmplPaths) {
            var htmlPath = tmplPaths[i].replace("at", "html");
            var name = tmplNames[i].replace(".at", "").replace(/([a-z](?=[A-Z]))/g, '$1 ');
            $("#pricing-list").append('<li> ' +
                '<form action="api/v4/purchases" method="get" id="form' + i + '"> ' +
                '<header class="cd-pricing-header"> ' +
                '<h2>' + name + '</h2> ' +
                '</header> ' +
                '<div class="cd-pricing-body">' +
                ' <div class="iframe">' +
                ' <iframe id="iframe' + i + '" src="' + htmlPath + '" width="100%" height="350px" scrolling="no">' +
                '</iframe> ' +
                '</div>' +
                ' </div>' +
                ' <footer class="cd-pricing-footer"> ' +
                '<input type="text" name="clientId" class="boton" placeholder="enter a client id">' +
                ' <input type="hidden" id="templateId" name="templateId" value="' + tmplNames[i] + '"> ' +
                '<input type="hidden" id="ws' + i + '"  name="ws" value="' + workspace + '"> ' +
                '<button type="submit" class="cd-select boton" form="form' + i + '" value="Purchase">Purchase</button> ' +
                '</footer>' +
                ' </form>' +
                ' </li>');

        }

    }


    getAgreementTemplates();
    getWorkspace();

});