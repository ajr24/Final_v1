package com.afkl.cases.df.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CounterStatus {
	
	FARES_200_STATUS("counter.status.200.fares.fromDestination.toDestination"),
	FARES_500_STATUS("counter.status.500.fares.fromDestination.toDestination"),
	FARES_400_STATUS("counter.status.400.fares.fromDestination.toDestination"),
	MONITOR_200_STATUS("counter.status.200.monitor"),
	MONITOR_400_STATUS("counter.status.400.monitor"),
	MONITOR_500_STATUS("counter.status.500.monitor"),
	METRICS_200_STATUS("counter.status.200.metrics"),
	METRICS_400_STATUS("counter.status.400.metrics"),
	METRICS_500_STATUS("counter.status.500.metrics"),
	AIRPORTS_200_STATUS("counter.status.200.airports"),
	AIRPORTS_400_STATUS("counter.status.400.airports"),
	_404_STATUS("counter.status.404.error"),
	AIRPORTS_500_STATUS("counter.status.500.airports");
	
	private String key;
	
	CounterStatus(String key){
		this.key = key;
	}
	
	public String getKey(){
		return key;
	}
	
	public static List<CounterStatus> getUriStatusKeyByCode(String statusCode){
		List<CounterStatus> list = Arrays.asList(CounterStatus.values());
		return list
			.stream()
			.filter(counterStatus-> counterStatus.key.contains(statusCode))
			.collect(Collectors.toList());
	}

	
	public static List<CounterStatus> getUriStatusKeyByCodeAndUri(String statusCode, String uri){
		List<CounterStatus> list = Arrays.asList(CounterStatus.values());
		return list
			.stream()
			.filter(counterStatus-> (counterStatus.key.contains(statusCode) && counterStatus.key.contains(statusCode)))
			.collect(Collectors.toList());
	}
}
