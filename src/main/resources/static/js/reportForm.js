/**
 * 
 */

var data= {
			labels : [ "전체", "채널","푸드"],
			datasets : [
					{
						data : [ 10, 40, 20 ],
						backgroundColor: [ 'rgba(180, 160, 160, 1)',
							'rgba(240,102,102,1)',
							'rgba(255, 153, 0,1)',]
					}]
		};
var data2= {
		labels : [ "전체", "채널","푸드"],
		datasets : [
				{
					data : [ 10, 40, 20 ],
					backgroundColor: [ 'rgba(180, 160, 160, 1)',
						'rgba(240,102,102,1)',
						'rgba(255, 153, 0,1)',]
				}]
	};
 var options = {
	//title: { display: true, text: 'Custom Chart Title' },
	responsive: true,
	legend: {
	    display: false, // 상단에 label 값 숨김 
	},
	maintainAspectRatio : false, // default value. false일 경우 포함된 div의 크기에 맞춰서 그려짐.
	scales : {
		yAxes : [ {
			//categoryPercentage: 0.7,
			ticks : {
				beginAtZero : true,
				//scaleLineColor:'transparent',
				display: false
			},
			gridLines : {
				color : 'transparent',
				display: false,
	            //drawBorder: false,
			},
			scaleLabel :{
				display: false
			}
		} ],
	xAxes : [ {
			//barThickness: 5,
			barPercentage: 0.7,
		    categoryPercentage: 1,
			ticks : {
				beginAtZero : true
			},
			gridLines : {
				color : 'transparent',
				display: false,
	            //drawBorder: false
			}
		} ]
	}
};