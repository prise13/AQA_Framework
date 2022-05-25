/*
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
var showControllersOnly = false;
var seriesFilter = "";
var filtersOnlySampleSeries = true;

/*
 * Add header in statistics table to group metrics by category
 * format
 *
 */
function summaryTableHeader(header) {
    var newRow = header.insertRow(-1);
    newRow.className = "tablesorter-no-sort";
    var cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Requests";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 3;
    cell.innerHTML = "Executions";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 7;
    cell.innerHTML = "Response Times (ms)";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Throughput";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 2;
    cell.innerHTML = "Network (KB/sec)";
    newRow.appendChild(cell);
}

/*
 * Populates the table identified by id parameter with the specified data and
 * format
 *
 */
function createTable(table, info, formatter, defaultSorts, seriesIndex, headerCreator) {
    var tableRef = table[0];

    // Create header and populate it with data.titles array
    var header = tableRef.createTHead();

    // Call callback is available
    if(headerCreator) {
        headerCreator(header);
    }

    var newRow = header.insertRow(-1);
    for (var index = 0; index < info.titles.length; index++) {
        var cell = document.createElement('th');
        cell.innerHTML = info.titles[index];
        newRow.appendChild(cell);
    }

    var tBody;

    // Create overall body if defined
    if(info.overall){
        tBody = document.createElement('tbody');
        tBody.className = "tablesorter-no-sort";
        tableRef.appendChild(tBody);
        var newRow = tBody.insertRow(-1);
        var data = info.overall.data;
        for(var index=0;index < data.length; index++){
            var cell = newRow.insertCell(-1);
            cell.innerHTML = formatter ? formatter(index, data[index]): data[index];
        }
    }

    // Create regular body
    tBody = document.createElement('tbody');
    tableRef.appendChild(tBody);

    var regexp;
    if(seriesFilter) {
        regexp = new RegExp(seriesFilter, 'i');
    }
    // Populate body with data.items array
    for(var index=0; index < info.items.length; index++){
        var item = info.items[index];
        if((!regexp || filtersOnlySampleSeries && !info.supportsControllersDiscrimination || regexp.test(item.data[seriesIndex]))
                &&
                (!showControllersOnly || !info.supportsControllersDiscrimination || item.isController)){
            if(item.data.length > 0) {
                var newRow = tBody.insertRow(-1);
                for(var col=0; col < item.data.length; col++){
                    var cell = newRow.insertCell(-1);
                    cell.innerHTML = formatter ? formatter(col, item.data[col]) : item.data[col];
                }
            }
        }
    }

    // Add support of columns sort
    table.tablesorter({sortList : defaultSorts});
}

