





stat_populateVenueDropDownListForSelectVenue()
function stat_populateVenueDropDownListForSelectVenue(){
    let venueInof=getVenueInfo();
    let content="";



    $.each(venueInof,function (i,rc) {


        venueSelectedPrice_temp=(i==0?rc.venBookingFee:venueSelectedPrice);
        venueSelectedPrice=format(venueSelectedPrice_temp)
        content+=
            '            <option value="'+rc.venID+'"   data-price="'+format(rc.venBookingFee) +'"    >' +  rc.venName +'</option>'

    })
    $(".statFilter--venue").append(content);

}




$(document).ready(function(){
    $("#mainPageForm").on("submit", function(event){
        event.preventDefault();
        event.stopPropagation()
        let dataToController = $(this).serializeArray();

  //      stat_getLineChart(dataToController)
        stat_getLineChart(dataToController)
        dataToController[2].value=1;
        stat_getBarChart(dataToController)
    });
})


function stat_getLineChart(dataToController) {



    $.ajax({
        type: 'POST',
        url: '/statisticController',
        data: dataToController,
        dataType: 'json',
        success: function (rs) {


            let mySetGroup = new Set();

            $.each(rs, function (index, data) {

                mySetGroup.add(data.venId);
            });
            let objJS = {
                animationEnabled: true,
                theme: "light2",
                title: {
                    text:  "From  " + dataToController[0].value + "  to  "+ dataToController[1].value
                },
                axisX: {
                    valueFormatString: "DD MMM"
                },
                axisY: {
                    title: "Number of Sales",
                    suffix: "recrods",
                    minimum: -5
                },
                toolTip: {
                    shared: true
                },
                legend: {
                    cursor: "pointer",
                    verticalAlign: "bottom",
                    horizontalAlign: "left",
                    dockInsidePlotArea: true,
                    itemclick: toogleDataSeries
                },
                data: []
            };

            let indexOfPoint = 0;
            for (let venue of mySetGroup) {
                objJS.data.push(
                    {
                        type: "line",
                        showInLegend: true,
                        name: "Projected Sales",
                        markerType: "square",
                        xValueFormatString: "DD MMM, YYYY",
                        color: getRandomColor(),
                        yValueFormatString: "#,##",
                        dataPoints: []
                    })


                $.each(rs, function (index, data) {
                    if (data.venId == venue) {

                        objJS.data[indexOfPoint].name = data.venName

                        objJS.data[indexOfPoint].dataPoints.push({
                            x: new Date(data.sessionDate),
                            y: data.bookingCount,
                            indexLabel: "$ "+ format(data.bookingRevenue)
                        });

                    }
                });
                indexOfPoint++
            }
            $(".stat_SuccContent").removeClass("containerHide");
            $(".stat_ErrMessage").addClass("containerHide");
            $("#stat_chartContainerLineTable").CanvasJSChart(objJS);
        },

        error: function(xhr, status, error) {
            if(xhr.readyState==4){
                switch (xhr.responseText) {

                    case "No Result Found Exception":
                        $(".stat_SuccContent").addClass("containerHide");
                        $(".stat_ErrMessage").removeClass("containerHide");
                        break

                }
            }

    }

    });//EO ajax

}



function stat_getBarChart(dataToController) {



    $.ajax({
        type: 'POST',
        url: '/statisticController',
        data: dataToController,
        dataType: 'json',

        success: function (rs) {


            let objJS =     {
                animationEnabled: true,
                title: {
                    text:  "From  " + dataToController[0].value + "  to  "+ dataToController[1].value,
                    fontColor: "Peru"
                },
                axisY: {
                    tickThickness: 0,
                    lineThickness: 0,
                    valueFormatString: " ",
                    includeZero: true,
                    gridThickness: 0
                },
                axisX: {
                    tickThickness: 0,
                    lineThickness: 0,
                    labelFontSize: 18,
                    labelFontColor: "Peru"
                },
                data: [{
                    indexLabelFontSize: 26,
                    toolTipContent: "<span style=\"color:#62C9C3\">{indexLabel}:</span> <span style=\"color:#CD853F\"><strong>{y}</strong></span>",
                    indexLabelPlacement: "inside",
                    indexLabelFontColor: "white",
                    indexLabelFontWeight: 600,
                    indexLabelFontFamily: "Verdana",
                    color: "#62C9C3",
                    type: "bar",
                    dataPoints: [
                    ]
                }]
            };




                $.each(rs, function (index, data) {



                        objJS.data[0].dataPoints.push({
                            y: data.bookingRevenue,
                            label: "$"+ format(data.bookingRevenue),
                            indexLabel: data.venName+  " | " +  data.bookingCount,
                            indexLabelFontColor: "green",
                         });


                });




            $("#stat_chartContainerLineTable--barChart").CanvasJSChart(objJS);
        },

    });//EO ajax

}

