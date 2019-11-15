
var categoryData ={
		labels : [ "갯수"],
		datasets : [
				{
					data : [ 3],
					backgroundColor: [ 'rgba(255, 153, 0,1)',]
				},
				{
					data : [1],
					backgroundColor: [ 'rgba(255, 153, 0,0.5)',]
				}]
	};
var ratingData ={
		labels : [ "평점"],
		datasets : [
				{
					data : [8.4],
					backgroundColor: [ 
						'rgba(255,204,0,1)',]
				},{
					data : [1.6],
					backgroundColor: [ 
						'rgba(180, 160, 160, 0.2)',]
				}]
	};
var viewData= {
			labels : [ "전체", "채널","푸드"],
			datasets : [
					{
						data : [ 10, 40, 20 ],
						backgroundColor: [ 'rgba(255, 153, 0,0.2)',
							'rgba(255, 153, 0,0.6)',
							'rgba(255, 153, 0,1)',]
					}]
		};
var chatData= {
		labels : [ "전체", "채널","푸드"],
		datasets : [
				{
					data : [ 761, 6200, 5020 ],
					backgroundColor: [ 'rgba(255, 153, 0,0.2)',
						'rgba(255, 153, 0,0.6)',
						'rgba(255, 153, 0,1)',]
				}]
	};
var buyData= {
		labels : [ "전체", "채널","푸드"],
		datasets : [
				{
					data : [ 761, 6200, 5020 ],
					backgroundColor: [ 'rgba(255, 153, 0,0.2)',
						'rgba(255, 153, 0,0.6)',
						'rgba(255, 153, 0,1)',]
				}]
	};
var ERData= {
		labels : [ "전체", "채널","푸드"],
		datasets : [
				{
					data : [ 761, 6200, 5020 ],
					backgroundColor: [ 'rgba(255, 153, 0,0.2)',
						'rgba(255, 153, 0,0.6)',
						'rgba(255, 153, 0,1)',]
				}]
	};
var genderData={
		labels:['여성','남성'],
		datasets:[{
			data: [52,47],
			backgroundColor: [ 'rgba(255, 102, 102, 1)',
				'rgba(0,153,255,1)',]
		}]

}
var ageData={
		labels:['10대','20대','30대','40대','50대','60대'],
		datasets:[{
			data: [23,27,20,20,10,0],
			backgroundColor: [ 'rgba(000,153,204,1)',
				'rgba(255,153,102,1)',
				'rgba(255,204,0,1)',
				'rgba(204,153,153,1)',
				'rgba(204,102,102,1)',
				'rgba(204,153,102,1)',]
		}]

}
var growData={
		labels:['8','9','10','11'],
		datasets:[{
			data: [100,120,200,300],
			backgroundColor:['rgba(255,255,255,0)'],
			borderColor : ['rgba(255, 153, 0,1)'],
			hoverBorderColor :['rgba(255, 153, 0,1)']
		}]
}
 var options = {
	title: { display: true, fontSize:15,},
	responsive: true,
	legend: {
		position: 'right',
	    display: false, // 상단에 label 값 숨김 
	    labels: { 
	    	boxWidth:20
	    }
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
				//display: true
			}
		} ],
	xAxes : [ {
			//barThickness: 5,
			barPercentage: 0.7,
		    categoryPercentage: 1,
			ticks : {
				beginAtZero : true
				//display: false
			},
			gridLines : {
				color : 'transparent',
				display: false,
	            //drawBorder: false
			},
			scaleLabel :{
				//display: false
			}
		} ]
	}
};