$(document).ready(function() {

    // Customize table sorter default options
    $.extend( $.tablesorter.defaults, {
        theme: 'blue',
        cssInfoBlock: "tablesorter-no-sort",
        widthFixed: true,
        widgets: ['zebra']
    });

    var data = {"OkPercent": 98.51988899167438, "KoPercent": 1.4801110083256244};
    var dataset = [
        {
            "label" : "FAIL",
            "data" : data.KoPercent,
            "color" : "#FF6347"
        },
        {
            "label" : "PASS",
            "data" : data.OkPercent,
            "color" : "#9ACD32"
        }];
    $.plot($("#flot-requests-summary"), dataset, {
        series : {
            pie : {
                show : true,
                radius : 1,
                label : {
                    show : true,
                    radius : 3 / 4,
                    formatter : function(label, series) {
                        return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;">'
                            + label
                            + '<br/>'
                            + Math.round10(series.percent, -2)
                            + '%</div>';
                    },
                    background : {
                        opacity : 0.5,
                        color : '#000'
                    }
                }
            }
        },
        legend : {
            show : true
        }
    });

    // Creates APDEX table
    createTable($("#apdexTable"), {"supportsControllersDiscrimination": true, "overall": {"data": [0.9315448658649399, 500, 1500, "Total"], "isController": false}, "titles": ["Apdex", "T (Toleration threshold)", "F (Frustration threshold)", "Label"], "items": [{"data": [0.7777777777777778, 500, 1500, "BugReportPost"], "isController": false}, {"data": [0.9947916666666666, 500, 1500, "GetHost"], "isController": false}, {"data": [1.0, 500, 1500, "GetManageCreateUserPage"], "isController": false}, {"data": [0.5677083333333334, 500, 1500, "PostLogin"], "isController": false}, {"data": [0.9, 500, 1500, "CloseIssue-1"], "isController": false}, {"data": [0.96875, 500, 1500, "GetManageUsersPage"], "isController": false}, {"data": [0.6, 500, 1500, "CloseIssue-0"], "isController": false}, {"data": [1.0, 500, 1500, "BugReportPageGet"], "isController": false}, {"data": [1.0, 500, 1500, "PostLogin-2"], "isController": false}, {"data": [0.9642857142857143, 500, 1500, "PostLogin-3"], "isController": false}, {"data": [1.0, 500, 1500, "SendLogin"], "isController": false}, {"data": [0.9574468085106383, 500, 1500, "PostLogin-0"], "isController": false}, {"data": [1.0, 500, 1500, "PostLogin-1"], "isController": false}, {"data": [0.3181818181818182, 500, 1500, "CloseIssue"], "isController": false}, {"data": [0.9523809523809523, 500, 1500, "GetManageProjectPage"], "isController": false}, {"data": [0.9605263157894737, 500, 1500, "GetManagePage"], "isController": false}, {"data": [0.95, 500, 1500, "PostCreateProject"], "isController": false}, {"data": [1.0, 500, 1500, "GetBugsPage"], "isController": false}, {"data": [1.0, 500, 1500, "GetHost-1"], "isController": false}, {"data": [1.0, 500, 1500, "GetHost-0"], "isController": false}, {"data": [0.8636363636363636, 500, 1500, "GetBug"], "isController": false}, {"data": [1.0, 500, 1500, "PostManageProjectCreatePage"], "isController": false}, {"data": [0.9545454545454546, 500, 1500, "ChangeBugStatus"], "isController": false}, {"data": [1.0, 500, 1500, "PostCreateUser"], "isController": false}, {"data": [0.78125, 500, 1500, "PostConfirmEmptyPassword"], "isController": false}]}, function(index, item){
        switch(index){
            case 0:
                item = item.toFixed(3);
                break;
            case 1:
            case 2:
                item = formatDuration(item);
                break;
        }
        return item;
    }, [[0, 0]], 3);

    // Create statistics table
    createTable($("#statisticsTable"), {"supportsControllersDiscrimination": true, "overall": {"data": ["Total", 1081, 16, 1.4801110083256244, 235.5087881591121, 62, 1288, 141.0, 568.2000000000006, 754.9999999999986, 1085.2400000000011, 34.10094637223975, 413.4231134167981, 12.797836159305994], "isController": false}, "titles": ["Label", "#Samples", "FAIL", "Error %", "Average", "Min", "Max", "Median", "90th pct", "95th pct", "99th pct", "Transactions/s", "Received", "Sent"], "items": [{"data": ["BugReportPost", 18, 3, 16.666666666666668, 397.22222222222234, 79, 1111, 166.0, 1057.9, 1111.0, 1111.0, 0.6024096385542169, 6.45492124748996, 0.4506306475903615], "isController": false}, {"data": ["GetHost", 96, 0, 0.0, 199.83333333333334, 135, 502, 190.5, 234.2, 295.99999999999983, 502.0, 3.045975187993781, 16.971340615778786, 0.8566805216232509], "isController": false}, {"data": ["GetManageCreateUserPage", 16, 0, 0.0, 135.56249999999997, 75, 420, 101.5, 311.5000000000001, 420.0, 420.0, 0.5550544647193506, 7.281668188007354, 0.16207156733504474], "isController": false}, {"data": ["PostLogin", 96, 7, 7.291666666666667, 704.4687499999998, 95, 1207, 707.5, 1063.8999999999999, 1130.9499999999998, 1207.0, 3.056935422239205, 109.9999825858171, 3.195658047143676], "isController": false}, {"data": ["CloseIssue-1", 10, 0, 0.0, 364.5, 131, 790, 300.5, 769.5000000000001, 790.0, 790.0, 0.37271710771524413, 7.3188318230525535, 0.19018036013790535], "isController": false}, {"data": ["GetManageUsersPage", 16, 0, 0.0, 273.06250000000006, 112, 679, 238.5, 478.1000000000002, 679.0, 679.0, 0.5528488994851594, 18.30546008474137, 0.157648318993815], "isController": false}, {"data": ["CloseIssue-0", 10, 0, 0.0, 625.9, 439, 829, 644.0, 821.7, 829.0, 829.0, 0.3650567663271639, 0.2288378303763735, 0.2807443393385171], "isController": false}, {"data": ["BugReportPageGet", 18, 0, 0.0, 159.33333333333331, 99, 322, 133.5, 241.0000000000001, 322.0, 322.0, 0.6025911419102139, 12.029689906179907, 0.17124416239831275], "isController": false}, {"data": ["PostLogin-2", 94, 0, 0.0, 125.60638297872345, 67, 395, 99.5, 220.5, 263.5, 395.0, 3.0632861891416283, 17.357613966874144, 0.849074089161181], "isController": false}, {"data": ["PostLogin-3", 56, 0, 0.0, 302.44642857142856, 155, 741, 267.5, 427.5000000000001, 580.15, 741.0, 1.8345017362248575, 91.10058715316451, 0.5159536133132412], "isController": false}, {"data": ["SendLogin", 96, 0, 0.0, 107.96875, 71, 289, 100.5, 154.5, 190.69999999999985, 289.0, 3.057130119100694, 16.292378869180308, 0.9129655853926502], "isController": false}, {"data": ["PostLogin-0", 94, 0, 0.0, 303.2978723404256, 131, 731, 277.0, 480.0, 556.25, 731.0, 3.0437457500890455, 2.499131044992391, 0.9660642080594503], "isController": false}, {"data": ["PostLogin-1", 94, 0, 0.0, 106.54255319148938, 62, 382, 94.0, 146.5, 214.25, 382.0, 3.064984185985849, 1.9138001218657277, 0.9363460456813069], "isController": false}, {"data": ["CloseIssue", 11, 4, 36.36363636363637, 935.8181818181819, 389, 1288, 952.0, 1278.8, 1288.0, 1288.0, 0.3685462525546956, 6.872680880825543, 0.42861824471471166], "isController": false}, {"data": ["GetManageProjectPage", 21, 1, 4.761904761904762, 143.6190476190476, 90, 377, 117.0, 323.0000000000001, 374.79999999999995, 377.0, 0.6873977086743044, 11.565121215220948, 0.18668166939443534], "isController": false}, {"data": ["GetManagePage", 38, 1, 2.6315789473684212, 135.97368421052633, 69, 742, 101.5, 251.1, 334.4499999999988, 742.0, 1.2339264839589559, 14.66074124886349, 0.3508153960741655], "isController": false}, {"data": ["PostCreateProject", 20, 0, 0.0, 293.7, 123, 629, 258.5, 499.50000000000006, 622.6499999999999, 629.0, 0.6911088842047065, 7.316845347109437, 0.352978463319396], "isController": false}, {"data": ["GetBugsPage", 11, 0, 0.0, 143.54545454545453, 112, 227, 129.0, 219.00000000000003, 227.0, 227.0, 0.3669602348545503, 25.58189129428543, 0.10499936407459301], "isController": false}, {"data": ["GetHost-1", 96, 0, 0.0, 103.59375, 64, 409, 95.5, 122.0, 197.19999999999993, 409.0, 3.0556704968647543, 14.907832542890791, 0.5192252602094407], "isController": false}, {"data": ["GetHost-0", 96, 0, 0.0, 96.10416666666666, 63, 344, 93.0, 113.0, 129.0999999999997, 344.0, 3.0552814996340025, 2.117258113602368, 0.3401387607014417], "isController": false}, {"data": ["GetBug", 11, 0, 0.0, 359.8181818181818, 180, 730, 282.0, 701.2, 730.0, 730.0, 0.3668011604254893, 10.450674361849345, 0.18681980267764847], "isController": false}, {"data": ["PostManageProjectCreatePage", 20, 0, 0.0, 111.10000000000001, 90, 177, 103.0, 148.20000000000002, 175.59999999999997, 177.0, 0.6929766813346732, 9.033330012820068, 0.3072377083261148], "isController": false}, {"data": ["ChangeBugStatus", 11, 0, 0.0, 271.6363636363636, 128, 630, 200.0, 587.0000000000001, 630.0, 630.0, 0.36844749623178696, 7.273305350862502, 0.26325154915424553], "isController": false}, {"data": ["PostCreateUser", 16, 0, 0.0, 152.37500000000003, 72, 348, 116.5, 295.50000000000006, 348.0, 348.0, 0.5541509368614276, 6.064949303847885, 0.2858693675752433], "isController": false}, {"data": ["PostConfirmEmptyPassword", 16, 0, 0.0, 435.68750000000006, 245, 812, 428.5, 674.8000000000002, 812.0, 812.0, 0.5455723394823881, 5.824743943294575, 0.28837014525863536], "isController": false}]}, function(index, item){
        switch(index){
            // Errors pct
            case 3:
                item = item.toFixed(2) + '%';
                break;
            // Mean
            case 4:
            // Mean
            case 7:
            // Median
            case 8:
            // Percentile 1
            case 9:
            // Percentile 2
            case 10:
            // Percentile 3
            case 11:
            // Throughput
            case 12:
            // Kbytes/s
            case 13:
            // Sent Kbytes/s
                item = item.toFixed(2);
                break;
        }
        return item;
    }, [[0, 0]], 0, summaryTableHeader);

    // Create error table
    createTable($("#errorsTable"), {"supportsControllersDiscrimination": false, "titles": ["Type of error", "Number of errors", "% in errors", "% in all samples"], "items": [{"data": ["The operation lasted too long: It took 1&nbsp;060 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1, 6.25, 0.09250693802035152], "isController": false}, {"data": ["The operation lasted too long: It took 1&nbsp;242 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1, 6.25, 0.09250693802035152], "isController": false}, {"data": ["The operation lasted too long: It took 1&nbsp;052 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1, 6.25, 0.09250693802035152], "isController": false}, {"data": ["Non HTTP response code: java.net.SocketException/Non HTTP response message: Socket closed", 5, 31.25, 0.46253469010175763], "isController": false}, {"data": ["The operation lasted too long: It took 1&nbsp;025 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1, 6.25, 0.09250693802035152], "isController": false}, {"data": ["The operation lasted too long: It took 1&nbsp;288 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1, 6.25, 0.09250693802035152], "isController": false}, {"data": ["The operation lasted too long: It took 1&nbsp;111 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1, 6.25, 0.09250693802035152], "isController": false}, {"data": ["The operation lasted too long: It took 1&nbsp;103 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1, 6.25, 0.09250693802035152], "isController": false}, {"data": ["The operation lasted too long: It took 1&nbsp;073 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1, 6.25, 0.09250693802035152], "isController": false}, {"data": ["The operation lasted too long: It took 1&nbsp;203 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1, 6.25, 0.09250693802035152], "isController": false}, {"data": ["The operation lasted too long: It took 1&nbsp;082 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1, 6.25, 0.09250693802035152], "isController": false}, {"data": ["The operation lasted too long: It took 1&nbsp;074 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1, 6.25, 0.09250693802035152], "isController": false}]}, function(index, item){
        switch(index){
            case 2:
            case 3:
                item = item.toFixed(2) + '%';
                break;
        }
        return item;
    }, [[1, 1]]);

        // Create top5 errors by sampler
    createTable($("#top5ErrorsBySamplerTable"), {"supportsControllersDiscrimination": false, "overall": {"data": ["Total", 1081, 16, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Socket closed", 5, "The operation lasted too long: It took 1&nbsp;073 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1, "The operation lasted too long: It took 1&nbsp;203 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1, "The operation lasted too long: It took 1&nbsp;060 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1, "The operation lasted too long: It took 1&nbsp;242 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1], "isController": false}, "titles": ["Sample", "#Samples", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors"], "items": [{"data": ["BugReportPost", 18, 3, "The operation lasted too long: It took 1&nbsp;052 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1, "The operation lasted too long: It took 1&nbsp;025 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1, "The operation lasted too long: It took 1&nbsp;111 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1, null, null, null, null], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": ["PostLogin", 96, 7, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Socket closed", 2, "The operation lasted too long: It took 1&nbsp;073 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1, "The operation lasted too long: It took 1&nbsp;203 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1, "The operation lasted too long: It took 1&nbsp;060 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1, "The operation lasted too long: It took 1&nbsp;082 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": ["CloseIssue", 11, 4, "The operation lasted too long: It took 1&nbsp;242 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Socket closed", 1, "The operation lasted too long: It took 1&nbsp;288 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1, "The operation lasted too long: It took 1&nbsp;103 milliseconds, but should not have lasted longer than 1&nbsp;000 milliseconds.", 1, null, null], "isController": false}, {"data": ["GetManageProjectPage", 21, 1, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Socket closed", 1, null, null, null, null, null, null, null, null], "isController": false}, {"data": ["GetManagePage", 38, 1, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Socket closed", 1, null, null, null, null, null, null, null, null], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}]}, function(index, item){
        return item;
    }, [[0, 0]], 0);

});
