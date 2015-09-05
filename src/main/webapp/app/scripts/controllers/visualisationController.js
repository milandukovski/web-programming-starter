FirstApp.controller('VisualisationCtrl', [
	'$scope', 
	'$http',
    function($scope, $http) {
		
		$http.get("/data/rest/EventView/all").success(function(data){
			$scope.data = data;
			var s = $scope;
			var numberFormat = d3.format(".2f");
			var monthsName = $scope.monthsName = ["Јан","Фев","Мар","Апр","Мај","Јун","Јул","Авг","Сеп","Окт","Ное","Дек"];
			var dateFormat = d3.time.format("%d/%m/%Y");
			var red = function(){ return 'red'; };
			var green = function(){ return 'green'; };
			
			data.forEach(function (d) {
	            d.dd = d3.time.format("%Y-%m-%d").parse(d.date);
	            d.month = d3.time.month(d.dd); // pre-calculate month for
												// better performance
	        });
			
			// ### Create Crossfilter Dimensions and Groups
			var ndx = s.ndx = crossfilter(data);
			var ndx2 = s.ndx2 = crossfilter(data);
			var ndx3 = s.ndx3 = crossfilter(data);
	        var all = s.all = ndx.groupAll();

	        // Calculate first and last Date
	        var strmDateAccessor = function (d){return d.date;};
	        strmDateExtent = [];
	        strmDateExtent = d3.extent(data, strmDateAccessor);
	        
	        $scope.minDate = strmDateExtent[0];
	        $scope.maxDate = strmDateExtent[1];

    // Good to go
	        // dimension by full date
	        s.dateDimension = ndx.dimension(function (d) {
	            return d.dd;
	        });
	        
	        // dimension by area
	        s.area = ndx.dimension(function (d){
	        	return d.areaName;
	        });
	        
	        s.areaGroup = s.area.group().reduceCount(function (d){
	        	return d.areaId;
	        });
	        
	        // summerize all events by quarter
	        s.quarter = ndx.dimension(function (d) {
	            var month = d.dd.getMonth();
	            if (month <= 2)
	                return "Q1";
	            else if (month > 3 && month <= 5)
	                return "Q2";
	            else if (month > 5 && month <= 8)
	                return "Q3";
	            else
	                return "Q4";
	        });
	        
	        s.quarterGroup = s.quarter.group().reduceCount(function (d) {
	            return d;
	        });
	        
	        // counts per weekday
	        s.dayOfWeek = ndx.dimension(function (d) {
	            var day = d.dd.getDay();
	            day = day == 0 ? 6 : day -1;
	            var name=["Пон","Вто","Сре","Чет","Пет","Саб","Нед"];
	            return day+"."+name[day];
	         });
	        
	        s.dayOfWeekGroup = s.dayOfWeek.group();
	        
	        
	        // time picker
	        s.timeMonths = ndx.dimension(function (d) {
	            return d.month;
	        });
	        
	        s.timeMonthsBenefit = ndx2.dimension(function (d) {
	            return d.month;
	        });
	        
	        s.timeMonthsEventPerCapita = ndx3.dimension(function (d) {
	            return d.month;
	        });
	        
	        // group by total volume within move, and scale down result
	        s.timeByMonthGroup = s.timeMonths.group().reduceCount(function (d) {
	            return d.id;
	        });
	        
	        s.commonAreaDimension = ndx.dimension(function (d) {
	        	return d.commonAreaName;
	        });
	        
	        s.commonAreaGroup = s.commonAreaDimension.group().reduceCount(function (d) {
	        	return d.commonAreaId;
	        });
	        
	        // dimension by month
	        s.monthsDimension = ndx.dimension(function (d) {
	        	var month = d.month.getMonth();
        		return month+"."+monthsName[month];
	        });
	        
	        s.monthsGroup = s.monthsDimension.group();
	        
	        // svr rc dimension
	        s.svrRcDimension = ndx.dimension(function (d) {
	        	return d.svrRcName;
	        });
	        
	        s.svrRcGroup = s.svrRcDimension.group().reduceCount(function (d) {
	        	return d.svrRcId;
	        })
	        
	        s.yearlyDimension = ndx.dimension(function (d) {
	            return d3.time.year(d.dd).getFullYear();
	        });
	        
	        s.yearlyGroup = s.yearlyDimension.group();
	        
	        s.policeStationDimension = ndx.dimension(function (d) {
	        	return d.policeStationName;
	        });
	        
	        s.policeStationGroup = s.policeStationDimension.group().reduceCount(function (d) {
	        	return d.policeStationId;
	        });
	        
	        var num = s.policeStationGroup.size();
	        s.filter = [];
	        var step = Math.round(num/3);
	        var i = 0;
	        
	        while(i < num){
	        	var temp = i + step
	        	temp = temp > num ? num : temp; 
        		s.filter.push({"from":(i),"to": temp});
        		i = temp;
        	}

	        s.n = s.filter[0].from;
	        s.m = s.filter[0].to;
	        
	        s.removeEmptyBins = function (source_group) {
	            function non_zero_pred(d) {
	                return d.value != 0;
	            }
	            return {
	                all: function () {
	                	return this.slice(s.n, s.m);
	                },
	                top: function(n) {
	                    return source_group.top(Infinity)
	                        .filter(non_zero_pred)
	                        .slice(0, n);
	                },
	                slice: function(n,m) {
	                    return source_group.top(Infinity)
	                    .filter(non_zero_pred)
                        .slice(n, m);
	                },
	                allItems: function(){
	                	return source_group.all().filter(non_zero_pred);
	                }
	            };
	        }
	        
	        s.policeStationGroup = s.removeEmptyBins(s.policeStationGroup);

	        s.setActive = function(f){
	        	if(f.from != s.n || f.to != s.m)
	        		return "";
	        	return "active";
	        }
	        
	        s.slice = function(f){
	        	s.n = f.from;
	        	s.m = f.to;
	            dc.redrawAll(1);
	        }
	        
	        s.municipalityDimension = ndx.dimension(function (d) {
	        	return d.municipalityName;
	        });
	        
	        s.municipalityGroup = s.municipalityDimension.group().reduceCount(function (d) {
	        	return d.municipalityId;
	        });
	        
	        s.materialCostsByMonthGroup = s.timeMonths.group().reduceSum(function (d) {
	        	return d.materialCost
	        });
	        
	        s.benefitByMonthGroup = s.timeMonthsBenefit.group().reduceSum(function (d) {
	        	return d.benefit;
	        });
	        
	        s.timeByMonthGroup2 = s.timeMonths.group().reduceCount(function (d) {
	            return d.id;
	        });
	        
	        function reduceAddAvg(p,v) {
        	  ++p.count
        	  p.residents = v.municipalityResidents;
        	  p.perCapita += p.residents*p.count / 100000;
        	  p.benefit += v.benefit;
        	  return p;
        	}
        	function reduceRemoveAvg(p,v) {
        	  --p.count
        	  p.residents -= v.municipalityResidents;
        	  p.perCapita = p.residents*p.count / 100000;
        	  p.benefit -= v.benefit;
        	  return p;
        	}
        	function reduceInitAvg() {
        	  return {count:0, residents:0, perCapita:0, benefit:0};
        	}
        	
	        s.eventPerCapiteGroup = s.timeMonthsEventPerCapita.group().reduce(reduceAddAvg, reduceRemoveAvg, reduceInitAvg);
	        
	        s.timeByMonthGroup3 = s.timeMonths.group().reduceCount(function (d) {
	            return d.id;
	        });
	        
	        // ### Define Chart Attributes
	        
	        s.dayOfWeekPostSetupChart = function(c) {
	            c.label(function(d) {
	                return d.key.split('.')[1];
	            })
	            .title(function(d) {
	                return d.value;
	            })
	            .xAxis().ticks(5);
	        }
	        
	        s.monthsPostSetupChart = function(c) {
	        	c.ordering(function (d) {
	        		return parseInt(d.key.split('.')[0]); 
	        	});
	            c.label(function(d) {
	                return d.key.split('.')[1];
	            })
	            .title(function(d) {
	                return d.value;
	            })
	            .xAxis().ticks(5);
	        }
	        
	        s.fluctuationChartOptions = {
                filterPrinter: function (filters) {
                    var filter = filters[0], s = "";
                    s += numberFormat(filter[0]) + "% -> " + numberFormat(filter[1]) + "%";
                    return s;
                }
            };
            s.fluctuationChartPostSetupChart = function(c) {
                // Customize axis
                c.xAxis().tickFormat(
                    function (v) { return v + "%"; });
                c.yAxis().ticks(5);
            }
	        
	        s.pieChartSetupChart = function(c) {
	            c.label(function(d) {
	                return d.value;
	            });
	        }
	        
	        s.timeBarChartSetup = function(c) {
	            c.yAxis().ticks(0);
	        }
	        
	        s.municipalityBarChartSetup = function(c) {
	        	c.yAxis().ticks(10);
	        	
	            c.renderlet(function (chart) {
	        	   // rotate x-axis labels
	        	   chart.selectAll('g.chart-body')
       	   				.attr('transform', 'translate(40,0)');
	        	   chart.selectAll('g.x text')
	        	   		.attr('transform', 'translate(-30,50) rotate(290)');
	        	   chart.selectAll('g.x')
       	   				.attr('transform', 'translate(40,280)');
	        	   chart.selectAll('g.y')
  	   				.attr('transform', 'translate(40,0)');
	           });
	        }
	        
	        s.policeStationBarChartSetup = function(c) {
	        	c.yAxis().ticks(10);
	        	c.xAxis().tickValues([]);
	        }
	        
	        s.moveChartOptions = {
                title: function (d) {
                    var value = d.value;
                    if (isNaN(value)) value = 0;
                    return "Датум: " + dateFormat(d.key) + 
                    "\nВредност: " + numberFormat(value);
                }
            }
	        
            s.benefitPostSetupChart = function(c) {
	        	c.group(s.benefitByMonthGroup, "Месечен Бенефит", function (d) {
                	return d.value;
                });

                c.renderlet(function (chart) {
 	        	   // rotate x-axis labels
	        	   chart.selectAll('g.chart-body')
		   				.attr('transform', 'translate(60, 35)');
	        	   chart.selectAll('g.x')
	        	   		.attr('transform', 'translate(60,180)');
	        	   chart.selectAll('g.y')
	   					.attr('transform', 'translate(60,35)');
 	        	   chart.selectAll('g.grid-line .horizontal')
 	        	  		.attr('transform', 'translate(60,35)');
 	           });
               c.colors(green);
            }
	        
	        s.materialCostsPostSetupChart = function(c) {
                c.group(s.materialCostsByMonthGroup, "Месечна Материјална Штета", function (d) {
                    return d.value;
                });
                
                c.renderlet(function (chart) {
  	        	   // rotate x-axis labels
  	        	   chart.selectAll('g.chart-body')
     	   				.attr('transform', 'translate(60, 35)');
  	        	   chart.selectAll('g.x')
  	        	   		.attr('transform', 'translate(60,180)');
  	        	   chart.selectAll('g.y')
    	   					.attr('transform', 'translate(60,35)');
  	        	   chart.selectAll('g.grid-line .horizontal')
  	        	  		.attr('transform', 'translate(60,35)');
  	           });
               c.colors(red);
	        }
	        
	        s.eventPerCapitaChartOptions = {
	                valueAccessor: function (d) {
	                    return d.value.perCapita;
	                },
	                // title can be called by any stack layer.
	                title: function (d) {
	                	 var value = d.value.perCapita ? d.value.perCapita : d.value;
	                     if (isNaN(value)) value = 0;
	                     return "Датум: " + dateFormat(d.key) + 
	                     "\nВредност: " + numberFormat(value);
	                }
	        }
	        
	        s.eventPerCapitaPostSetupChart = function(c) {
	        	c.group(s.eventPerCapiteGroup, "Настани по глава на жител", function (d) {
                    return d.value.perCapita;
                });
                c.renderlet(function (chart) {
  	        	   // rotate x-axis labels
  	        	   chart.selectAll('g.chart-body')
     	   				.attr('transform', 'translate(60, 35)');
  	        	   chart.selectAll('g.x')
  	        	   		.attr('transform', 'translate(60,180)');
  	        	   chart.selectAll('g.y')
    	   					.attr('transform', 'translate(60,35)');
  	        	   chart.selectAll('g.grid-line .horizontal')
  	        	  		.attr('transform', 'translate(60,35)');
  	           });
	        }
	        
	        s.resetAll = function(){
//	        	s.dayOfWeek.filterAll();
	        	s.n = s.filter[0].from;
	            s.m = s.filter[0].to;
	            dc.filterAll(1);
	            dc.redrawAll(1);
	        }
		});
    }
]);