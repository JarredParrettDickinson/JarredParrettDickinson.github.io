---
layout: post
title:  "Network Analysis of 2010 US Flights -  Applied Empirical Analysis of Data"
date:   2020-04-24 3:44:00 -0500
categories: Applied Empirical Analysis of Data
---

# Question: The importance of a singular airport within the airport network can be determined by measuring the degree centrality, the ratio of edges in and out, of it. **TRUE**


## Data
At the beginning of the Applied Empirical Analysis of Data (AEAD) class Professor Erfle tasked us with finding a dataset that both interested us and was suitable for analysis. From the start, I had an interest in flights as I had once adopted TensorFlow machine learning libraries to construct a tool to estimate flight delays and diversions on flights destined for Aspen, CO.

{% include US_ROUTE_MAP.html %}

The source of the data is available through the Bureau of Transportation Statistics (BTS) and is reported on a monthly basis under the title of[ On-Time: Reporting Carrier On-Time Performance (1987-present)](https://www.transtats.bts.gov/DL_SelectFields.asp?Table_ID=236&DB_Short_Name=On-Time " On-Time: Reporting Carrier On-Time Performance (1987-present)"). The data consists of 109 variable including geographic, temporal and indicator of events. The below section provides a complete list of the statistics descriptions. 

<details>
<summary>BTS Variables</summary>
<br>
<ul>
<li>Time Period</li>
<ul>
<li>Year: Year</li>
<li>Quarter: Quarter (1-4)</li>
<li>Month: Month</li>
<li>DayofMonth: Day of Month</li>
<li>DayOfWeek: Day of Week</li>
<li>FlightDate: Flight Date (yyyymmdd)</li>
</ul>
<li>Airline</li>
<ul>
<li>Reporting_Airline: Unique Carrier Code. When the same code has been used by multiple carriers, a numeric suffix is used for earlier users, for example, PA, PA(1), PA(2). Use this field for analysis across a range of years.</li>
<li>DOT_ID_Reporting_Airline: An identification number assigned by US DOT to identify a unique airline (carrier). A unique airline (carrier) is defined as one holding and reporting under the same DOT certificate regardless of its Code, Name, or holding company/corporation.</li>
<li>IATA_CODE_Reporting_Airline	Code assigned by IATA and commonly used to identify a carrier. As the same code may have been assigned to different carriers over time, the code is not always unique. For analysis, use the Unique Carrier Code.</li>
<li>Tail_Number: Tail Number	</li>
<li>Flight_Number_Reporting_Airline: Flight Number</li>
</ul>
 <li>Origin	</li>
<ul>
<li>OriginAirportID: Origin Airport, Airport ID. An identification number assigned by US DOT to identify a unique airport. Use this field for airport analysis across a range of years because an airport can change its airport code and airport codes can be reused.</li>
<li>OriginAirportSeqID: Origin Airport, Airport Sequence ID. An identification number assigned by US DOT to identify a unique airport at a given point of time. Airport attributes, such as airport name or coordinates, may change over time.	</li>
<li>OriginCityMarketID: Origin Airport, City Market ID. City Market ID is an identification number assigned by US DOT to identify a city market. Use this field to consolidate airports serving the same city market.	</li>
<li>Origin: Origin Airport</li>
<li>OriginCityName: Origin Airport, City Name</li>
<li>OriginState: Origin Airport, State Code</li>
<li>OriginStateFips: Origin Airport, State Fips</li>
<li>OriginStateName: Origin Airport, State Name</li>
<li>OriginWac: Origin Airport, World Area Code</li>
</ul>
<li>Destination			</li>
<ul>
<li>DestAirportID: Destination Airport, Airport ID. An identification number assigned by US DOT to identify a unique airport. Use this field for airport analysis across a range of years because an airport can change its airport code and airport codes can be reused.		</li>
<li>DestAirportSeqID: Destination Airport, Airport Sequence ID. An identification number assigned by US DOT to identify a unique airport at a given point of time. Airport attributes, such as airport name or coordinates, may change over time.		</li>
<li>DestCityMarketID: Destination Airport, City Market ID. City Market ID is an identification number assigned by US DOT to identify a city market. Use this field to consolidate airports serving the same city market.		</li>
<li>Dest: Destination Airport		</li>
<li>DestCityName: Destination Airport, City Name		</li>
<li>DestState: Destination Airport, State Code		</li>
<li>DestStateFips: Destination Airport, State Fips		</li>
<li>DestStateName: Destination Airport, State Name		</li>
<li>DestWa: Destination Airport, World Area Code</li>
</ul>
<li>Departure Performance			</li>
<ul>
<li>CRSDepTime: CRS Departure Time (local time: hhmm)		</li>
<li>DepTime: Actual Departure Time (local time: hhmm)		</li>
<li>DepDelay: Difference in minutes between scheduled and actual departure time. Early departures show negative numbers.		</li>
<li>DepDelayMinutes: Difference in minutes between scheduled and actual departure time. Early departures set to 0.		</li>
<li>DepDel15: Departure Delay Indicator, 15 Minutes or More (1=Yes)		</li>
<li>DepartureDelayGroups: Departure Delay intervals, every (15 minutes from <-15 to >180)		</li>
<li>DepTimeBlk: CRS Departure Time Block, Hourly Intervals		</li>
<li>TaxiOut: Taxi Out Time, in Minutes		</li>
<li>WheelsOff: Wheels Off Time (local time: hhmm)</li>
</ul>
<li>Arrival Performance			</li>
<ul>
<li>WheelsOn: Wheels On Time (local time: hhmm)		</li>
<li>TaxiIn: Taxi In Time, in Minutes		</li>
<li>CRSArrTime: CRS Arrival Time (local time: hhmm)		</li>
<li>ArrTime: Actual Arrival Time (local time: hhmm)		</li>
<li>ArrDelay: Difference in minutes between scheduled and actual arrival time. Early arrivals show negative numbers.		</li>
<li>ArrDelayMinutes: Difference in minutes between scheduled and actual arrival time. Early arrivals set to 0.		</li>
<li>ArrDel15: Arrival Delay Indicator, 15 Minutes or More (1=Yes)		</li>
<li>ArrivalDelayGroups: Arrival Delay intervals, every (15-minutes from <-15 to >180)</li>
<li>ArrTimeBlk: CRS Arrival Time Block, Hourly Intervals</li>
</ul>
</ul>
<br><br>
</details>

While the data did include names and information on flights including origin and destination, it did not provide the longitude and latitude location information for these airports. To cope with this, the [OpenFlights](https://openflights.org/data.html "OpenFlights") data set was used to get airport location information. Note, the following analysis could be adopted for the world network with relatively little alteration. The variable information for the OpenFlights dataset may be found in the below expandable section. If you visit both sections, you will notice there are many variables that overlap - e.g. IATA.

<details>
<summary>OpenFlights Variables</summary>
<br>
<ul>
<li>Airport ID: Unique OpenFlights identifier for this airport.</li>
<li>Name: Name of airport. May or may not contain the City name.</li>
<li>City: Main city served by airport. May be spelled differently from Name.</li>
<li>Country: Country or territory where airport is located. See Countries to cross-reference to ISO 3166-1 codes.</li>
<li>IATA: 3-letter IATA code. Null if not assigned/unknown.</li>
<li>ICAO: 4-letter ICAO code.</li>
<li>Latitude: Decimal degrees, usually to six significant digits. Negative is South, positive is North.</li>
<li>Longitude: Decimal degrees, usually to six significant digits. Negative is West, positive is East.</li>
<li>Altitude: In feet.</li>
<li>Timezone: Hours offset from UTC. Fractional hours are expressed as decimals, eg. India is 5.5.</li>
<li>DST	Daylight savings time. One of E (Europe), A (US/Canada), S (South America), O (Australia), Z (New Zealand), N (None) or U (Unknown). See also: Help: Time</li>
<li>Tz database time zone: Timezone in "tz" (Olson) format, eg. "America/Los_Angeles".</li>
<li>Type: Type of the airport. Value "airport" for air terminals, "station" for train stations, "port" for ferry terminals and "unknown" if not known. In airports.csv, only type=airport is included.</li>
<li>Source: Source of this data. "OurAirports" for data sourced from OurAirports, "Legacy" for old data not matched to OurAirports (mostly DAFIF), "User" for unverified user contributions. In airports.csv, only source=OurAirports is included.</li>
</ul>
 <br><br>
</details>

## Examining the Data
The data from the BTS for 2010 is comprised of 6,450,117 flights from 305 different airports across the United States. For each flight, they include the date of the flight, origin, destination, time, market id, computerized reservation system (CRS) departure time, CRS arrival time, the actual time of arrival, delay information along with reasons, carrier name, and much more. I note this as it equips researchers with knowledge of parsing to effectively much more information from this dataset. 


### Types of Analysis
As this is a list of flights, the frame of analysis appears to be relatively restricted to looking at statistics such as average delay, delay reasons, most commonly delayed carriers, and airports with the most traffic. However, there is a subsection of analysis that may be conducted with interpretation of the data. That is, with the construction of a graph/network comprised of nodes and edges. For example, with this approach, the importance of airports based on other factors when considering a network. 

By iterating over the dataset and identifying all unique airports and building a collection of nodes and then using all unique flight paths - that is an origin to destination - a graph may be constructed. Through the use of tools such as [NetworkX](https://networkx.github.io/ "NetworkX") - “NetworkX is a Python package for the creation, manipulation, and study of the structure, dynamics, and functions of complex networks.” - additional traits may be examined such as degree centrality, clustering coefficient, congestion, and more.

For my analysis, I will begin by taking a global look at the airnetwork of the United States and further narrowing down on carrier networks and finally visiting the traits of individual aircraft - however, at the time of publishing this (4/27/20), the aircraft portion was not complete. This document will contain some pseudo code for the purpose that it is a computer scinence blog. While this will exmine the data, it is by no means a completely a comprehensive coverage and I encougage anyone interested to reach out for conversation and further exploration.

## General Statistics
A relatively intuitive starting point is to begin the analysis of the flight data by simply looking at the arrival and departure data for each airport. In the below figures, you can find the histograms for the variables of arrival and departure delay - note, the dataset conviently bins these variables into 15 minute sections to make plotting on historgram easy. It can be seen that the majority of time flights actually take off eariler than their CRS departure time. Futher, these flights will arrive earlier than expected on the destination side as well.  
<br />
**figure 1: Departure and Arrival Histogram**
![US_ARR_DEP_DELAY](/assets/DEP_ARR_DELAY_GROUP.png)

This data begins the process of understanding the data but can, in fact, be presented in a more dynamic fashion. That is, a delay will not be as taxing on the network if it occurs at a relatively small airport as comparted to a large one. The below interactive figure provides the data in the above histograms with the additon of a the perspective of the airports percentage of flgiht traffic as the color and size being mean delay at that airport.  
<br />
**figure 2a: US Departure Delay Map**
{% include US_DEP_MAP.html %}
<br />
**figure 2b: US Arrival Delay Map**
{% include US_ARR_MAP.html %}

This may be a relatively counterintuitive idea at this point as we are analyzing these as individuals and not as a network. As this analysis is continued, it will become appearnent that the delay at Atlanta will then reverberate to the next airport given the aircraft link these two nodes.

## Network Analysis
As stated above, it can be difficult to understanding the interconnected nature of the network without modeling and understanding importance within a graph. The following analysis will be of the US flights network with respect to graph traits. As an aside before presenting findings, I willprovide a brief vocab section on graph terms.
<details>
<summary> Graph Vocab </summary>
<br>
<ul>
<li>Node: an airport within the network</li>
<li>Edge: flight route between two airports</li>
<li>Degree: number of incoming and outgoing edges from a node</li>
<li>Degree Centrality: measure that counts how many neighbors a node has</li>
<li>Center: A vertex is central in G if its greatest distance from any other vertex is as small as possible </li>
<li>Clustering Coefficient: clustering coefficient is a measure of the degree to which nodes in a graph tend to cluster together.</li>
<li>Partition: the reduction of a graph to a smaller graph by partitioning its set of nodes into mutually exclusive groups</li>
</ul>
 <br><br>
</details>

When starting with networks, one can lok to the tools of networks to identify the importance of measures such as degree, center, and clustering coefficient. The questions that will be asked are what is the center of the graph, what is the most important node within the graph, are there any partitions, what is the clustering coefficient for nodes as related to degree centrality.

#### Degree Centrality
Using the NetworkX library, the degree centrality may be found by finding the value for (edges)/(n-1). To better understand the relation of centrality the following chart provides the scatterplot of centrality measure to percentage of airtraffic at an airport. In figure 3, there is the relation of centrality with size where size is the percent of air traffic and color is the centrality. The positive relation between the two metrics may be seen with the additional plotting below - figure 4 - with trendline. 

<br />
**figure 3** US Centrality Map  
{% include US_CT_MAP.html %}

<br />
**figure 4**:Centrality x Percent of Air Traffic  
{% include CT_PCT.html %}

#### Paritions and Center
The partition of a graph can provide a peprsepctive which may better identify the significane of airports. That is, there are paritions within the graph such as the Alaska paritions which may distort what the center of a graph looks like. Note the paprtitions below demonstrate there is an Alaskan partition of airports, partition 2 and 3,  which are highly connected sections. While relevant to the overall graph, when considering the amount of travel on the Alaskan partitions, a questions may be asked if they are that important. With this partition included, it resulted in **Seattle-Tacoma International Airport** being the center of the network.
- partition 1: 
['Dayton, OH: James M Cox/Dayton International', 'Tulsa, OK: Tulsa International', 'Dubuque, IA: Dubuque Regional', 'Washington, DC: Ronald Reagan Washington National', … 'Dallas, TX: Dallas Love Field']

* partition 2:
['King Salmon, AK: King Salmon Airport', 'Anchorage, AK: Ted Stevens Anchorage International', 'Dillingham, AK: Dillingham Airport', 'Bethel, AK: Bethel Airport', 'Deadhorse, AK: Deadhorse Airport', 'Barrow, AK: Wiley Post/Will Rogers Memorial', 'Nome, AK: Nome Airport', 'Kotzebue, AK: Ralph Wien Memorial', 'Adak Island, AK: Adak', 'Kodiak, AK: Kodiak Airport']

* partition 3:
['Juneau, AK: Juneau International', 'Wrangell, AK: Wrangell Airport', 'Sitka, AK: Sitka Rocky Gutierrez', 'Ketchikan, AK: Ketchikan International', 'Yakutat, AK: Yakutat Airport', 'Cordova, AK: Merle K Mudhole Smith', 'Gustavus, AK: Gustavus Airport', 'Petersburg, AK: Petersburg James A Johnson']

When we remove partition 3, Alaska, the resulting center becomes **Denver International Airport**.

#### Takeaways
In the two previous sections, much has been discussed from concepts of graphs to the applications of them to networks. It has been established that there are metrics by which we may measure the same things as percentage of traffic within a network by adopting centrality -  with a .88 r-squared. Further, with the discussion of partitions and center, the application of centrality finds relevance with the high value of Denver as compared to Seattle. This leads to further evidence that the main partition, as expected, is the lower-48.

------------

## Network Analysis on SubNetworks - Carriers
As seen up to this point, network analysis may be applied to the entire US flight network. However, when considering practical applications, this may not be the best approach as flight carriers may not be interested in this information as they only serve specific markets. To combat this, the same tools may be applied to subnetworks which are subsets of the dataset.

Within the dataset, there are 18 unique carriers each with their own interconnected networks. For the following analysis, the departure delay and arrival delay metrics have been bypassed in favor of looking into the relation of centrality with percent of network traffic and centrality and mean delay.

### Takeaways
As the data below is quite space intensive given the limited abilities of markdown and its collapsable sections, the takeaways will be discussed prior to presentation. Of the following, it can be noted that firms may be more inclined to use measures of centrality as indicators of importance for the channeling of resources. While all show a level of positive significance, some exhibit more than others. Therfore, this may be a better metric for some firms than others. 

#### Network Overall
- Number of Airports: 305
- Number of Routes: 4622
- Mean Arr Delay: 4.1021
- Mean Dep Delay: 8.2613
- Mean Carrier Delay: 16.3569
- Mean Weather Delay: 2.3706
- Mean Late Aircraft Delay: 21.2091
- R-Squared traffic x centrentality: .88

{% include  graph_carrier_stats_a.html %}
{% include  graph_carrier_stats_be.html %}
(*note: ExpressJet Airlines Inc. (2012 - 2019) is Atlantic Southeast Airlines (1993 - 2011)*)

#### Pinnacle Airlines
- Number of Airports: 147
- Number of Routes: 781
- Mean Arr Delay: 3.8666
- Mean Dep Delay: 7.2538
- Mean Carrier Delay: 19.2087
- Mean Weather Delay: 2.5398
- Mean Late Aircraft Delay: 19.6674
- R-Squared traffic x centrentality: .88
- Density: 0.0372



**Centrality x Traffic**  
{% include  centrality_Pinnacle_Airlines.html %}
{% include  route_Pinnacle_Airlines.html %}

#### American Airlines
- Number of Airports: 80
- Number of Routes: 400
- Mean Arr Delay: 3.8215
- Mean Dep Delay: 8.7133
- Mean Carrier Delay: 20.1099
- Mean Weather Delay: 3.6168
- Mean Late Aircraft Delay: 17.2126
- R-Squared traffic x centrentality: .77
- Density: 0.0636


**Centrality x Traffic**  
{% include  centrality_American_Airlines.html %}
{% include  route_American_Airlines.html %}

#### Alaska Airlines
- Number of Airports: 53
- Number of Routes: 181
- Mean Arr Delay: -2.3741
- Mean Dep Delay: 1.3768
- Mean Carrier Delay: 15.1059
- Mean Weather Delay: 1.8455
- Mean Late Aircraft Delay: 16.1838
- R-Squared traffic x centrentality: .92
- Density: 0.0675



**Centrality x Traffic**  
{% include  centrality_Alaska_Airlines.html %}
{% include  route_Alaska_Airlines.html %}


#### JetBlue Airways
 - Number of Airports: 50
 - Number of Routes: 259
 - Mean Arr Delay: 6.4605
 - Mean Dep Delay: 11.5178
 - Mean Carrier Delay: 21.1683
 - Mean Weather Delay: 1.2981
 - Mean Late Aircraft Delay: 21.7439
 - R-Squared traffic x centrentality: .96
 - Density: 0.1102
 
**Centrality x Traffic**  
{% include  centrality_JetBlue_Airways.html %}
{% include  route_JetBlue_Airways.html %}


#### Continental Airlines
- Number of Airports: 67
- Number of Routes: 256
- Mean Arr Delay: 3.4017
- Mean Dep Delay: 7.7463
- Mean Carrier Delay: 14.7957
- Mean Weather Delay: 2.3685
- Mean Late Aircraft Delay: 11.7919
- R-Squared traffic x centrentality: .96
- Density: 0.0592


**Centrality x Traffic**  
{% include  centrality_Continental_Air_Lines.html  %}
{% include  route_Continental_Air_Lines.html %}


#### Delta Airlines
- Number of Airports: 135
- Number of Routes: 854
- Mean Arr Delay: 5.5136
- Mean Dep Delay: 9.8842
- Mean Carrier Delay: 19.475
- Mean Weather Delay: 2.549
- Mean Late Aircraft Delay: 17.2881
- R-Squared traffic x centrentality: .88
- Density: 0.0481


**Centrality x Traffic**  
{% include  centrality_Delta_Air_Lines.html %}
{% include  route_Delta_Air_Lines.html %}


#### American Eagle Airlines
- Number of Airports: 139
- Number of Routes: 436
- Mean Arr Delay: 6.2021
- Mean Dep Delay: 8.2594
- Mean Carrier Delay: 15.95
- Mean Weather Delay: 4.0574
- Mean Late Aircraft Delay: 20.1839
- R-Squared traffic x centrentality: .97
- Density: 0.0227


**Centrality x Traffic**  
{% include  centrality_American_Eagle_Airlines.html %}
{% include  route_American_Eagle_Airlines.html %}


#### PSA Airlines
- Number of Airports: 113
- Number of Routes: 728
- Mean Arr Delay: 7.4982
- Mean Dep Delay: 9.7203
- Mean Carrier Delay: 26.9148
- Mean Weather Delay: 6.8779
- Mean Late Aircraft Delay: 4.4049
- R-Squared traffic x centrentality: .72
- Density: 0.0593

**Centrality x Traffic**  
{% include  centrality_PSA_Airlines.html %}
{% include  route_PSA_Airlines.html %}


#### SkyWest Airlines
- Number of Airports: 160
- Number of Routes: 921
- Mean Arr Delay: 6.2429
- Mean Dep Delay: 7.645
- Mean Carrier Delay: 12.4105
- Mean Weather Delay: 1.3412
- Mean Late Aircraft Delay: 27.8823
- R-Squared traffic x centrentality: .817
- Density: 0.0381

**Centrality x Traffic**  
{% include  centrality_SkyWest_Airlines.html %}
{% include  route_SkyWest_Airlines.html %}


#### United Air Lines
- Number of Airports: 78
- Number of Routes: 380
- Mean Arr Delay: -4.0139
- Mean Dep Delay: 6.0763
- Mean Carrier Delay: 14.5705
- Mean Weather Delay: 1.709
- Mean Late Aircraft Delay: 25.0573
- R-Squared traffic x centrentality: .95
- Density: 0.0666


**Centrality x Traffic**  
{% include  centrality_United_Air_Lines.html %}
{% include  route_United_Air_Lines.html %}


#### US Airways
- Number of Airports: 84
- Number of Routes: 351
- Mean Arr Delay: 0.5104
- Mean Dep Delay: 3.183
- Mean Carrier Delay: 13.8995
- Mean Weather Delay: 1.5026
- Mean Late Aircraft Delay: 14.4317
- R-Squared traffic x centrentality: .97
- Density: 0.0508


**Centrality x Traffic**  
{% include  centrality_US_Airways.html %}
{% include  route_US_Airways.html %}


#### Southwest Airlines
- Number of Airports: 69
- Number of Routes: 959
- Mean Arr Delay: 4.7902
- Mean Dep Delay: 11.3448
- Mean Carrier Delay: 12.939
- Mean Weather Delay: 1.7841
- Mean Late Aircraft Delay: 25.3732
- R-Squared traffic x centrentality: .85
- Density: 0.2046

**Centrality x Traffic**  
{% include  centrality_Southwest_Airlines.html %}
{% include  route_Southwest_Airlines.html %}


#### Mesa Airlines
 - Number of Airports: 118
 - Number of Routes: 419
 - Mean Arr Delay: 2.9946
 - Mean Dep Delay: 4.5988
 - Mean Carrier Delay: 19.53
 - Mean Weather Delay: 2.4514
 - Mean Late Aircraft Delay: 21.5251
 - R-Squared traffic x centrentality: .72
 - Density: 0.0313

 
**Centrality x Traffic**  
{% include  centrality_Mesa_Airlines.html %}
{% include  route_Mesa_Airlines.html %}


#### ExpressJet Airlines
- Number of Airports: 122
- Number of Routes: 559
- Mean Arr Delay: 6.9092
- Mean Dep Delay: 7.7848
- Mean Carrier Delay: 13.6902
- Mean Weather Delay: 1.9729
- Mean Late Aircraft Delay: 21.8362
- R-Squared traffic x centrentality: .84
- Density: 0.0383

**Centrality x Traffic**  
{% include  centrality_ExpressJet_Airlines_06_11.html %}
{% include  route_ExpressJet_Airlines.html %}


#### Frontier Airlines
- Number of Airports: 54
- Number of Routes: 133
- Mean Arr Delay: 4.6572
- Mean Dep Delay: 6.6031
- Mean Carrier Delay: 10.6675
- Mean Weather Delay: 0.8233
- Mean Late Aircraft Delay: 24.1998
- R-Squared traffic x centrentality: .95
- Density: 0.0496

**Centrality x Traffic**  
{% include  centrality_Frontier_Airlines.html %}
{% include  route_Frontier_Airlines.html %}

#### AirTran Airways
- Number of Airports: 66
- Number of Routes: 363
- Mean Arr Delay: 2.9649
- Mean Dep Delay: 6.037
- Mean Carrier Delay: 10.0695
- Mean Weather Delay: 0.8456
- Mean Late Aircraft Delay: 28.8182
- R-Squared traffic x centrentality: .83
- Density: 0.0848

**Centrality x Traffic**  
{% include  centrality_AirTran_Airways_Corporation.html %}
{% include  route_AirTran_Airways.html %}

#### Hawaiian Airlines
- Number of Airports: 15
- Number of Routes: 43
- Mean Arr Delay: 0.8451
- Mean Dep Delay: -0.2728
- Mean Carrier Delay: 31.7755
- Mean Weather Delay: 0.2989
- Mean Late Aircraft Delay: 10.9867
- R-Squared traffic x centrentality: .88
- Density: 0.2095

**Centrality x Traffic**  
{% include  centrality_Hawaiian_Airlines.html %}
{% include  route_Hawaiian_Airlines.html %}

------------

## Next Steps
- Match tail numbers with flight N-numbers to analyze the life and stress on aircraft
- Employ network congestion methods to monitor network traffic. This was a shortfall of this inital approach as present, studied methods for analysis required tools and data not included in this dataset. There may be an approach with this data but it will require more analysis andalgorithmic approaches.