function toogleDataSeries(e) {
    if (typeof (e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
        e.dataSeries.visible = false;
    } else {
        e.dataSeries.visible = true;
    }
    e.chart.render();
}

function getRandomColor() {
    var r = Math.floor(Math.random() * 256);
    var g = Math.floor(Math.random() * 256);
    var b = Math.floor(Math.random() * 256);
    return "rgb(" + r + "," + g + "," + b + ")";
}





function stat_loadChartByDefaultVal(){

    let today = new Date();
    let year = today.getFullYear();
    let month = today.getMonth() + 1;
    let day = today.getDate();

    month = month.toString().padStart(2, '0');
    day = day.toString().padStart(2, '0');


    let todayStr = `${day}/${month}/${year}`;
    let todayStrSQL = `${year}-${month}-${day}`;

    let lastWeek = new Date(today.getTime() - 30 * 24 * 60 * 60 * 1000); // 使用时间戳计算出7天前的日期
    year = lastWeek.getFullYear();
    month = lastWeek.getMonth() + 1;
    day = lastWeek.getDate();


    month = month.toString().padStart(2, '0');
    day = day.toString().padStart(2, '0');


    let lastWeekStr = `${day}/${month}/${year}`;
    let lastWeekStrSQL = `${year}-${month}-${day}`;


    $(".filter__formInput--date_s").val(lastWeekStrSQL)
    $(".filter__formInput--date_e").val(todayStrSQL)

     let dataToController=([
        {name: 'date_s_0', value: lastWeekStrSQL}
        ,
        {name: 'date_e_0', value: todayStrSQL},
        {name: 'type', value: '2'}
    ])



    stat_getLineChart(dataToController)
    dataToController[2].value=1;
    stat_getBarChart(dataToController)

}


//
// $(".filter__formInput--date").click(function () {
//
//             let date_temp = $(this).val().split('/').reverse().join('-')
//
//             $(this).prop("type","date");
//
//             $(this).val(date_temp);
//
// })
//



$(document).on('change', '.filter__formInput--date_s', function() {

    var $startDateInput = $(this);
    var $endDateInput = $startDateInput.parent().next().find('input');
    var startDate = $startDateInput.val();
    var endDate = $endDateInput.val();
    var tomorrow = new Date();
    tomorrow.setDate(tomorrow.getDate() + 1);

    var currentDate = tomorrow.toISOString().slice(0, 10);
    console.log(currentDate);


    if (startDate > currentDate) {
        $startDateInput.val(currentDate);
        $endDateInput.val(currentDate);
        alert("Please select a date that is on or before today.")
        return true;
    }

    if (startDate > endDate) {
        $endDateInput.val(startDate);
    }


    if (endDate > currentDate) {
        $endDateInput.val(currentDate);
    }
});

$(document).on('change', '.filter__formInput--date_e', function() {
    var $endDateInput = $(this);
    var $startDateInput = $endDateInput.parent().prev().find('input');
    var endDate = $endDateInput.val();
    var startDate = $startDateInput.val();
    var tomorrow = new Date();
    tomorrow.setDate(tomorrow.getDate() + 1);

    var currentDate = tomorrow.toISOString().slice(0, 10);
    console.log(currentDate);




    if (endDate < startDate) {
        $startDateInput.val(endDate);
    }
});


